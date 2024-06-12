package com.upc.tp_fast_route.Controller;

import com.upc.tp_fast_route.DTO.ZonaDTO;
import com.upc.tp_fast_route.Entities.Zona;
import com.upc.tp_fast_route.Servicio.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ZonaController {


    @Autowired
    private ZonaServicio zonaServicio;



    @PostMapping("/zona")
    public ResponseEntity<ZonaDTO> save(@RequestBody ZonaDTO zonaDTO) {
        ModelMapper modelMapper= new ModelMapper();
        Zona zona = modelMapper.map(zonaDTO, Zona.class);
        zona = zonaServicio.guardar(zona);
        ZonaDTO createdZonaDTO = modelMapper.map(zona, ZonaDTO.class);
        return new ResponseEntity<>(createdZonaDTO, HttpStatus.OK);
    }

    @GetMapping("/zonas")
    public ResponseEntity<List<ZonaDTO>> listar_zonas() {
        ModelMapper modelMapper= new ModelMapper();
        return new ResponseEntity<>(Arrays.asList(modelMapper.map(zonaServicio.listar(),ZonaDTO[].class)), HttpStatus.OK);
    }

    @PutMapping("/zon")
    public ResponseEntity<ZonaDTO> actualizar(@RequestBody ZonaDTO zonaDTO) throws Exception {
        ModelMapper modelMapper= new ModelMapper();

        Zona zona = modelMapper.map(zonaDTO, Zona.class);
        zona = zonaServicio.actualizar(zona);
        ZonaDTO updatedZonaDTO = modelMapper.map(zona, ZonaDTO.class);
        return new ResponseEntity<>(updatedZonaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/zo/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception {
        zonaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
