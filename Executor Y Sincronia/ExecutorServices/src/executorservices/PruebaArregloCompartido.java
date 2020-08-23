package executorservices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PruebaArregloCompartido {
    public static void main (String [] args){
        ArregloSimple arregloSimpleCompartido = new ArregloSimple(6);
        
        //Crea dos tareas para escribir en el objeto ArregloSimple
        EscritorArreglo escritor1 = new EscritorArreglo(10, arregloSimpleCompartido);
        EscritorArreglo escritor2 = new EscritorArreglo(20, arregloSimpleCompartido);
        
        //Ejecuta las tareas con un objeto ExecutorService
        ExecutorService ejecutor= Executors.newCachedThreadPool();
        ejecutor.execute(escritor1);
        ejecutor.execute(escritor2);
        
        ejecutor.shutdown();
        
        try{
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);
            if (tareasTerminaron)
                System.out.println(arregloSimpleCompartido);
            else 
                System.out.println("Se agoto el tiempo esperando a que las tareas terminaran");
        }catch (InterruptedException ex){
            System.out.println("Houbo una interrupción mientras esperaba a que terminaran las tareas");
        }
    }
    
}
