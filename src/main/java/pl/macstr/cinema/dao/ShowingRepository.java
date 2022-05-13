package pl.macstr.cinema.dao;

import org.springframework.data.repository.CrudRepository;
import pl.macstr.cinema.model.Showing;

public interface ShowingRepository extends CrudRepository<Showing, Integer> {
}
