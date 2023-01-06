package com.example.hwspringbuytickets.validation;

import com.example.hwspringbuytickets.dto.CustomerDto;
import com.example.hwspringbuytickets.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    @Autowired
    CustomerService customerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto user=(CustomerDto) target;
       String  regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
               + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
     if(!Pattern.compile(regexPattern)
                .matcher(user.getEmail())
                .matches()){
         errors.rejectValue("email","Invalid.email.format");
     }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotEmpty");
        if(customerService.getCustomerForEmail(user.getEmail())!=null){
            errors.rejectValue("email","Duplicate.customer.email");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"encrytedPassword","NotEmpty");
        if(!user.getConfirmPassword().equals(user.getEncrytedPassword())){
            errors.rejectValue("confirmPassword","Diff.customer.passwordConfirm");
        }

    }
}
