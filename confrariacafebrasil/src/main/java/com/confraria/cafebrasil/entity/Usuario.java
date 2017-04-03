package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TB_USUARIO", schema = "demaoemmao")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;

	@Column(name="EMAIL", nullable=false, length=45)
	private String email;

	@Column(name="ID_TELEGRAM", nullable=false, length=30)
	private String telegram;

	@Column(name="NOME", nullable=false, length=45)
	private String nome;

	@OneToMany(mappedBy="usuario")
	private List<UsuarioLivro> usuarioLivros;

	@OneToMany(mappedBy="usuario")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy="usuario")
	private List<FilaEspera> filasEspera;

	public Usuario() {
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telegram
	 */
	public String getTelegram() {
		return telegram;
	}

	/**
	 * @param telegram the telegram to set
	 */
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the usuarioLivros
	 */
	public List<UsuarioLivro> getUsuarioLivros() {
		return usuarioLivros;
	}

	/**
	 * @param usuarioLivros the usuarioLivros to set
	 */
	public void setUsuarioLivros(List<UsuarioLivro> usuarioLivros) {
		this.usuarioLivros = usuarioLivros;
	}

	/**
	 * @return the emprestimos
	 */
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param emprestimos the emprestimos to set
	 */
	public void setEmprestimos(List<Emprestimo> tbEmprestimos) {
		this.emprestimos = tbEmprestimos;
	}

	/**
	 * @return the filasEspera
	 */
	public List<FilaEspera> getFilasEspera() {
		return filasEspera;
	}

	/**
	 * @param filasEspera the filasEspera to set
	 */
	public void setFilasEspera(List<FilaEspera> tbFilaEsperas) {
		this.filasEspera = tbFilaEsperas;
	}


}