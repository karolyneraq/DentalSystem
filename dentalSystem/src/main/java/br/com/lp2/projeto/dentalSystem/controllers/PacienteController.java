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
    private String idTemporario = null;
    private int dP;
    
    
    
    @GetMapping("/pacientelist")
    public  ModelAndView list(){
    	ModelAndView mv = new ModelAndView("paciente/pacientes");
    	mv.addObject("pacientelista", service.list());
    	return mv;
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
		  return "perfilPaciente/perfil_paciente";
	  }
    
    @GetMapping("/pacienteEditar/{id}")
	public String alterarPaciente(@PathVariable(value = "id") String id, Model model) {
    	 model.addAttribute("paciente", new PacienteDTO());
		 model.addAttribute("pacienteDados", service.list());
		 dP= buscarID(id);
		 model.addAttribute("pacienteDados", service.list().get(dP));
    		return "paciente/atualizar_paciente";
	}
    
    
    @GetMapping("/pacienteAtualizar")
    public  ModelAndView dadosAtualizar(){
    	ModelAndView mv = new ModelAndView("paciente/atualizar_paciente");
    	mv.addObject("pacienteDados", service.list().get(dP));
    	
    	return mv;
    }
    
    @PutMapping("/pacienteUpdates")
	public String editSubmit(@ModelAttribute PacienteDTO paciente, Model model ) {
    	  service.edit(idTemporario,paciente);
		  model.addAttribute("paciente", paciente);
		  //Faltando o tratamento de erro do firebase
		  return "perfilPaciente/perfil_paciente";
    }
    
    @GetMapping("/pacienteDeletar/{id}")
   	public String deletePaciente(@PathVariable(value = "id") String id, Model model) {
   		 dP= buscarID(id);
   		idTemporario=id;
   		 model.addAttribute("pacienteExcluindo", service.list().get(dP));
       		return "paciente/excluir_paciente";
   	}
    
    @GetMapping("/pacienteDelete")
    public  ModelAndView dadosDelete(){
    	ModelAndView mv = new ModelAndView("paciente/excluir_paciente");
    	mv.addObject("pacienteExcluindo", service.list().get(dP));
    	return mv;
    }
    
    @DeleteMapping("/pacienteExcluir")
	public String deleteSubmit() {
    	  service.delete(idTemporario);
		  return "redirect:/pacienteCadastro";
    }
    
    
    public int buscarID(String id) {
    	boolean verificar;
    	int achou=0;
    	for(int i=0; i<service.list().size(); i++) {
    		verificar = service.list().get(i).getId().contains(id);
    		System.out.println(verificar);
    		if(verificar==true) {
    			achou=i;
    		}
    	}
    	return achou;
    }
    
}