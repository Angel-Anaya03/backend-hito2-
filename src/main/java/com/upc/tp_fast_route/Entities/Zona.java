package com.upc.tp_fast_route.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Zona {
    @Id
    private Long id;
    @Column
    private String tipo;
    @Column
    private String coordenadas;
}
