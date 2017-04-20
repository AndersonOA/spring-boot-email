/**
 * 
 */
package br.com.makersweb.email.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author anderson.aristides
 *
 */
@Entity
@Table(name = "tb_cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "email", "telefone" }))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cliente extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -689705686480185503L;

	@Column(name = "nome", nullable = false, length = 150)
	private String nome;

	@Column(name = "email", nullable = false, unique = true, length = 255)
	private String email;

	@Column(name = "senha", length = 30)
	private String senha;

	@Column(name = "telefone", nullable = false, unique = true, length = 11)
	private String telefone;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
