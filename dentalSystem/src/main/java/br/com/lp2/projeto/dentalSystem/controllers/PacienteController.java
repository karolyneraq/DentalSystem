package br.com.lp2.projeto.dentalSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.MedicamentoDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;

@Controller 
public class PacienteController {

	
    @Autowired 
    private DentalSystemServicePaciente service;
    private int dP;
    
    
    
    @GetMapping("/pacientelist")
    public  String list(Model model){
    	model.addAttribute("pacientelista", service.list());
    	return "paciente/pacientes";
    }
    
    
    @GetMapping("/pacienteCadastro")
	public String login(Model model) {
		 model.addAttribute("paciente", new PacienteDTO());
		 model.addAttribute("pacientelista", service.list());
		return "paciente/pacientes";
	}
        
    @PostMapping("/pacienteAdd")
	public String greetingSubmit(@ModelAttribute PacienteDTO paciente, Model model) {
		  service.add(paciente);
		  model.addAttribute("paciente", paciente);
		  //Faltando o tratamento de erro do firebase
		  return "paciente/perfil_paciente";
	  }
    
    @GetMapping("/pacienteEditar/{id}")
	public String alterarPaciente(@PathVariable(value = "id") String id, Model model) {
    	dP= buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	return "paciente/atualizar_paciente";
	}
    
    @PostMapping("/pacienteUpdates/{id}")
	public String editSubmit(@PathVariable(value = "id") String id, @ModelAttribute PacienteDTO paciente ) {
    	  service.edit(id,paciente);
		  return  "redirect:/pacienteCadastro";
    }
    
    @GetMapping("/pacienteDeletar/{id}")
	public String deletePaciente(@PathVariable(value = "id") String id, Model model) {
    	dP= buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	return "paciente/excluir_paciente";
	}
    
    @GetMapping("/pacienteExcluir/{id}")
	public String deleteSubmit(@PathVariable(value = "id") String id) {
    	  service.delete(id);
		  return "redirect:/pacienteCadastro";
    }
    
    @GetMapping("/pacientePerfil/{id}")
	public String pefilPaciente(@PathVariable(value = "id") String id, Model model) {
    	dP= buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	return "paciente/perfil_paciente";
	}
    public int buscarID(String id) {
    	boolean verificar;
    	int achou=0;
    	for(int i=0; i<service.list().size(); i++) {
    		verificar = service.list().get(i).getId().contains(id);
    		if(verificar==true) {
    			achou=i;
    		}
    	}
    	return achou;
    }
    
}