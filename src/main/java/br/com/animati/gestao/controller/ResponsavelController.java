package br.com.animati.gestao.controller;

import br.com.animati.gestao.DAO.ResponsavelDAO;
import br.com.animati.gestao.entity.Responsavel;
import br.com.animati.gestao.service.ResponsavelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelServiceImpl responsavelDAO;

    @GetMapping
    public List<Responsavel> listar(){
        return responsavelDAO.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> findById(@PathVariable(value = "id") Long id){
        Optional<Responsavel> responsavel = responsavelDAO.findById(id);
        if(responsavel.isPresent())
            return new ResponseEntity<Responsavel>(responsavel.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsavel cadastrar(@RequestBody Responsavel responsavel){
        return responsavelDAO.cadastrar(responsavel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ) throws Exception {
        Optional<Responsavel> responsavelDelete = responsavelDAO.findById(id);
        if(responsavelDelete.isPresent()) {
            responsavelDAO.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualiza(@PathVariable(value = "id") long id, @RequestBody Responsavel newResponsavel){
        Optional<Responsavel> responsavel1 = responsavelDAO.findById(id);
        if(responsavel1.isPresent()){
            Responsavel responsavel = responsavel1.get();
            responsavel.setNome(newResponsavel.getNome());
            responsavel.setFuncao(newResponsavel.getFuncao());

            responsavelDAO.cadastrar(responsavel);
            return new ResponseEntity<Responsavel>(responsavel, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
