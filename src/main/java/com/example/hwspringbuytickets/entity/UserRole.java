package com.example.hwspringbuytickets.entity;


import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(schema="box")
public class UserRole {

    @Id
    @Column
    @GeneratedValue(generator = "box.userRole_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "userRole_generator_seq", sequenceName = "box.userRole_generator")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}