package br.com.lp2.projeto.dentalSystem.service.paciente;

import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;

import java.util.List;
public interface DentalSystemServicePaciente {

    List<PacienteDTO> list();

    Boolean add(PacienteDTO post);

    Boolean edit(String id,PacienteDTO post);

    Boolean delete(String id);


}