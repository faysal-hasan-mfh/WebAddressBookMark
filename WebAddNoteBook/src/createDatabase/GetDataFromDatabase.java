/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class GetDataFromDatabase {
     Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    
    int id[]=new int[5000];
    
    DatabaseExistence dbe=new DatabaseExistence();
    
    
    int getLastId;
    
    
   // method....
    
    public String[] getWNFromDB(){
    
     
    
        if(dbe.dbExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/testDB/test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database WN successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM websiteaddress;" );
      
              int count=0;
      
              while ( rs.next() ) {
          
                  this.web_name[count]=rs.getString("ADDRESS");
        
                      ++count;
                }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
        return web_name;
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
    
    
    
    
    
    
    
    
    public int[] getIDFromDB(){
    
   if(dbe.dbExist()){     
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:C:/testDB/test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database ID successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM websiteaddress;" );
      
      int countID=0;
      while ( rs.next() ) {
          
     
         this.id[countID]=rs.getInt("ID");
       
         
         ++countID;
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
        
        return id;
   }
   else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return id;
    }
   
    }
    
    public void showWNFromDB(String []wn ){
        
      
     /* 
      int count2=0;
      while(count2<sub_name.length)
      {
      
          if(sub_name[count2]!=null)
          System.out.println(sub_name[count2]);
          
          ++count2;
      }
        
    */
        
        int count2=0;
      while(count2<wn.length)
      {
      
          if(web_name[count2]!=null) {
              System.out.println(wn[count2]);
          }
          
          ++count2;
      }
        
    }
    
    public void showIDFromDB(int []id ){
        
      
     /* 
      int count2=0;
      while(count2<sub_name.length)
      {
      
          if(sub_name[count2]!=null)
          System.out.println(sub_name[count2]);
          
          ++count2;
      }
        
    */
        
        int count3=0;
      while(count3<id.length)
      {
      
          if(web_name[count3]!=null) {
              System.out.println(id[count3]);
          }
          
          ++count3;
      }
        
    }
    
    
    
     public int totalID(String []wn ){
        
     int totalIDnum=0,countid=0;
      while((countid<wn.length)&&(web_name[countid]!=null))
      {
      
       totalIDnum= ++countid;
        
      }
        
      
      return totalIDnum;
      
    }
    
     // Last id       ,,,,,,,,,,,,,............
     
    public int LastID(){
    
        if(dbe.dbExist()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
                c = DriverManager.getConnection("jdbc:sqlite:C:/testDB/test.db");
                c.setAutoCommit(false);
      
                System.out.println("Opened database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM websiteaddress;" );
      
       int countID=0;
                 while ( rs.next() ) {
                         this.id[countID]=rs.getInt("ID");
                           getLastId=id[countID];
                        ++countID;
                        }
                 
      
                 rs.close();
                 stmt.close();
                   c.close();
            }
            catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                        System.exit(0);
                }
        
        return getLastId;
   }
   else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return getLastId;
    }
   
    }
    
    public static void main( String args[] )
  {
    
    GetDataFromDatabase ob= new GetDataFromDatabase();
      
  //  String [] WNarr=  ob.getWNFromDB();
   //   ob.showWNFromDB(WNarr);
      
      
//    int []IDarr= ob.getIDFromDB(); 
  //    ob.showIDFromDB(IDarr);
    
    //  System.out.println("Total inserted ID : "+ ob.totalID(WNarr));
      
      System.out.println("Last ID is: "+ob.LastID());
    
  }
}
