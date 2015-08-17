/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class InsertWebNameIntroDB {
    
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB(String WebsiteAddressName){
    
    
        GetDataFromDatabase objgdfd=new GetDataFromDatabase();
        
        int lastID= objgdfd.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/testDB/test.db");
            c.setAutoCommit(false);
            System.out.println("Opened WN database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO websiteaddress (ID,ADDRESS) " +
                   "VALUES (?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,WebsiteAddressName);
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
            System.exit(0);
    }
        
        
    System.out.println("Records created successfully");
    JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
    }
    
    
    public static void main(String arg[])
    {
    InsertWebNameIntroDB obj=new InsertWebNameIntroDB();
    
    obj.InsertToDB("www.abc.com");
    }
     
}
