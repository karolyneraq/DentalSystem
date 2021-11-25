package br.com.lp2.projeto.dentalSystem.service.medicamento;

import br.com.lp2.projeto.dentalSystem.dto.MedicamentoDTO;

import java.util.List;
public interface DentalSystemServiceMedicamento {

    List<MedicamentoDTO> list();

    Boolean add(MedicamentoDTO medicamento);

    Boolean edit(String id,MedicamentoDTO medicamento);

    Boolean delete(String id);
    
    int buscarID(String id);
    
    String buscarIDPorNome(String nome);
}