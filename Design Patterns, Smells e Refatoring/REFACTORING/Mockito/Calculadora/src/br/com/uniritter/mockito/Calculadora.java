package br.com.uniritter.mockito;

public class Calculadora {
	private String descricao;

	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public double adicao(double numero1, double numero2){
		return numero1 + numero2;
	}

	public double subtracao(double numero1, double numero2){
		return numero1 - numero2;
	}

	public double multiplicacao(double numero1, double numero2){
		return numero1 * numero2;
	}

	public double divisao(double numero1, double numero2){
		return numero1 / numero2;
	}
}

