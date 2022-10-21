package com.example.hwspringbuytickets.model;

import com.example.hwspringbuytickets.dto.TicketDto;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
