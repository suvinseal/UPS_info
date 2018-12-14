package finalProject;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Suvin 
 */
public class Mid extends JPanel {
    
    private static String message = "Would you like to insert, display or delete?";
    private static int x = 60;  
    private static int y = 35;  
    
    public Mid(){
        
       TheHandler handler = new TheHandler();
       setBackground(Color.white);
       
       Bottom.display.addMouseListener(new MouseListener(){
           public void mouseClicked(MouseEvent e){
               if (e.getSource() == Bottom.display){
                   
                    DataSource datasource = new DataSource();
               if (!datasource.open()){
                   System.out.println("Can't open datasource");
                     return;
                } 
                   
                    java.util.List<Rack> rack = datasource.queryRack();
       
               if (rack == null){
                     System.out.println("No data!");
                     return;
                }
      
            for(Rack rackInfo : rack){
          
                System.out.println("Serial Number = " + rackInfo.getUPSSerialNum() + 
                               ", Room Number = " + rackInfo.getRackRoomNum() +
                               ", Rack Number = " + rackInfo.getRackNum() +
                               ", Make = " + rackInfo.getMake() + 
                               ", Model = " + rackInfo.getModel() +
                               ", Manufacturing Date = " + rackInfo.getMFGDate() +
                               ", UPS type = " + rackInfo.getUPSType() + 
                               ", Number of Switches Plugged in UPS = " + rackInfo.getNumOfSwitchesPluggedIn() +
                               ", Survey ID = " + rackInfo.getSurveyID()); 
      
                  }
                  datasource.close();
               }
               else {
                   return; 
               }
           }
           public void mousePressed(MouseEvent e){
               
           }
           public void mouseReleased(MouseEvent e){
               
           }
           public void mouseEntered(MouseEvent e){
               
           }
           public void mouseExited(MouseEvent e){
               
           }
       });
       
        Bottom.delete.addMouseListener(new MouseListener(){
           public void mouseClicked(MouseEvent e){
               if (e.getSource() == Bottom.delete){
                   
               DataSource datasource = new DataSource();
               if (!datasource.open()){
                   System.out.println("Can't open datasource");
                     return;
                } 
               System.out.println("Enter the Id:");
               Scanner input = new Scanner(System.in);
               String upsSerialNum = input.nextLine();
      
               try {
                datasource.deleteRack(upsSerialNum);
                 }
               catch(SQLException e3){
                System.out.println("Error while deleting table" + e3.getMessage());
                 }
   
               datasource.close();
               }
               else {
                   return; 
               }
           }
           public void mousePressed(MouseEvent e){
               
           }
           public void mouseReleased(MouseEvent e){
               
           }
           public void mouseEntered(MouseEvent e){
               
           }
           public void mouseExited(MouseEvent e){
               
           }
       });
        
        Bottom.insert.addMouseListener(new MouseListener(){
           public void mouseClicked(MouseEvent e){
               if (e.getSource() == Bottom.insert){
                   
               DataSource datasource = new DataSource();
               if (!datasource.open()){
                   System.out.println("Can't open datasource");
                     return;
                } 
            System.out.println("Please enter the values to be entered sequentially"); 
            Scanner input = new Scanner(System.in); 
            String upsSerialNumber = input.nextLine(); 
            String roomnumber = input.nextLine();
            String racknumber = input.nextLine();
            String upsmake = input.nextLine();
            String upsmodel = input.nextLine();
            String manfdate = input.nextLine();
            String upstype = input.nextLine();
            String numswitches = input.nextLine();
            String surveyid = input.nextLine(); 
            
            try {
            datasource.insertRack(upsSerialNumber, roomnumber, racknumber, upsmake, upsmodel,
                    manfdate, upstype, numswitches, surveyid);
            }
            catch(SQLException e2){
                System.out.println("Something bad happened" + e2.getMessage());
            }           
            datasource.close();
               }
               else {
                   return; 
               }
           }
           public void mousePressed(MouseEvent e){
               
           }
           public void mouseReleased(MouseEvent e){
               
           }
           public void mouseEntered(MouseEvent e){
               
           }
           public void mouseExited(MouseEvent e){
               
           }
       });
    }
    
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString(message,x,y);
        }
    
    private class TheHandler implements MouseListener{
        
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == Bottom.display){
                
            }
            if (e.getSource() == Bottom.delete){
                
            }
            if (e.getSource() == Bottom.insert){
                
            }
        }
            
           public void mousePressed(MouseEvent e){
               
           }
           public void mouseReleased(MouseEvent e){
               
           }
           public void mouseEntered(MouseEvent e){
               
           }
           public void mouseExited(MouseEvent e){
               
           }
            
       }
    }

