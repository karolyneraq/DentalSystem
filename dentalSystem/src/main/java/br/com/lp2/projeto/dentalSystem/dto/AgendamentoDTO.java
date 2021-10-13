package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class AgendamentoDTO {
	
	private String id;
	private String nomePaciente;
	private String data;
	private String horario;
	private String nomeMedico;
	private String obs;

	public AgendamentoDTO(String id, String nomePaciente, String nomeMedico, String data, String horario, String obs) {
		super();
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.data = data;
		this.horario = horario;
		this.obs = obs;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	
}
