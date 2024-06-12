package com.upc.tp_fast_route.Controller;

import com.upc.tp_fast_route.DTO.DistritoDTO;
import com.upc.tp_fast_route.Entities.Distrito;
import com.upc.tp_fast_route.Servicio.DistritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DistritoController {

    @Autowired
    private DistritoServicio distritoServicio;



    @PostMapping("/distrito")
    public ResponseEntity<DistritoDTO> save(@RequestBody DistritoDTO distritoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
        distrito = distritoServicio.guardar(distrito);
        DistritoDTO createdDistritoDTO = modelMapper.map(distrito, DistritoDTO.class);
        return new ResponseEntity<>(createdDistritoDTO, HttpStatus.OK);
    }

    @GetMapping("/distritos")
    public ResponseEntity<List<DistritoDTO>> listar() {
        ModelMapper modelMapper = new ModelMapper();
        return new ResponseEntity<List<DistritoDTO>>(Arrays.asList(modelMapper.map(distritoServicio.listar(),DistritoDTO[].class)), HttpStatus.OK);
    }

    @PutMapping("/distrit")
    public ResponseEntity<DistritoDTO> actualizar(@RequestBody DistritoDTO distritoDTO) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

        Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
        distrito = distritoServicio.actualizar(distrito);
        DistritoDTO updatedDistritoDTO = modelMapper.map(distrito, DistritoDTO.class);
        return new ResponseEntity<>(updatedDistritoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/distri/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable(value = "id") Long id) throws Exception {
        distritoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
