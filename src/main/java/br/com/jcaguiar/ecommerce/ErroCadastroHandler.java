package br.com.jcaguiar.ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jcaguiar.ecommerce.dto.ErroCadastroDto;

@RestControllerAdvice
public final class ErroCadastroHandler {
	
	@Autowired
	private MessageSource messageSource;

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**ERRO NO CADASTRO
	 * Tratamento de exceções quando o dto enviado ao sistema não atende aos requisitos dos atributos da classe modelo
	 * @param exc = MethodArgumentNotValidException
	 * @return ExceptionDto + HttpStatus 400 (BAD_REQUEST)
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroCadastroDto> handler(MethodArgumentNotValidException exc) {
		//Coletando atributos inválidos
		List<FieldError> listaErro = exc.getBindingResult().getFieldErrors();
		
		//Preparando lista DTO
		List<ErroCadastroDto> listaErroDto = new ArrayList<ErroCadastroDto>();
		
		//Iterando listas
		for(FieldError erro : listaErro) {
			final String CAMPO =  erro.getField();
			final String MENSAGEM = messageSource.getMessage(erro, LocaleContextHolder.getLocale() );
			listaErroDto.add( new ErroCadastroDto(CAMPO, MENSAGEM) );
		}
		
		//Retornando exceptionDto
		return listaErroDto;
	}
	
}
