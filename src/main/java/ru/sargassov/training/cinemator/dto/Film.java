package ru.sargassov.training.cinemator.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Film {
    private Long id;
    private String title;
    private Integer timeLength;

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", timeLength=" + timeLength +
                '}';
    }
}
