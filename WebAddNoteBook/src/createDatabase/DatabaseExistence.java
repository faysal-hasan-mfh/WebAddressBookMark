/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createDatabase;

import java.io.File;

/**
 *
 * @author faysal
 */
public class DatabaseExistence {
    
    File fl=new File("C:/testDB/test.db");
    
    boolean dbExistence;
    
    public void showPathAndExistenc(){
    if(fl.exists()){
    
        System.out.println(fl.getName()+" exists");
        
        System.out.println(fl.isFile() ? "is a file" : "is not a file");
        
        System.out.println(fl.getAbsolutePath());
        
                }
    }
    
    public boolean dbExist(){
    
        if(fl.exists()) {
            return true;
        }
        else {
            return false;
        }
    
  }
    
}
