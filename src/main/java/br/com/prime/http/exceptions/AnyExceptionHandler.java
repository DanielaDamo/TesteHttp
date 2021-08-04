package br.com.prime.http.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.prime.http.model.response.MensagensErro;

@ControllerAdvice
public class AnyExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> tratamentoDeExcecoes(Exception e, WebRequest request){
		String descricaoErro = e.getLocalizedMessage();
		if(descricaoErro==null) {
			descricaoErro = e.toString();
		}
		MensagensErro mensagem = new MensagensErro(new Date(), descricaoErro);
		return new ResponseEntity<>(mensagem, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
