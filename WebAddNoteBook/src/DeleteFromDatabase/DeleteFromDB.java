/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeleteFromDatabase;

import createDatabase.DatabaseExistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class DeleteFromDB {
    
    Connection c = null;
    Statement stmt = null;
    DatabaseExistence dbe=new DatabaseExistence();
    
    
    
    public void deleteItem(String getSelectedItem)
    {
    
        if(dbe.dbExist()){ 
                
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:c:/testDB/test.db");
                c.setAutoCommit(false);
      
                System.out.println("Opened database successfully from DeleteFromDB ");

                stmt = c.createStatement();
                String sql = "DELETE FROM websiteaddress WHERE ADDRESS=?";
                
                PreparedStatement pst= c.prepareStatement(sql);
                
                pst.setString(1,getSelectedItem);
                pst.executeUpdate();
                c.commit();
                
                
                 
                stmt.close();
                c.close();
             }
            catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                   System.exit(0);
                }
    
            System.out.println("Operation done successfully");
            JOptionPane.showMessageDialog(null, "Item Successfully Deleted.", "Delete Option: ", JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    else{
            JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    
    // delete all item.............
    
    
    
    public void deleteAllItem()
    {
    
        if(dbe.dbExist()){ 
                
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:c:/testDB/test.db");
                c.setAutoCommit(false);
      
                System.out.println("Opened database successfully from DeleteFromDB  delete allll ");

                stmt = c.createStatement();
                String sql = "DELETE FROM websiteaddress";
                
                PreparedStatement pst= c.prepareStatement(sql);
                
                pst.executeUpdate();
                c.commit();
                
                
                 
                stmt.close();
                c.close();
             }
            catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                   System.exit(0);
                }
    
            System.out.println("All Data Deleted successfully");
            JOptionPane.showMessageDialog(null, " ALL Item Successfully Deleted.", "Delete Option: ", JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    else{
            JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    }
        
    }
    
    
    
    
 /*   
    public static void main(String arg[])
    {
        DeleteFromDB obj=new DeleteFromDB();
        obj.deleteItem("h");
                
    }
    */ 
}
