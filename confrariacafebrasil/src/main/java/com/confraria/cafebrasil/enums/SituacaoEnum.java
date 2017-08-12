package com.confraria.cafebrasil.enums;
/**
 *
 * @author mederafael
 *
 */
public enum SituacaoEnum {
	DISPONIVEL(1),
	INDISPONIVEL_DISPONIVEL(2)
	;
	private Integer codigo;
	SituacaoEnum(final Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(final Integer codigo) {
		this.codigo = codigo;
	}
}
