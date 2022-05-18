package pl.macstr.cinema.service;

import org.springframework.stereotype.Service;
import pl.macstr.cinema.dao.RoomRepository;
import pl.macstr.cinema.handlers.RecordNotFountException;
import pl.macstr.cinema.model.Room;

import java.util.Optional;

@Service
public class RoomService {

    RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Iterable<Room> findAll() {
        return repository.findAll();
    }

    public Room findById(Integer id) {
        Optional<Room> optionalRoom = repository.findById(id);
        if (optionalRoom.isPresent()) {
            return optionalRoom.get();
        }
        System.out.println("Room not found");
        throw new RecordNotFountException("Room not found");
    }

    public Room save(Room movie) {
        return repository.save(movie);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
