
package vue;


import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Moussa SOW
 * Classe Texte_area
 * extends javax.swing.JTextArea et implements Observer 
 * Observer est une classe abstraite pour le patron observateur
 * Il sera notifié et mis à jour par le buffer
 * La relation entre le textArea et le buffer en temps qu'observateur et observable a été faite dans le main 
 */

public class TexteArea extends javax.swing.JTextArea implements Observer{
   
    
  

    public TexteArea() throws HeadlessException {
        
    }


    @Override
    public void update(Observable o, Object arg) {
        
     this.setText(arg.toString());
    }

    
}
