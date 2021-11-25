package br.com.lp2.projeto.dentalSystem.service.receita;

import br.com.lp2.projeto.dentalSystem.dto.ReceitaDTO;

import java.util.List;
public interface DentalSystemServiceReceita {

    List<ReceitaDTO> list(String idPaciente);

    Boolean add(String idPaciente,ReceitaDTO receita);

    Boolean edit(String idPaciente, String id,ReceitaDTO receita);

    Boolean delete(String idPaciente, String id);


}