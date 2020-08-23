package SinSincronia;
/**
 * Clase Consumidor quita un elemento a la pila
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Consumidor implements Runnable{
    private Pilas pila;
    private static int numCons = 0;
    
    /**
     * Constructor de la clase Productor
     * @param p Objeto de la clase pila
     */
    public Consumidor (Pilas p){
        pila = p;
        numCons++;
    }
    
    /**
     * Quita los char a la pila
     */
    @Override
    public void run() {
        char c;
        for (int i = 0 ; i < 20 ; i++){
            c = pila.quitar();
            if (Character.isAlphabetic(c)){
                System.out.println("Hilo: " + Thread.currentThread().getName() +
                        " Consumidor " + numCons + ": "+c);
                try{
                    Thread.sleep((int)(Math.random()*777));
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    
}
