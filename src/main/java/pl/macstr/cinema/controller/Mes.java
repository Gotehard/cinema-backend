package pl.macstr.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mes {

    @GetMapping
    public String main(){
        return "{\"message\":\"Root endpoint maciej mistrz XD\"}";
    }

    @GetMapping("/prv")
    public String priv(){
        return "{\"message\":\"Private endpoint nie widać bez logowania\"}";
    }

    @GetMapping("/admin")
    public String admin(){
        return "{\"message\":\"Admin endpoint\"}";
    }

    @GetMapping("/user")
    public String userA(){
        return "{\"message\":\"User endpoint\"}";
    }

    @GetMapping("/login")
    public void oszukiwanko(){
    }
}
