/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import Entity.Modlitba;
import InterfacesMysqlobjectOther.MysqlModlitba;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Šimon
 */
public class PridajMform extends javax.swing.JFrame {

    /**
     * Creates new form PridajMform
     */
    public PridajMform() {
        initComponents();
        this.setSize(480,387);
        Image im = Toolkit.getDefaultToolkit().getImage("aa.jpg");
        this.setIconImage(im);
        PridajButton.setEnabled(false);
        TextArea.setVisible(false);
        
        
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        PridajButton = new javax.swing.JButton();
        control = new javax.swing.JButton();
        pozadie = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TextField);
        TextField.setBounds(160, 30, 153, 20);

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 359, 169);

        Label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label1.setForeground(new java.awt.Color(255, 255, 255));
        Label1.setText("Názov modlitby");
        getContentPane().add(Label1);
        Label1.setBounds(30, 30, 126, 20);

        Label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label2.setForeground(new java.awt.Color(255, 255, 255));
        Label2.setText("Text modlitby");
        getContentPane().add(Label2);
        Label2.setBounds(30, 80, 130, 17);

        PridajButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PridajButton.setText("Pridať");
        PridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PridajButton);
        PridajButton.setBounds(350, 290, 88, 25);

        control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlActionPerformed(evt);
            }
        });
        getContentPane().add(control);
        control.setBounds(330, 20, 60, 50);

        pozadie.setIcon(new javax.swing.ImageIcon("C:\\Users\\MojaAplikacia\\pm3.jpg")); // NOI18N
        getContentPane().add(pozadie);
        pozadie.setBounds(0, 0, 460, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldActionPerformed
     
        
    }//GEN-LAST:event_TextFieldActionPerformed

    private void PridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridajButtonActionPerformed
        
      MysqlModlitba mysql = new MysqlModlitba();
      
		Modlitba modlitba = new Modlitba(null, TextField.getText(), TextArea.getText());

		mysql.pridat(modlitba);

		MysqlModlitba zoznam = new MysqlModlitba();
		zoznam.dajVsetky();

		ImageIcon icon = new ImageIcon("add_folder.jpg");

		JOptionPane.showMessageDialog(null, "Modlitba bola úspešne pridaná.", "Modlibníček info",
				JOptionPane.INFORMATION_MESSAGE, icon);

		this.setVisible(false);
        
    }//GEN-LAST:event_PridajButtonActionPerformed

    private void controlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlActionPerformed

        MysqlModlitba zoznam = new MysqlModlitba();
               
      
      if(!(zoznam.contains(TextField.getText())) && !(TextField.getText().equals(""))){
         
          PridajButton.setEnabled(true);
          TextArea.setVisible(true);
          control.setIcon(new javax.swing.ImageIcon("ch2.jpg"));
         
      }else{
          control.setIcon(new javax.swing.ImageIcon("ch1.jpg"));
          PridajButton.setEnabled(false);
      }
  
    }//GEN-LAST:event_controlActionPerformed

   
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
            java.util.logging.Logger.getLogger(PridajMform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajMform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajMform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajMform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PridajMform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JButton PridajButton;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JTextField TextField;
    private javax.swing.JButton control;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pozadie;
    // End of variables declaration//GEN-END:variables
}
