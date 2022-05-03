package ru.sargassov.training.cinemator.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sargassov.training.cinemator.models.FilmEntity;
import ru.sargassov.training.cinemator.repositories.FilmEntityRepository;

import javax.persistence.SecondaryTable;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmEntityRepository filmEntityRepository;

    public List<FilmEntity> findAll(){
        return filmEntityRepository.findAll();
    }
}
