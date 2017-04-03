package com.confraria.cafebrasil.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class UsuarioLivroPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO", unique=true, nullable=false)
	private Long codigo;

	@Column(name="CODIGO_USUARIO", insertable=false, updatable=false, unique=true, nullable=false)
	private Long codigoUsuario;

	@Column(name="CODIGO_LIVRO", insertable=false, updatable=false, unique=true, nullable=false)
	private Long codigoLivro;

	public UsuarioLivroPK() {
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
	 * @return the codigoUsuario
	 */
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * @param codigoUsuario the codigoUsuario to set
	 */
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	/**
	 * @return the codigoLivro
	 */
	public Long getCodigoLivro() {
		return codigoLivro;
	}

	/**
	 * @param codigoLivro the codigoLivro to set
	 */
	public void setCodigoLivro(Long codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((codigoLivro == null) ? 0 : codigoLivro.hashCode());
		result = prime * result + ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioLivroPK other = (UsuarioLivroPK) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoLivro == null) {
			if (other.codigoLivro != null)
				return false;
		} else if (!codigoLivro.equals(other.codigoLivro))
			return false;
		if (codigoUsuario == null) {
			if (other.codigoUsuario != null)
				return false;
		} else if (!codigoUsuario.equals(other.codigoUsuario))
			return false;
		return true;
	}
	
}