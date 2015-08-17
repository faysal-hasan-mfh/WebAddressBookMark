/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateDatabase {
    
    
    
    Connection c = null;
    Statement stmt = null;
    CreateFilePath cfp=new CreateFilePath();
    
    public void createDatabaseMethod(){
    
        if(cfp.fileexist()){
        
        
                 try {
                     Class.forName("org.sqlite.JDBC");
                     c = DriverManager.getConnection("jdbc:sqlite:c://testDB/test.db");
      
      
                      System.out.println("Opened database successfully");
                      JOptionPane.showMessageDialog(null, "Database Successfully Created...", "Database Info : ", JOptionPane.INFORMATION_MESSAGE);
    
      
      stmt = c.createStatement();
      String sql = "CREATE TABLE websiteaddress " +
                   "(ID INT PRIMARY KEY," + 
                   " ADDRESS TEXT)";  
                   
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("From CreateDatabase");
      System.exit(0);
    }
    System.out.println("Table created successfully");
    }
     else
    {
    JOptionPane.showMessageDialog(null, "sorry.. file path is not existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    
     int getvalue=JOptionPane.showConfirmDialog(null, "Do you want to create file folder ? ", "Create path?", JOptionPane.YES_NO_OPTION);
    
     if(getvalue==0)
     {
     CreateFilePath cfp=new CreateFilePath();
     }
     else{
     JOptionPane.showMessageDialog(null,"You must have to create folder to access DB.."
             + "", "Info: ", JOptionPane.WARNING_MESSAGE);
     }
    
    }
        
        
        
        
   }
    
   /*
    public static void main(String arg[]){
    
    CreateDatabase obj =new CreateDatabase();
    obj.createDatabaseMethod();
    }
     
     */ 
}
