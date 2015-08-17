/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createDatabase;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateFilePath {
    
    boolean folder;
    public CreateFilePath(){
    
        File fl=new File("C://testDB");
        boolean isPathCreated=fl.mkdir();
        if(isPathCreated)
        {
        JOptionPane.showMessageDialog(null, "FILE FOLDER SUCCESSFULLY CREATED...", "FILE PATH CREATED..", JOptionPane.INFORMATION_MESSAGE);
        this.folder=true;
        }
    }
    public boolean fileexist()
    {
        
    return folder;
    }
    
    public static void main(String arg[])
    {
        CreateFilePath object= new CreateFilePath();
        
    }
}
