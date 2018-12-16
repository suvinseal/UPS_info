package finalProject;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Suvin
 */
public class GuiMainFrame extends JFrame {
    
    public GuiMainFrame(){
        
        add(new Top(), BorderLayout.NORTH);
        add(new Mid(), BorderLayout.CENTER);
        add(new Bottom(), BorderLayout.SOUTH);
        setTitle("CSI 203, Final Project - Suvin"); 
    }
}































