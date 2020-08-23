package productoConsumidorSincronizacion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase PruebaBuferSincronizado:
 * Muestra como dos subprocesos manipulan un bufer sincronizado
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class PruebaBuferSincronizado {
    public static void main (String [] args){
        //Crea una nueva reserva de subprocesos con dos subprocesos
        ExecutorService aplicacion = Executors.newCachedThreadPool();
        //Crea un objeto BuferBloqueo
        Bufer ubicacionCompartida = new BuferSincronizado();
        
        System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n","Operacion","Bufer",
                "Ocupado","---------","-----\t\t-------");
        //Ejecuta el Productor y Consumidor:
        //A acada uno de ellos le proporciona acceso a la ubicacionCompartida
        aplicacion.execute(new Productor(ubicacionCompartida));
        aplicacion.execute(new Consumidor(ubicacionCompartida));
        
        aplicacion.shutdown(); //Termina la aplicacion cuando se completen las tareas
    }    
}
