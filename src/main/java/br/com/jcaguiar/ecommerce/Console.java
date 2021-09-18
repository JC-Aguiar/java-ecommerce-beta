package br.com.jcaguiar.ecommerce;

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
	//@Value("${ecommerce.systemLog}") private static String log;
	private static boolean LOG = true;
	private static int LV = 0;


	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**LOG DO SISTEMA
	 * Método único responsável por exibir as informaçoes
	 * @param txt
	 */
	public static void log(String txt) {
		if(!LOG) {
			return;
		}
		for(int i = 0; i < LV; i++) {
			System.out.printf("\t");
		}
		System.out.println(txt);
	}
	
	public static void log(Number txt) {
		log(String.valueOf(txt));
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
	
	public static void log(Number txt, int lv) {
		log(String.valueOf(txt), lv);
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
