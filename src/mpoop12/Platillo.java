package mpoop12;
/**
 * Clase que crea a un Platillo.
 * @author Gómez Segovia David Israel y Montoya Colón David Fernando
 */
public class Platillo {
    private String nombre;
    private double precio;
    private String ingredientes;
    /**
     * Constructor vacío.
     */
    public Platillo() {
    }
    /**
     * Constructor con parámetros.
     * @param nombre Nombre del platillo.
     * @param precio Precio del platillo.
     * @param ingredientes Ingredientes que conforman al platillo.
     */
    public Platillo(String nombre, double precio, String ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    /**
     * Método toString del platillo que imprime sus atributos como cadena.
     * @return Atributos de un objeto Platillo como cadena, cada atributo lo separa una coma.
     */
    @Override
    public String toString() {
        return nombre + "," + precio + "," + ingredientes;
    }
}
