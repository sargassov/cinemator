package ru.sargassov.training.cinemator.dto;

import lombok.Data;


@Data
public class FilmSession {
    private Long id;
    private Day day;
    private TimeSession timeSession;
    private Film film;
    private Integer ticketQuantity;

    @Override
    public String toString() {
        return "FilmSession{" +
                "day=" + day +
                ", timeSession=" + timeSession +
                ", film=" + film +
                ", ticketQuantity=" + ticketQuantity +
                ", allTicketCost=" + timeSession.getTicketCost() * ticketQuantity +
                '}';
    }
}
