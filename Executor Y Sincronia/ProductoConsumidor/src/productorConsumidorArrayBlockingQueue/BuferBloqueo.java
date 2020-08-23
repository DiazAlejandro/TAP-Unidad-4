package productorConsumidorArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Clase BuferBloqueo crea un bufer sincronizado, usando la clase ArrayBlockingQueue
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class BuferBloqueo implements Bufer{
    private final ArrayBlockingQueue<Integer> bufer; //Bufer compartido
    
    /**
     * Constructor de la clase BuferBloqueo
     */
    public BuferBloqueo(){
        bufer = new ArrayBlockingQueue<Integer>(1);
    }
    
    /**
     * Coloca un valor en el Bufer
     */
    @Override
    public void establecer(int valor) throws InterruptedException {
        bufer.put(valor); //Coloca el valor en el bufer
        System.out.printf("%s%2d\t%s%d\n","Productor Escribe: ",valor,
                "Celdas del Bufer ocupadas: ",bufer.size());
    }
    /**
     * Devuelve el valor del bufer
     */
    @Override
    public int obtener() throws InterruptedException {
        int valorLeido = 0;
        valorLeido = bufer.take(); //Elimina el valor del bufer
        System.out.printf("%s   %2d\t%s%d\n","Consumidor lee: ",valorLeido, 
                "Celdas del bufer ocupadas: ",bufer.size());
        return valorLeido;
    }
    
}
