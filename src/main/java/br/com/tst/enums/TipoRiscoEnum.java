package br.com.tst.enums;

public enum TipoRiscoEnum {

	RISCO_BAIXO(1), RISCO_MEDIO(2), RISCO_ALTO(3);  

	private Integer codigo;

	TipoRiscoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
}