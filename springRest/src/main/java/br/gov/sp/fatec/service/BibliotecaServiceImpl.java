package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;
import br.gov.sp.fatec.repository.BibliotecaRepository;
import br.gov.sp.fatec.repository.LivroRepository;

@Service("bibliotecaService")
public class BibliotecaServiceImpl implements BibliotecaService {

	@Autowired
	private BibliotecaRepository bibliotecaRepo;
	
	@Autowired
	private LivroRepository livroR;
	
	@Autowired
	private LivroService livroService;

	
	/**
	 * @param autorizacaoRepo the autorizacaoRepo to set
	 */
	public void setBibliotecaRepo(BibliotecaRepository bibliotecaRepo) {
		this.bibliotecaRepo = bibliotecaRepo;
	}

	@Override
	@Transactional
	public void adicionarBiblioteca(String nome) {
		Biblioteca biblioteca = bibliotecaRepo.findByNome(nome);

		if (biblioteca == null) {
			biblioteca = new Biblioteca();
			biblioteca.setNome(nome);
			bibliotecaRepo.save(biblioteca);
		}

	}

	@Override
	@Transactional
	public Biblioteca buscaId(Long id) {
		Biblioteca biblioteca = bibliotecaRepo.buscaIdBiblioteca(id);

		return biblioteca;
	}

	@Override
	@Transactional
	public Biblioteca buscaNome(String nome) {
		Biblioteca biblioteca = bibliotecaRepo.buscaNome(nome);
		return biblioteca;
	}

	@Override
	@Transactional
	public List<Biblioteca> retornaBibliotecas() {
		final List<Biblioteca> bibliotecas = (List<Biblioteca>) bibliotecaRepo.findAll();
		return bibliotecas;
	}

	@Override
	public void excluirBiblioteca(Long id) {
		
		bibliotecaRepo.deleteById(id);;
	}

	@Override
	public Biblioteca salvarBiblioteca(Biblioteca biblioteca) {
		bibliotecaRepo.save(biblioteca);
		for(Livro liv: biblioteca.getLivros()) {
			livroService.incluirLivro(liv.getNome(), biblioteca.getNome());
		}
		return biblioteca;
	}

	@Override
	public Livro adicionaLivoBiblioteca(Livro livro) {
		if(livroR.findByNome(livro.getNome()) == null) {
			livroR.save(livro);
		}
		return livro;
	}

}

