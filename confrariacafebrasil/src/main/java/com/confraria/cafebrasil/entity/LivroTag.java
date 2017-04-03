package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TB_LIVRO_TAG", schema = "demaoemmao")
@NamedQuery(name="LivroTag.findAll", query="SELECT l FROM LivroTag l")
public class LivroTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_LIVRO", nullable=false)
	private Livro livro;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_TAG", nullable=false)
	private Tag tag;

	public LivroTag() {
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
	 * @return the tag
	 */
	public Tag getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(Tag tag) {
		this.tag = tag;
	}

	

}