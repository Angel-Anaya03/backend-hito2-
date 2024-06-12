package com.upc.tp_fast_route.Servicio;
import com.upc.tp_fast_route.Entities.Distrito;
import com.upc.tp_fast_route.Repositorio.DistritoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistritoServicio {

    @Autowired
    private DistritoRepositorio distritoRepositorio;

    public Distrito guardar(Distrito distrito)
    {
        return distritoRepositorio.save(distrito);
    }

    public List<Distrito> listar() {
        return distritoRepositorio.findAll();
    }

    public Distrito actualizar(Distrito distrito) throws Exception {
        distritoRepositorio.findById(distrito.getId())
                .orElseThrow(() -> new Exception("No se actualizó: Distrito no encontrado"));
        return distritoRepositorio.save(distrito);
    }

    public Distrito eliminar(Long id) throws Exception {
        Distrito distrito = distritoRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el Distrito"));
        distritoRepositorio.delete(distrito);
        return distrito;
    }

    public List<Distrito> buscarPorCodigoPostal(String postal) {
        return distritoRepositorio.findDistritoByPostalStartingWith(postal);
    }

    public Distrito encontrarPorId(Long id) throws Exception {
        return distritoRepositorio.findById(id)
                .orElseThrow(() -> new Exception("Distrito no encontrado"));
    }
}
