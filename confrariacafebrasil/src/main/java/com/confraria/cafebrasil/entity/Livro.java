package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TB_LIVRO", schema = "demaoemmao")
@NamedQueries({
	@NamedQuery(name = "Livro.listarTodos",
			query = "SELECT new com.confraria.cafebrasil.entity.Livro(l.codigo,l.ativo,l.autor,l.isbn,l.titulo)"
					+ " FROM Livro l ") ,
	@NamedQuery(name = "Livro.pesquisar", query = ""
			+ "SELECT new com.confraria.cafebrasil.entity.Livro(l.codigo,l.ativo,l.autor,l.isbn,l.titulo) "
			+ "FROM Livro l where l.titulo like ?1 or l.autor like ?1") })

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro implements Serializable {

	/**
	 * @param codigo
	 * @param ativo
	 * @param autor
	 * @param isbn
	 * @param titulo
	 */
	public Livro(final Long codigo, final Boolean ativo, final String autor, final BigInteger isbn,
			final String titulo) {
		super();
		this.codigo = codigo;
		this.ativo = ativo;
		this.autor = autor;
		this.isbn = isbn;
		this.titulo = titulo;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", unique = true, nullable = false)
	private Long codigo;

	@Column(name = "ATIVO", length = 45)
	private Boolean ativo;

	@Column(name = "AUTOR", nullable = false, length = 400)
	private String autor;

	@Column(name = "NUMERO_ISBN", precision = 10)
	private BigInteger isbn;

	@Column(name = "TITULO", nullable = false, length = 400)
	private String titulo;

	@OneToMany(mappedBy = "livro")
	private List<LivroImagem> imagens;

	@OneToMany(mappedBy = "livro")
	private List<UsuarioLivro> usuarios;

	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy = "livro")
	private List<FilaEspera> esperas;

	@OneToMany(mappedBy = "livro")
	private List<LivroTag> tags;

	public Livro() {

	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
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
	 * @param ativo
	 *            the ativo to set
	 */
	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(final String autor) {
		this.autor = autor;
	}

	/**
	 * @return the isbn
	 */
	public BigInteger getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(final BigInteger isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the imagens
	 */

	public List<LivroImagem> getImagens() {
		return imagens;
	}

	/**
	 * @param imagens
	 *            the imagens to set
	 */
	public void setImagens(final List<LivroImagem> imagens) {
		this.imagens = imagens;
	}

	/**
	 * @return the usuarios
	 */

	public List<UsuarioLivro> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(final List<UsuarioLivro> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the emprestimos
	 */

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param emprestimos
	 *            the emprestimos to set
	 */
	public void setEmprestimos(final List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	/**
	 * @return the esperas
	 */

	public List<FilaEspera> getEsperas() {
		return esperas;
	}

	/**
	 * @param esperas
	 *            the esperas to set
	 */
	public void setEsperas(final List<FilaEspera> esperas) {
		this.esperas = esperas;
	}

	/**
	 * @return the tags
	 */

	public List<LivroTag> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<LivroTag> tags) {
		this.tags = tags;
	}

}