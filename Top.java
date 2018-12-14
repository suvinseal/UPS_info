package finalProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder; 
/**
 *
 * @author Suvin
 */
public class Top extends JPanel {
    
    public Top(){
        
        TitledBorder border = new TitledBorder("Welcome to UPS_info");
        border.setTitleJustification(TitledBorder.LEFT); 
        border.setTitlePosition(TitledBorder.TOP);
        setBorder(border);
        
    }
    
}
