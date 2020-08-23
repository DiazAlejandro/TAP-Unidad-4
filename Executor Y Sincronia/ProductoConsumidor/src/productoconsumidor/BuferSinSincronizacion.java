package productoconsumidor;

/**
 * Clase BuferSinSincronizacion que implementa Bufer.
 * Mantiene el entero compartido que utilizan los subprocesos Productor y Consumidor
 * mediante los métodos establecer y obtener
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class BuferSinSincronizacion implements Bufer{
    private int bufer = -1; //Compartido con los subprocesos productor y consumidor
    
    /**
     * Coloca el valor en el bufer
     */
    @Override
    public void establecer(int valor) throws InterruptedException {
        System.out.printf("Productor escribe\t%2d",valor);
        bufer = valor;
    }

    /**
     * Devuelve el valor del bufer
     */
    @Override
    public int obtener() throws InterruptedException {
        System.out.printf("Consumidor lee\t\t%2d",bufer);
        return bufer;
    }
    
}
