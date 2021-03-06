package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.LoginDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.login.DentalSystemServiceLogin;

@Controller
public class ClinicaCadastroController {

	@Autowired
    private DentalSystemServiceLogin service;

	@GetMapping("/clinicalogin")
	public String login(Model model) {
	 model.addAttribute("clinicalogin", new LoginDTO());
	 return "clinica/login";
	}
	
	 @GetMapping("/clinicacadastro")
		public String cadastro(Model model) {
		 model.addAttribute("clinica", new LoginDTO());
		 return "clinica/criar_conta";
	}
	 
	 @PostMapping("/clinicaadd")
		public String greetingSubmit(@ModelAttribute LoginDTO clinica, Model model) {
		 service.add(clinica);
		 return "redirect:/pacienteCadastro";
		 }
	 
	 @GetMapping("/clinicalist")
	    public ResponseEntity list(){
	        return new ResponseEntity(service.list(), HttpStatus.OK);
	    }
	}