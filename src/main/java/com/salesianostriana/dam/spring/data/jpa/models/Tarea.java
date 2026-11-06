package com.salesianostriana.dam.spring.data.jpa.models;

import com.salesianostriana.dam.spring.data.jpa.Comentario;
import com.salesianostriana.dam.spring.data.jpa.Etiqueta;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tarea {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @ToString.Exclude
    private Proyecto proyecto;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tarea_etiqueta",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Etiqueta> etiquetas = new HashSet<>();

    public Tarea addComentario(Comentario c) {
        comentarios.add(c);
        c.setTarea(this);
        return this;
    }

    public Tarea removeComentario(Comentario c) {
        comentarios.remove(c);
        c.setTarea(null);
        return this;
    }

    public Tarea addEtiqueta(Etiqueta e) {
        etiquetas.add(e);
        return this;
    }

    public Tarea removeEtiqueta(Etiqueta e) {
        etiquetas.remove(e);
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Tarea tarea = (Tarea) o;
        return getId() != null && Objects.equals(getId(), tarea.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
