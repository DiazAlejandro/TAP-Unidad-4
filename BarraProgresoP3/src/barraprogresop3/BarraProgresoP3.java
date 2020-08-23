package barraprogresop3;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class BarraProgresoP3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Barra de Progreso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        JProgressBar bp = new JProgressBar(1, 100);
        frame.setLayout(new FlowLayout());
        bp.setStringPainted(true);
        frame.add(bp);
        frame.setLocation(900, 500);
        frame.setVisible(true);
        for(int i = 0 ; i <= 100 ; i++)
            try{
                bp.setValue(i);
                Thread.sleep(80);
            }catch(Exception e){
            
            }
    }
    
}
