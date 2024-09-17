package entities;

import exception.EstoqueInsuficienteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private int id;
    private Cliente cliente;
    private List<Pedido> pedidos;
    private LocalDate dataVenda;
    private double valorTotal;

    public Venda() {
    }

    public Venda(int id, Cliente cliente, LocalDate dataVenda) {
        this.id = id;
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calcularValorTotal() {
        valorTotal = 0.0;
        for (Pedido pedido : pedidos) {
            valorTotal += pedido.calcularPrecoTotal();
        }
    }

    public void atualizarEstoque() throws EstoqueInsuficienteException {
        for (Pedido pedido : pedidos) {
            Produto produto = pedido.getProduto();
            int quantidadeVendida = pedido.getQuantidade();
            produto.reduzirEstoque(quantidadeVendida);
        }
    }

    public boolean verificarEstoque() {
        for (Pedido pedido : pedidos) {
            Produto produto = pedido.getProduto();
            int quantidadeVendida = pedido.getQuantidade();
            if (quantidadeVendida > produto.getQuantidadeEmEstoque()) {
                System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
                return false;
            }
        }
        return true;
    }

    public void adicionarPedido(Produto produto, int quantidade) {
        Pedido pedido = new Pedido(produto, quantidade);
        pedidos.add(pedido);
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
    }

    public boolean concluirVenda() {
        try {
            if (verificarEstoque()) {
                calcularValorTotal();
                atualizarEstoque();
                System.out.println("Venda concluída com sucesso!");
                return true;
            } else {
                System.out.println("Venda não realizada devido a estoque insuficiente!");
                return false;
            }
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro ao atualizar o estoque: " + e.getMessage());
            return false;
        }
    }

}
