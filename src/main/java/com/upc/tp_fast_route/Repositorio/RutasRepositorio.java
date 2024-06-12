package com.upc.tp_fast_route.Repositorio;

import com.upc.tp_fast_route.Entities.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutasRepositorio extends JpaRepository<Rutas,Long> {
    List<Rutas>findAllById(Long id_usuario);
}
