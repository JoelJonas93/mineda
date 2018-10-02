package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name= "liv_livro")
public class Livro {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "liv_id")
	@JsonView({View.LivroIdNome.class, View.LivroCompleto.class})
	private Long id;
	
	@Column(name = "liv_nome", unique=true, length = 20, nullable = false)
	@JsonView({View.LivroSemId.class, View.LivroSemIdAlternativo.class, View.LivroIdNome.class, View.LivroCompleto.class, View.BibliotecaCompleta.class})
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="liv_bib_id",nullable =false)
	@JsonView({View.LivroCompleto.class})
	private  Biblioteca biblioteca;
	
		

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

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
	
	
}
	
	
