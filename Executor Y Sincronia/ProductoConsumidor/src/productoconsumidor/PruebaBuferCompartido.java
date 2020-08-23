package productoconsumidor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase BuferSinSincronizacion que implementa Bufer.
 * Mantiene el entero compartido que utilizan los subprocesos Productor y Consumidor
 * mediante los métodos establecer y obtener
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class PruebaBuferCompartido {
    public static void main (String [] args){
        //Crea una nueva reserva de subprocesos con dos subprocesos
        ExecutorService aplicacion = Executors.newCachedThreadPool();
        //Crea un objeto BuferSinSincronizacion para almacenar los valores int 
        Bufer ubicacionCompartida = new BuferSinSincronizacion();
        
        System.out.println("Accion\t\t\tValor\tSuma Producidos\tSuma Consumidos");
        System.out.println("------\t\t\t-----\t---------------\t---------------\n");
        
        //Ejecuta el Productor y Consumidor:
        //A acada uno de ellos le proporciona acceso a la ubicacionCompartida
        aplicacion.execute(new Productor(ubicacionCompartida));
        aplicacion.execute(new Consumidor(ubicacionCompartida));
        
        aplicacion.shutdown(); //Termina la aplicacion cuando se completen las tareas
    }
}