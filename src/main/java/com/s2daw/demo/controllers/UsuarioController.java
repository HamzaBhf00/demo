package com.s2daw.demo.controllers;

import com.s2daw.demo.dao.UsuarioDao;
import com.s2daw.demo.models.Usuario;
import com.s2daw.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    @RequestMapping(value="api/usuario/{id}" , method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("632656889");
        return usuario;
    }
    @RequestMapping(value="api/usuario" , method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
         usuarioDao.registrar(usuario);
    }

    @RequestMapping(value="api/usuario", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization")String token) {
        String usuarioId=jwtUtil.getKey(token);
        if (!validarToken(token)) {return null;}
        if (usuarioId == null) {
            return new ArrayList<>();
        }
        return usuarioDao.getUsuarios();
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

    @RequestMapping(value="api/usuario/{id}" , method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization")String token, @PathVariable Long id) {
        if (!validarToken(token)) {return;}
        usuarioDao.eliminar(id);
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
