package org.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.services.IPeon;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartaProvinciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_provincia", nullable = false)
    private Long idCarta;
    @Column(nullable = false)
    private String descripcion;
    @Column(name="id_duenio" ,nullable = true)
    private Long idDuenio;
    @Column(name = "tipo_carta",nullable = false)
    private int tipoCarta;
    @Column(name="provincia_carta",nullable = false)
    public int provincia;
    @Column(name="zona_carta",nullable = false)
    private int zona;
    @Column(name="valor_alquiler",nullable = false)
    private int valorAlquiler;
    @Column(name = "valor_chacra",nullable = false)
    private int valorChacra;
    @Column(name = "valor_estancia",nullable = false)
    private int valorEstancia;
    @Column(name = "valor_hipoteca",nullable = false)
    private int valorHipoteca;
    private boolean hipotecado;
    @Column(name = "cantidad_chacras")
    private int conteoChacras;
    @Column(name = "cantidad_estancias")
    private int conteoEstancias;
    @Column(name="casillero")
    private int nroCasillero;
}