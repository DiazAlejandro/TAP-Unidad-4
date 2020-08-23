package Factorial;

public class FactorialTest {
    public static void main (String [] args) throws InterruptedException{
        final int n = 25000;
        Factorial f1 = new Factorial(n);
        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread(f1);
        t1.start();
        while(t1.isAlive())
        t1.join();
        long timeEnd = System.currentTimeMillis();
        System.out.println("Calculo de Factorial con UN HILO");
        System.out.printf("Factorial de: %d\nResultado = %d \nTiempo: %.4f\n",n,f1.getResultado(),
                (timeEnd-timeStart)/1000.0);
    }
}
