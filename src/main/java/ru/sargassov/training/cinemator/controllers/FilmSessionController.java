package ru.sargassov.training.cinemator.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sargassov.training.cinemator.converters.FilmSessionConverter;
import ru.sargassov.training.cinemator.dto.FilmSession;
import ru.sargassov.training.cinemator.dto.FilmVisitorForAllTime;
import ru.sargassov.training.cinemator.services.FilmSessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FilmSessionController {
    private final FilmSessionConverter filmSessionConverter;
    private final FilmSessionService filmSessionService;

    @GetMapping("/all") //найти все фильмы
    public List<String> findAllFilmSessions() {
        List<FilmSession> filmSessions = filmSessionService.findAll()
                .stream()
                .map(filmSessionConverter::entityToDto)
                .collect(Collectors.toList());

        List<String> films = new ArrayList<>();
        for(FilmSession f : filmSessions){
            films.add(f.toString());
        }

        return films;
    }

    @GetMapping("/{id}") //найти конкретный фильм
    public String findFilmSessionById(@PathVariable Long id) {
        FilmSession filmSession = filmSessionConverter.entityToDto(filmSessionService.findById(id));
        System.out.println(filmSession);
        return filmSession.toString();
    }

//    сгруппированные по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21,
//    с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

    @GetMapping("/allfor") //необходимо писать сначала день, потом час с которого считается, потом до которого
    //например чтобы посмотреть в воскресенье с 9 до 12 нужно написать http://localhost:7777/cinema/allfor?day=7&start=9&finish=12
    public Integer findFilmSessionById(@RequestParam(name = "day", defaultValue = "1") Long day,
                                      @RequestParam(name = "start", required = false) Integer start,
                                      @RequestParam(name = "finish", required = false) Integer finish) {

        return filmSessionService.findAllVisitorsByTime(day, start, finish);
    }
//    список фильмов, для каждого — с указанием общего числа посетителей за все время,
//    среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму
//    (отсортировать по убыванию прибыли).

    @GetMapping("/allfilms") //выводит на экран запрос в виде JSON внизу добавляет строку итого
    public List<FilmVisitorForAllTime> findFilmVisitorForAllTime() {
        return filmSessionService.findFilmVisitorForAllTime();
    }
}
