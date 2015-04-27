
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Selectionner
 * Commande Selection
 */
public class Selectionner implements Commande {
    
    private Buffer monBuffer;
    private int debut;
    private int fin;

    public Selectionner(Buffer monBuffer, int debut, int fin) {
        this.monBuffer = monBuffer;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void execute() throws Exception {
               monBuffer.setDebutSelection(debut);
               monBuffer.setFinSelection(fin); 
    }
    
}
