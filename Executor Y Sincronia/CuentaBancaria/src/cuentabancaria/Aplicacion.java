package cuentabancaria;

public class Aplicacion {
    public static void main (String [] args){
        CajeroAutomatico cajero = new CajeroAutomatico();
        
        Thread pepe = new Thread(cajero,"Pepe");
        Thread toño = new Thread(cajero,"Toño");
        
        
        toño.start();
        pepe.start();
    }
}
