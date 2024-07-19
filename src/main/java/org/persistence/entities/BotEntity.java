package org.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BotEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "botEntity_sequence"),
                    @Parameter(name = "initial_value", value = "2"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name="id_bot", nullable = false)
    private Long id;
    @Column(name="nombre_bot", nullable = false)
    private String nombre;
    @Column(name = "dinero_bot",nullable = false)
    private int dinero;
    @Column(name = "posicion_bot",nullable = false)
    private int posicion;
    @Column(name="tarjeta_liberacion")
    private boolean tarjetaLiberacion;
    @Column(name="estado_bot",nullable = false)
    private int estado;
    @Column(name="estrategia_bot", nullable = false)
    private int estrategia;
    private int doblesConsecutivos;
}
