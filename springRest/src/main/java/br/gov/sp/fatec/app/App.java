package br.gov.sp.fatec.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Biblioteca;
import br.gov.sp.fatec.model.Livro;
import br.gov.sp.fatec.service.BibliotecaService;
import br.gov.sp.fatec.service.LivroService;

public class App 
{
 
	public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(	"applicationContext.xml");
 		
		BibliotecaService bibliotecaService = (BibliotecaService)context.getBean("biblioteca");
		
		Biblioteca biblioteca = new Biblioteca();
		Biblioteca biblioteca2 = new Biblioteca();
		
//		biblioteca = bibliotecaService.adicionarBiblioteca("Jose");
//		biblioteca2 = bibliotecaService.adicionarBiblioteca("Kimb");
//		
//		System.out.println("Biblioteca: " + biblioteca.getNome());
//		System.out.println("Biblioteca: " + biblioteca2.getNome());
		
		LivroService livroService = (LivroService)context.getBean("livroService");
		
		Livro livro = new Livro();
		Livro livro2 = new Livro();
		
		livro = livroService.incluirLivro("Hobbitx", "Horusy);
		livro2 = livroService.incluirLivro("Marvelx", "Messiasx");
		
		System.out.println("Livro: " + livro.getNome());
		System.out.println("Livro: " + livro2.getNome() + "\nBiblioteca: " + livro.getBiblioteca().getNome());
		
		System.out.println(livroService.retornaLivros().size());
		
		System.out.println(bibliotecaService.buscaId(23l).getNome());
		
		context.close();

    }
    
}

