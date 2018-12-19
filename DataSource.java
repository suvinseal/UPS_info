package finalProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*; 
/**
 * This class establishes the connection between the database and the data entered in UPS_info class
 * @author Suvin
 */
public class DataSource {
    // name of the database and its connection String
    public static final String databaseName = "ups.db";
    public static final String connectionString = "jdbc:sqlite:C:\\Users\\asus\\Desktop\\Suvin\\Washington College\\Fall 18\\CSI 203\\final project\\ups.db";
    
    // table and its columns in the database 
    public static final String tableRack = "rack";
    public static final String UPSSerialNo = "UPSSerialNo";
    public static final String roomNumber = "roomNumber";
    public static final String rackNum = "rackNum";
    public static final String make = "make";
    public static final String model = "model";
    public static final String MFGdate = "MFGDate";
    public static final String UPStype = "UPSType";
    public static final String numOfSwitchesPluggedIn = "numOfSwitchesPluggedIn";
    public static final String surveyID = "surveyID";
                
    public static final String tableBuilding = "building";
    public static final String building_ID = "buildingID";
    public static final String building_name = "buildingName";
    
    public static final String tableSurveyInfo = "surveyID";
    public static final String surveyInfo_surveyID = "surveyID";
    public static final String survey_surveyID = "buildingID";
    
    public static final String insertRack = "INSERT INTO " + tableRack + 
            '(' + UPSSerialNo + ", " + roomNumber + ", " + rackNum + ", " +
            make + ", " + model + ", " + MFGdate + ", " + UPStype + ", " +
            numOfSwitchesPluggedIn + ", " + surveyID + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
    
    public static final String deleteRack = "DELETE FROM rack WHERE UPSSerialNo = ?";
    
    private Connection conn;            // make a connection string 
    
    private PreparedStatement insertIntoRack;
    private PreparedStatement deleteFromRack; 
    
    public boolean open(){
        try {                           // open if connected
            conn = DriverManager.getConnection(connectionString);  
            insertIntoRack = conn.prepareStatement(insertRack, Statement.RETURN_GENERATED_KEYS);
            deleteFromRack = conn.prepareStatement(deleteRack);
            return true;
        }
        catch(SQLException e) {         // throws exception 
            System.out.println("Coudn't connect to a database." + e.getMessage());
            return false;
        }
    }
    
    public void close(){                // close if no connection 
        try{
            if(insertIntoRack != null){
                insertIntoRack.close();
            }
            
            if(deleteFromRack == null){
                deleteFromRack.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        catch(SQLException e){          // get and throw the exception  
            System.out.println("Could not close connection" + e.getMessage());
        }
    }
    
    
    public List<Rack> queryRack(){
        
        try(Statement statement = conn.createStatement();                                 // uses statement library
            ResultSet results = statement.executeQuery("SELECT * FROM " + tableRack)) {   // uses sql library
            
            List<Rack> rack = new ArrayList<>();
            while(results.next()){
                Rack rackInfo = new Rack();        // rackInfo gives certain attributes of the rack 
                rackInfo.setUPSSerialNum(results.getString("UPSSerialNo"));
                rackInfo.setRackRoomNum(results.getString("roomNumber"));
                rackInfo.setRackNum(results.getString("rackNum"));
                rackInfo.setMake(results.getString("make"));
                rackInfo.setModel(results.getString("model"));
                rackInfo.setMFGDate(results.getString("MFGdate"));
                rackInfo.setUPSType(results.getString("UPStype"));
                rackInfo.setNumOfSwitchesPluggedIn(results.getString("numOfSwitchesPluggedIn"));
                rackInfo.setSurveyID(results.getString("surveyID"));
                rack.add(rackInfo);    
            }
            return rack; 
        } 
        catch(SQLException e){
            System.out.println("Query failed" + e.getMessage());
            return null;
        } 
    }
    
    public void insertRack(String UPSSerialNo, String roomNumber, String rackNum,
     String make, String model, String MFGdate, String UPStype, String numOfSwitchesPluggedIn,
     String surveyID) throws SQLException{
        insertIntoRack.setString(1, UPSSerialNo );
        insertIntoRack.setString(2, roomNumber );
        insertIntoRack.setString(3, rackNum );
        insertIntoRack.setString(4, make );
        insertIntoRack.setString(5, model );
        insertIntoRack.setString(6, MFGdate );
        insertIntoRack.setString(7, UPStype );
        insertIntoRack.setString(8, numOfSwitchesPluggedIn );
        insertIntoRack.setString(9, surveyID );
        
        int affectedRows = insertIntoRack.executeUpdate();
        if (affectedRows != 1){
            throw new SQLException("Could not insert Rack"); 
        }
    }
    
    public void deleteRack(String UPSSerialNo) throws SQLException{
        
        deleteFromRack.setString(1,UPSSerialNo ); 
        int affectedRow = deleteFromRack.executeUpdate(); 
        if (affectedRow != 1){
            throw new SQLException("Could not delete from Rack"); 
        }
    }
}
    


