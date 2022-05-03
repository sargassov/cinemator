package ru.sargassov.training.cinemator.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class FilmVisitorForAllTime {
    private String film;
    private int allTimeVisitors;
    private int filmSessionValues;
    private int allTicketCash;
    private double averageAmountOfVisitorsInOneFilmSession;

    @Override
    public String toString() {
        return "FilmVisitorForAllTime{" +
                "фИЛЬМ='" + film + '\'' +
                ", За все время его посмотрели=" + allTimeVisitors +
                ", Сколько раз его показали=" + filmSessionValues +
                ", Сколько заработали на фильме=" + allTicketCash +
                ", Среднее количество человек на сеансе=" + averageAmountOfVisitorsInOneFilmSession +
                '}';
    }
}
