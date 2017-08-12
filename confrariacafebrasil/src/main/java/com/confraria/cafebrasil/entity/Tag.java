package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TB_TAG", schema = "demaoemmao")
@NamedNativeQuery(name = "tag.exists", query = "select 1 from demaoemmao.TB_TAG a "
		+ "where exists (select 1 from demaoemmao.TB_TAG b where b.CODIGO = a.CODIGO "
		+ "and a.DESCRICAO =  ?1 )")
@NamedQueries({
	@NamedQuery(name = "Tag.listarTodos", query = "SELECT t FROM Tag t") ,
	@NamedQuery(name = "Tag.recuperarPorDescricao", query = "SELECT t FROM Tag t where t.descricao = ?1 ")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="DESCRICAO", length=45)
	private String descricao;

	@OneToMany(mappedBy="tag")
	@XmlTransient
	private List<LivroTag> livroTags;

	public Tag() {
	}

	/**
	 * @return the livroTags
	 */
	public List<LivroTag> getLivroTags() {
		return livroTags;
	}

	/**
	 * @param livroTags the livroTags to set
	 */
	public void setLivroTags(final List<LivroTag> livroTags) {
		this.livroTags = livroTags;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}