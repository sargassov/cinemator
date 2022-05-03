package ru.sargassov.training.cinemator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.sargassov.training.cinemator.models.DayEntity;
import ru.sargassov.training.cinemator.models.FilmSessionEntity;

import java.util.List;

public interface FilmSessionRepository extends JpaRepository<FilmSessionEntity, Long> {
    @Query("select f from FilmSessionEntity f where f.dayEntity = ?1")
    List<FilmSessionEntity> findAllFromOneDay(DayEntity dayEntity);
}
