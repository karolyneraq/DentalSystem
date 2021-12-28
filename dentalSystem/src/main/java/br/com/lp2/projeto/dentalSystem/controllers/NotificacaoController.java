package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;
import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.NotificacaoDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.agendamento.DentalSystemServiceAgendamento;
import br.com.lp2.projeto.dentalSystem.service.dentista.DentalSystemServiceDentista;
import br.com.lp2.projeto.dentalSystem.service.notificacoes.notificacao.DentalSystemServiceNotificacao;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;

@Controller
public class NotificacaoController {
	@Autowired
    private DentalSystemServiceAgendamento service;
	@Autowired
	private DentalSystemServicePaciente servicePaciente;
	@Autowired
	private DentalSystemServiceDentista serviceDentista;
	@Autowired
	private DentalSystemServiceNotificacao serviceMsg;
	
	@GetMapping("/Notificacao")
    public String notificacao(Model model) {
		model.addAttribute("dentistalista", serviceDentista.list());
		return  "notificacoes/not_dentistas";
	}
	
	@GetMapping("/NotificacaoPaciente")
    public String notificacao(@RequestParam(value = "id") String id, Model model) {
		int dP;
		dP=serviceDentista.buscarID(id);
    	DentistaDTO dentista = serviceDentista.list().get(dP);
    	model.addAttribute("dentista",  dentista);
		model.addAttribute("pacientelista", servicePaciente.list());
		return  "notificacoes/not_pacientes";
	}
	
	@GetMapping("/NotificacaoMensagemAna")
	public String notificacao1(@RequestParam(value = "pacienteId") String pacienteId, Model model) {
		int dP;
		int nome;
    	dP= servicePaciente.buscarID(pacienteId);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	nome = serviceDentista.buscarIDPorNome("Ana");
    	DentistaDTO dentista = serviceDentista.list().get(nome);
    	model.addAttribute("dentista",  dentista);
		return  "notificacoes/mensagens";
	}
	
	@GetMapping("/NotificacaoMensagemCriar")
	public String notificacao2(@RequestParam(value = "pacienteId") String pacienteId, Model model ) {
		int dP;
		int nome;
    	dP= servicePaciente.buscarID(pacienteId);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	nome = serviceDentista.buscarIDPorNome("Ana");
    	DentistaDTO dentista = serviceDentista.list().get(nome);
    	model.addAttribute("dentista",  dentista);
    	model.addAttribute("msg", " ");
		return  "notificacoes/criar";
	}
	
	@GetMapping("/Notificacao1MensagemCriar")
	public String msg1(@RequestParam(value = "pacienteId") String pacienteId, Model model) {
		int dP;
		int nome;
    	dP= servicePaciente.buscarID(pacienteId);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	nome = serviceDentista.buscarIDPorNome("Ana");
    	DentistaDTO dentista = serviceDentista.list().get(nome);
    	model.addAttribute("dentista",  dentista);
    	model.addAttribute("msg",  "Caro cliente, infelizmente seu(a) dentista teve um imprevisto e não irá atender hoje. Sua consulta terá que ser remarcada.");
		return  "notificacoes/criar1";
		
	}
	
	@GetMapping("/Notificacao2MensagemCriar")
	public String msg2(@RequestParam(value = "pacienteId") String pacienteId, Model model) {
		int dP;
		int nome;
    	dP= servicePaciente.buscarID(pacienteId);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	nome = serviceDentista.buscarIDPorNome("Ana");
    	DentistaDTO dentista = serviceDentista.list().get(nome);
    	model.addAttribute("dentista",  dentista);
    	model.addAttribute("msg",  "Caro cliente, o (a) seu (a) dentista não faz mais parte da clínica XXXXX. A partir de agora você será atendido (a) por outro profissional. A clínica entrará em contato para dar mais informações.");
		return  "notificacoes/criar2";
		
	}
	
	@GetMapping("/Notificacao3MensagemCriar")
	public String msg3(@RequestParam(value = "pacienteId") String pacienteId, Model model) {
		int dP;
		int nome;
    	dP= servicePaciente.buscarID(pacienteId);
    	PacienteDTO paciente = servicePaciente.list().get(dP);
    	model.addAttribute("paciente", paciente);
    	nome = serviceDentista.buscarIDPorNome("Ana");
    	DentistaDTO dentista = serviceDentista.list().get(nome);
    	model.addAttribute("dentista",  dentista);
    	model.addAttribute("msg",  "Caro cliente, a clínica não irá funcionar hoje. Sua consulta terá que ser remarcada.");
		return  "notificacoes/criar3";
		
	}
	
	@GetMapping("/MensagemCriar")
	public String criarMsg(@ModelAttribute NotificacaoDTO agendarMsg) {

		return "redirect:/Notificacao";
	}
	
	
    
}