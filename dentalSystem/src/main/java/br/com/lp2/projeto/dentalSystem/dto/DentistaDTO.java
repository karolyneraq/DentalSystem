package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class DentistaDTO {
	
	private String id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String cRO;
	private String especialidade;
	private String email;
	private String senha;
	private String celular;
	
	
	public DentistaDTO() {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cRO = cRO;
		this.especialidade = especialidade;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCRO() {
		return cRO;
	}
	public void setCRO(String cRO) {
		this.cRO = cRO;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
