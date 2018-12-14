package finalProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 *
 * @author Suvin
 */
public class Bottom extends JPanel {
    
    public static JButton insert = new JButton("Insert");
    public static JButton delete = new JButton("Delete");
    public static JButton display = new JButton("Display");
   
    
    public Bottom(){
        
        add(insert);
        insert.setActionCommand("i");
        insert.setSelected(true);
        
        add(display);
        display.setActionCommand("di");
        display.setSelected(true); 
        
        add(delete);
        delete.setActionCommand("d");
        delete.setSelected(true); 
    }
    
}
