package application;

import entities.Cliente;
import entities.Pedido;
import entities.Produto;
import entities.Venda;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "Mateus", "mateus@gmail.com");

        Produto produto = new Produto(1, "Notebook Dell", 3000.00, 5);
        Produto produto2 = new Produto(2, "Notebook Acer", 2000.00, 7);
        Produto produto3 = new Produto(2, "Notebook Lenovo", 1000.00, 10);

        Pedido pedido = new Pedido(produto, 3);
        Pedido pedido2 = new Pedido(produto2, 2);
        Pedido pedido3 = new Pedido(produto3, 0);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        Venda venda = new Venda(1,cliente,pedidos);
        boolean vendaConcluida = venda.concluirVenda();
        venda.calcularValorTotal();

        if (vendaConcluida) {
            System.out.println("Valor total da venda: R$" + venda.getValorTotal());
            System.out.println("Estoque após a venda: ");
            System.out.println(produto.getNome() + " - Estoque: " + produto.getQuantidadeEmEstoque());
            System.out.println(produto2.getNome() + " - Estoque: " + produto2.getQuantidadeEmEstoque());
            System.out.println(produto3.getNome() + " - Estoque: " + produto3.getQuantidadeEmEstoque());
        } else {
            System.out.println("A venda não pôde ser concluída!");
        }
    }
}
