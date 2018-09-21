package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Livro;

public interface LivroService {
	
	public Livro incluirLivro( String nome , String nomeBiblioteca);
	
	public void incluirDoisLivros(String nomeLivro1 , String nomeLivro2);
	
	public List<Livro> retornaLivros();
	
	public List<Livro> buscaLivro();
	
	

}