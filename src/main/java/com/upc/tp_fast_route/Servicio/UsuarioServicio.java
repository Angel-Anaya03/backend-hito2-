package com.upc.tp_fast_route.Servicio;

import com.upc.tp_fast_route.Entities.Rutas;
import com.upc.tp_fast_route.Entities.Usuario;
import com.upc.tp_fast_route.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioR;

    public Usuario Guardar(Usuario u)
    {
        return usuarioR.save(u);
    }

    public List<Usuario> list()
    {
        return usuarioR.findAll();
    }

    public Usuario actualizar(Usuario u) throws Exception {
        usuarioR.findById(u.getId()).orElseThrow(()->new Exception("No se actualizo"));
        return usuarioR.save(u);
    }

    public Usuario Eliminar(Long id) throws Exception {
        Usuario u;

        u= usuarioR.findById(id).orElseThrow(()->new Exception("No se encontro "));
        usuarioR.delete(u);
        return u;
    }
    public  List<Usuario> Listar_porNombre(String Nombre)
    {
        return usuarioR.findUsuarioByNombreStartingWith(Nombre);
    }

    public Usuario Encontrar_usuario(Long id) throws Exception {
        return usuarioR.findById(id).orElseThrow(()->new Exception("No se encontro"));
    }


}
