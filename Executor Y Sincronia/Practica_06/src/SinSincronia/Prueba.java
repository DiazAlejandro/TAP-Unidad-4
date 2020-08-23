package SinSincronia;
/**
 * Clase Prueba
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Prueba {
    public static void main (String [] args){
        Pilas pila = new Pilas(10);
        //Instancias de la clase Productor
        Productor p1 = new Productor(pila,1);
        Productor p2 = new Productor(pila,2);
        //Instancias de la clase consumidor
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        //Creacion de hilos
        Thread prodT1 = new Thread (p1);
        Thread prodT2 = new Thread (p2);
        
        Thread consT1 = new Thread (c1);
        Thread consT2 = new Thread (c2);
        Thread consT3 = new Thread (c3);
        //Ejecución de los hilos concurrentemente
        prodT1.start();
        prodT2.start();
        consT1.start();
        consT2.start();
        consT3.start();
    }
}
