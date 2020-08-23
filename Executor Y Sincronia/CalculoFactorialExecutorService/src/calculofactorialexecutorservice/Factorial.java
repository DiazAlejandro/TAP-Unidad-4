package calculofactorialexecutorservice;

import java.math.BigInteger;

public class Factorial implements Runnable{
    private int start;
    private int end;
    private BigInteger resultado = BigInteger.ONE;
    
    public Factorial(int start, int end){
        this.start = start;
        this.end   = end;
    }
    
    public BigInteger getResultado(){
        return resultado;
    }

    @Override
    public void run(){                                    //Operaciones del hilo
        for (int i = start ; i <= end ; i++){
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
    }
    
    public String toString(){
        return String.format("%4s %6d %6d %s",Thread.currentThread().getName(),start, end, getResultado().bitCount());
    }
    
    
}
