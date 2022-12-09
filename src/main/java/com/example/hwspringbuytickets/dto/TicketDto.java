package com.example.hwspringbuytickets.dto;

import com.example.hwspringbuytickets.entity.TicketStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
