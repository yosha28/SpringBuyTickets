package com.example.hwspringbuytickets.entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(schema="box")
@Data
public class Ticket {
    @Id
    @Column
    @GeneratedValue(generator = "box.ticket_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ticket_generator_seq", sequenceName = "box.ticket_generator")
    private Long id;
    @Column
    private Integer cost;
    @Column
    private int number;
    @Column
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

}
