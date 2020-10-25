package br.com.tst.domain;

import java.io.Serializable;

import br.com.tst.enums.TipoRiscoEnum;
import lombok.Data;

public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Float valor;
    private TipoRiscoEnum risco;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TipoRiscoEnum getRisco() {
		return risco;
	}
	public void setRisco(TipoRiscoEnum risco) {
		this.risco = risco;
	}
    
    
    
}
