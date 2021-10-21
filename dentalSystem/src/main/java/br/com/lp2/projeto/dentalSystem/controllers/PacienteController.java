package br.com.lp2.projeto.dentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;

@Controller // Define que a classe é um controller. Tinha antes o  restController que retornava o objeto gravados diretamente na resposta http como Json
public class PacienteController {

    @Autowired // Permite que o Spring injete as dependências na classe do DentalSystemServicePaciente
    private DentalSystemServicePaciente service;
    
    @GetMapping("/pacientecadastro")
	public String login(Model model) {
		 model.addAttribute("paciente", new PacienteDTO());
		 model.addAttribute("pacientelista", service.list());
		return "paciente/pacientes";
	}
        
    @PostMapping("/pacienteadd")
	public String greetingSubmit(@ModelAttribute PacienteDTO paciente, Model model) {
		  service.add(paciente);
		  model.addAttribute("paciente", paciente);
		  //Faltando o tratamento de erro do firebase
		  return "perfilPaciente/perfil_paciente";
	  }
    
    
    @GetMapping("/pacientelist")
    public  ModelAndView list(){
    	ModelAndView mv = new ModelAndView("paciente/pacientes");
    	mv.addObject("pacientelista", service.list());
    	return mv;
    }
    
    /*
    @PutMapping(value = "/{id}/pacienteeditar")
	public String greetingSubmit(@ModelAttribute PacienteDTO paciente, Model model, @PathVariable(value = "id") String id) {
		  model.addAttribute("paciente", paciente);
		  service.edit(id,paciente);
		  //Faltando o tratamento de erro do firebase
		  return "perfilPaciente/perfil_paciente";
	  }
	  
	  
    @GetMapping("/pacienteliste")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
        
	  
 
  */  
    
    @PutMapping(value = "/{id}pacienteeditar")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PacienteDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/pacientedelete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
   
   
}