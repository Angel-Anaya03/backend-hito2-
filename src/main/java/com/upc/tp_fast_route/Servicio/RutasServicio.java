package com.upc.tp_fast_route.Servicio;

import com.upc.tp_fast_route.Entities.Rutas;
import com.upc.tp_fast_route.Repositorio.RutasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasServicio {
    @Autowired
    private RutasRepositorio R_T;

   public  List<Rutas>Listar_Rutas(Long id)
    {
        return R_T.findAllById(id);
    }
}
