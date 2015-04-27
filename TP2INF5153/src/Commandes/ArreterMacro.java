/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commandes;

import Modele.Buffer;

/**
 *
 * @author lebaron2012
 */
public class ArreterMacro implements Commande{

    private Buffer buffer;

    public ArreterMacro(Buffer buffer) {
        this.buffer = buffer;
    }
    
    
    @Override
    public void execute() throws Exception {
        buffer.setIndiceTimer(2);
    }
    
}
