package ru.sargassov.training.cinemator.converters;

import org.springframework.stereotype.Component;
import ru.sargassov.training.cinemator.dto.Film;
import ru.sargassov.training.cinemator.models.FilmEntity;

@Component
public class FilmConverter {
    public Film entityToDto(FilmEntity filmEntity){
        Film film = new Film();
        film.setId(filmEntity.getId());
        film.setTimeLength(filmEntity.getTimeLength());
        film.setTitle(filmEntity.getTitle());
        return film;
    }
}
