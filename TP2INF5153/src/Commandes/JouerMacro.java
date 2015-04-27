/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commandes;

import Modele.Buffer;

/**
 *
 * @author LeBaron2012
 */
public class JouerMacro implements Commande  {

    private Buffer buffer;

    public JouerMacro(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void execute() throws Exception {
     buffer.jouer();
    }
    
}
