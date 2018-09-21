package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Biblioteca;

public interface BibliotecaRepository extends CrudRepository<Biblioteca, Long>{
	public Biblioteca findByNome(String nome);
	
	@Query("select b from Biblioteca b where b.id = ?1")
	public Biblioteca buscaIdBiblioteca(Long id);
	
	@Query("select b from Biblioteca b where b.nome = ?1")
	public Biblioteca buscaNome(String nome);

}
