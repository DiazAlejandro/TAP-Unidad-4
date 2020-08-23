package barraprogresop3;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
//Inicio de la clase BarraProgreso que implementa la interface Runnable
public class BarraProgreso implements Runnable{
    //Atributos de la clase barraProgreso
    private JProgressBar bp; //La barra de progreso
    private int no_barra;    //El número de la barra
    private JLabel txt;      //El texto que acompaña la barra
    private int time = (int)Math.floor(Math.random()*120+100); //Tiempo aleatorio que duerme el hilo
    
    //Constructor de la clase BarraProgreso
    public BarraProgreso (JProgressBar bp, int no, JLabel txt){
        this.bp = bp;
        this.no_barra = no;
        this.txt = txt;
    }   
    //Método run por la interface Runnable
    @Override
    public void run() {
        bp.setStringPainted(true); //Asigna el porcentaje dentro de la barra
        for(int i = 0 ; i <= 100+1 ; i++){ //Ciclo que actualiza la barra
            txt.setText("Barra: "+no_barra+" Progreso: "+ bp.getString()); //Label que muestra el porcentaje de la barra
            try{
                bp.setValue(i); //Asigna el progreso de la barra
                Thread.sleep(time); //Duerme el hilo según el tiempo declarado arriba (Linea 11)
            }catch(Exception e){
            }
        }
    }
    
}
