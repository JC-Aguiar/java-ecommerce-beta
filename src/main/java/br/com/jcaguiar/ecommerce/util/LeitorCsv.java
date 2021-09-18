package br.com.jcaguiar.ecommerce.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import lombok.Getter;
import lombok.ToString;

@ToString
final public class LeitorCsv {
	
	@Getter
	private List<String[]> arquivo = new ArrayList<String[]>();
	private final String DIRETORIO = "C:\\Users\\JM Costal Aguiar\\eclipse-workspace\\ecommerce\\src\\main\\resources\\cadastros\\";
	
	public LeitorCsv(String nome) {
		nome = DIRETORIO + nome;
		try( CSVReader csvReader = new CSVReader(new FileReader(nome)); ) {
			csvReader.skip(1);
		    String[] line = null;
		    while ( (line = csvReader.readNext()) != null ) {
		        arquivo.add( line[0].split(";") );
		        System.out.println( Arrays.toString( line[0].split(";") ) );
		    }
		} catch (FileNotFoundException e) {
			System.out.printf("Erro: Arquivo não encontrado\n");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.printf("Erro: Falha na leitura/escrita\n");
			e.printStackTrace();
			
		} catch (CsvException e) {
			System.out.printf("Erro: Problema no manuseio do csv\n");
			e.printStackTrace();
		}
	}
	

}
