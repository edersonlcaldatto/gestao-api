package br.com.animati.gestao.service;

import br.com.animati.gestao.DAO.AtividadeDAO;
import br.com.animati.gestao.entity.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeDAO atividadeDAO;

    @Override
    public Atividade cadastrar(Atividade atividade) {
        atividadeDAO.save(atividade);
        return atividade;
    }

    @Override
    public void editar(Atividade atividade) {
        atividadeDAO.save(atividade);
    }

    @Override
    public void deletar(long idAtividade) throws Exception {
        atividadeDAO.deleteById(idAtividade);
    }

    @Override
    public List<Atividade> listar() {
        return atividadeDAO.findAll();
    }

    @Override
    public Optional<Atividade> findById(long idAtividade) {
        return atividadeDAO.findById(idAtividade);
    }

    @Override
    public void limparLista() {
        atividadeDAO.deleteAll();
    }
}
