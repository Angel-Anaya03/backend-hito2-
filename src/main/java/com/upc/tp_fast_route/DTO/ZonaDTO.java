package com.upc.tp_fast_route.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZonaDTO {
    private Long id;

    private String tipo;

    private String coordenadas;
}
