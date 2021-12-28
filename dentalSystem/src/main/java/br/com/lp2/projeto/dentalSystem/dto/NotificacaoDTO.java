package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class NotificacaoDTO {
	
	private String id;
	private String nomeMedico;
	private String nomePaciente;
	private String msg;
	
	
	
	
	public NotificacaoDTO() {
		super();
		this.id = id;
		this.nomeMedico = nomeMedico;
		this.nomePaciente = nomePaciente;
		this.msg = msg;
	}
	
	
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
}
