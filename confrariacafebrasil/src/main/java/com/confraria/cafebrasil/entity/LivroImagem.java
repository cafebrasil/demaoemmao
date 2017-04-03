package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="RL_LIVRO_IMAGEM", schema = "demaoemmao")
@NamedQuery(name="LivroImagem.findAll", query="SELECT l FROM LivroImagem l")
public class LivroImagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="ATIVO", nullable=false, length=45)
	private Boolean ativo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ARQUIVO", nullable=false)
	private Arquivo arquivo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LIVRO", nullable=false)
	private Livro livro;

	public LivroImagem() {
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
	 * @return the arquivo
	 */
	public Arquivo getArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
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


}