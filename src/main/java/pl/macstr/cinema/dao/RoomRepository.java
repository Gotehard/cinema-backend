package pl.macstr.cinema.dao;

import org.springframework.data.repository.CrudRepository;
import pl.macstr.cinema.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
