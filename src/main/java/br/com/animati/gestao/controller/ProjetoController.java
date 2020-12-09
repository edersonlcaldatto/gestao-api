package br.com.animati.gestao.controller;

import br.com.animati.gestao.DAO.ProjetoDAO;
import br.com.animati.gestao.entity.Projeto;
import br.com.animati.gestao.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoServiceImpl projetoDAO;

    @GetMapping
    public List<Projeto> listar(){
        return projetoDAO.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable(value = "id") Long id){
        Optional<Projeto> projeto = projetoDAO.findById(id);
        if(projeto.isPresent())
            return new ResponseEntity<Projeto>(projeto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto cadastrar(@RequestBody Projeto projeto){
        return projetoDAO.cadastrar(projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ) throws Exception {
        Optional<Projeto> projetoDelete = projetoDAO.findById(id);
        if(projetoDelete.isPresent()) {
            projetoDAO.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualiza(@PathVariable(value = "id") long id, @RequestBody Projeto newProjeto){
        Optional<Projeto> projeto1 = projetoDAO.findById(id);
        if(projeto1.isPresent()){
            Projeto projeto = projeto1.get();
            projeto.setNome(newProjeto.getNome());
            projeto.setCliente(newProjeto.getCliente());
            projeto.setDescricao(newProjeto.getDescricao());

            projetoDAO.cadastrar(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    
}
