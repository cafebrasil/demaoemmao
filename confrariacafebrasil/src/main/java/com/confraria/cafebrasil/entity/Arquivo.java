package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_ARQUIVO database table.
 * 
 */
@Entity
@Table(name="TB_ARQUIVO", schema = "demaoemmao")
@NamedQuery(name="Arquivo.findAll", query="SELECT a FROM Arquivo a")
public class Arquivo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Lob
	@Column(name="ARQUIVO", nullable=false)
	private byte[] arquivo;

	@Column(name="ATIVO", length=45)
	private Boolean ativo;

	@OneToMany(mappedBy="arquivo")
	private List<LivroImagem> livros;

	public Arquivo() {
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
	 * @return the arquivo
	 */
	public byte[] getArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
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
	 * @return the livros
	 */
	public List<LivroImagem> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<LivroImagem> livros) {
		this.livros = livros;
	}


}