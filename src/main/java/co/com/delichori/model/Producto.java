package co.com.delichori.model;

public class Producto {


    protected int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioCostoProducto;
    private double precioVentaProducto;
    private double gananciaProducto;
    private int existenciaProducto;
    private int opc;

    public Producto() {

    }

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, double precioCostoProducto, double precioVentaProducto, double gananciaProducto, int existenciaProducto, int opc) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioCostoProducto = precioCostoProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.gananciaProducto = gananciaProducto;
        this.existenciaProducto = existenciaProducto;
        this.opc = opc;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioCostoProducto() {
        return precioCostoProducto;
    }

    public void setPrecioCostoProducto(double precioCostoProducto) {
        this.precioCostoProducto = precioCostoProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public double getGananciaProducto() {
        return gananciaProducto;
    }

    public void setGananciaProducto(double gananciaProducto) {
        this.gananciaProducto = gananciaProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

}
