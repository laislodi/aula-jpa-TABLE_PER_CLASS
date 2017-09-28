package br.com.tt;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Aluno;
import br.com.tt.model.Cliente;
import br.com.tt.model.Curso;
import br.com.tt.model.Pessoa;
import br.com.tt.model.Professor;

public class Sistema {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();
		
		Aluno aluno = new Aluno();
		aluno.setNome("Pedro Silva");
		aluno.setCpf("123.123.123-09");
		aluno.setMatricula("0000000");
		
		Curso curso = new Curso();
		curso.setNome("JPA - Hibernate");
		curso.setCodigo("123456");
		curso.setCargaHoraria(32);
		curso.setValor(786.60d);
		aluno.addCurso(curso);
		
		Professor professor = new Professor();
		professor.setNome("Paulo Heck");
		professor.setSalario(new BigDecimal(15000));
		
		Cliente cliente = new Cliente();
		cliente.setCnpj("1928372161/0001");
		cliente.setRazaoSocial("TargetTrust");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Augusto Rival");
		pessoa.setTelefone("23123456");
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.persist(cliente);
		em.persist(professor);
		em.persist(pessoa);
		em.getTransaction().commit();
		em.clear();
		em.close();
		
		System.exit(0);
	}
}
