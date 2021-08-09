package br.com.prime.http.model.response;

import java.util.Date;

public class MensagensErro {
	private Date dataAtual;
	private String mensagem;
	
	public MensagensErro(Date dataAtual, String mensagem) {
		this.dataAtual = dataAtual;
		this.mensagem = mensagem;
	}
	public MensagensErro(String mensagem) {
		this.mensagem = mensagem;
	}
	public Date getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
