
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Copier
 * Commande pour Copier
 */
public class Copier implements Commande {

 private Buffer monBuffer;

    public Copier(Buffer monBuffer) {
        this.monBuffer = monBuffer;
    }
     
    public void execute() throws Exception {
       
      monBuffer.Copie();
   
    }
    
}
