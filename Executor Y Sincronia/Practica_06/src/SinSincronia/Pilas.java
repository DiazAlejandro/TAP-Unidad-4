package SinSincronia;
/**
 * Clase Pilas sin Sincronía, se declaran los métodos necesarios 
 * para que un arreglo de char, funcione como una pila.
 * @author: Alejandro Diaz Ruiz
 * @version: 09/05/2020
 */
public class Pilas {
    private int tope;       //Posicion del arreglo
    private char [] datos;  //Arreglo de datos
    
    /**
     * Constructor de la clase Pilas
     * @param size el tamaño de nuestra pila datos[]
     */
    public Pilas (int size){
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
    
    public void poner (char c){
        //Verifica si se encuentra llena
        if (llena()){
            System.out.println("Pila Llena, intentó colocar " + 
                    Thread.currentThread().getName());
        } else { //Si no está llena, agrega el dato c a la pila
            tope++;
            datos[tope] = c;
        }
    }
    
    /**
     * Devuelve el ultimo caracter que haya sido introducido, al ser una pila
     * funciona con LIFO
     * @return 
     */
    public char quitar(){
        char d = ' ';
        if(vacia()){ //Si la pila esta vacía, no puede retirar nada
            System.out.println("Pila Vacia, intentó retirar " + 
                    Thread.currentThread().getName());
        }else{ //Si la pila no está vacía, retira el dato.
            d = datos[tope];
            tope--;
        }
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
