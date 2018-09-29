package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "bib_biblioteca")
public class Biblioteca {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bib_id")
	@JsonView({View.BibliotecaSemNome.class})
	private Long id;
	
    @Column(name = "bib_nome", unique=true, length = 20, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "biblioteca" )
    @JsonView({View.BibliotecaSemNome.class})
    private List<Livro> livros;
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
    
    

}

