package br.com.lp2.projeto.dentalSystem.service.agendamento;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;

import java.util.List;
public interface DentalSystemServiceAgendamento {

    List<AgendamentoDTO> list();

    Boolean add(AgendamentoDTO agendamento);

    Boolean edit(String id,AgendamentoDTO agendamento);

    Boolean delete(String id);


}