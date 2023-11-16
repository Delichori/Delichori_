package co.com.delichori.model;

import java.time.LocalDate;

public class Pedido {


    private int idPedido;
    private int cedulaCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private int idProducto;
    private String estadoPedido;
    private int cantidadProducto;
    private LocalDate fechaPedido;
    private double precioUnidad;
    private double valorTotalPedido;
    private int opc;

    Producto producto;


    public Pedido() {

    }

    public Pedido(int idPedido, int cedulaCliente, String nombreCliente, String apellidoCliente, String direccionCliente, int idProducto, String estadoPedido, int cantidadProducto, LocalDate fechaPedido, double valorTotalPedido, int opc) {
        this.idPedido = idPedido;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.idProducto = idProducto;
        this.estadoPedido = estadoPedido;
        this.cantidadProducto = cantidadProducto;
        this.fechaPedido = fechaPedido;
        this.valorTotalPedido = valorTotalPedido;
        this.opc = opc;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }
}