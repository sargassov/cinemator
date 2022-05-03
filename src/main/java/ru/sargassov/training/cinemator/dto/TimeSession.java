package ru.sargassov.training.cinemator.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class TimeSession {
    private Long id;
    private String time;
    private Integer ticketCost;

    @Override
    public String toString() {
        return "TimeSession{" +
                "time='" + time + '\'' +
                ", ticketCost=" + ticketCost +
                '}';
    }
}
