package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.model.Showing;
import pl.macstr.cinema.service.ShowingService;

@RestController
@RequestMapping("/api/showing")
public class ShowingController {
    ShowingService service;

    @GetMapping
    Iterable<Showing> getAllShowings(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    Showing getShowingById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    Showing addNewShowing(@RequestBody Showing reqShowing){
        return service.save(reqShowing);
    }

    @DeleteMapping("/{id}")
    void deleteShowingById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
