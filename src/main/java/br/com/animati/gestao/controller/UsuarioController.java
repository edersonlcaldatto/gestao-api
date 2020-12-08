package br.com.animati.gestao.controller;

import br.com.animati.gestao.DAO.UsuarioDAO;
import br.com.animati.gestao.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioDAO.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioDAO.save(usuario);
    }

    
}
