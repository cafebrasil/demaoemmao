package com.confraria.cafebrasil.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TB_LIVRO_TAG", schema = "demaoemmao")
@NamedQueries({
		@NamedQuery(name="LivroTag.removeByLivro", query="delete from LivroTag l where l.livro.codigo = ?1"),
		@NamedQuery(name="LivroTag.findAll", query="SELECT l FROM LivroTag l"),
		@NamedQuery(name ="LivroTag.findByCodigoLivro",
			query = "SELECT new com.confraria.cafebrasil.entity.LivroTag(l.codigo,l.ativo,l.livro.codigo,l.tag.codigo,l.tag.descricao) FROM LivroTag l where l.livro.codigo = ?1")
		})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LivroTag implements Serializable {
	private static final long serialVersionUID = 1L;



	/**
	 * @param codigo
	 * @param ativo
	 * @param livro
	 * @param tag
	 */
	public LivroTag(final Long codigo, final Boolean ativo, final Long livroCodigo, final Long codigtag, final String descricaoTag) {
		super();
		this.codigo = codigo;
		this.ativo = ativo;
		setLivro(new Livro());
		getLivro().setCodigo(livroCodigo);
		setTag(new Tag());
		getTag().setCodigo(codigtag);
		getTag().setDescricao(descricaoTag);
	}

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
	public void setCodigo(final Long codigo) {
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
	public void setAtivo(final Boolean ativo) {
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
	public void setLivro(final Livro livro) {
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
	public void setTag(final Tag tag) {
		this.tag = tag;
	}
}