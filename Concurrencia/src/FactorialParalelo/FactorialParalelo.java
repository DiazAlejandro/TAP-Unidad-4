/* Practica Factorial paralelo con dos hilos.
 * @author Alejandro Diaz Ruiz
 * @date 19-04-2020
 */
package FactorialParalelo;

import java.math.BigInteger;

public class FactorialParalelo implements Runnable{
    private int start;
    private int end;
    
    private BigInteger resultado = BigInteger.ONE;
    
    public FactorialParalelo (int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public BigInteger getResultado(){
        return resultado;
    }
    
    @Override
    public void run(){
        for (int i = start ; i <= end ; i++){
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
    }
}
