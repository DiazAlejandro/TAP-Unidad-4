package ConSincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Pila con Sincronía, se declaran los métodos necesarios 
 * para que un arreglo de char, funcione como una pila.
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Pila {
    private int tope;       //Posicion del arreglo
    private char [] datos;  //Arreglo de datos
    
    /**
     * Constructor de la clase Pilas
     * @param size el tamaño de nuestra pila datos[]
     */
    public Pila (int size){
        datos = new char[size];
        tope = -1;
    }
    
    /**
     * Verifica que la pila se encuentre llena
     * @return true si la posición del arreglo es igual al tamaño del arreglo
     */
    public boolean llena(){
        return tope == datos.length-1;
    }
    /**
     * Verifica si la pila se encuentra vacía o no@.
     * @return ture si tope es menor que cero
     */
    public boolean vacia(){
        return tope < 0;
    }
    
    /**
     * Agrega elementos a la pila
     * @param c Recibe un Char que será agregado a la pila
     */
    public synchronized void poner (char c){
        //Verifica si se encuentra llena
        if (llena()){
            System.out.println("Pila Llena, esperando Consumidor " + 
                    Thread.currentThread().getName());
            try {
                wait(); //Mientras esté llena pone el hilo en espera
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
                tope++;
                datos[tope] = c;
                notify();     
        }
    }
    
    /**
     * Devuelve el ultimo caracter que haya sido introducido, al ser una pila
     * funciona con LIFO
     * @return 
     */
    public synchronized char quitar(){
        char d = ' ';
        if(vacia()) //Si la pila esta vacía, no puede retirar nada
            System.out.println("Pila Vacia, en espera el hilo " + 
                    Thread.currentThread().getName());
        while(vacia()) //Mientras esté vacía pone el hilo en espera
            try{
                this.wait();
            }catch(InterruptedException ex){
            }
                d = datos[tope];
                tope--;
                notify(); //Regresa al estado Runable despues de estar en espera
        return d;
    }
    
    /**
     * Devuelve el último dato que hayamos introducido a la pila
     * @return 
     */
    public char ver (){
        if(!vacia())
            return datos[tope];
        return ' ';
    }
}
