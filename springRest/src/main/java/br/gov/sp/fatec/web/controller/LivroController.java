package br.gov.sp.fatec.web.controller;
import br.gov.sp.fatec.view.View;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.LivroRepository;
import br.gov.sp.fatec.service.BibliotecaService;
import br.gov.sp.fatec.service.LivroService;

@RestController
@RequestMapping(value = "/livro") 
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroRepository livroRepo;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	public void setLivroService(LivroService livroService) {
		this.livroService = livroService;
	}

	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST )
	@JsonView(View.LivroCompleto.class)
	public ResponseEntity<Livro> cadastroLivro(@RequestBody Livro livro, HttpServletRequest request, HttpServletResponse response ) {
		livro = livroService.salvarLivro(livro);
		response.addHeader("Location",request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/livro/cadastro?nome=" + livro.getNome());
		return new ResponseEntity<Livro>(livro, HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.LivroSemId.class)
	public ResponseEntity<Livro> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Livro livro = livroService.buscaLivroId(id);
		if(livro == null) {
			return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Livro>(livro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNomeBiblioteca", method = RequestMethod.GET)
	@JsonView(View.LivroIdNome.class)
	public ResponseEntity<List<Livro>> getBiblioteca(@RequestParam(value="nome", defaultValue="1") String nome) {
		Biblioteca biblioteca = bibliotecaService.buscaNome(nome);
		List<Livro> livros = livroService.buscaLivroBiblioteca(biblioteca.getId());
		if(livros == null) {
			return new ResponseEntity<List<Livro>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
	}
	
	
}
