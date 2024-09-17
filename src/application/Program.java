package application;

import entities.Cliente;
import entities.Pedido;
import entities.Produto;
import entities.Venda;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Produto produto = new Produto(1, "Notebook Dell", 3000.00, 5);
        Produto produto2 = new Produto(2, "Notebook Acer", 2200.00, 7);

        Cliente cliente = new Cliente(1, "Mateus", "mateus@gmail.com");
        Cliente cliente2 = new Cliente(2, "Eliza", "eliza@gmail.com");

        Pedido pedido = new Pedido(produto, 2);
        Pedido pedido2 = new Pedido(produto2, 3);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        pedidos.add(pedido2);

        Venda venda = new Venda(1,cliente,pedidos);
        Venda venda2 = new Venda(2, cliente2, pedidos);
        venda.calcularValorTotal();

        System.out.println("Produto 1: " + produto.getNome() + ", preço: R$" + produto.getPreco());
        System.out.println("Produto 2: " + produto2.getNome() + ", preço: R$" + produto2.getPreco());

        System.out.println();

        System.out.println("Cliente 1: " + cliente.getNome() + ", email: " + cliente.getEmail());
        System.out.println("Cliente 2: " + cliente2.getNome() + ", email: " + cliente2.getEmail());

        System.out.println();

        System.out.println("Produto: " + pedido.getProduto().getNome());
        System.out.println("Quantidade: " + pedido.getQuantidade());
        System.out.println("Preço Total: " + pedido.calcularPrecoTotal());

        System.out.println("===========================================================");

        System.out.println("Cliente: " + venda.getCliente().getNome());
        System.out.println("Valor total da venda: R$" + venda.getValorTotal());

        System.out.println();

        System.out.println("Cliente: " + venda2.getCliente().getNome());
        System.out.println("Valor total da venda: R$" + venda.getValorTotal());

    }
}
