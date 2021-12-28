package br.com.lp2.projeto.dentalSystem.service.notificacoes.notificacao;

import br.com.lp2.projeto.dentalSystem.dto.NotificacaoDTO;

import java.util.List;
public interface DentalSystemServiceNotificacao {

    List<NotificacaoDTO> list();

    Boolean add(NotificacaoDTO msg);

    Boolean edit( String id,NotificacaoDTO msg);

    Boolean delete(String id);


}