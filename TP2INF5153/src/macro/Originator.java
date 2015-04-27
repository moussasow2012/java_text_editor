/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

/**
 *
 * @author lebaron2012
 */
public class Originator {
    
    private String state;

    public Originator(String state) {
        this.state = state;
    }
        
 
    public void set(String state)
    {
        
        this.state = state;
    }

    public String getState() {
        return state;
    }
 
    public Object saveToMemento()
    {
       
        return new Memento(state);
    }
 
    public void restoreFromMemento(Object m)
    {
        if (m instanceof Memento)
        {
            Memento memento = (Memento)m;
            state = memento.getSavedState();
            
        }
    }
    
}
