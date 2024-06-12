package com.upc.tp_fast_route.Controller;

import com.upc.tp_fast_route.DTO.ReporteDTO;
import com.upc.tp_fast_route.Entities.Reporte;
import com.upc.tp_fast_route.Servicio.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReporteController {


    @Autowired
    private ReporteServicio reporteServicio;


    @PostMapping("/reporte")
    public ResponseEntity<ReporteDTO> save(@RequestBody ReporteDTO reporteDTO) {
        ModelMapper modelMapper= new ModelMapper();

        Reporte reporte = modelMapper.map(reporteDTO, Reporte.class);
        reporte = reporteServicio.guardar(reporte);
        ReporteDTO createdReporteDTO = modelMapper.map(reporte, ReporteDTO.class);
        return new ResponseEntity<>(createdReporteDTO, HttpStatus.OK);
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<ReporteDTO>> listar_repotes() {
        ModelMapper modelMapper= new ModelMapper();

        return new ResponseEntity<>(Arrays.asList(modelMapper.map(reporteServicio.listar(),ReporteDTO[].class)), HttpStatus.OK);
    }

    @PutMapping("/reporte")
    public ResponseEntity<ReporteDTO> actualizar(@RequestBody ReporteDTO reporteDTO) throws Exception {
        ModelMapper modelMapper= new ModelMapper();

        Reporte reporte = modelMapper.map(reporteDTO, Reporte.class);
        reporte = reporteServicio.actualizar(reporte);
        ReporteDTO updatedReporteDTO = modelMapper.map(reporte, ReporteDTO.class);
        return new ResponseEntity<>(updatedReporteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/reporte/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception {
        reporteServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
