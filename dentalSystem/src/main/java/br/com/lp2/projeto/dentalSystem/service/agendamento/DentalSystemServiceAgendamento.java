package br.com.lp2.projeto.dentalSystem.service.agendamento;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;

import java.util.List;
public interface DentalSystemServiceAgendamento {

    List<AgendamentoDTO> list(String idPaciente);

    Boolean add(String idPaciente,AgendamentoDTO agendamento);

    Boolean edit(String idPaciente, String id,AgendamentoDTO agendamento);

    Boolean delete(String idPaciente, String id);


}