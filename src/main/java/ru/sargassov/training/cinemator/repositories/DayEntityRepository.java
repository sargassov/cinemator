package ru.sargassov.training.cinemator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sargassov.training.cinemator.models.DayEntity;

public interface DayEntityRepository extends JpaRepository<DayEntity, Long> {
}
