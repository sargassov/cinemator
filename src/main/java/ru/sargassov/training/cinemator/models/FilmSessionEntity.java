package ru.sargassov.training.cinemator.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "film_sessions")
@Data
@NoArgsConstructor
public class FilmSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_days")
    private DayEntity dayEntity;

    @ManyToOne
    @JoinColumn(name = "id_time_sessions")
    private TimeSessionEntity timeSessionEntity;

    @ManyToOne
    @JoinColumn(name = "id_films")
    private FilmEntity filmEntity;

    @Column(name = "tickets")
    private Integer ticketQuantity;
}
