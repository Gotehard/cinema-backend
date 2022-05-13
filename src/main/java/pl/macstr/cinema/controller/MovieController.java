package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.dao.MovieRepository;
import pl.macstr.cinema.model.Movie;

import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Movie> getAllMovies(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Movie getMovieById(@PathVariable Integer id){
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()){
            return movie.get();
        }
        return null;
    }

    @PostMapping
    Movie addNewMovie(@RequestBody Movie reqMovie){
        return repository.save(reqMovie);
    }

    @DeleteMapping("/{id}")
    void deleteMovieById(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
