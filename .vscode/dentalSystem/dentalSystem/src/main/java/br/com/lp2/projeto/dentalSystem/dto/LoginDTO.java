package br.com.lp2.projeto.dentalSystem.dto;

import lombok.Data;

@Data
public class LoginDTO {

	private String id;
	private String usuario;
	private String email;
	private String senha;
	
	
	public LoginDTO(String id, String usuario, String email, String senha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
