/** Practica Barras de Progreso con Hilos
 *  DATE: 22-APRIL-2019
 *  @author: ALEJANDRO DIAZ RUIZ 
 */
package BarrasProcesos;
//Librerías importadas
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BarrasMultiples extends JFrame{ //Clase BarrasMultiples que hereda de JFrame
    private final JProgressBar barra [];     //Arreglo de Barras de Proceso
    private final Thread hilos [];           //Arreglo de hilos
    private final JLabel nameBarra[];        //Arreglo de los nombre de cada hilo                     
    
    public BarrasMultiples(){                //Constructor de la clase
        super("Barras Multiples");           //Titulo del Frame
        barra = new JProgressBar[4];         //Inicializa el arreglo de Barras de proceso
        hilos = new HiloBarra[barra.length]; //Inicializa el arreglo de Hilos
        nameBarra = new JLabel[barra.length];//Inicializa el arreglo de Titulos
        
        JPanel panel = new JPanel();         //Panel que contendrá los otros paneles de barras y titulos
        panel.setLayout(new GridLayout(1, 2));
        
        JPanel titulos = new JPanel();       //Panel que contendrá los titulos
        titulos.setLayout(new GridLayout(barra.length,1));
        
        JPanel barras = new JPanel();        //Panel que contendrá ñas barras
        barras.setLayout(new GridLayout(barra.length,1));
        
        //Ciclo que se encargará de asignar los objetos titulos y barras
        //así como inicializarlos
        for (int i = 0 ; i < barra.length ; i ++){
            int intervalo = (int) Math.floor(Math.random()*9+5); //Constante que estará aumentando las barras
            nameBarra [i] = new JLabel(" Barra "+(i+1)+" | "+    //Asigana el contenido a mostrar dentro de los labels
                    "Intervalo: "+intervalo);
            titulos.add(nameBarra[i]);                           //Añade al panel titulos
            
            barra [i] = new JProgressBar();                      //Crea una barra de proceso en la posicion indicada del arreglo
            barra [i].setValue(0);                               //El valor inicial de la barra siempre será 0 = 0%
            barra [i].setStringPainted(true);                    //Habilita la opcion de mostrar el porcentaje
            barras.add(barra[i]);                                //Añade al panel barras barras del arreglo
            
            hilos [i] = new HiloBarra(barra[i], intervalo);      //Crea una instancia de la clase HiloBarra que reciirá 
                                                                 //una barra y su intervalo de tiempo a ocupar
            hilos [i].start();                                   //Inicia el proceso concurrente de los hilos
        }
        
        panel.add(titulos);                                      //Añade al panel principal los titulos
        panel.add(barras);                                       //Añade al panel principal las barras
        add(panel,BorderLayout.NORTH);                           //Añade y define la posicion del panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          //Finalizar el proceso con la x
        setVisible(true);                                        //Visibilidad Activada
        setSize(350,150);                                        //Tamaño del JFrame
    }
    
    //Esta clase se encarga de asociar el hilo con la barra de procesos.
    class HiloBarra extends Thread implements Runnable{          //Clase interna HiloBarra
        JProgressBar ba1;                                        //Atributo JProgressBar 
        int time1;                                               //Atributo time - tiempo
        
        public HiloBarra (JProgressBar ba1, int time1){          //Constructor de la clase, al crear objetos de esta clase
            this.ba1 = ba1;                                      //necesitamos de la barra de progreso y del tiempo (intervalo de avance)
            this.time1 = time1;        
        }
        /**
         * Método update que se encargará de actualizar el progreso dentro de cada barra
         * @param barra Una barra de progreso
         * @param time  Intervalo de tiempo de actualizacion o avance
         */
        public void update(JProgressBar barra, int time){ 
            try { 
                for (int i = 0 ; i <= 100 ; i += time) {  //Ciclo para ir actualizando la barra de proceso
                    barra.setValue(i + time);             //Asigna el valor que va avanzando (porcentaje)
                    Thread.sleep(1000);                   //Duerme el hilo durante cada actualización 1 segundo
                } 
            } catch (InterruptedException e) {
            }  
        }
        /**
         * Método run que se encarga de ejecutar el proceso de los hilos
         */
        @Override
        public void run() {
            update(ba1, time1);  
            //Le pasamos el método update para que al momento de iniciar el hilo para se ejecute directamente
        }
    }
    //Método main 
    public static void main (String [] args){
        BarrasMultiples b1 = new BarrasMultiples(); //Instancia de la clase
    }
}
