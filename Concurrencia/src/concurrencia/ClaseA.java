package concurrencia;
/**
 * La clase DemoThread implemente la interface Runnable de quien 
 * hereda el método run. 
 * Dentro del método run, se programan todas las acciones que queremos
 * que realice durante la ejecución.
 * 
 */
public class ClaseA implements Runnable{ //Firma de la ClaseA
    private String dato;                 //Atributo de la ClaseA
    
    public ClaseA (String dato){         //Constructor de la clase
        this.dato = dato;
    }

    @Override
    public void run() {                  //Método run heredado de la interface Runnable
        for (int i = 0 ; i < 1000 ; i++) //Ciclo que se imprimirá durante la ejecución
            System.out.println(dato+" -> "+i);
    }  
    
    public static void main (String [] args) throws InterruptedException{
        //Instancia Objetos de la ClaseA
        ClaseA p1 = new ClaseA(" A; ");
        ClaseA p2 = new ClaseA(" B; ");
        //Instancia Objetos de la clase Thread y recibe como parametro objetos creados de la claseA
        Thread h1 = new Thread(p1);
        Thread h2 = new Thread(p2);
        /**Asigna la prioridad de la ejecución a los hilos, esto quiere decir que 
         * el scheduler (planificador del SO) va asignar el tiempo de procesador.
         * Para esto, se emplea el método setPriority que recibe parametros entre
         * Thread.MAX_PRIORITY y Thread.MIN_PRIORITY que son constantes que 
         * equivales a 1 y 10 respectivamente.         
         */
        h2.setPriority(Thread.MAX_PRIORITY);
        h1.setPriority(Thread.MAX_PRIORITY);
        
        //Invoca los métodos start() para que sean ejecutados concurrentemente
        h1.start();
        h2.start();
        //Tiempo de espera para imprimir el resultado de las prioridades (5000 corresponde a 5 segundos)
        Thread.sleep(5000);
        System.out.println("Prioridad del hilo 1: "+h1.getPriority());
        System.out.println("Prioridad del hilo 2: "+h2.getPriority());
    }
    
}
