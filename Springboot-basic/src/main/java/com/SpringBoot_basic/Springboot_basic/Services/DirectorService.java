package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Repositories.DirectorRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

}
