package ru.sargassov.training.cinemator.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sargassov.training.cinemator.exceptions.ResourceNotFoundException;
import ru.sargassov.training.cinemator.models.DayEntity;
import ru.sargassov.training.cinemator.repositories.DayEntityRepository;

@Service
@AllArgsConstructor
public class DayService {
    private final DayEntityRepository dayEntityRepository;

    public DayEntity findById(Long id){
        return dayEntityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("day with id #" + id + " was not found!"));
    }
}
