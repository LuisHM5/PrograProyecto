
package setgetters;


public class Ventas {
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;
    private int idprodc;


     
    public Ventas(){
        
    }

    public Ventas(int id, String nombre, int cantidad, double precio, int idprodc) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idprodc = idprodc;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdprodc() {
        return idprodc;
    }

    public void setIdprodc(int idprodc) {
        this.idprodc = idprodc;
    }


    

   
   @Override
    public String toString() {
        return "Ventas{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
}
    
    
