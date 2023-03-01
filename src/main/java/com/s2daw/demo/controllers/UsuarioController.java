package com.s2daw.demo.controllers;

import com.s2daw.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

@RestController
public class UsuarioController {

    @RequestMapping(value="usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("632656889");
        return usuario;
    }
    @RequestMapping(value="usuario")
    public List<Usuario> getUsuario() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(001L);
        usuario.setNombre("Mario");
        usuario.setApellido("Gonzales");
        usuario.setEmail("mario@gmail.com");
        usuario.setTelefono("6326598");

        Usuario usuario2 = new Usuario();
        usuario2.setId(002L);
        usuario2.setNombre("Max");
        usuario2.setApellido("Pablo");
        usuario2.setEmail("max@gmail.com");
        usuario2.setTelefono("6326598");

        Usuario usuario3 = new Usuario();
        usuario3.setId(003L);
        usuario3.setNombre("Fran");
        usuario3.setApellido("Fran");
        usuario3.setEmail("fran@gmail.com");
        usuario3.setTelefono("326598");

        Usuario usuario4 = new Usuario();
        usuario4.setId(004L);
        usuario4.setNombre("Loco");
        usuario4.setApellido("gris");
        usuario4.setEmail("loco@gmail.com");
        usuario4.setTelefono("326541");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        return usuarios;
    }
    @RequestMapping(value="usuario11") //esto es un URL
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("632656889");
        return usuario;
    }

    @RequestMapping(value="usuario12")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("632656889");
        return usuario;
    }

    @RequestMapping(value="usuario13")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("632656889");
        return usuario;
    }
}
