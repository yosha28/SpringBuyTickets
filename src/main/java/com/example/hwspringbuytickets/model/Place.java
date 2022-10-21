package com.example.hwspringbuytickets.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "box")
@Data
public class Place {
    @Id
    @Column
    @GeneratedValue(generator = "box.place_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "place_generator_seq", sequenceName = "box.place_generator")
    private Long id;
    @Column
    private String address;
    @Column
    private String name;
}
