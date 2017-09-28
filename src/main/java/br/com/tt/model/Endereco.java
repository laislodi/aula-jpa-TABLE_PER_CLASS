package br.com.tt.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "Rua", length = 250)
	private String rua;
	@Column(name = "Bairro", length = 150)
	private /* Bairro */String bairro;
	@Column(name = "Cidade", length = 200)
	private /* Cidade */String cidade;
	@Enumerated(EnumType.STRING) // escreve a descrição do ENUM
	@Column(name = "Estado", length = 2)
	private Estado estado;
	@OneToOne(cascade = ALL, fetch = LAZY)
	private Pessoa pessoa;

	public Endereco() {
		super();
	}

	public Endereco(String rua, String bairro, String cidade, Estado estado) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



}
