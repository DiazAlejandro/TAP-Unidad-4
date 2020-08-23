package ConSincronia;
/**
 * Clase Productor agrega un elemento a la pila
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Productor implements Runnable{
    private Pila pila;
    private static int numProd = 1;
    private int no;
    /**
     * Constructor de la clase Productor
     * @param p Objeto de la clase pila
     */
    public Productor (Pila p, int no){
        pila = p;
        numProd++;
        this.no = no;
    }
    
    /**
     * Agrega los char a la pila
     */
    @Override
    public void run() {
        char c;
        for (int i = 0 ; i < 20 ; i++){
            c = (char)(Math.random() * 26 + 65);
            pila.poner(c);
            System.out.println("Productor " + no + " agregó a " + c +
                    " en \tHilo_" + no + "-productor");
            try{
                Thread.sleep((int)(Math.random()*777));
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    } 
}
