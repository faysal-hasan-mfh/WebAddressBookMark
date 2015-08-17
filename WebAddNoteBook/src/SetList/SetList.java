/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SetList;

import createDatabase.GetDataFromDatabase;
import javax.swing.DefaultListModel;

/**
 *
 * @author faysal
 */
public class SetList {
    
    String WAN[];
    public SetList()
    {
    GetDataFromDatabase objgdfd=new GetDataFromDatabase();
    
     this.WAN=objgdfd.getWNFromDB();   
    }
    
    public void CheckAndPublish(String searchLetter)
    {
    /*    
    for ( String string : WAN )
        {
           if ( string.startsWith( searchLetter ) ) {
                System.out.printf( "\"%s\" starts with \"w\"\n", string );
            }
        }
        */
        
        int wacount=0;
      while(wacount<WAN.length)
      {
      
          if((WAN[wacount]!=null)&&((WAN[wacount].startsWith(searchLetter))||(WAN[wacount].startsWith(searchLetter.toLowerCase())))) {
              System.out.println(WAN[wacount]);
          }
          
        //  if((WAN[wacount]!=null)&&(WAN[wacount].startsWith(searchLetter))) {
         
        //     System.out.println(WAN[wacount]);
        //  }
          
          ++wacount;
      }
    }
    
    
    
    public DefaultListModel CheckAndMakeList(String searchLetter)
    {
    
        DefaultListModel DLMWA=new DefaultListModel();
        
        int wacount=0;
      while(wacount<WAN.length)
      {
      
       //   if((WAN[wacount]!=null)&&(WAN[wacount].startsWith(searchLetter))) {
         
          if((WAN[wacount]!=null)&&((WAN[wacount].startsWith(searchLetter))||(WAN[wacount].startsWith(searchLetter.toLowerCase())))) {
              DLMWA.addElement(WAN[wacount]);
          }
          
          ++wacount;
      }
    return DLMWA;
    }
    
    
    public static void main(String arg[])
    {
    SetList sl=new SetList();
    sl.CheckAndPublish("A");
    }
}
