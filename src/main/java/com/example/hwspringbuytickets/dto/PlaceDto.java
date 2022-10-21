package com.example.hwspringbuytickets.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class PlaceDto {
    private Long id;

    private String address;

    private String name;

    @Builder
    public PlaceDto(String address, String name) {
        this.address = address;
        this.name = name;
    }
}
