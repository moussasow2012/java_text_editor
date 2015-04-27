/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commandes;

import Modele.Buffer;

/**
 *
 * @author Moussa SOW
 * Classe Coller
 * Commande pour coller
 */
public class Coller implements Commande {

  private Buffer monBuffer;

    public Coller(Buffer monBuffer) {
        this.monBuffer = monBuffer;
    }

   
    public void execute() throws Exception {
     monBuffer.Colle();
    }
    
}
