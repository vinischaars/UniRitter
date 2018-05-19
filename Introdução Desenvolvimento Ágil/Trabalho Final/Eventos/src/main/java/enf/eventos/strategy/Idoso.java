package enf.eventos.strategy;

import org.springframework.stereotype.Component;

@Component("IDOSO")
public class Idoso implements CalcularDesconto {

	private static final double PERCENTUAL_DESCONTO = 0.5;
	
	@Override
	public double calcularValorDesconto(double valor) {
		return valor * (1 - PERCENTUAL_DESCONTO);
	}

}
