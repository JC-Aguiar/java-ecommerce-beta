package br.com.jcaguiar.ecommerce;

import org.springframework.beans.factory.annotation.Value;

public final class Console {
	/**CONCEITO
	 * Classe responsável em exibir informações do sistema no console se o atributo global estiver ativado
	 * @author JM Costal Aguiar
	 * 
	 */
	/**ATRIBUTOS
	 * 		Log:		para exibir informações no console
	 * 					(valor coletado no arquivo "application.properties")
	 */
	@Value("${ecommerce.system.log}") private static boolean LOG;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**LOG DO SISTEMA
	 * Método único responsável por exibir as informaçoes
	 * @param txt
	 */
	public static void log(String txt) {
		if(LOG) {
			System.out.printf("txt");
		}
	}

}
