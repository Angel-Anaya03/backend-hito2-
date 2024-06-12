package com.upc.tp_fast_route.Controller;

import com.upc.tp_fast_route.DTO.RutasDto;
import com.upc.tp_fast_route.DTO.UsuarioDTO;
import com.upc.tp_fast_route.Entities.Rutas;
import com.upc.tp_fast_route.Entities.Usuario;
import com.upc.tp_fast_route.Servicio.RutasServicio;
import com.upc.tp_fast_route.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
          private RutasServicio RutasServicio;

    @PostMapping("/u")
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO udto)
    {
        ModelMapper mp= new ModelMapper();
        Usuario u = mp.map(udto,Usuario.class);
        u=usuarioServicio.Guardar(u);
        udto= mp.map(u,UsuarioDTO.class);

        return new ResponseEntity<UsuarioDTO>(udto, HttpStatus.OK);
    }



    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> lista_usuarios()
    {
        ModelMapper mp= new ModelMapper();


        return new ResponseEntity<List<UsuarioDTO>>(Arrays.asList(mp.map(usuarioServicio.list(),UsuarioDTO[].class)),HttpStatus.OK);
    }

    @PutMapping("/usu")

    public ResponseEntity<UsuarioDTO> Actualizar(@RequestBody UsuarioDTO udto) throws Exception {
        ModelMapper mp= new ModelMapper();
        Usuario u = mp.map(udto,Usuario.class);
        usuarioServicio.actualizar(u);
        udto= mp.map(u,UsuarioDTO.class);

        return new ResponseEntity<UsuarioDTO>(udto,HttpStatus.OK);
    }


    @DeleteMapping("/usua/{id}")

    public ResponseEntity<Usuario> Eliminar(@PathVariable (value= "id")Long id) throws Exception {
        return new ResponseEntity<Usuario>(usuarioServicio.Eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/usua/nombre/{nombre}")
    public ResponseEntity<List<UsuarioDTO>> listarpornombre(@PathVariable(value="nombre")String nombre)
    {
        ModelMapper mp = new ModelMapper();
        return new ResponseEntity<List<UsuarioDTO>>(Arrays.asList(mp.map(usuarioServicio.Listar_porNombre(nombre),UsuarioDTO[].class)),HttpStatus.OK);
    }

    @GetMapping("/usuario/{n}")
    public ResponseEntity<UsuarioDTO> encontrar(@PathVariable (value="n")Long n) throws Exception {
        ModelMapper mp = new ModelMapper();
        UsuarioDTO udto= mp.map(usuarioServicio.Encontrar_usuario(n),UsuarioDTO.class);
        return  new ResponseEntity<UsuarioDTO>(udto,HttpStatus.OK);
    }

    @GetMapping("/Rutas/{id}")
    public ResponseEntity<List<RutasDto>> Listar_Rutas(@PathVariable(value = "id")Long id)
    {
        ModelMapper mp = new ModelMapper();
        return new ResponseEntity<List<RutasDto>>(Arrays.asList(mp.map(RutasServicio.Listar_Rutas(id),RutasDto[].class)), HttpStatus.OK);
    }
}
