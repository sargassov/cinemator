package ru.sargassov.training.cinemator.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "time_sessions")
@Data
@NoArgsConstructor
public class TimeSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private String time;

    @Column(name = "ticket_cost")
    private Integer ticketCost;
}
