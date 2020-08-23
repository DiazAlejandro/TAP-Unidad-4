package ConSincronia;
/**
 * Clase Consumidor quita un elemento a la pila
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Consumidor implements Runnable{
    private Pila pila;
    private int no;
    
    /**
     * Constructor de la clase Productor
     * @param p Objeto de la clase pila
     * @param no Numero de consumidor
     */
    public Consumidor (Pila p, int no){
        pila = p;
        this.no = no;
    }
    
    /**
     * Quita los char a la pila
     */
    @Override
    public void run() {
        char c;
        for (int i = 0 ; i < 20 ; i++){
            c = pila.quitar();
                System.out.println("Hilo: Hilo_" + no + "-consumidor" +
                        " Consumidor " + no + ": "+c);
                try{
                    Thread.sleep((int)(Math.random()*777));
                }catch(InterruptedException ex){
                }
        }
    }
    
}
