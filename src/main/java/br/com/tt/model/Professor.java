package br.com.tt.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {

	private BigDecimal salario;
	private String pisPasep;

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

}
