package ru.sargassov.training.cinemator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sargassov.training.cinemator.models.TimeSessionEntity;

public interface TimeSessionRepository extends JpaRepository<TimeSessionEntity, Long> {
}
