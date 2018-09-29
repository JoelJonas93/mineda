package br.gov.sp.fatec.view;

/**
 * Esta classe define as diferentes visualizacoes disponiveis para serializacoes
 */
public class View {
	
	public class LivroCompleto {

	}

	public class LivroIdNome {

	}

	/**
	 * Visualizacao principal com os principais atributos
	 * 
	 */
	public static class BibliotecaSemNome{
		
	}
	
	public static class LivroSemId{
		
	}
	
	public static class LivroSemIdAlternativo{
		
	}
	
	public static class UsuarioResumo {
	}
	
	/**
	 * Visualizacao com todos os atributos
	 * Inclui tudos os atributos marcados com Main
	 */
	public static class UsuarioCompleto extends UsuarioResumo {
	}
	
	/**
	 * Visualizacao alternativa
	 */
	public static class UsuarioResumoAlternativo {
	}

}
