package ru.sargassov.training.cinemator.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sargassov.training.cinemator.dto.FilmVisitorForAllTime;
import ru.sargassov.training.cinemator.exceptions.ResourceNotFoundException;
import ru.sargassov.training.cinemator.models.FilmEntity;
import ru.sargassov.training.cinemator.models.FilmSessionEntity;
import ru.sargassov.training.cinemator.repositories.FilmSessionRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmSessionService {
    private final FilmSessionRepository filmSessionRepository;
    private final DayService dayService;
    private final FilmService filmService;


    public List<FilmSessionEntity> findAll(){
        return filmSessionRepository.findAll();
    }

    public FilmSessionEntity findById(Long id){
        return filmSessionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("film session with id #" + id + " was not found!"));
    }

    public Integer findAllVisitorsByTime(Long day, Integer start, Integer finish) {
        List<FilmSessionEntity> fseList = filmSessionRepository.findAllFromOneDay(dayService.findById(day));
        Integer allVisitors = 0;
        for(FilmSessionEntity f : fseList){
            if(Integer.parseInt(f.getTimeSessionEntity().getTime().split(":")[0]) >= start &&
                    Integer.parseInt(f.getTimeSessionEntity().getTime().split(":")[0]) <= finish){
                allVisitors += f.getTicketQuantity();
            }
        }
        return allVisitors;
    }

    public List<FilmVisitorForAllTime> findFilmVisitorForAllTime() {
        List<FilmEntity> filmEntities = filmService.findAll();
        List<FilmVisitorForAllTime> fvaList = getFilmVisitorsListFromFilmList(filmEntities);
        List<FilmSessionEntity> fseList = filmSessionRepository.findAll();

        for(FilmSessionEntity f : fseList){
            for(FilmVisitorForAllTime fv : fvaList){
                if(f.getFilmEntity().getTitle().equals(fv.getFilm())){
                    fv.setAllTimeVisitors(fv.getAllTimeVisitors() + f.getTicketQuantity());
                    fv.setAllTicketCash(fv.getAllTicketCash() + f.getTicketQuantity() * f.getTimeSessionEntity().getTicketCost());
                    fv.setFilmSessionValues(fv.getFilmSessionValues() + 1);
                    fv.setAverageAmountOfVisitorsInOneFilmSession(fv.getAllTimeVisitors() / fv.getFilmSessionValues());
                }
            }
        }
        fvaList.sort(new Comparator<FilmVisitorForAllTime>() {
            @Override
            public int compare(FilmVisitorForAllTime o1, FilmVisitorForAllTime o2) {
                if(o1.getAllTicketCash() > o2.getAllTicketCash())
                    return -1;
                if (o2.getAllTicketCash() > o1.getAllTicketCash())
                    return 1;
                else return 0;
            }
        });
        return allFilmsCashAmount(fvaList);
    }

    private List<FilmVisitorForAllTime> allFilmsCashAmount(List<FilmVisitorForAllTime> fvaList) {
        FilmVisitorForAllTime f = new FilmVisitorForAllTime();
        f.setFilm("ИТОГО");
        for(FilmVisitorForAllTime fva : fvaList){
            f.setAllTicketCash(f.getAllTicketCash() + fva.getAllTicketCash());
        }
        fvaList.add(f);
        return fvaList;
   }

    private List<FilmVisitorForAllTime> getFilmVisitorsListFromFilmList(List<FilmEntity> filmEntities) {
        List<FilmVisitorForAllTime> fvaList = new ArrayList<>();
        for(FilmEntity f: filmEntities){
            FilmVisitorForAllTime fv = new FilmVisitorForAllTime();
            fv.setFilm(f.getTitle());
            fvaList.add(fv);
        }
        return fvaList;
    }
}
