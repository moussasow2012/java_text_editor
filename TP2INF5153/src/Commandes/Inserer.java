
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Inserer
 * Commande pour inserer
 */
public class Inserer implements Commande {

    private Buffer monBuffer;
    private char caractereClavier;
    public Inserer(Buffer monBuffer , char caractereClavier) {
        this.monBuffer = monBuffer;
        this.caractereClavier = caractereClavier;
    }

    
    @Override
    public void execute() throws Exception {
        monBuffer.insert(""+caractereClavier);  
    }
    
}
