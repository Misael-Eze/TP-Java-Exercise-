package org.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartaFerrocarrilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ferrocarril", nullable = false)
    private Long id;
    @Column(name = "id_duenio", nullable = true)
    private Long idDuenio;
    private String descripcion;
    @Column(name="tipo_tarjeta", nullable = false)
    private int tipoTarjeta;
    @Column(name="valor_alquiler")
    private int valorAlquiler;
    @Column(name="valor_hipoteca")
    private int valorHipoteca;
    @Column(name="casillero")
    private int nroCasillero;
}