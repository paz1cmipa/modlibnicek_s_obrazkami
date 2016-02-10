
package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import InterfacesMysqlobjectOther.MysqlPribeh;
import Entity.Pribeh;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Šimon
 */
public class PridajPform extends javax.swing.JFrame {

  
    public PridajPform() {
        initComponents();
        
        this.setTitle("Pridajte príbeh");
        Image im = Toolkit.getDefaultToolkit().getImage("aa.jpg");
        this.setIconImage(im);
       
        choice.addItem("Bruno Ferrero - malé príbehy");
        choice.addItem("Z denníčka sestry Faustíny");
        choice.addItem("Zo sv. Písma");
        
         pridajButton.setEnabled(false);
         pribehArea.setVisible(false);
         this.setSize(645, 444);
            
    }
    
    public String formatuj(String neupraveny, int pocet) {

		int pocetMedz = 0;
		StringBuilder upraveny = new StringBuilder();
		char pismenko;

		for (int i = 0; i < neupraveny.length(); i++) {
			
			pismenko = neupraveny.charAt(i);

			if (pismenko == ' ') {
				pocetMedz++;
			}

			if (pocetMedz == pocet) {
				
				upraveny.append("\n");
				pocetMedz = 0;
			}else{
				
				upraveny.append(pismenko);
			}

		}

		return upraveny.toString();
	}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nazovField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pribehArea = new javax.swing.JTextArea();
        choice = new java.awt.Choice();
        pridajButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        control = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nazovField.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        nazovField.setText("Názov príbehu...");
        nazovField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazovFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nazovField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 176, 30));

        pribehArea.setColumns(20);
        pribehArea.setRows(5);
        jScrollPane1.setViewportView(pribehArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 420, 210));
        getContentPane().add(choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 100, 150, -1));

        pridajButton.setBackground(new java.awt.Color(204, 255, 255));
        pridajButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pridajButton.setText("Pridať");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Príbeh:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlActionPerformed(evt);
            }
        });
        getContentPane().add(control, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/prifajPform.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 690, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed

        
        int kategoria = 0;
        if(choice.getSelectedItem().equals("Bruno Ferrero - malé príbehy")){
            kategoria = 1;
        }
        
        if(choice.getSelectedItem().equals("Z denníčka sestry Faustíny")){
            kategoria = 2;
        }
        
        if(choice.getSelectedItem().equals("Zo sv. Písma")){
            kategoria = 3;
        }
        
        MysqlPribeh novy = new MysqlPribeh();
        Pribeh pribeh = new Pribeh(nazovField.getText(), this.formatuj(pribehArea.getText(), 14), kategoria);
        novy.pridat(pribeh);
        
         ImageIcon icon = new ImageIcon("add_folder.jpg");

          JOptionPane.showMessageDialog(
                        null,
                        "Pribeh bol úspešne pridaný.",
                        "Modlibníček info", JOptionPane.INFORMATION_MESSAGE,
                        icon);
        this.setVisible(false);
        
          
    }//GEN-LAST:event_pridajButtonActionPerformed

    private void controlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlActionPerformed

        MysqlPribeh zoznam = new MysqlPribeh();

        if(!(zoznam.contains(nazovField.getText())) && !(nazovField.getText().equals("")) && !(nazovField.getText().equals("Názov príbehu..."))){

            pridajButton.setEnabled(true);
            pribehArea.setVisible(true);
            control.setIcon(new javax.swing.ImageIcon("ch2.jpg"));

        }else{
            control.setIcon(new javax.swing.ImageIcon("jpg"));
            pridajButton.setEnabled(false);
        }

    }//GEN-LAST:event_controlActionPerformed

    private void nazovFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazovFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nazovFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(PridajPform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajPform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajPform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajPform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PridajPform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice;
    private javax.swing.JButton control;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nazovField;
    private javax.swing.JTextArea pribehArea;
    private javax.swing.JButton pridajButton;
    // End of variables declaration//GEN-END:variables
}
