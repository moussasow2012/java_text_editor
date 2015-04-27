
package vue;

import Commandes.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import Modele.Buffer;
import javax.swing.AbstractButton;
/**
 *
 * @author Moussa SOW
 * Classe Texte_Editor
 * extend JFrame
 * Il contient le Main de l'application
 * Il représente la vue principale des utilisateurs
 * Il contient un Buffer et un TextArea
 * Il crée les commandes, il contient les bouttons correspondant aux commandes
 * 
 */
public class TextEditor extends JFrame {

    /**
     * Creates new form textEditeur
     */
    private static Buffer monBuffer ;
    private static boolean copiee;
    private static boolean selectionnee;
    private static Commande coupe;
    private static Commande insertion;
    private static Commande colle;
    private static Commande copie;
    private static Commande supprime;
    private static Commande selection;
     private static Commande defaire;
      private static Commande refaire;
       private static Commande jouer;
       private static Commande enregistrer;
      private static Commande stopperEnregistrement;
     
    public TextEditor(Buffer monBuffer) {
        initComponents(); // Méthode pour créer l'interface graphique
       this.monBuffer = monBuffer;
    }
    
   
    
    @SuppressWarnings("unchecked")
                              
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new vue.TexteArea();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        copiee = false;
        selectionnee = false;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("framePrincipal"); // NOI18N

        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setMinimumSize(new java.awt.Dimension(60, 110));
        jInternalFrame1.setVisible(true);

       jTextArea1.setColumns(20);
       jTextArea1.setRows(5);
       jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
       jScrollPane1.setViewportView(jTextArea1);
      

        label1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        label1.setMinimumSize(new java.awt.Dimension(100, 100));
        label1.setPreferredSize(new java.awt.Dimension(90, 20));
        label1.setText("Text Editor 1.1");

        jButton1.setText("Copier"); // Copier

        jButton2.setText("Coller"); // Coller

        jButton3.setText("Couper"); // Couper

        button1.setLabel("<--  Défaire");

        button2.setLabel("Refaire -->");

        jCheckBox1.setText("Enregistrer");

        jButton4.setText("Jouer");
        
      
            jButton1.setEnabled(false); // on désactive le bouton Copier Pour gérer une exception: il faut sélectionner du texte pour pouvoir Copier
            jButton2.setEnabled(false); // on désactive le bouton Coller Pour gérer une exception: il faut couper ou copier avant de pouvoir coller
            jButton3.setEnabled(false); //on désactive le bouton Couper Pour gérer une exception: il faut sélectionner du texte pour pouvoir couper
             button1.setEnabled(false);
             button2.setEnabled(false);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(110, 110, 110)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 331, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(canvas2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2))
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        
        jTextArea1.addKeyListener(new KeyListener() {// Ajout de listener pour chaque frappe au clavier

            @Override
            public void keyTyped(KeyEvent e) {
            
            }

            @Override
            public void keyPressed(KeyEvent e) { //Losrqu'on presse un boutton
              if(!e.isActionKey() && !e.isControlDown() && !(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)){
                    // Si c'est un caractère ayant un code Unicode et différent de la touche Bacspace         
                 try {
                        button1.setEnabled(true);
                        insertion = new Inserer(monBuffer,e.getKeyChar()); 
                        insertion.execute();//On exécute la commande d'insertion
                 } catch (Exception ex) {
                     Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){// Si c'est la touche Backspace
                    try {
                           supprime = new Supprimer(monBuffer);
                           supprime.execute();// On exécute la commande de suppression
                    } catch (Exception ex) {
                        Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            

            @Override
            public void keyReleased(KeyEvent e) {
               jTextArea1.getCaret().setVisible(true);
            }
        });
              
         
         CaretListener caret = new CaretListener() {
             // On utilise un listener de java pour la position du curseur
            @Override
            public void caretUpdate(CaretEvent e) { // dès que le curseur bouge
                        
                if(e.getDot() != e.getMark()) { // s'il ya sélection
                    jButton1.setEnabled(true); // on active le boutton pour la Copie
                    jButton3.setEnabled(true); // On active le boutton Couper
                }
                        selection = new Selectionner(monBuffer,e.getMark(),e.getDot()); 
                 try {
                     selection.execute(); // On exécute la commande de sélection
                 } catch (Exception ex) {
                     Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  selectionnee = false;
            }
        };
        
         
         
         jTextArea1.addCaretListener(caret); // On ajoute le listener du curseur au textArea
           
       
      
         jButton1.addActionListener(new ActionListener() { // Listener d'action pour le boutton Copier

            @Override
            public void actionPerformed(ActionEvent e) { // Lorsqu'on click sur le boutton Copie
                
                 copie = new Copier(monBuffer); 
                 try {
                     copie.execute(); // On exécute la commande de copie
                 } catch (Exception ex) {
                     Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 jButton2.setEnabled(true); // et on active le Boutton Coller
            }
        }); 
         
         jButton2.addActionListener(new ActionListener() { // Lorsqu'on click sur le boutton Coller

            @Override
            public void actionPerformed(ActionEvent e) {
             colle = new Coller(monBuffer);
                 try {  
                     colle.execute();// On exécute la commande de coller
                 } catch (Exception ex) {
                     Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        });
         
         jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // Lorsqu'on click sur le boutton Couper
                coupe = new Couper(monBuffer);
                  try {
                      coupe.execute(); // On exécute la commande de couper
                  } catch (Exception ex) {
                      Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  jButton2.setEnabled(true); // et on active le boutton Coller
            }
            
        });
         
         jButton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           jouer = new JouerMacro(monBuffer);
                  try {
                      jouer.execute(); // On exécute la commande de jouerMacro
                  } catch (Exception ex) {
                      Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  jButton2.setEnabled(true); // et on active le boutton Coller
            }
            
        });
                 
         button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
              button2.setEnabled(true);
               defaire = new Defaire(monBuffer);
                try {
                    defaire.execute();// On exécute la commande refaire
                } catch (Exception ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
         
         button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                refaire = new Refaire(monBuffer);
                try {
                    refaire.execute();// On exécute la commande Refaire
                } catch (Exception ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
         
         jCheckBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                AbstractButton abstractButton = (AbstractButton) ae.getSource();
                 enregistrer = new EnregistrerMacro(monBuffer);
                 stopperEnregistrement = new ArreterMacro(monBuffer);
                if(abstractButton.getModel().isSelected()){
                    try {
                        enregistrer.execute();
                    } catch (Exception ex) {
                        Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        stopperEnregistrement.execute();
                    } catch (Exception ex) {
                        Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        });
         
          
    }// </editor-fold>                        
 
   
    /**
     * @param args the command line arguments
     */
   
    
    
    // Variables declaration - do not modify                     
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
     private static vue.TexteArea jTextArea1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
   
    private java.awt.Label label1;
    // End of variables declaration                   

  /*
   * La Classe Main
   */
 public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
      
     //Pour le débogage et la gestion des execptions
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

             
        monBuffer = new Buffer("",0,0);
        new TextEditor(monBuffer).setVisible(true); // On rend visible le TexteEditor
           jTextArea1.setEditable(false); // On empêche l'utilisateur de modifier le texte, c'est le buffer qui le modifie
           jTextArea1.getCaret().setVisible(true);
           monBuffer.addObserver(jTextArea1); // On ajoute le texteArea en temps qu'observer du buffer
 }   
  
}