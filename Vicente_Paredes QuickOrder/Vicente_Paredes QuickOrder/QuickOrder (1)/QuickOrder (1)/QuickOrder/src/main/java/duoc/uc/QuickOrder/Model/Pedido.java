package duoc.uc.QuickOrder.Model;

import java.time.LocalDate;

public class Pedido {

    private Long id;
    private String nombreCliente;
    private String descripcion;
    private Estado estado;
    private TipoPedido tipoPedido;
    private Double montoTotal;
    private LocalDate fechaPedido;

    public Pedido() {
    }

    public Pedido(Long id, String nombreCliente, String descripcion, Estado estado, TipoPedido tipoPedido, Double montoTotal, LocalDate fechaPedido) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoPedido = tipoPedido;
        this.montoTotal = montoTotal;
        this.fechaPedido = fechaPedido;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}