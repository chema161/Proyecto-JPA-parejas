package com.salesianostriana.dam.spring.data.jpa;

import org.springframework.stereotype.Service;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public Etiqueta guardar(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public long contar() {
        return etiquetaRepository.count();
    }
}
