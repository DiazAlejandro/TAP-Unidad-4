package productoConsumidorSincronizacion;

/**
 * Clase BuferSincronizado:
 * Sincronizacion del acceso a datos compartidos, usando los métodos 
 * wait y notify de Object
 * @author: Alejandro Diaz Ruiz
 * @version: 08/05/2020
 */
public class BuferSincronizado implements Bufer{
    private int bufer = -1;         //Compartido por los subprocesos productor y consumidor
    private boolean ocupado = false; //Indica si el bufer se encuentra ocupado

    /**
     Coloca el valor en el bufer
     */
    @Override
    public synchronized void establecer(int valor) throws InterruptedException {
        while (ocupado){ //imprime información del subproceso e info. del bufer hy luego espera.
            System.out.println("Productor trata de escribir: ");
            mostrarEstado("***Bufer Lleno. Productor en espera***");
            wait();
        }
        bufer = valor;  //Establece el nuevo valor del bufer
        //Indica que el productor no puede almacenar otro valor hasta que 
        //el consumidor obtenga el valor actual del bufer
        ocupado = true;
        
        mostrarEstado("Productor Escribe: " + bufer);
        notifyAll(); //Inidica a los subprocesos en espera al estado Runnable
    }
    
    /**
     * Devuelve el valor del bufer
     */
    @Override
    public synchronized int obtener() throws InterruptedException {
        while (!ocupado){ //Mientras no haya datos para leer los pone en espera
            System.out.println("Consumidor trata de leer");
            mostrarEstado("***Bufer Vacio. Consumidor en espera***");
            wait();
        }
        //Indica que el productor puede almacenar otro valor, 
        //ya que el consumidor obtuvo el valor del bufer
        ocupado = false; 
        mostrarEstado("Consumidor lee: "+ bufer);
        notifyAll(); 
        return bufer;
    }
     /**
     * Muestra la operación actual y el estado del bufer
     */
    public void mostrarEstado(String operacion){
        System.out.printf("%-40s %d\t\t%b\n\n",operacion, bufer, ocupado);
    }
}
