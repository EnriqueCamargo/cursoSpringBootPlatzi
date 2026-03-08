package com.SpringBoot_basic.Springboot_basic.Controllers;

import com.SpringBoot_basic.Springboot_basic.Entities.Director;
import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Services.DirectorService;
import com.SpringBoot_basic.Springboot_basic.Services.MovieService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorController {
    private final DirectorService directorService;
    private final MovieService movieService;
    public DirectorController(DirectorService directorService,MovieService movieService) {
        this.directorService = directorService;
        this.movieService=movieService;
    }

    @GetMapping("/api/directors")
    public ResponseEntity<?> getAllDirectores(){
        try {
            List<Director> directorList = directorService.getAllDirectores();
            return ResponseEntity.ok(directorList);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/directors/{id}")
    public ResponseEntity<?> getDirectorById(@PathVariable Integer id){
        try{
            Director director=directorService.getDirectorById(id);
            if(director!=null){
                return ResponseEntity.ok(director);
            }else {
                return ResponseEntity.status(404).body("Director No encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
    @GetMapping("/api/directors/name/{name}")
    public ResponseEntity<?> getDirectorByName(@PathVariable String name){
        try{
            Director director=directorService.getDirectorByName(name);
            if(director!=null)
            {
                return ResponseEntity.ok(director);
            }else{
                return ResponseEntity.status(404).body("Director No encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
    @GetMapping("/api/directors/movies/{id}")
    public ResponseEntity<?> getMoviesByDirectorId(@PathVariable Integer id){
        try{
            List<Movie> movieList=directorService.getMoviesByDirectorId(id);
            if(!movieList.isEmpty()){
                return ResponseEntity.ok(movieList);
            }else {
                return ResponseEntity.status(404).body("No hay peliculas registradas del director con id: "+ id);
            }
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/directors/name/movies/{name}")
    public ResponseEntity<?> getMoviesByDirectorName(@PathVariable String name){
        try{
            List<Movie> movieList=directorService.getMoviesByDirectorName(name);
            if(!movieList.isEmpty()){
                return ResponseEntity.ok(movieList);

            }else {
                return ResponseEntity.status(404).body("No hay peliculas registradas con el director "+name);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
