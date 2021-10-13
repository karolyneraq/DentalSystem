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
    
    @GetMapping("/cadastro")
	public String login(Model model) {
		 model.addAttribute("paciente", new PacienteDTO());
		return "paciente/pacientes";
	}
    

    @PostMapping("/add")
	public String greetingSubmit(@ModelAttribute PacienteDTO paciente, Model model) {
		  service.add(paciente);
		  //Faltando o tratamento de erro do firebase
		  return "pacienteOK";
	  }

    @PutMapping(value = "/{id}/updateLogin")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PacienteDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}