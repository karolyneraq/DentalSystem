package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;
import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.agendamento.DentalSystemServiceAgendamento;
import br.com.lp2.projeto.dentalSystem.service.dentista.DentalSystemServiceDentista;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;



@Controller
public class AgendamentoController {
	@Autowired
    private DentalSystemServiceAgendamento service;
	@Autowired
	private DentalSystemServicePaciente servicePaciente;
	@Autowired
	private DentalSystemServiceDentista serviceDentista;
	
	@GetMapping("/AgendamentoCadastro")
    public String agendamento(@RequestParam(value = "id", required = false) String idP, Model model) {
    	int dP= servicePaciente.buscarID(idP);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	AgendamentoDTO agendar = new AgendamentoDTO();
    	agendar.setIdPaciente(paciente.getId());
    	agendar.setNomePaciente(paciente.getNome());
    	model.addAttribute("agendamento",agendar);
    	return  "paciente/agendamento";
	}
	/*
    @GetMapping("/AgendamentoCadastro")
    public String agendamento(@RequestParam(value = "id", required = false) String idP, Model model) {
    	int dP= servicePaciente.buscarID(idP);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	AgendamentoDTO agendar = new AgendamentoDTO();
    	agendar.setIdPaciente(paciente.getId());
    	agendar.setNomePaciente(paciente.getNome());
    	model.addAttribute("agendamento",agendar);
    	model.addAttribute("dentistalista", serviceDentista.list());
    	System.out.println(serviceDentista.list());
    	return  "paciente/agendamento";
	}
    */
    
    @PostMapping("/AgendamentoAdd")
	public String agendamentoSubmit(@RequestParam(value = "id", required = false) String idP, @ModelAttribute AgendamentoDTO agendamento, Model model) {
    	
    	service.add(idP,agendamento);
		return  "redirect:/pacienteCadastro";
    }
 
}