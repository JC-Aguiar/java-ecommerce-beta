package br.com.jcaguiar.ecommerce.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import br.com.jcaguiar.ecommerce.Console;
import lombok.Getter;
import lombok.ToString;

@ToString
final public class LeitorCsv {
	
	@Getter
	private List<String[]> arquivo = new ArrayList<String[]>();
	private final String DIRETORIO = "C:\\Users\\JM Costal Aguiar\\eclipse-workspace\\ecommerce\\src\\main\\resources\\cadastros\\";
	
	public LeitorCsv(String nome) {
		//nome = DIRETORIO + nome;
		Path diretorio = Paths.get(nome);
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		try(BufferedReader reader = Files.newBufferedReader(diretorio,  StandardCharsets.UTF_8);
			CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();) {				
			csvReader.skip(1);
		    arquivo = csvReader.readAll();

		} catch (FileNotFoundException e) {
			Console.log("Erro: Arquivo não encontrado\n");
			e.printStackTrace();
			
		} catch (IOException e) {
			Console.log("Erro: Falha na leitura/escrita\n");
			e.printStackTrace();
			
		} catch (CsvException e) {
			Console.log("Erro: Problema no manuseio do csv\n");
			e.printStackTrace();
		}
	}
	

}
