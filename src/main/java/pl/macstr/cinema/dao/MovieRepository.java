package pl.macstr.cinema.dao;

import org.springframework.data.repository.CrudRepository;
import pl.macstr.cinema.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
