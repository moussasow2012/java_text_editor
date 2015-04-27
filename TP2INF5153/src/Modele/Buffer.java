
package Modele;

import java.util.Observable;
import macro.Caretaker;
import macro.Originator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moussa SOW
 * Classe Buffer: Représente le modèle
 * Extends Observable
 * C'est l'observable il notifie son Observeur TextArea lorsque son Texte est modifier
 */
public class Buffer extends Observable {
      private String text ;    
      private int debutSelection; 
      private int finSelection ;    
      private PressPapier presspapier;
      private Originator originateur = new Originator(" ");
      private Caretaker caretaker = new Caretaker();
      private Caretaker caretaker2 = new Caretaker();
      private int[] indiceTimer = new int[2];
      private int temp; 
      private int indiceMacro ;

  
      
    public Buffer(String text,  int debutSelection, int finSelection) {
       //Constructeur
        this.text =text;        
        this.debutSelection = debutSelection;
        this.finSelection = finSelection;
        presspapier = new PressPapier("");
         caretaker.addMemento( originateur.saveToMemento() );
          caretaker2.addMemento( originateur.saveToMemento() );
          indiceTimer[0] = -1;
           indiceTimer[1] = -1;
            
    }

    public Buffer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    public void insert(String c){      
    //Pour la commande Insérer
        Write(c);
    }
    
    public void Supprime(){
        if(text.length()>0){ // Si il ya du texte à supprimer (Pour éviter une exception)
        if(getTextSelection().equals("")){ //Si aucun texte n'est sélectionné
            text = text.substring(0, text.length()-1);
             setChanged();           
             notifyObservers(text); // Notifie le TextArea
                 originateur.set(text);
             caretaker.addMemento( originateur.saveToMemento() );
              caretaker2.addMemento( originateur.saveToMemento() );
             indiceMacro = caretaker.tailleListe();
            
        }else{ //sinon
            String temp;
            String temp2;
            if(debutSelection < finSelection){ // Si on sélectionne le texte normalement
            temp = text.substring(0, debutSelection);
            temp2 = text.substring(finSelection);
            }else{// Si le texte est sélectionné de les droite vers la gauche
            temp = text.substring(0, finSelection);
            temp2 = text.substring(debutSelection,text.length());
            }
            text = temp+""+temp2;
       
             setChanged();           
             notifyObservers(text); // Notifie le TextArea
              originateur.set(text);
             caretaker.addMemento( originateur.saveToMemento() );
             indiceMacro = caretaker.tailleListe();
            }
        }
    }

    public void setDebutSelection(int debutSelection) {
        this.debutSelection = debutSelection;
    }

    public void setFinSelection(int finSelection) {
        this.finSelection = finSelection;
    }
    


    public String getTextSelection() { // pour connaitre le texte sélectionné
            String selection;
        if(debutSelection < finSelection){
        selection = text.substring(debutSelection,finSelection); 
        }else {
            selection = text.substring(finSelection); 
        }
        return selection;
        
    }

   

    public void Copie(){ // Pour enregistrer le texte Copié ou coupé
        if(getTextSelection().length()>0){
     
         presspapier.setValeur(getTextSelection());
         
        }
    }
    
    public void Colle(){ // Pour coller le texte Copié ou coupé      
       // Write(valeurCopie) ;
        Write(presspapier.getValeur());
    }
  
    public void Coupe(){ // Pour couper du texte
        if(getTextSelection().length()>0){
        Copie();
        Supprime();
        }
    }
        
      public void setIndiceTimer(int a) {
          /*Méthode permettant de définir le début et la fin
           * de la liste de memento à afficher pour la macro jouer
           */
       if(a==1){ this.indiceTimer[0] = caretaker2.tailleListe();}else if(a==2){
        this.indiceTimer[1] = caretaker2.tailleListe()-1;}
       temp = indiceTimer[0];
    }
    
      public void jouer() throws InterruptedException{
    
         /*Méthode pour gérer la macro Jouer()
          * On Restaure les mementos sauvegarder 
          * à partir d'une position définit jusqu'à la fin de la 
          * liste du Caretaker. On utilise l'outils Timer pour
          * gérer les intervalles de temps pour l'affichage
          */
          if(indiceTimer[0] != -1){
         final Timer timer = new Timer();
         timer.schedule(new TimerTask() {
            
             @Override
             public void run() {
                originateur.restoreFromMemento( caretaker2.getMemento(indiceTimer[0]));
                text = originateur.getState();
                setChanged();            
                notifyObservers(text);
                         // Thread.currentThread().sleep(100);
                if(indiceTimer[1]> 0){
             if(indiceTimer[0]<indiceTimer[1] && indiceTimer[1]<caretaker2.tailleListe()){ indiceTimer[0]++;}else{timer.cancel();}  
                 } 
             else {
             if(indiceTimer[0]<caretaker2.tailleListe()-1){ indiceTimer[0]++;}else{timer.cancel();}  
         }
             }
             
         },0,200);
                  
          }      
    indiceTimer[0] = temp;
      }
      
 
   
    public void defaire(){
       
        if(indiceMacro > 0){
           indiceMacro--;      
        originateur.restoreFromMemento( caretaker.getMemento(indiceMacro));
        text = originateur.getState();
         caretaker2.addMemento( originateur.saveToMemento() );
        setChanged();            
        notifyObservers(text);
        }
    }
    
     public void refaire(){
           
             if(indiceMacro<caretaker.tailleListe()-1){
                  indiceMacro++;
        originateur.restoreFromMemento( caretaker.getMemento(indiceMacro));
          text = originateur.getState();
           caretaker2.addMemento( originateur.saveToMemento() );
        setChanged();            
        notifyObservers(text);
             }
    }
    
    public void Write(String c){          
      // Méthode Pour écricre le dans le Text du buffer et Notiffier le texteArea son observeur 
            
             int debut = debutSelection;             
             int fin = finSelection;
             String temp = "";
              String temp2 =""; 
                    if(fin == debut){// Rien n'est selectionner
                        
                     temp = text.substring(0, fin);
                     temp2 = text.substring(fin);
                     text = temp+c+temp2;
                
                     setChanged();            
                        notifyObservers(text);
                        originateur.set(text);
                        caretaker.addMemento( originateur.saveToMemento() );
                           caretaker2.addMemento( originateur.saveToMemento() );
                          indiceMacro = caretaker.tailleListe();
                    }else if(fin != debut){// Si du texte est sélectionnée
                     Supprime();                
                     Write(c);                 
                      
                    }           
    }
    
        
}