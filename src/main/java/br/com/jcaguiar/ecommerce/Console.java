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
	private static int LV = 0;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**LOG DO SISTEMA
	 * Método único responsável por exibir as informaçoes
	 * @param txt
	 */
	public static void log(String txt) {
//		if(!LOG) {
//			return;
//		}
		for(int i = 0; i < LV; i++) {
			System.out.printf("\t");
		}
		System.out.printf(txt);
		System.out.println();
	}
	
	/**LOG DO SISTEMA COM LEVEL DE ESPAÇAMENTO
	 * Para exibir log interno já com acréscimo ou decréscimo de espaçamento
	 * @param txt = mensagem a exibir no console
	 * @param lv = valor para adicionar ou diminuir no espaçamento
	 */
	public static void log(String txt, int lv) {
		LV += lv<0 ? lv : 0;
		log(txt);
		LV += lv>0 ? lv : 0;
	}
	
	/**AUMENTANDO ESPAÇAMENTO
	 * 
	 */
	public static void lvUp() {
		LV++;
	}
	
	/**DIMINUINDO ESPAÇAMENTO
	 * 
	 */
	public static void lvDown() {
		LV--;
	}

}
