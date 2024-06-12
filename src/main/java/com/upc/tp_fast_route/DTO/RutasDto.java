package com.upc.tp_fast_route.DTO;

import com.upc.tp_fast_route.Entities.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutasDto {

        private Long id;

        private  String P_inicio;
        private String P_Final;


        private Usuario usuario;



}
