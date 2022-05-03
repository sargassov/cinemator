package ru.sargassov.training.cinemator.converters;

import org.springframework.stereotype.Component;
import ru.sargassov.training.cinemator.dto.Day;
import ru.sargassov.training.cinemator.models.DayEntity;

@Component
public class DayConverter {
    public Day entityToDto(DayEntity dayEntity){
        Day day = new Day();
        day.setId(dayEntity.getId());
        day.setTitle(dayEntity.getTitle());
        return day;
    }
}
