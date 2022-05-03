package ru.sargassov.training.cinemator.converters;

import org.springframework.stereotype.Component;
import ru.sargassov.training.cinemator.dto.TimeSession;
import ru.sargassov.training.cinemator.models.TimeSessionEntity;
@Component
public class TimeSessionConverter {

    public TimeSession entityToDto(TimeSessionEntity timeSessionEntity){
        TimeSession timeSession = new TimeSession();
        timeSession.setId(timeSessionEntity.getId());
        timeSession.setTicketCost(timeSessionEntity.getTicketCost());
        timeSession.setTime(timeSessionEntity.getTime());
        return timeSession;
    }
}
