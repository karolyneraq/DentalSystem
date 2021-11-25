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

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.agendamento.DentalSystemServiceAgendamento;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;

@Controller 
public class PacienteController {

	
    @Autowired 
    private DentalSystemServicePaciente service;
    @Autowired
    private DentalSystemServiceAgendamento serviceAgendar;
    private String nomeP = null;
    public int dP;
    
    
    
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
    	int cod = 1+service.list().size();
    	String nP= String.valueOf(cod);
    	paciente.setNumero(nP);
    	service.add(paciente);
		  model.addAttribute("paciente", paciente);
		  //Faltando o tratamento de erro do firebase
		  return "redirect:/pacienteCadastro";
	  }
    
    @GetMapping("/pacienteEditar")
	public String alterarPaciente(@RequestParam(value = "id") String id, Model model) {
    	dP= service.buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("paciente", paciente);
        	return "paciente/atualizar_paciente";
	}
    
    @PostMapping("/pacienteUpdates")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute PacienteDTO paciente ) {
    	  service.edit(id,paciente);
		  return  "redirect:/pacienteCadastro";
    }
     @GetMapping("/pacienteDeletar")
	public String deletePaciente(@RequestParam(value = "id") String id, Model model) {
    	dP= service.buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	return "paciente/excluir_paciente";
	}
    
   
    @GetMapping("/pacienteExcluir")
	public String deleteSubmit(@RequestParam(value = "id") String id) {
    	  service.delete(id);
		  return "redirect:/pacienteCadastro";
    }
    
    @GetMapping("/pacientePerfilList/{nome}")
    public  String Perfillist(@PathVariable(value = "nome") String nome){
    	String idNome= service.buscarIDPorNome(nome);
    	return "redirect:/pacientePerfil(id="+nome+"})";
    }
    
    @RequestMapping("/pacientePerfil")
	public String pefilPaciente(@RequestParam(value = "id") String id, Model model) {
    	dP= service.buscarID(id);
    	PacienteDTO paciente = service.list().get(dP);
		model.addAttribute("Agendamentolista", serviceAgendar.list(id));
    	System.out.println(service.list().get(dP).getNumero());
    	model.addAttribute("paciente", paciente);
    	return "paciente/perfil_paciente";
	}
    
    
    
    
    /*@PostMapping("/nomepaciente")
    public  String pesquisarNome(@RequestParam("nomepaciente") String nome, Model model){
    	dP= buscarNome(nome);
    	PacienteDTO paciente = service.list().get(dP);
    	model.addAttribute("pacientelista", paciente);
    	return "paciente/pacientes";
    }
    */
    public int buscarNome(String nome) {
    	boolean verificar;
    	int achou=0;
    	for(int i=0; i<service.list().size(); i++) {
    		verificar = service.list().get(i).getNome().toLowerCase().contains(nome.toLowerCase());
    		if(verificar==true) {
    			achou=i;
    		}
    	}
    	return achou;
    }
    
    
    
}