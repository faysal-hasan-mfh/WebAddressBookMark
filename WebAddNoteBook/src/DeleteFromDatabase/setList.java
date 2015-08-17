/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeleteFromDatabase;

import createDatabase.GetDataFromDatabase;
import javax.swing.DefaultListModel;

/**
 *
 * @author faysal
 */
public class setList {
    
    GetDataFromDatabase objgdfd=new GetDataFromDatabase();
   
    DefaultListModel dlm=new DefaultListModel();
    
    
    
    public DefaultListModel deleteSetList(){
    
        String getWebAdd[]= objgdfd.getWNFromDB();
                int lengthofid=objgdfd.totalID(getWebAdd);
                
         
                if(lengthofid!=0){
                    
                
                     for(String wan: getWebAdd)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                }
                        }
                
                         return dlm;
                }
                else
                {
               
                String noItem="NO ITEM !";
                dlm.addElement(noItem);
                return dlm;
                
                }
                
                
    }
}
