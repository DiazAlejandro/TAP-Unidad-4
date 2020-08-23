/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactorialParalelo;

import java.math.BigInteger;

public class FactorialTest {
    public static void main (String [] args) throws InterruptedException{
        final int n = 250000;
        FactorialParalelo f1 = new FactorialParalelo(2, n/2);
        FactorialParalelo f2 = new FactorialParalelo(n/2 +1 , n);
        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long timeEnd = System.currentTimeMillis();
        BigInteger total = f2.getResultado().multiply(f1.getResultado());
        System.out.printf("Resultado = %d \nTiempo: %.4f",total.bitCount(),
                (timeEnd-timeStart)/1000.0);
    }
}
