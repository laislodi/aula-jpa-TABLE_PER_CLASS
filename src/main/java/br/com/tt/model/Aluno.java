package br.com.tt.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.DATE;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class Aluno extends Cliente {

	private String matricula;
	private String curso;
	@Temporal(DATE)
	private Calendar data;
	@ManyToMany(cascade = ALL)
	// 	@formatter:off
	@JoinTable(
			name="relacao_aluno_curso",
			joinColumns= {@JoinColumn(name="aluno_key")},
			inverseJoinColumns= {@JoinColumn(name="curso_key")}
	)
	private List<Curso> cursos;
	//	@formatter:on

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void addCurso(Curso curso) {
		if (curso != null) {
			if (cursos == null) {
				cursos = new ArrayList<Curso>();
			}
			cursos.add(curso);
			curso.addAluno(this);
		}
	}

}
