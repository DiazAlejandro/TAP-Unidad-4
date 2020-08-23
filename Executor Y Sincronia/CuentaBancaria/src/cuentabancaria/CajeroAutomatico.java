package cuentabancaria;

public class CajeroAutomatico implements Runnable{
    
    CuentaBancaria miCuentaBancaria = new CuentaBancaria();
    
    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++){
            try{
                retirarDineroCuenta(10);
                if(miCuentaBancaria.getSaldoActual() < 0){
                    System.out.println("¡La cuenta tiene saldo negativo!");
                }
                Thread.sleep(500);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private synchronized void retirarDineroCuenta (int valorRetiro){
        if (miCuentaBancaria.getSaldoActual() >= valorRetiro){
            System.out.println("Saldo Actual = " + miCuentaBancaria.getSaldoActual());            
            System.out.println("El usuario : " + Thread.currentThread().getName()+
                    " Realiza un retiro de: " + valorRetiro + " Pesos");
            miCuentaBancaria.retiroDeCuenta(valorRetiro);
            System.out.println("¡Retiro Exitoso!, El saldo actual es: "+
                    miCuentaBancaria.getSaldoActual() + "\n");
        }else{
            System.out.println("Usuario: "+Thread.currentThread().getName()+
                    " No hay saldo suficiente para realizar la transacción.");
        }
    }
}
