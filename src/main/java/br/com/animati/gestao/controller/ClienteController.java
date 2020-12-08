package br.com.animati.gestao.controller;

import br.com.animati.gestao.DAO.ClienteDAO;
import br.com.animati.gestao.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteDAO clienteDAO;

    @GetMapping
    public List<Cliente> listar(){
        return clienteDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable(value = "id") Long id){
        Optional<Cliente> cliente = clienteDAO.findById(id);
        if(cliente.isPresent())
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return clienteDAO.save(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id ){
        Optional<Cliente> clienteDelete = clienteDAO.findById(id);
        if(clienteDelete.isPresent()) {
            clienteDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable(value = "id") long id, @RequestBody Cliente newCliente){
        Optional<Cliente> cliente1 = clienteDAO.findById(id);
        if(cliente1.isPresent()){
            Cliente cliente = cliente1.get();
            cliente.setCnpj(newCliente.getCnpj());
            cliente.setNome(newCliente.getNome());

            clienteDAO.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
