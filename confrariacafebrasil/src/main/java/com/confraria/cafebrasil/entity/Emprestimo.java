package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="TB_EMPRESTIMO", schema = "demaoemmao")
@NamedQuery(name="Emprestimo.findAll", query="SELECT e FROM Emprestimo e")
public class Emprestimo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="ATIVO")
	private Boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_DEVOLUCAO", nullable=false)
	private Date dtDevolucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_EMPRESTIMO", nullable=false)
	private Date dtEmprestimo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LIVRO", nullable=false)
	private Livro livro;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO", nullable=false)
	private Usuario usuario;

	public Emprestimo() {
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
	 * @return the dtDevolucao
	 */
	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	/**
	 * @param dtDevolucao the dtDevolucao to set
	 */
	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	/**
	 * @return the dtEmprestimo
	 */
	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	/**
	 * @param dtEmprestimo the dtEmprestimo to set
	 */
	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
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