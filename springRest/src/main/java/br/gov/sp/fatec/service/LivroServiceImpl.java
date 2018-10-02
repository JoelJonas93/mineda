package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Autorizacao;
import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.BibliotecaRepository;
import br.gov.sp.fatec.repository.LivroRepository;

@Service("livroService")
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepository livroRepo;

	@Autowired
	private BibliotecaRepository biblioRepo;

	public LivroRepository getLivroRepo() {
		return livroRepo;
	}

	public void setLivroRepo(LivroRepository livroRepo) {
		this.livroRepo = livroRepo;
	}

	public BibliotecaRepository getBiblioRepo() {
		return biblioRepo;
	}

	public void setBiblioRepo(BibliotecaRepository biblioRepo) {
		this.biblioRepo = biblioRepo;
	}

	@Override
	@Transactional
	public Livro incluirLivro(String nome, String nomeBiblioteca) {

		Biblioteca biblioteca = biblioRepo.findByNome(nomeBiblioteca);

		if (biblioteca != null) {
			Livro livro = new Livro();
			livro.setNome(nome);
			livro.setBiblioteca(biblioteca);
			livroRepo.save(livro);
			return livro;
		} else {
			return null;
		}

	}

	@Override
	@Transactional
	public void incluirDoisLivros(String nomeLivro1, String nomeLivro2) {
		Livro livro = new Livro();
		livro.setNome(nomeLivro1);
		livroRepo.save(livro);

		livro = new Livro();
		livro.setNome(nomeLivro2);
		livroRepo.save(livro);

	}

	@Override
	@Transactional
	public List<Livro> retornaLivros() {
		List<Livro> livros = new ArrayList<Livro>();

		livros = livroRepo.retornaLivros();
		return livros;
	}

	@Override
	public List<Livro> buscaLivro() {
		List<Livro> livros = new ArrayList<Livro>();
		return livros;
	}

	@Override
	@Transactional
	public Livro buscaLivroId(Long idLivro) {
		Optional<Livro> livro = livroRepo.findById(idLivro);
		if (livro.isPresent()) {
			return livro.get();
		}
		return null;
	}

	@Override
	@Transactional
	public Livro buscaLivroNome(String nome) {
		return livroRepo.buscaLivro(nome);
	}

	@Override
	public List<Livro> buscaLivroBiblioteca(Long id) {
		List<Livro> liOptional = livroRepo.buscaLivroBiblioteca(id);
		return liOptional;
	}

	@Override
	@Transactional
	public Livro salvarLivro(Livro livro) {

		if (livroRepo.findById(livro.getId()) == null) {
			livroRepo.save(livro);
		}
		return livro;
	}

}
