package br.com.lp2.projeto.dentalSystem.service.dentista;

import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;

import java.util.List;
public interface DentalSystemServiceDentista {

    List<DentistaDTO> list();

    Boolean add(DentistaDTO dentista);

    Boolean edit(String id, DentistaDTO dentista);

    Boolean delete(String id);


}