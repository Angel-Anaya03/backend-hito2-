package com.upc.tp_fast_route.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String P_inicio;
    @Column
    private String P_Final;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
   private  Usuario usuario;

}
