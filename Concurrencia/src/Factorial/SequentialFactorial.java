/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorial;

import java.math.BigInteger;

public class SequentialFactorial {
    public static void main (String [] args){
        final int n = 10;
        long timeStart = System.currentTimeMillis();
        BigInteger result = BigInteger.ONE;
        
        for (int i = 2 ; i <= n ; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        long timeEnd = System.currentTimeMillis();
        System.out.printf("Resultado: %s Tiempo: %.4f%n",result.toString(),
                (timeEnd-timeStart)/1000.0);
    }
}
