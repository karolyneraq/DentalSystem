package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;

@Controller
public class LoginUsuarioController {
	
	 @Autowired // Permite que o Spring injete as dependências na classe do DentalSystemServicePaciente
	    private DentalSystemServicePaciente service;
	 
	@GetMapping("/testeinicio")
	public String login(Model model) {
		 model.addAttribute("paciente", new PacienteDTO());
		return "paciente/pacientes";
	}
	
	  @PostMapping("/testeadd")
	  public String greetingSubmit(@ModelAttribute PacienteDTO paciente, Model model) {
		  ResponseEntity a =  new ResponseEntity(service.add(paciente), HttpStatus.OK);
		  return "ok";
	  }
	
}
