package com.example.hwspringbuytickets.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema="box")
public class Role {

    @Id
    @GeneratedValue(generator = "box.role_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "role_generator_seq", sequenceName = "box.role_generator")
    @Column
    private Long id;

    @Column(unique=true, length = 30, nullable = false)
    private String roleName;
}