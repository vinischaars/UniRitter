package enf.eventos.strategy;

import org.springframework.stereotype.Component;

@Component("GOLD")
public class MembroGold implements CalcularDesconto {

	private static final double PERCENTUAL_DESCONTO = 0.75;
	
	@Override
	public double calcularValorDesconto(double valor) {
		return valor * (1 - PERCENTUAL_DESCONTO); 
	}

}
