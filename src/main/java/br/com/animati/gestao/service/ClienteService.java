package br.com.animati.gestao.service;


import br.com.animati.gestao.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public Cliente cadastrar(Cliente cliente);

    public void editar(Cliente cliente);

    public void deletar(long idCliente) throws Exception;

    public List<Cliente> listar();

    public Optional<Cliente> findById(long idCliente);

    public void limparLista();

}
