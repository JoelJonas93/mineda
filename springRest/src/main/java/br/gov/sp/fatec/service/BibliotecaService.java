package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;

public interface BibliotecaService {
	
	public void adicionarBiblioteca(String nome);
	
	public Biblioteca buscaId(Long id);
	
	public Biblioteca buscaNome(String nome);
	
	public List<Biblioteca> retornaBibliotecas();
	
	public void excluirBiblioteca(Long id);
	
	public Biblioteca salvarBiblioteca(Biblioteca biblioteca);
	
	public Livro adicionaLivoBiblioteca(Livro livro);
	
}
