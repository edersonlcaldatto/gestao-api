package br.com.animati.gestao.controller;

import br.com.animati.gestao.DAO.AtividadeDAO;
import br.com.animati.gestao.entity.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {
    @Autowired
    private AtividadeDAO atividadeDAO;

    @GetMapping
    public List<Atividade> listar(){
        return atividadeDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findById(@PathVariable(value = "id") Long id){
        Optional<Atividade> atividade = atividadeDAO.findById(id);
        if(atividade.isPresent())
            return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atividade cadastrar(@RequestBody Atividade atividade){
        return atividadeDAO.save(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Atividade> atividadeDelete = atividadeDAO.findById(id);
        if(atividadeDelete.isPresent()) {
            atividadeDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Atividade> atualiza(@PathVariable(value = "id") long id, @RequestBody Atividade newAtividade){
        Optional<Atividade> atividade1 = atividadeDAO.findById(id);
        if(atividade1.isPresent()){
            Atividade atividade = atividade1.get();
            atividade.setStatus(newAtividade.getStatus());

            atividadeDAO.save(atividade);
            return new ResponseEntity<Atividade>(atividade, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
