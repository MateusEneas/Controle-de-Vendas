package entities;

import exception.EstoqueInsuficienteException;

import java.time.LocalDate;
import java.util.List;

public class Venda {

    private int id;
    private Cliente cliente;
    private List<Pedido> pedidos;
    private LocalDate data;
    private double valorTotal;

    public Venda() {
    }

    public Venda(int id, Cliente cliente, List<Pedido> pedidos) {
        this.id = id;
        this.cliente = cliente;
        this.pedidos = pedidos;
        this.valorTotal = 0.0;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
