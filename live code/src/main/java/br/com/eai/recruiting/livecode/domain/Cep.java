package br.com.eai.recruiting.livecode.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CEP")
public class Cep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "cep", length = 250, nullable = false)
	private String cep;

	@Column(name = "logradouro", length = 250, nullable = false)
	private String logradouro;

	@Column(name = "complemento", length = 250, nullable = false)
	private String complemento;

	@Column(name = "bairro", length = 250, nullable = false)
	private String bairro;

	@Column(name = "localidade", length = 250, nullable = false)
	private String localidade;

	@Column(name = "uf", length = 250, nullable = false)
	private String uf;

	@Column(name = "ibge", length = 250, nullable = false)
	private String ibge;

	@Column(name = "gia", length = 250, nullable = false)
	private String gia;

	@Column(name = "ddd", length = 250, nullable = false)
	private String ddd;

	@Column(name = "siafi", length = 250, nullable = false)
	private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}
}
