package com.SpringBoot_basic.Springboot_basic.Repositories;

import com.SpringBoot_basic.Springboot_basic.Entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

}
