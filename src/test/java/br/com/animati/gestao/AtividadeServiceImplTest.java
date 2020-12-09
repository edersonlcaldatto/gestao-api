package br.com.animati.gestao;

import br.com.animati.gestao.entity.*;
import br.com.animati.gestao.service.AtividadeService;
import br.com.animati.gestao.service.ClienteService;
import br.com.animati.gestao.service.ProjetoService;
import br.com.animati.gestao.service.ResponsavelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AtividadeServiceImplTest {

    @Autowired
    private AtividadeService atividadeService;
    @Autowired
    private ProjetoService projetoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ResponsavelService responsavelService;

    void init(){
        Cliente cliente = new Cliente();
        cliente.setNome("Hospital Santa Casa");
        cliente.setCnpj("12345678912345");

        clienteService.cadastrar(cliente);

        Responsavel responsavel = new Responsavel();
        responsavel.setNome("Ederson");
        responsavel.setFuncao(FuncaoEnum.PROGRAMADOR);

        responsavelService.cadastrar(responsavel);

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste");
        projeto.setDescricao("Desenvolver integração");
        projeto.setCliente(clienteService.findById(cliente.getIdcliente()).get());

        projetoService.cadastrar(projeto);

    }

    private void initAtividades(){
        init();

        Atividade atividade = new Atividade();
        atividade.setProjeto(projetoService.findById(1).get());
        atividade.setTask("Criar integraçao");
        atividade.setResponsavel(responsavelService.findById(1).get());
        atividade.setStatus(StatusEnum.PENDENTE);
        atividadeService.cadastrar(atividade);

        Atividade atividade2 = new Atividade();
        atividade2.setProjeto(projetoService.findById(1).get());
        atividade2.setTask("Criar documentação");
        atividade2.setResponsavel(responsavelService.findById(1).get());
        atividade2.setStatus(StatusEnum.PENDENTE);
        atividadeService.cadastrar(atividade2);

    }

    @Test
    public void TestAtividade(){
        initAtividades();

        List<Atividade> list = atividadeService.listar();
        for (Atividade atividade: list) {
            System.out.println(atividade.getTask());
        }
    }








}
