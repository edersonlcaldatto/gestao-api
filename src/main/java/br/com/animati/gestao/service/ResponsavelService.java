package br.com.animati.gestao.service;

import br.com.animati.gestao.entity.Responsavel;

import java.util.List;
import java.util.Optional;

public interface ResponsavelService {

    public Responsavel cadastrar(Responsavel reponsavel);

    public void editar(Responsavel reponsavel);

    public void deletar(long IdResponsavel) throws Exception;

    public List<Responsavel> listar();

    public Optional<Responsavel> findById(long IdResponsavel);

    public void limparLista();

}
