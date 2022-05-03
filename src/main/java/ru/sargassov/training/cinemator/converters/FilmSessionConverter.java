package ru.sargassov.training.cinemator.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sargassov.training.cinemator.dto.FilmSession;
import ru.sargassov.training.cinemator.models.FilmSessionEntity;

@Component
@RequiredArgsConstructor
public class FilmSessionConverter {
    private final FilmConverter filmConverter;
    private final TimeSessionConverter timeSessionConverter;
    private final DayConverter dayConverter;

    public FilmSession entityToDto(FilmSessionEntity filmSessionEntity){
        FilmSession filmSession = new FilmSession();
        filmSession.setId(filmSessionEntity.getId());
        filmSession.setFilm(filmConverter.entityToDto(filmSessionEntity.getFilmEntity()));
        filmSession.setTimeSession(timeSessionConverter.entityToDto(filmSessionEntity.getTimeSessionEntity()));
        filmSession.setTicketQuantity(filmSessionEntity.getTicketQuantity());
        filmSession.setDay(dayConverter.entityToDto(filmSessionEntity.getDayEntity()));
        return filmSession;
    }
}
