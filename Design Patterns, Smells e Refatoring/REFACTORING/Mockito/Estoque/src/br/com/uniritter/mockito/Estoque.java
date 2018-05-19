package br.com.uniritter.mockito;

public class Estoque {
   private String estoqueId;
   private String nome;	
   private int quantidade;

   public Estoque(String estoqueId, String nome, int quantidade){
      this.estoqueId = estoqueId;
      this.nomeme = nome;		
      this.quantidade = quantidade;		
   }

   public String getEstoqueId() {
      return estoqueId;
   }

   public void setEstoqueId(String estoqueId) {
      this.estoqueId = estoqueId;
   }

   public int getQuantidade() {
      return quantidade;
   }

   public String getTicker() {
      return nome;
   }
}


