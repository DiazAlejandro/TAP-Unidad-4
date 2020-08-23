package productorConsumidorArrayBlockingQueue;

import java.util.Random;

/**
 * Clase Productor que implementa Runnable con el método run que inserta los 
 * valores del 1 al 10 en el bufer.
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class Productor implements Runnable{
    private final static Random generador = new Random();
    private final Bufer ubicacionCompartida; //Referencia al objeto compartido
    
    /**
     * Constructor de la clase Productor
     * @param compartido Bufer que hace referencia al objeto compartido
     */
    public Productor(Bufer compartido){
        ubicacionCompartida = compartido;
    }
    
    /**
     * Almacena valores del 1 al 10 dentro de ubicacionCompartida
     */
    @Override
    public void run() {
        int suma = 0;
        for (int cuenta = 1 ; cuenta <= 10 ; cuenta++){
            try {
                Thread.sleep(generador.nextInt(3000)); //Tiempo de inactividad aleatorio
                ubicacionCompartida.establecer(cuenta); //Establece el valor en el buffer
                suma += cuenta;
                //System.out.printf("\t%2d\n",suma);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("\nProductor terminó de producir \nTerminando Productor");
    }
    
}
