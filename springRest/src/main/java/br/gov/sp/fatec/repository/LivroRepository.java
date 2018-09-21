package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

	public Livro findByNome(String nome);

	public Livro findTop1ByNomeContains(String nome);

	@Query("select l from Livro l")
	public List<Livro> retornaLivros();

	@Query("select l from Livro l join l.biblioteca b where  l.nome = ?1")
	public  List<Livro> buscaLivro(String nome);

}

