package br.com.animati.gestao.service;

import br.com.animati.gestao.entity.Projeto;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    public void cadastrar(Projeto projeto);

    public void editar(Projeto projeto);

    public void deletar(long idProjeto) throws Exception;

    public List<Projeto> listar();

    public Optional<Projeto> findById(long idProjeto);

    public void limparLista();
}
