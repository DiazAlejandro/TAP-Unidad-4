package ConSincronia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase Prueba
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Prueba {
    public static void main (String [] args){
        Pila pila = new Pila(10);
        //Instancias de la clase Productor
        Productor p1 = new Productor(pila,1);
        Productor p2 = new Productor(pila,2);
        //Instancias de la clase Consumidor
        Consumidor c1 = new Consumidor(pila,1);
        Consumidor c2 = new Consumidor(pila,2);
        Consumidor c3 = new Consumidor(pila,3);
        //Administrador de hilos
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ejecutor.execute(p1);
        ejecutor.execute(p2);
        ejecutor.execute(c1);
        ejecutor.execute(c2);
        ejecutor.execute(c3);
        
        ejecutor.shutdown();
        
        try{
            //Espera 1 minuto de los consumidores-productores en su ejecución
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);
            if (tareasTerminaron)
                System.out.println("Todas las tareas terminaron");
            else{
                System.out.println("Se agotó el tiempo esperando a que las tareas terminaran...");
                System.exit(1);
            }
        }catch(InterruptedException ex){
            System.out.println("Hubo una interrupcion mientras esperaba a que terminaran las tareas");
        
        }
    }
}
