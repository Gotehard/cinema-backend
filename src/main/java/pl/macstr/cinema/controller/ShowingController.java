package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.dao.ShowingRepository;
import pl.macstr.cinema.model.Room;
import pl.macstr.cinema.model.Showing;

import java.util.Optional;

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

    @GetMapping("/{id}")
    Showing getShowingById(@PathVariable Integer id){
        Optional<Showing> showing = repository.findById(id);
        if (showing.isPresent()) {
            showing.get();
        }
        return null;
    }

    @PostMapping
    Showing addNewShowing(@RequestBody Showing reqShowing){
        return repository.save(reqShowing);
    }

    @DeleteMapping("/{id}")
    void deleteShowingById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
