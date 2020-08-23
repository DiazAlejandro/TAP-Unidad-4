package productoconsumidor;

import java.util.Random;

/**
 * Clase Consumidor que implementa Runnable con el método run que itera y lee
 * los 10 valores que del bufer
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class Consumidor implements Runnable{
    private final static Random generador = new Random ();
    private final Bufer ubicacionCompartida; //Referencia al objeto compartido
    
    /**
     * Constructor de la clase Consumidor
     * @param compartido Bufer que hace referencia al objeto compartido
     */
    public Consumidor (Bufer compartido){
        ubicacionCompartida = compartido;
    }
    /**
     * Lee el valor de ubicacionCompartida 10 veces y suma los valores
     */
    @Override
    public void run() {
        int suma = 0;
        for (int cuenta = 1 ; cuenta <= 10 ; cuenta++){
            try {
                Thread.sleep(generador.nextInt(3000)); //Tiempo de inactividad aleatorio
                suma += ubicacionCompartida.obtener();
                System.out.printf("\t\t\t%2d\n",suma);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.printf("\n%s %d\n%s\n","Consumidor leyo valores, el total es: ", 
                           suma, "Terminando Consumidor");
    }
    
}
