package br.com.uniritter.mockito;

import java.util.List;

public class CarteiraProdutos {
   private EstoqueService estoqueService;
   private List<Estoque> estoques;

   public EstoqueService getEstoqueService() {
      return estoqueService;
   }
   
   public void setEstoqueService(EstoqueService estoqueService) {
      this.estoqueService = estoqueService;
   }

   public List<Estoque> getEstoques() {
      return estoques;
   }

   public void setEstoques(List<Estoque> estoques) {
      this.estoques = estoques;
   }

   public double getValorMercado(){
      double valorMercado = 0.0;
      
      for(Estoque estoque:estoques){
         valorMercado += estoqueService.getPreco(estoque) * estoque.getQuantidade();
      }
      return valorMercado;
   }
}

