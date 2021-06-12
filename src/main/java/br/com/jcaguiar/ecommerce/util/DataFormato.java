package br.com.jcaguiar.ecommerce.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

final public class DataFormato {
	
	final static DateTimeFormatter DATA_FORMATO = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss (EEE)");
	
	final static public String formatar(LocalDateTime data) {
		return data.format(DATA_FORMATO);
	}

}
