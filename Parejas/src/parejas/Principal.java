/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parejas;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Principal
{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException
    {
        LecturaDatos lectura = new LecturaDatos();
        
        JOptionPane.showMessageDialog(null, lectura.toString());
        
        
        lectura.destructorLecturaDatos();
        
        
    }
    
}
