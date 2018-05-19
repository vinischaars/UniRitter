package enf.eventos.strategy;

import org.springframework.stereotype.Component;

@Component("GERAL")
public class PublicoGeral implements CalcularDesconto {

	@Override
	public double calcularValorDesconto(double valor) {
		return valor;
	}

}
