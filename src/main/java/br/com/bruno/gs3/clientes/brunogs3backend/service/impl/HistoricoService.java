package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.HistoricoTransacao;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.HistoricoRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTransacaoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public void gravaHistorico(String login, TipoTransacaoEnum tipo) {
        HistoricoTransacao historico = new HistoricoTransacao();
        historico.setData(LocalDateTime.now());
        historico.setUsuario(login);
        historico.setTipoTransacao(tipo.getDesc());
        historicoRepository.save(historico);
    }
}
