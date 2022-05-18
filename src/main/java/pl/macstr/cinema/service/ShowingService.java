package pl.macstr.cinema.service;

import org.springframework.stereotype.Service;
import pl.macstr.cinema.dao.ShowingRepository;
import pl.macstr.cinema.handlers.RecordNotFountException;
import pl.macstr.cinema.model.Showing;

import java.util.Optional;

@Service
public class ShowingService {
    ShowingRepository repository;

    public ShowingService(ShowingRepository repository) {
        this.repository = repository;
    }

    public Iterable<Showing> findAll() {
        return repository.findAll();
    }

    public Showing findById(Integer id) {
        Optional<Showing> optionalShowing = repository.findById(id);
        if (optionalShowing.isPresent()) {
            return optionalShowing.get();
        }
        System.out.println("Showing not found");
        throw new RecordNotFountException("Showing not found");
    }

    public Showing save(Showing movie) {
        return repository.save(movie);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
