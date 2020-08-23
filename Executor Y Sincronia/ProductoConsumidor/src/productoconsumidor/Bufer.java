package productoconsumidor;
/**
 * Interfaz Bufer que espeficica los metodos que la clase Productor y Consumidor llaman
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public interface Bufer {
    /**
     * Colocará un valor in value en el Bufer
     * @param valor El numero que será agregado
     * @throws java.lang.InterruptedException
     */
    public void establecer (int valor) throws InterruptedException;
    
    /**
     * Obtiene el valor int de Bufer
     * @return El numero que esté en el buffer
     * @throws java.lang.InterruptedException
     */
    public int obtener() throws InterruptedException;
}
