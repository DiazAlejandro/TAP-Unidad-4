package barrasprocesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

public class ProgressMonitorExample extends JFrame implements ActionListener{
    static ProgressMonitor pbar;       //Objeto de la clase ProgressMonitor
    static int counter = 0;            //Atributo contador para la barra 

    public ProgressMonitorExample( ) { //Constructor de la clase
        super("Progress Monitor Demo");//Titulo de la ventana
        setSize(250,100);              //Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Crea un nuevo objeto ProgressMonitor  que recibe como parámetros:
        //(null, Titulo de la barra, Estado inicial de la barra, Valor inicial, Valor Final)
        pbar = new ProgressMonitor(null, "Monitoring Progress", 
                "Initializing . . .", 0, 100);

        // Tiempo que lanza cada actualización de la barra
        Timer timer = new Timer(500, this);
        timer.start( );
        setVisible(true);
    }
    
    public static void main(String args[]) {
        //Nombre de la ventana del proceso
        UIManager.put("ProgressMonitor.progressText", "This is progress?");
        //Botón que aparecerá en la parte inferior de la barra de prgreso
        UIManager.put("OptionPane.cancelButtonText", "Go Away"); 
        new ProgressMonitorExample( ); //Instancia de la clase ProgressMonitorExample
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Invocado por el temporizador cada 0.5 segundos. 
        //Simplemente coloca la actualización del monitor de progreso en la cola de eventos.
        SwingUtilities.invokeLater(new Update( ));
    }
    
    //Clase interna que se encara de hacer la ejecución de los hilos
    class Update implements Runnable {
        public void run( ) {
            if (pbar.isCanceled( )) { //Si se cierra la ventana del proceso
            pbar.close( );            //La barra de procesos de cierra.
            System.exit(1);
        }

        pbar.setProgress(counter);    //Cuando se cumpla el límite máximo se termina
        pbar.setNote("Operation is "+counter+"% complete"); //Imprime en una label el progreso en porcentaje de la barra
        counter += 2;                 //Contador aumentará con forme a la barra
        }
    }    
}
