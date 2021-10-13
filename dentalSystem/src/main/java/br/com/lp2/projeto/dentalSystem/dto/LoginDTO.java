package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class LoginDTO {

	private String id;
	private String nomeDentista;
	private String nomeClinica;
	private String email;
	private String senha;
	
	
	public LoginDTO() {
		super();
		this.id = id;
		this.nomeDentista = nomeDentista;
		this.nomeClinica = nomeClinica;
		this.email = email;
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeDentista() {
		return nomeDentista;
	}
	public void setNomeDentista(String nomeDentista) {
		this.nomeDentista = nomeDentista;
	}
	public String getNomeClinica() {
		return nomeClinica;
	}
	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
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
	
	
	
}
