package com.upc.tp_fast_route.Servicio;

import com.upc.tp_fast_route.Entities.Zona;
import com.upc.tp_fast_route.Repositorio.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaServicio {
    @Autowired
    private ZonaRepositorio zonaRepositorio;

    public Zona guardar(Zona zona) {
        return zonaRepositorio.save(zona);
    }

    public List<Zona> listar() {
        return zonaRepositorio.findAll();
    }

    public Zona actualizar(Zona zona) {
        return zonaRepositorio.save(zona);
    }

    public Zona eliminar(Long id) {
        Zona zona = zonaRepositorio.findById(id).orElse(null);
        if (zona != null) {
            zonaRepositorio.delete(zona);
        }
        return zona;
    }

    public List<Zona> buscarPorTipo(String tipo) {
        return zonaRepositorio.findZonaByTipoStartingWith(tipo);
    }

    //public List<Zona> listarPorTipoInseguro(String tipo) {
    //    // Este método retorna directamente lo que devuelve el repositorio,
    //    // sin manejar excepciones específicas.
    //    return zonaRepositorio.findZonaByTipoStartingWith(tipo);
    //}

    public Zona encontrarPorId(Long id) {
        return zonaRepositorio.findById(id).orElse(null);
    }
}
