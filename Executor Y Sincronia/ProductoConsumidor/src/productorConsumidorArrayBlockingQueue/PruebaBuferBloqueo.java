package productorConsumidorArrayBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase que muestra a dos subprocesos manipulando un bufer con bloqueo
 * @author Alejandro Diaz Ruiz
 */
public class PruebaBuferBloqueo {
    public static void main (String [] args ){
        //Crea una nueva reserva de subprocesos con dos subprocesos
        ExecutorService aplicacion = Executors.newCachedThreadPool();
        //Crea un objeto BuferBloqueo
        Bufer ubicacionCompartida = new BuferBloqueo();
        
        //Ejecuta el Productor y Consumidor:
        //A acada uno de ellos le proporciona acceso a la ubicacionCompartida
        aplicacion.execute(new Productor(ubicacionCompartida));
        aplicacion.execute(new Consumidor(ubicacionCompartida));
        
        aplicacion.shutdown(); //Termina la aplicacion cuando se completen las tareas
    }
}
