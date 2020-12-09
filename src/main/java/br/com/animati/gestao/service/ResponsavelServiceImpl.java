package br.com.animati.gestao.service;

import br.com.animati.gestao.DAO.ResponsavelDAO;
import br.com.animati.gestao.entity.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

    @Autowired
    private ResponsavelDAO responsavelDAO;

    @Override
    public void cadastrar(Responsavel responsavel) {
        responsavelDAO.save(responsavel);
    }

    @Override
    public void editar(Responsavel responsavel) {
        responsavelDAO.save(responsavel);
    }

    @Override
    public void deletar(long idResponsavel) throws Exception {
        responsavelDAO.deleteById(idResponsavel);
    }

    @Override
    public List<Responsavel> listar() {
        return responsavelDAO.findAll();
    }

    @Override
    public Optional<Responsavel> findById(long idResponsavel) {
        return responsavelDAO.findById(idResponsavel);
    }

    @Override
    public void limparLista() {
        responsavelDAO.deleteAll();
    }

}
