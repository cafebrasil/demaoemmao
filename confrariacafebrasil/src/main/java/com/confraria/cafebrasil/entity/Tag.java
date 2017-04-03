package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TB_TAG", schema = "demaoemmao")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="DESCRICAO", length=45)
	private String descricao;

	@OneToMany(mappedBy="tag")
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
	public void setLivroTags(List<LivroTag> livroTags) {
		this.livroTags = livroTags;
	}

	
}