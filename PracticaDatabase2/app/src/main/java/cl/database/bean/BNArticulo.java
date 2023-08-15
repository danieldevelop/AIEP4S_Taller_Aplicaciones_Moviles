package cl.database.bean;

public class BNArticulo {

    private int id;
    private String nombre;
    private String detalle;
    private int estado; /*Estado del articulo*/

    public BNArticulo() {
    }

    public BNArticulo(int id, String name, String detail, int status) {
        this.id = id;
        this.nombre = name;
        this.detalle = detail;
        this.estado = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}