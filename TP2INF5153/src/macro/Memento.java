/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

/**
 *
 * @author lebaron2012
 */
public class Memento {
     private String state;
 
        public Memento(String stateToSave) { state = stateToSave; }
        public String getSavedState() { return state; }
}
