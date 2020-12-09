package br.com.animati.gestao.service;

import br.com.animati.gestao.DAO.ProjetoDAO;
import br.com.animati.gestao.entity.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoDAO projetoDAO;

    @Override
    public Projeto cadastrar(Projeto projeto) {
        projetoDAO.save(projeto);
        return projeto;
    }

    @Override
    public void editar(Projeto projeto) {
        projetoDAO.save(projeto);
    }

    @Override
    public void deletar(long idProjeto) throws Exception {
        projetoDAO.deleteById(idProjeto);
    }

    @Override
    public List<Projeto> listar() {
        return projetoDAO.findAll();
    }

    @Override
    public Optional<Projeto> findById(long idProjeto) {
        return projetoDAO.findById(idProjeto);
    }

    @Override
    public void limparLista() {
        projetoDAO.deleteAll();
    }

}
