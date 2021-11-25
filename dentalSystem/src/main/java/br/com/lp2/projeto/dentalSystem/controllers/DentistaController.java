package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.dentista.DentalSystemServiceDentista;


@Controller 
public class DentistaController {

	@Autowired
    private DentalSystemServiceDentista service;
    
	public int dP;
	
    @GetMapping("/dentistaMenu")
	public String Menu(Model model) {
    	model.addAttribute("dentistalista", service.list());
		return "medico/menu_medico";
	}

    @GetMapping("/dentistaCadastro")
	public String login(Model model) {
		 model.addAttribute("dentista", new DentistaDTO());
		return "medico/criar_medico";
	}
        
    @PostMapping("/dentistaAdd")
	public String greetingSubmit(@ModelAttribute DentistaDTO dentista, Model model) {
		  service.add(dentista);
		  model.addAttribute("dentista", dentista);
		  //Faltando o tratamento de erro do firebase
		  return "redirect:/pacienteCadastro";
	  }
    
    @GetMapping("/dentistaEditar")
	public String alterarDentista(@RequestParam(value = "id") String id, Model model) {
    	dP= service.buscarID(id);
    	DentistaDTO dentista = service.list().get(dP);
    	model.addAttribute("paciente", dentista);
        	return "paciente/atualizar_paciente";
	}
    
    @PostMapping("/dentistaUpdates")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute DentistaDTO dentista ) {
    	  service.edit(id,dentista);
		  return  "redirect:/pacienteCadastro";
    }
    
    @GetMapping("/dentistaDeletar")
   	public String deleteDentista(@RequestParam(value = "id") String id, Model model) {
       	dP= service.buscarID(id);
       	DentistaDTO dentista = service.list().get(dP);
       	model.addAttribute("dentista", dentista);
       	return "paciente/excluir_paciente";
   	}
       
      
       @GetMapping("/dentistaExcluir")
   	public String deleteSubmit(@RequestParam(value = "id") String id) {
       	  service.delete(id);
   		  return "redirect:/pacienteCadastro";
       }
}