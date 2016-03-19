package br.com.trainning.pdv2.domain.model;

import java.util.List;

public class Compra {
    private Carrinho carrinho;
    private List<Item> itens;


    public Carrinho getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}