package entities;

import java.util.ArrayList;

public class Pedido {

    private Produto produto;
    private int quantidade;

    public Pedido(ArrayList<Produto> produtos, int quantidade) {
    }

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularPrecoTotal() {
        return produto.getPreco() * quantidade;
    }

}
