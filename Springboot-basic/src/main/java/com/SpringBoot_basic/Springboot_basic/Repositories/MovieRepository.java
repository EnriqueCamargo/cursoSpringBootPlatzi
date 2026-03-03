package com.SpringBoot_basic.Springboot_basic.Repositories;

import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
