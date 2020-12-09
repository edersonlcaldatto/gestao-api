package br.com.animati.gestao.service;

import br.com.animati.gestao.DAO.ClienteDAO;
import br.com.animati.gestao.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        clienteDAO.save(cliente);
        return cliente;
    }

    @Override
    public void editar(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public void deletar(long idCliente) throws Exception {
        clienteDAO.deleteById(idCliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> findById(long idCliente) {
        return clienteDAO.findById(idCliente);
    }

    @Override
    public void limparLista() {
        clienteDAO.deleteAll();
    }
    
}
