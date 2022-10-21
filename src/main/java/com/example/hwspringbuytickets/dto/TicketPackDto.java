package com.example.hwspringbuytickets.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketPackDto {
    private  Integer cost;
    private Integer count;
@Builder
    public TicketPackDto(Integer cost, Integer count) {
        this.cost = cost;
        this.count = count;
    }
}
