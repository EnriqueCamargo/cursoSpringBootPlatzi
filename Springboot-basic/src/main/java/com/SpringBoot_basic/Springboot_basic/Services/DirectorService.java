package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Entities.Director;
import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Repositories.DirectorRepository;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private  DirectorRepository directorRepository;
    @Autowired
    private MovieRepository movieRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectores(){

        return directorRepository.findAll();
    }

    public Director getDirectorById(Integer id){
        return directorRepository.findById(id).orElse(null);
    }

    public Director getDirectorByName(String name){
        List<Director> directorList = directorRepository.findAll();
        return directorList.stream().filter(director -> director.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<Movie> getMoviesByDirectorId(Integer directorId){
        return movieRepository.findByDirectorId(directorId);
    }

    public List<Movie> getMoviesByDirectorName(String name){
        return movieRepository.findByDirectorNameContainingIgnoreCase(name);
    }
    }
