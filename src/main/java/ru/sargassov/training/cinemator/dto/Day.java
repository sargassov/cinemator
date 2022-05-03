package ru.sargassov.training.cinemator.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Day {
    private Long id;
    private String title;

    @Override
    public String toString() {
        return "Day{" +
                "title='" + title + '\'' +
                '}';
    }
}
