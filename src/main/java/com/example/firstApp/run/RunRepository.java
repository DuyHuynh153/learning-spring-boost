package com.example.firstApp.run;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);

        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id() == id);
    }


    @PostConstruct
    private void init(){
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS), 5, Location.INDOOR));
    }
}
