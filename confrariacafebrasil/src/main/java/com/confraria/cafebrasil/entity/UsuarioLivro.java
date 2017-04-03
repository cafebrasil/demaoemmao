package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="RL_USUARIO_LIVRO", schema = "demaoemmao")
@NamedQuery(name="UsuarioLivro.findAll", query="SELECT u FROM UsuarioLivro u")
public class UsuarioLivro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioLivroPK id;

	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_LIVRO", nullable=false, insertable=false, updatable=false)
	private Livro livro;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_USUARIO", nullable=false, insertable=false, updatable=false)
	private Usuario usuario;

	public UsuarioLivro() {
	}

	public UsuarioLivroPK getId() {
		return this.id;
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
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UsuarioLivroPK id) {
		this.id = id;
	}

}