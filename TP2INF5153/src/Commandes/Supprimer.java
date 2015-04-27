
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Supprimer
 * Commande supprimer
 */
public class Supprimer implements Commande {

    private Buffer monBuffer;

    public Supprimer(Buffer monBuffer) {
        this.monBuffer = monBuffer;
    }
    
    @Override
    public void execute() throws Exception {
        monBuffer.Supprime();
    }
    
}
