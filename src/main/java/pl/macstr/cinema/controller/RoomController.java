package pl.macstr.cinema.controller;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.dao.RoomRepository;
import pl.macstr.cinema.model.Room;

import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Room> getAllRooms(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Room getRoomById(@PathVariable Integer id){
        Optional<Room> room = repository.findById(id);
        if (room.isPresent()){
            return room.get();
        }
        return null;
    }

    @PostMapping
    Room addNewRoom(@RequestBody Room reqRoom){
        return repository.save(reqRoom);
    }

    @DeleteMapping("/{id}")
    void deleteRoomById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
