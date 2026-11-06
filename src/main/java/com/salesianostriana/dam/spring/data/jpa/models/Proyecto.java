package com.salesianostriana.dam.spring.data.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Proyecto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "proyecto")
    @Builder.Default
    @ToString.Exclude
    private List<Tarea> tareas = new ArrayList<>();

    public Proyecto addTarea(Tarea t) {
        tareas.add(t);
        t.setProyecto(this);
        return this;
    }

    public Proyecto removeTarea(Tarea t) {
        tareas.remove(t);
        t.setProyecto(null);
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Proyecto proyecto = (Proyecto) o;
        return getId() != null && Objects.equals(getId(), proyecto.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

