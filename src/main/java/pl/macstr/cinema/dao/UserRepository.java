package pl.macstr.cinema.dao;

import org.springframework.data.repository.CrudRepository;
import pl.macstr.cinema.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String username);
    boolean removeByUserName(String username);
    void deleteById(Integer id);
}
