package br.gov.sp.fatec.web.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;
import br.gov.sp.fatec.repository.BibliotecaRepository;
import br.gov.sp.fatec.service.BibliotecaService;
import br.gov.sp.fatec.view.View;
import br.gov.sp.fatec.view.View.BibliotecaSemNome;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
	
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@RequestMapping(value= "/salvarBiblioteca", method = RequestMethod.POST)
	public ResponseEntity<Biblioteca> salvarBiblioteca(@RequestBody Biblioteca biblioteca, HttpServletRequest request, HttpServletResponse response){
		biblioteca = bibliotecaService.salvarBiblioteca(biblioteca);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/biblioteca/salvarBiblioteca?nome=" + biblioteca.getNome());
		return new ResponseEntity<Biblioteca>(biblioteca, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getIdBiblioteca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.BibliotecaNome.class)
	public ResponseEntity<Biblioteca> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Biblioteca biblioteca = bibliotecaService.buscaId(id);
		if(biblioteca == null) {
			return new ResponseEntity<Biblioteca>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Biblioteca>(biblioteca, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@JsonView(View.UsuarioCompleto.class)
//	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
//		usuario = usuarioService.salvar(usuario);
//		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
//		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
//	}

}
