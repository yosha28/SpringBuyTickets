package com.example.hwspringbuytickets.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "box")
@Data
public class Customer {
    @Id
    @Column
    @GeneratedValue(generator = "box.customer_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_generator_seq", sequenceName = "box.customer_generator")
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;

    @Column(length = 128, nullable = false)
    private String encrytedPassword;

//    private String confirmPassword;

    @Column(length = 1, nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
