package entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioVendas {

    public void gerarRelatorioPorCliente(List<Venda> vendas) {
        System.out.println("Relatório de Vendas por Cliente");
        for (Venda venda : vendas) {
            Cliente cliente = venda.getCliente();
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Venda ID: " + venda.getId() + " | Total: R$" + venda.getValorTotal());
            System.out.println("---------------------------------------------");
        }
    }

    public void gerarRelatorioPorProduto(List<Venda> vendas) {
        System.out.println("Relatório de Vendas por Produto");
        Map<String, Integer> vendasPorProduto = new HashMap<>();

        for (Venda venda : vendas) {
            for (Pedido pedido : venda.getPedidos()) {
                Produto produto = pedido.getProduto();
                String nomeProduto = produto.getNome();
                int quantidadeVendida = pedido.getQuantidade();

                vendasPorProduto.put(nomeProduto, vendasPorProduto.getOrDefault(nomeProduto, 0) + quantidadeVendida);
            }
        }

        for (Map.Entry<String, Integer> entry : vendasPorProduto.entrySet()) {
            System.out.println("Produto: " + entry.getKey() + " | Quantidade Vendida: " + entry.getValue());
        }
    }

    public void gerarRelatotioPorPeriodo(List<Venda> vendas, LocalDate dataInicio, LocalDate dataFim) {
        System.out.println("Relatório de Vendas por Periodo: " + dataInicio + " a " + dataFim);

        for (Venda venda : vendas) {
            LocalDate dataVenda = venda.getDataVenda();
            if (dataVenda.isAfter(dataInicio.minusDays(1)) && dataVenda.isBefore(dataFim.plusDays(1))) {
                System.out.println("Venda ID: " + venda.getId() + " | Cliente: " + venda.getCliente().getNome() + " | Total: RS" + venda.getValorTotal());
                System.out.println("Data da Venda: " + dataVenda);
                System.out.println("-------------------------------------------------");
            }
        }

    }
}
