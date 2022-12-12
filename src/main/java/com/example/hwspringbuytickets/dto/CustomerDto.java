package com.example.hwspringbuytickets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String encrytedPassword;

    private String confirmPassword;

    private boolean enabled;

    private List<TicketDto> tickets;
}
