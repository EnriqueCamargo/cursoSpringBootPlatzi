package com.SpringBoot_basic.Springboot_basic.Controllers;

import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import com.SpringBoot_basic.Springboot_basic.Services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public List<Movie> getAllMovies(){

        List<Movie> movieList=movieService.getAllMovies();
        return movieList;
    }
}
