package com.upc.tp_fast_route.Repositorio;

import com.upc.tp_fast_route.Entities.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Repository

public interface ReporteRepositorio extends JpaRepository<Reporte,Long> {
    List<Reporte> findReporteByFechacreacion(LocalDate Fecha_creacion);
}
