package application;

import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1, "Mateus", "mateus@gmail.com");
        Cliente cliente2 = new Cliente(2, "Eliza", "eliza@gmail.com");

        Produto produto1 = new Produto(1, "Café", 10.0, 50);
        Produto produto2 = new Produto(2, "Leite", 5.0, 30);

        Pedido pedido1 = new Pedido(produto1, 2);
        Pedido pedido2 = new Pedido(produto2, 3);

        Pedido pedido3 = new Pedido(produto1, 1);
        Pedido pedido4 = new Pedido(produto2, 2);

        Venda venda1 = new Venda(1, cliente1, LocalDate.of(2024, 9, 15));
        venda1.adicionarPedido(produto1, 3);
        venda1.adicionarPedido(produto2, 4);
        venda1.calcularValorTotal();

        Venda venda2 = new Venda(2, cliente2, LocalDate.of(2024, 9, 16));
        venda2.adicionarPedido(produto1, 7);
        venda2.adicionarPedido(produto2, 12);
        venda2.calcularValorTotal();

        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda1);
        vendas.add(venda2);

        RelatorioVendas relatorio = new RelatorioVendas();

        System.out.println("======= RELATÓRIO POR CLIENTE =======");
        relatorio.gerarRelatorioPorCliente(vendas);

        System.out.println("\n======= RELATÓRIO POR PRODUTO =======");
        relatorio.gerarRelatorioPorProduto(vendas);

        System.out.println("\n======= RELATÓRIO POR PERÍODO =======");
        LocalDate dataInicio = LocalDate.of(2024, 9, 14);
        LocalDate dataFim = LocalDate.of(2024, 9, 16);
        relatorio.gerarRelatotioPorPeriodo(vendas, dataInicio, dataFim);
    }

}

