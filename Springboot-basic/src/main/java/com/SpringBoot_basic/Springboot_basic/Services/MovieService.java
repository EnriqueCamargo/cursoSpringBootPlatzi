package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}
