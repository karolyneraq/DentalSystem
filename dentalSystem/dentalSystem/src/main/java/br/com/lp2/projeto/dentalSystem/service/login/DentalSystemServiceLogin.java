package br.com.lp2.projeto.dentalSystem.service.login;

import br.com.lp2.projeto.dentalSystem.dto.LoginDTO;

import java.util.List;

public interface DentalSystemServiceLogin {

	List<LoginDTO> list();

    Boolean add(LoginDTO login);

    Boolean edit(String id,LoginDTO login);

    Boolean delete(String id);
}
