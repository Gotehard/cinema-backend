package pl.macstr.cinema.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.macstr.cinema.dao.UserRepository;
import pl.macstr.cinema.model.User;
import pl.macstr.cinema.service.TokenService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt.token.key}")
    String key;
    UserRepository repository;

    public AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sign-up")
    User RegisterUser(@RequestBody User user) {
        user.setActive(true);
        user.setRoles("ROLE_USER");
        Optional<User> inDBUser = repository.findByUserName(user.getUserName());

        if (inDBUser.isPresent()) {
            return null;
        }
        inDBUser = repository.findByEmail(user.getEmail());
        if (inDBUser.isPresent()) {
            return null;
        }
        //todo move into service
        return repository.save(user);
    }

    @PostMapping(value = "/refresh", produces = "application/json")
    String refreshToken(@RequestBody String refToken) {
        String userName = TokenService.getUserNameFromToken(refToken, key);
        String token = TokenService.createToken(userName, key);
        String rToken = TokenService.createRenewToken(userName, key);
        return "{\"token\":\"" + token + "\",\"refreshToken\":\"" + rToken + "\"}";
    }
}
