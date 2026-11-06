package com.salesianostriana.dam.spring.data.jpa.services;

import com.salesianostriana.dam.spring.data.jpa.models.Tarea;
import com.salesianostriana.dam.spring.data.jpa.repos.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTodos() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void mostrarDetalle(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la tarea con id " + id));

        System.out.println("Título: " + tarea.getTitulo());
        System.out.println("Nº de comentarios: " + tarea.getComentarios().size());
        System.out.println("Etiquetas:");
        tarea.getEtiquetas().forEach(e -> System.out.println(" - " + e.getNombre()));
    }
}
