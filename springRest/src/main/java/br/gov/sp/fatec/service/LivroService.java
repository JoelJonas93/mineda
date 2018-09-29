package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Livro;

public interface LivroService {
	
	public Livro incluirLivro( String nome , String nomeBiblioteca);
	
	public void incluirDoisLivros(String nomeLivro1 , String nomeLivro2);
	
	public List<Livro> retornaLivros();
	
	public List<Livro> buscaLivro();
	
	public Livro buscaLivroNome(String nome);
	
	public Livro buscaLivroId(Long idLivro);
	
	public List<Livro> buscaLivroBiblioteca(Long id);
	
	public Livro salvarLivro(Livro livro);

}
