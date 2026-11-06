package com.salesianostriana.dam.spring.data.jpa.sevices;

import com.salesianostriana.dam.spring.data.jpa.repos.ComentarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public long contar() {
        return comentarioRepository.count();
    }
}
