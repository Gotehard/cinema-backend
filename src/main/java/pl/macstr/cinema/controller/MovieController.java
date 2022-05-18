package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.model.Movie;
import pl.macstr.cinema.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    Iterable<Movie> getAllMovies() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Movie getMovieById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    Movie addNewMovie(@RequestBody Movie reqMovie){
        return service.save(reqMovie);
    }

    @DeleteMapping("/{id}")
    void deleteMovieById(@PathVariable Integer id){
        service.deleteById(id);
    }

}
