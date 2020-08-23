package cuentabancaria;

public class CuentaBancaria {
    private int saldoActual = 50;
    
    public int getSaldoActual(){
        return saldoActual;
    }
    
    public void retiroDeCuenta(int valorRetiro){
        saldoActual -= valorRetiro;
    }
}
