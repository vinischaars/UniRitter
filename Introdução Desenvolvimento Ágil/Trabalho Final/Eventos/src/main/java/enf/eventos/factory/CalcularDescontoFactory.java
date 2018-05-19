package enf.eventos.factory;

import enf.eventos.strategy.CalcularDesconto;

public interface CalcularDescontoFactory {
	CalcularDesconto getStrategy(String tipoDesconto);
}
