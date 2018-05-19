package br.com.uniritter.mockito;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import br.com.uniritter.mockito.Estoque;
import br.com.uniritter.mockito.EstoqueService;
import br.com.uniritter.mockito.CarteiraProdutos;

public class CarteiraProdutosTest {
	
   CarteiraProdutos carteiraProdutos;	
   EstoqueService estoqueService;
	   
   public static void main(String[] args){
      CarteiraProdutosTest teste = new CarteiraProdutosTest();
      teste.setAcima();
      System.out.println(teste.testeValorMercado()?"PASSOU":"FALHOU");
   }
   
   public void setAcima(){
      // Crie um objeto CarteiraProdutos que seja testavel
      carteiraProdutos = new CarteiraProdutos();		
  
      // Crie o objeto mock do servico Estoque
      estoqueService = mock(EstoqueService.class);		
  
      // Configure o Estoque para a Carteira de Produtos
      carteiraProdutos.setEstoqueService(estoqueService);
   }
  
   public boolean testeValorMercado(){
    	   
      // Cria uma lista de produtos a serem adicionados à Carteira de Produtos
      List<Estoque> estoques = new ArrayList<Estoque>();
      Estoque koenigseggEstoque = new Estoque("1","Koenigsegg CCXR Trevita", 10);
      Estoque lamborghiniEstoque = new Estoque("2","Lamborghini Veneno",100);
      Estoque lykanEstoque = new Estoque("3","Lykan Hypersport ",100);	
      Estoque bugattiEstoque = new Estoque("4","Bugatti Veyron Mansory Vivere", 10);
      Estoque ferrariEstoque = new Estoque("5","Ferrari FXX K",100);
     
      estoques.add(koenigseggEstoque);
      estoques.add(lamborghiniEstoque);
	  estoques.add(lamborghiniEstoque);
      estoques.add(bugattiEstoque);
	  estoques.add(ferrariEstoque);
	  
      // Adicione ações a Carteira de Produtos
      carteiraProdutos.setEstoques(estoques);

      // Mock o comportamento do serviço de Estoque para retornar o valor de v produtos
      when(estoqueService.getPreco(koenigseggEstoque)).thenReturn(50.00);
      when(estoqueService.getPreco(lamborghiniEstoque)).thenReturn(1000.00);	
      when(estoqueService.getPreco(lykanEstoque)).thenReturn(1000.00);	
      when(estoqueService.getPreco(bugattiEstoque)).thenReturn(1000.00);	
      when(estoqueService.getPreco(ferrariEstoque)).thenReturn(1000.00);	

      double valorMercado = carteiraProdutos.getValorMercado();		
      return valorMercado == 400500.0;
   }
}
