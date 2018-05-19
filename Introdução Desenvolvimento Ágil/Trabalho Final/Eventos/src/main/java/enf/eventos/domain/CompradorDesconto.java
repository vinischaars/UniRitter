package enf.eventos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompradorDesconto {
	ESTUDANTE("ESTUDANTE"),
    IDOSO("IDOSO"),
    GOLD("GOLD"),
    SILVER("SILVER"),
    GERAL("GERAL");

	private String comprador;
	
}
