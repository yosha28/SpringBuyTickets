package com.example.hwspringbuytickets.configuration;

import com.example.hwspringbuytickets.service.CustomerService;
//import com.example.hwspringbuytickets.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerService customerService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Настройка службы для поиска пользователя в базе данных.
        // и установка PasswordEncoder
        auth.userDetailsService(customerService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();//CORS

        // не требуют авторизациии
        http.authorizeRequests().antMatchers("/", "/login", "/logout", "/registration").permitAll();

        // Страница /userInfo требует входа в систему как ROLE_USER или ROLE_ADMIN.
        // Если нет логина, будет перенаправлен на страницу /login.
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // ТОлько для роли админ
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        // если нет прав (роли) для доступа к странице
        // будет брошено AccessDeniedException.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Конфиг для формы входа (логин страница)
        http.authorizeRequests().and().formLogin()
            .loginProcessingUrl("/j_spring_security_check") // Submit URL
            .loginPage("/login")//
            .defaultSuccessUrl("/userInfo")//
            .failureUrl("/login?error=true")//
            .usernameParameter("email")//
            .passwordParameter("password").and()
            // Конфиг для выхода
            .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }

}
