package br.com.animati.gestao.service;

import br.com.animati.gestao.entity.Atividade;

import java.util.List;
import java.util.Optional;

public interface AtividadeService {

    public void cadastrar(Atividade atividade);

    public void editar(Atividade atividade);

    public void deletar(long idAtividade) throws Exception;

    public List<Atividade> listar();

    public Optional<Atividade> findById(long idAtividade);

    public void limparLista();

}
