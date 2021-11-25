package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.ReceitaDTO;
import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.agendamento.DentalSystemServiceAgendamento;
import br.com.lp2.projeto.dentalSystem.service.dentista.DentalSystemServiceDentista;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;



@Controller
public class ReceitaController {
	@Autowired
    private DentalSystemServiceAgendamento service;
	@Autowired
	private DentalSystemServicePaciente servicePaciente;
	@Autowired
	private DentalSystemServiceDentista serviceDentista;
	
	
    @GetMapping("/ReceitaCadastro")
    public String receita(@RequestParam(value = "id", required = false) String idP, Model model) {
    	
    	return  "paciente/receita";
	}
    
  
 
}