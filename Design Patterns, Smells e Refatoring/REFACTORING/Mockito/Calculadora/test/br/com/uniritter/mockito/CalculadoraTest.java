package br.com.uniritter.mockito;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void Test01(){
		Calculadora mockedCalc = mock(Calculadora.class);

		// Usando o mock object
		mockedCalc.setDescricao("Calculadora Mockito");
		mockedCalc.getDescricao();

		//Verificações
		verify(mockedCalc).setDescricao("Calculadora Mockito");
		verify(mockedCalc).getDescricao();
	}
	
	@Test
	public void Test02(){
		
		Calculadora mockedCalc = mock(Calculadora.class);
		when(mockedCalc.adicao(3.0, 5.0).thenReturn(8.0));

		Assert.assetEquals(8.0, mockedCalc.adicao(3.0, 5.0), 0.0);
		Assert.assetEquals(11.0, mockedCalc.adicao(6.0, 5.0), 0.0);
	}
}