package com.example.hwspringbuytickets.dto;

import com.example.hwspringbuytickets.model.Customer;
import com.example.hwspringbuytickets.model.Event;
import com.example.hwspringbuytickets.model.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor

public class TicketDto {
    private Long id;

    private Integer cost;

    private int number;

    private TicketStatus status;
@Builder
    public TicketDto(Integer cost, int number, TicketStatus status) {
        this.cost = cost;
        this.number = number;
        this.status = status;
    }
}
