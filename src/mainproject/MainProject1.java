/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

/**
 *
 * @author Manideep
 */
public class MainProject1 {

    /**
     * @param args the command line arguments
     */
    //Calling the designed frame from main method
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainProject().setVisible(true);
            }
        });
        
        
    }

   
    
}
