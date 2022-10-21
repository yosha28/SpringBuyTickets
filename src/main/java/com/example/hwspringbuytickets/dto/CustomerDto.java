package com.example.hwspringbuytickets.dto;

import com.example.hwspringbuytickets.model.Ticket;
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

    private List<TicketDto> tickets;
}
