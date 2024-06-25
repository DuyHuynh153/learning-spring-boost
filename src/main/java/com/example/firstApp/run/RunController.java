package com.example.firstApp.run;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/")
@RestController
public class RunController {

    private RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/runs")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/runs/{id}")

    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    // post: create new run

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/runs")
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/runs/{id}")
    void update(@RequestBody  Run run, @PathVariable Integer id){
            runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/runs/{id}")
    void delete(@PathVariable  Integer id){
        runRepository.delete(id);
    }

}
