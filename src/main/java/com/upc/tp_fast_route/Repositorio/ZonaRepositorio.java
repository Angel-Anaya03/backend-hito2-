package com.upc.tp_fast_route.Repositorio;

import com.upc.tp_fast_route.Entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ZonaRepositorio extends JpaRepository<Zona,Long> {
    List<Zona> findZonaByTipoStartingWith(String tipo);
}
