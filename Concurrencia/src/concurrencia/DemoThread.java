package concurrencia;
/**
 * La clase DemoThread implemente la interface Runnable de quien 
 * hereda el método run. 
 * Dentro del método run, se programan todas las acciones que queremos
 * que realice durante la ejecución.
 */
public class DemoThread implements Runnable{ //Firma de la clase
    private String nombre;                   //Atributo nombre
    
    public DemoThread(String nombre){        //Constructor de la clase
        this.nombre = nombre;                
    }
    
    @Override
    public void run() { //Método Run de la interface Runnable
        try{
            int x = (int) (Math.random()*5000);
            Thread.sleep(x); //Tiempo que tardará en hacer la ejecución
            System.out.println("Soy "+nombre+" ( "+x+" )"); //Salida durante ejecución
        }catch(Exception e){
            e.printStackTrace(); //Diagnostica la excepciones e imprime donde está el error.
        }
    }
    
    public static void main (String [] args){
        /**Instancia objetos de la clase Thread, 
         * dentro de los cuales instanciamos 
         * Objetos de la clase DemoThread(instancias de la clase Runnable)
         */
        Thread t1 = new Thread(new DemoThread("Alejandro"));
        Thread t2 = new Thread(new DemoThread("Joselyne "));
        Thread t3 = new Thread(new DemoThread("Rogelio  "));
        
        //Invocar el método start para que los hilos sean ejecutados concurrentemente
        t1.start();
        t2.start();
        t3.start();
    }
}
