package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.*;
import pl.macstr.cinema.model.Room;
import pl.macstr.cinema.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    Iterable<Room> getAllRooms() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Room getRoomById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    Room addNewRoom(@RequestBody Room reqRoom){
        return service.save(reqRoom);
    }

    @DeleteMapping("/{id}")
    void deleteRoomById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
