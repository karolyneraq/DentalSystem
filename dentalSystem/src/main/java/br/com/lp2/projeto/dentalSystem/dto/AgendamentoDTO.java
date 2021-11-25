package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class AgendamentoDTO {
	
	private String id;
	private String data;
	private String horario;
	private String obs;
	
	private String idMedico;
	private String nomeMedico;
	private String nomePaciente;
	private String idPaciente;
	

	
	
	public AgendamentoDTO() {
		super();
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.obs = obs;
		this.nomeMedico = nomeMedico;
		this.idMedico = idMedico;
		this.nomePaciente = nomePaciente;
		this.idPaciente = idPaciente;
	}

	
	public String getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	
}
