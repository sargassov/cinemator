package ru.sargassov.training.cinemator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sargassov.training.cinemator.models.FilmEntity;

public interface FilmEntityRepository extends JpaRepository<FilmEntity, Long> {
}
