package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.macstr.cinema.dao.ShowingRepository;
import pl.macstr.cinema.model.Showing;

@RestController
@RequestMapping("/api/showing")
public class ShowingController {
    ShowingRepository repository;

    public ShowingController(ShowingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Showing> getAllShowings(){
        return repository.findAll();
    }
}
