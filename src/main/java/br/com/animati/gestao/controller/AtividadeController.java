package br.com.animati.gestao.controller;

import br.com.animati.gestao.entity.Atividade;
import br.com.animati.gestao.service.AtividadeServiceImpl;
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
    private AtividadeServiceImpl atividadeService;

    @GetMapping
    public List<Atividade> listar(){
        return atividadeService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findById(@PathVariable(value = "id") Long id){
        Optional<Atividade> atividade = atividadeService.findById(id);
        if(atividade.isPresent())
            return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atividade cadastrar(@RequestBody Atividade atividade){
        return atividadeService.cadastrar(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ) throws Exception {
        Optional<Atividade> atividadeDelete = atividadeService.findById(id);
        if(atividadeDelete.isPresent()) {
            atividadeService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Atividade> atualiza(@PathVariable(value = "id") long id, @RequestBody Atividade newAtividade){
        Optional<Atividade> atividade1 = atividadeService.findById(id);
        if(atividade1.isPresent()){
            Atividade atividade = atividade1.get();
            atividade.setTask(newAtividade.getTask());
            atividade.setResponsavel(newAtividade.getResponsavel());
            atividade.setStatus(newAtividade.getStatus());

            atividadeService.cadastrar(atividade);
            return new ResponseEntity<Atividade>(atividade, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
