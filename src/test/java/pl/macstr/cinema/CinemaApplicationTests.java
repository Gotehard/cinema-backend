package pl.macstr.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import pl.macstr.cinema.model.Movie;
import pl.macstr.cinema.service.MovieService;

@SpringBootTest
class CinemaApplicationTests {

    @Autowired
    MovieService movieService;

    @Test
    void contextLoads() {
        Iterable<Movie> movies =  movieService.findAll();
        Assert.notNull(movies);
    }

}
