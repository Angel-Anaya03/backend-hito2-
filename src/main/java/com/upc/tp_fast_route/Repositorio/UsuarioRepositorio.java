package com.upc.tp_fast_route.Repositorio;

import com.upc.tp_fast_route.Entities.Rutas;
import com.upc.tp_fast_route.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    List<Usuario> findUsuarioByNombreStartingWith(String Nombre);

}
