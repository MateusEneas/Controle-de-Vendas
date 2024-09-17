package application;

import entities.Cliente;
import entities.Pedido;
import entities.Produto;
import entities.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        produtos.add(new Produto(1, "Notebook Dell", 3000.00, 5));
        produtos.add(new Produto(2, "Notebook Acer", 2000.00, 7));
        produtos.add(new Produto(2, "Notebook Lenovo", 1000.00, 10));

        clientes.add(new Cliente(1, "Mateus", "mateus@gmail.com"));

        Cliente cliente = clientes.get(0); // João
        Venda venda = new Venda(1, cliente);
        venda.adicionarPedido(produtos.get(0),1);
        venda.adicionarPedido(produtos.get(1), 2);

        venda.calcularValorTotal();
        vendas.add(venda);

        System.out.println("Venda realizada por: " + venda.getCliente().getNome());
        System.out.println("Itens comprados:");
        venda.getPedidos().forEach(p -> System.out.println(p.getProduto().getNome() + " - Quantidade: " +p.getQuantidade()));
        System.out.println("Valor total: R$" + venda.getValorTotal());

        System.out.println("\nEstoque atualizado:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - Estoque: " + produto.getQuantidadeEmEstoque());
        }
    }
}
