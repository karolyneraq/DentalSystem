package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class MedicamentoDTO {
	
	private String id;
	private String nome;
	private String tipo;
	private String medida;
	private String posologia;
	private String receitaControlada;
	
	
	public MedicamentoDTO(String id, String nome, String tipo, String medida, String posologia,
			String receitaControlada) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.medida = medida;
		this.posologia = posologia;
		this.receitaControlada = receitaControlada;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getPosologia() {
		return posologia;
	}
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	public String getReceitaControlada() {
		return receitaControlada;
	}
	public void setReceitaControlada(String receitaControlada) {
		this.receitaControlada = receitaControlada;
	}
	
	
}
