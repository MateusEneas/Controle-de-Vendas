package entities;

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

    public Venda(int id, Cliente cliente, List<Pedido> pedidos, LocalDate data, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.pedidos = pedidos;
        this.data = data;
        this.valorTotal = valorTotal;
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
        valorTotal = pedidos.stream().mapToDouble(Pedido::calcularPrecoTotal).sum();
    }
}
