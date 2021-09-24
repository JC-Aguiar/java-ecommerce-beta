package br.com.jcaguiar.ecommerce.util;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jcaguiar.ecommerce.Console;

public class JsonConverter implements AttributeConverter<Object, String> {

	private final static ObjectMapper mapper = new ObjectMapper();
	
	/**CONVERTER PARA BANDO DE DADOS
	 * 
	 */
	@Override
	public String convertToDatabaseColumn(Object entidade) {
		try {
			Console.log("[JSON-CONVERTER]: Convertendo Json para String");
			return mapper.writeValueAsString(entidade);
		}
		catch (Exception ex) {
			Console.log("[JSON-CONVERTER]: Erro na conversão");
			return null;
		}
	}

	/**CONVERTER PARA CLASSE
	 * 
	 */
	@Override
	public Object convertToEntityAttribute(String dbData) {
		try {
			Console.log("[JSON-CONVERTER]: Convertendo String para Json");
			return mapper.readValue(dbData, Object.class);
		}
		catch (Exception ex) {
			Console.log("[JSON-CONVERTER]: Erro na conversão");
			return null;
		}
	}

}
