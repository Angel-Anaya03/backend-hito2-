package com.upc.tp_fast_route.Servicio;

import com.upc.tp_fast_route.Entities.Reporte;
import com.upc.tp_fast_route.Repositorio.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReporteServicio {
    @Autowired
    private ReporteRepositorio reporteRepositorio;

    public Reporte guardar(Reporte reporte) {
        return reporteRepositorio.save(reporte);
    }

    public List<Reporte> listar() {
        return reporteRepositorio.findAll();
    }

    public Reporte actualizar(Reporte reporte) throws Exception {
        reporteRepositorio.findById(reporte.getId()).orElseThrow(() -> new Exception("No se actualizó: Reporte no encontrado"));
        return reporteRepositorio.save(reporte);
    }

    public Reporte eliminar(Long id) throws Exception {
        Reporte reporte = reporteRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el Reporte"));
        reporteRepositorio.delete(reporte);
        return reporte;
    }


    public List<Reporte> buscarPorFecha(LocalDate fecha) {  return reporteRepositorio.findReporteByFechacreacion(fecha);
    }


    public Reporte encontrarPorId(Long id) throws Exception {
        return reporteRepositorio.findById(id)
                .orElseThrow(() -> new Exception("Reporte no encontrado"));
    }
}
