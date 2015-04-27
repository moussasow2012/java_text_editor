
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Couper
 * Commande pour Couper
 */
public class Couper implements Commande  {

 private Buffer monBuffer;

    public Couper(Buffer monBuffer) {
        this.monBuffer = monBuffer;
    }

 
    public void execute() throws Exception {
        monBuffer.Coupe();
    }
    
}
