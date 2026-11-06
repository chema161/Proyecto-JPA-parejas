package com.salesianostriana.dam.spring.data.jpa.services;

import com.salesianostriana.dam.spring.data.jpa.models.Proyecto;
import com.salesianostriana.dam.spring.data.jpa.repos.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }
}

