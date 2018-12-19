package finalProject;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 * This class helps execute queries from the database 
 * @author Suvin
 */
public class Main {
 
    public static void main(String[] args){
        
        
        
        GuiMainFrame frame = new GuiMainFrame();
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
        
        
        DataSource datasource = new DataSource();
        if (!datasource.open()){
            System.out.println("Can't open datasource");
            return;
        }     
        datasource.close();
    }
   
    }
