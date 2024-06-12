package com.upc.tp_fast_route.DTO;

import com.upc.tp_fast_route.Entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDTO {

    private Long id;


    private String comentario;




    private LocalDate fechacreacion;

    Usuario usuario;

}
