package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TB_FILA_ESPERA", schema = "demaoemmao")
@NamedQuery(name="FilaEspera.findAll", query="SELECT f FROM FilaEspera f")
public class FilaEspera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_SOLICITACAO", nullable=false)
	private Date dataSolicitacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LIVRO", nullable=false)
	private Livro livro;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO", nullable=false)
	private Usuario usuario;

	public FilaEspera() {
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
	 * @return the dataSolicitacao
	 */
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	/**
	 * @param dataSolicitacao the dataSolicitacao to set
	 */
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
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


}