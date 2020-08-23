package barraprogresop3;
/**Se importan las librerías*/
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**Inicio de la clase JProgressPrueba, en esta clase se 
 * implementa la clase JProgressBarRunable*/
public class JProgressPrueba extends JFrame{
    //Se declaran las barras de progreso, los labels y las instancias de la clase BarraProceso
    private JProgressBar bp0, bp1, bp2, bp3;
    private JLabel txt0, txt1, txt2, txt3;
    private BarraProgreso j0, j1, j2, j3;
    
    public JProgressPrueba(){ //Constructor de la clase
        
        //Se crean las etiquetas de texto y el JProgressBar con su límite máximo
        bp0  = new JProgressBar(1, 100);
        txt0 = new JLabel();
        //Se agregan al Objeto BarraProgreso y recibe como parametros un JProgressBar, el numero de la barra y el label que lo acompaña
        j0   = new BarraProgreso(bp0, 1, txt0); 
        
        //Se crean las etiquetas de texto y el JProgressBar con su límite máximo
        bp1  = new JProgressBar(1, 134);
        txt1 = new JLabel();
        //Se agregan al Objeto BarraProgreso y recibe como parametros un JProgressBar, el numero de la barra y el label que lo acompaña
        j1   = new BarraProgreso(bp1, 2, txt1);
        
        //Se crean las etiquetas de texto y el JProgressBar con su límite máximo
        bp2  = new JProgressBar(1, 117);
        txt2 = new JLabel();
        //Se agregan al Objeto BarraProgreso y recibe como parametros un JProgressBar, el numero de la barra y el label que lo acompaña
        j2   = new BarraProgreso(bp2, 3, txt2);
        
        //Se crean las etiquetas de texto y el JProgressBar con su límite máximo
        bp3  = new JProgressBar(1, 243);
        txt3 = new JLabel();
        //Se agregan al Objeto BarraProgreso y recibe como parametros un JProgressBar, el numero de la barra y el label que lo acompaña
        j3   = new BarraProgreso(bp3, 4, txt3);
        
        //Se crean y se inicalizan los hilos, recibiendo un objeto de la clase BarraProgreso
        Thread h1 = new Thread(j0);
        h1.start(); //Provoca que los hilos se ejecuten concurrentemente
        Thread h2 = new Thread(j1);
        h2.start(); //Provoca que los hilos se ejecuten concurrentemente
        Thread h3 = new Thread(j2);
        h3.start(); //Provoca que los hilos se ejecuten concurrentemente
        Thread h4 = new Thread(j3);
        h4.start(); //Provoca que los hilos se ejecuten concurrentemente
        
        
        //Se declaran el panel que contendrá los componentes
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        //Atributos finales para determinar el alto y ancho de los componentes que añadiremos a nuestro panel
        final int alt  = 20;
        final int anch = 165;
        //Definimos la posión de cada uno de los componentes
        txt0.setBounds(40, 30, anch, alt);
        bp0.setBounds(180, 30, anch, alt);
        txt1.setBounds(40, 30*2, anch, alt);
        bp1.setBounds(180, 30*2, anch, alt);
        txt2.setBounds(40, 30*3, anch, alt);
        bp2.setBounds(180, 30*3, anch, alt);
        txt3.setBounds(40, 30*4, anch, alt);
        bp3.setBounds(180, 30*4, anch, alt);
        //Añade al panel los componentes
        panel.add(txt0);
        panel.add(bp0);
        panel.add(txt1);
        panel.add(bp1);
        panel.add(txt2);
        panel.add(bp2);
        panel.add(txt3);
        panel.add(bp3);
        //Se declara un Frame y se definen sus métodos necesarios
        JFrame frame = new JFrame();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize( new Dimension(420,220));
            frame.setLocation(900, 500);
            frame.pack();
            frame.setVisible(true);
    }
    //Clase main que instancia un objeto de esta misma Clase
    public static void main (String [] args){
        JProgressPrueba j1 = new JProgressPrueba();
    }
    
}
