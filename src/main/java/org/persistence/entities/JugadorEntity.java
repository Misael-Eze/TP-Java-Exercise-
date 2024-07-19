package org.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.model.enums.EstadosJugadores;
import org.services.IPropiedad;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="nombre_jugador", nullable = false)
    private String nombre;
    @Column(name="dinero_jugador", nullable = false)
    private int dinero;
    @Column(name = "posicion_jugador", nullable = false)
    private int posicion;
    @Column(name = "estado_jugador", nullable = false)
    private int estado;
    @Column(name = "tarjeta_liberacion")
    private boolean tarjetaLiberacion;

    int doblesConsecutivos;
}
