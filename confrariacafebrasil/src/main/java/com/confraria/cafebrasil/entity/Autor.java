package com.confraria.cafebrasil.entity;

import java.io.Serializable;

public class Autor implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3173554244373605348L;
	private String id;
	private String codigo;
	private String nome;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
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
	public void setNome(final String nome) {
		this.nome = nome;
	}



}
