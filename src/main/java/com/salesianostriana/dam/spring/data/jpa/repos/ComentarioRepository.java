package com.salesianostriana.dam.spring.data.jpa.repos;

import com.salesianostriana.dam.spring.data.jpa.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
