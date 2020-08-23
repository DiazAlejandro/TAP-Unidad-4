package calculofactorialexecutorservice;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FacotorialPrueba {
    public static void main (String [] args){
        final int n = 500000;  //Numero del factorial a calcular
        long timeEnd = 0;      //Tiempo final de ejecución
        BigInteger total = null; //Variable de tipo BigInteger que almacenará el total del factorial
        //Cantidad de rangos para calcular el factorial.
        Factorial f1 = new Factorial(2, n/4);
        Factorial f2 = new Factorial(n/4+1, n/2);
        Factorial f3 = new Factorial(n/2 +1, (3*n)/4);
        Factorial f4 = new Factorial((3*n)/4 +1, n);
        long timeStart = System.currentTimeMillis();  //Toma el tiempo de inicio de ejecución
        
        ExecutorService ejecutor= Executors.newCachedThreadPool(); //Objeto de la clase ExecutorService
        ejecutor.execute(f1);
        ejecutor.execute(f2);
        ejecutor.execute(f3);
        ejecutor.execute(f4);
        
        ejecutor.shutdown(); //Ya no recibirá mas tareas
        
        try{
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES); //Un minuto de ejecución
            if (tareasTerminaron){
                timeEnd = System.currentTimeMillis();  //Tiempo final de ejecucion 
                System.out.printf("%4s %6s %6s %s \n","HILO","INICIO","FINAL","RESULTADO");
                //imprime la informacion de cada factorial
                System.out.println(f1+"\n"+f2+"\n"+f3+"\n"+f4);
                //Realiza la multiplicacion de cada uno de los rangos.
                total = f2.getResultado().multiply(f1.getResultado().multiply(f3.getResultado()).multiply(f4.getResultado()));
                //imprime los totales
                System.out.println("\nFactorial de: "+n+"\nEs: "+total.bitCount()+
                        "\nTiempo total: "+(timeEnd-timeStart)/1000.0+" segundos"+
                                "\n**Los resultados están expresados en bitCount()");
            }else 
                System.out.println("Para el factorial de: "+n
                        +"\nSe agoto el tiempo esperando a que las tareas terminaran");
        }catch (InterruptedException ex){
            System.out.println("Hubo una interrupción mientras esperaba a que terminaran las tareas");
        }
    }
}
