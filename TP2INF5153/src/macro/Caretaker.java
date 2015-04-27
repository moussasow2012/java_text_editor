/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import java.util.ArrayList;

/**
 *
 * @author lebaron2012
 */
public class Caretaker {
    private ArrayList ListeMemento = new ArrayList();

  
 
    public void addMemento(Object m) { 
        ListeMemento.add(m); 
    }
    
    public Object getMemento(int index) { 
        return ListeMemento.get(index);
    }
    
    public int tailleListe(){        
    return ListeMemento.size();
}
    
}
