package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class ReceitaDTO {
	
	private String id;
	private String data;
	private String medicamento;
	private String quantidade;
	private String medida;
	private String prescricao;
	
	private String idMedico;
	
	private String nomePaciente;
	
	public ReceitaDTO() {
		super();
		this.id = id;
		this.data = data;
		this.medicamento = medicamento;
		this.quantidade = quantidade;
		this.medida = medida;
		this.prescricao = prescricao;
		this.idMedico = idMedico;
		this.nomePaciente = nomePaciente;
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

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getIdPaciente() {
		return nomePaciente;
	}

	public void setIdPaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	

}