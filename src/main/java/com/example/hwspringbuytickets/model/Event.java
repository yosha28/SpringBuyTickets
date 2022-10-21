package com.example.hwspringbuytickets.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema="box")
@Data
public class Event {
    @Id
    @Column
    @GeneratedValue(generator = "box.event_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "event_generator_seq", sequenceName = "box.event_generator")
    private Long id;
    @Column
    private String  name;
    @Column
    private Date date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy= "event",cascade=CascadeType.ALL)
    private List<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Place place;

}
