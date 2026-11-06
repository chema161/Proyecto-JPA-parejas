package com.salesianostriana.dam.spring.data.jpa.repos;

import com.salesianostriana.dam.spring.data.jpa.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
