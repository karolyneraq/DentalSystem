package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.MedicamentoDTO;
import br.com.lp2.projeto.dentalSystem.service.medicamento.DentalSystemServiceMedicamento;

@Controller
public class MedicamentoController {

	@Autowired
    private DentalSystemServiceMedicamento service;

	public int dP;
	
	@GetMapping("/medicamentoMenu")
	public String Menu(Model model) {
    	model.addAttribute("medicamentolista", service.list());
		return "medicamento/menu_medicamento";
	}
	
	@GetMapping("/medicamentoCadastro")
	public String login(Model model) {
		 model.addAttribute("medicamento", new MedicamentoDTO());
		return "medicamento/cadastrar_medicamento";
	}
        
    @PostMapping("/medicamentoAdd")
	public String greetingSubmit(@ModelAttribute MedicamentoDTO medicamento, Model model) {
		  service.add(medicamento);
		  model.addAttribute("medicamento", medicamento);
		  //Faltando o tratamento de erro do firebase
		  return "redirect:/medicamentoMenu";
	  }
    
    @GetMapping("/medicamentoEditar")
	public String alterarDentista(@RequestParam(value = "id") String id, Model model) {
    	dP= service.buscarID(id);
    	MedicamentoDTO medicamento = service.list().get(dP);
    	model.addAttribute("medicamento", medicamento);
        	return "paciente/atualizar_paciente";
	}
    
    @PostMapping("/medicamentoUpdates")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute MedicamentoDTO medicamento ) {
    	  service.edit(id,medicamento);
		  return  "redirect:/pacienteCadastro";
    }
    
    @GetMapping("/medicamentoDeletar")
   	public String deleteDentista(@RequestParam(value = "id") String id, Model model) {
       	dP= service.buscarID(id);
       	MedicamentoDTO medicamento = service.list().get(dP);
       	model.addAttribute("dentista", medicamento);
       	return "paciente/excluir_paciente";
   	}
       
      
       @GetMapping("/medicamentoExcluir")
   	public String deleteSubmit(@RequestParam(value = "id") String id) {
       	  service.delete(id);
   		  return "redirect:/pacienteCadastro";
       }
}