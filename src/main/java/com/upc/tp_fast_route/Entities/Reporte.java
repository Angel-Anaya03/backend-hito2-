package com.upc.tp_fast_route.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "reportes")
public class Reporte {
    @Id
    private Long id;

    @Column
    private String comentario;


    @Column
    private LocalDate fechacreacion;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
