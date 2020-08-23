package concurrencia;
public class ThreadTester {
    public static void main (String [] args){
        //Instancia un objeto de la clase HelloRunner 
        HelloRunner r = new HelloRunner();
        //Instancia un objeto de la clase Thread
        Thread t = new Thread(r);
        //Ejecuta el método start para que sea concurrente
        t.start();
    }
    
    /**
     * Clase interna, la cual implementa la interface Runnable
     * y que hereda el método run.     
     */
    static class HelloRunner implements Runnable{
        int i;
        @Override
        public void run() {
            //Ciclo que se cargará durante la ejecución
            i = 0;
            while (true){
                //salida de impresión.
                System.out.println("Hello "+i++);
                //Condición para terminar el ciclo
                if (i == 50) break;
            }
        }
        
    }
}
