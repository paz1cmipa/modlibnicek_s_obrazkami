/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.Citat;
import Entity.Modlitba;
import Entity.PravdyViery;
import InterfacesMysqlobjectOther.MysqlCitat;
import InterfacesMysqlobjectOther.MysqlModlitba;
import InterfacesMysqlobjectOther.MysqlPribeh;
import Entity.Pribeh;
import InterfacesMysqlobjectOther.PravdyVieryDao;
import InterfacesMysqlobjectOther.PravdyVieryDaoFactory;
import javax.swing.JOptionPane;


public class upravitForm extends javax.swing.JFrame {

    private PravdyVieryDao pravdyMySql = PravdyVieryDaoFactory.INSTANCE.getPravdyVieryDao();
    
    private int vyber = 0;
    
    private Modlitba mM=null;
    private Pribeh mP=null;
    private Citat mC=null;
    private PravdyViery pravda = null;
    
    public upravitForm() {
        initComponents();
        
    }

    upravitForm(String selectedItem, Point location) {
                initComponents();
                
                this.setSize(420, 420);
                choice1.setVisible(false);
                this.setLocationRelativeTo(null);
                this.setTitle("Upraviť");
                Image im = Toolkit.getDefaultToolkit().getImage("aa.jpg");
                this.setIconImage(im);
                
                if(selectedItem.equals("Modlitby")){
                    
                    MysqlModlitba zoznam = new MysqlModlitba();
                    ListUprava.setListData(zoznam.dajVsetky().toArray());
                    coUpravujem.setText("Modlitby");
                    vyber = 1;
                    
                    
                }
                
                 if(selectedItem.equals("Príbehy")){
                    
                     MysqlPribeh zoznam = new MysqlPribeh();
                     ListUprava.setListData(zoznam.dajVsetky().toArray());
                     coUpravujem.setText("Príbehy");
                     vyber = 2;
                     
                     choice1.setVisible(true);
                     choice1.addItem("Bruno Ferrero - malé príbehy");
                     choice1.addItem("Z denníčka sestry Faustíny");
                     choice1.addItem("Zo sv. Písma");
                }
                 
                  if(selectedItem.equals("Citáty")){
                    
                     MysqlCitat zoznam = new MysqlCitat();
                     ListUprava.setListData(zoznam.dajVsetky().toArray());
                     coUpravujem.setText("Citáty");
                     vyber = 3;
                     
                     choice1.setVisible(true);
                     choice1.addItem("Z Biblie");
                     choice1.addItem("Citáty svätcov");
                }
                  
                  if(selectedItem.equals("Pravdy Viery")){
                      ListUprava.setListData(pravdyMySql.dajVsetky().toArray());
                      coUpravujem.setText("Pravdy Viery");
                      vyber = 4;
                      
                  }
        
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListUprava = new javax.swing.JList();
        coUpravujem = new javax.swing.JLabel();
        upravButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        change2 = new javax.swing.JTextArea();
        change1 = new javax.swing.JTextField();
        ulozButton = new javax.swing.JButton();
        zrusButton = new javax.swing.JButton();
        choice1 = new java.awt.Choice();
        binButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListUprava.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListUprava);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 62, 335, 220));

        coUpravujem.setFont(new java.awt.Font("AR CARTER", 1, 36)); // NOI18N
        coUpravujem.setText("upraviť");
        getContentPane().add(coUpravujem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        upravButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upravButton.setText("Upraviť");
        upravButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upravButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        change2.setColumns(20);
        change2.setRows(5);
        jScrollPane2.setViewportView(change2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 87, 296, 200));
        getContentPane().add(change1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 52, 149, -1));

        ulozButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ulozButton.setText("Uložiť");
        ulozButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ulozButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, -1, -1));

        zrusButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zrusButton.setText("Zrušiť");
        zrusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zrusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, -1));
        getContentPane().add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 52, 124, -1));

        binButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pandita\\Documents\\NetBeansProjects\\modlibnicek\\bin1.jpg")); // NOI18N
        binButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                binButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                binButtonMouseExited(evt);
            }
        });
        binButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binButtonActionPerformed(evt);
            }
        });
        getContentPane().add(binButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 60, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MojaAplikacia\\editing.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 830, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upravButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravButtonActionPerformed
            
        if(ListUprava.getSelectedValue() == null){
            return;
        }
        
        ListUprava.setEnabled(false);
        upravButton.setEnabled(false);
        binButton.setEnabled(false);
        this.setSize(790, 420);
        
        
        if(vyber == 1){
         Modlitba mod = (Modlitba) ListUprava.getSelectedValue();
             change1.setText(mod.getNazov());
             change2.setText(mod.getText());
             
            mM= mod;
             
        }
       
        if(vyber == 2){
        Pribeh pribeh = (Pribeh) ListUprava.getSelectedValue();
          change1.setText(pribeh.getNazov());
          change2.setText(pribeh.getText());
          
          mP= pribeh;
          
        }
        
        if(vyber == 3){
        Citat citat = (Citat) ListUprava.getSelectedValue();
          change1.setText(citat.getAutor());
          change2.setText(citat.getZnenie());
          
         mC= citat;
          
        }
        
        if(vyber == 4){
            pravda = (PravdyViery) ListUprava.getSelectedValue();
            change1.setText(pravda.getNazov());
            change2.setText(pravda.getObsah());
        }
    }//GEN-LAST:event_upravButtonActionPerformed

    private void ulozButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozButtonActionPerformed

                if (vyber == 1) {
			Modlitba mod = new Modlitba(null, change1.getText(), change2.getText());

			MysqlModlitba zoznam = new MysqlModlitba();

			zoznam.odstranit(mM);
			zoznam.pridat(mod);

		}

		if (vyber == 2) {
			int kat = 0;

			if (choice1.getSelectedItem().equals("Bruno Ferrero - malé príbehy")) {
				kat = 1;
			}

			if (choice1.getSelectedItem().equals("Z denníčka sestry Faustíny")) {
				kat = 2;
			}

			if (choice1.getSelectedItem().equals("Zo sv. Písma")) {
				kat = 3;
			}

			Pribeh pribeh = new Pribeh(change1.getText(), change2.getText(), kat);
			MysqlPribeh p = new MysqlPribeh();
			p.odstranit(mP);
			p.pridat(pribeh);

		}

		if (vyber == 3) {
			Citat cit = null;
			if (choice1.getSelectedItem().equals("Z Biblie")) {
				cit = new Citat(null, change2.getText(), change1.getText(), true);
			}
			if (choice1.getSelectedItem().equals("Citáty svätcov")) {
				cit = new Citat(null, change2.getText(), change1.getText(), false);

			}

			MysqlCitat c = new MysqlCitat();
			c.pridat(cit);
			c.odstranit(mC);
		}
                if(vyber == 4){
                     if(change1.getText().trim().isEmpty()){
                       JOptionPane.showMessageDialog(this, "Nie je zadaný názov", "Chyba", JOptionPane.ERROR_MESSAGE);
                       return;
                      }
                     if(change2.getText().trim().isEmpty()){
                          JOptionPane.showMessageDialog(this, "Nie je zadané znenie", "Chyba", JOptionPane.ERROR_MESSAGE);
                            return;
                          }
                    pravda.setNazov(change1.getText());
                    pravda.setObsah(change2.getText());
                    pravdyMySql.upravit(pravda);
                          
                }
		this.setVisible(false);
    }//GEN-LAST:event_ulozButtonActionPerformed

    private void zrusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusButtonActionPerformed
            
        this.setVisible(false);

    }//GEN-LAST:event_zrusButtonActionPerformed

    private void binButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binButtonActionPerformed
            
      
        if(vyber == 1){
           
          MysqlModlitba m = new MysqlModlitba();
          Modlitba mod = (Modlitba) ListUprava.getSelectedValue();
          m.odstranit(mod);
          ListUprava.setListData(m.dajVsetky().toArray());

        }        
        
        
        if(vyber == 2){
           
          MysqlPribeh p = new MysqlPribeh();
          Pribeh pribeh = (Pribeh) ListUprava.getSelectedValue();
          p.odstranit(pribeh);
          ListUprava.setListData(p.dajVsetky().toArray());

        }

        if(vyber == 3){
           
          MysqlCitat c = new MysqlCitat();
          Citat cit = (Citat) ListUprava.getSelectedValue();
          c.odstranit(cit);
          ListUprava.setListData(c.dajVsetky().toArray());

        }
        if(vyber == 4){
            pravda = (PravdyViery) ListUprava.getSelectedValue();
            pravdyMySql.odstranit(pravda);
            ListUprava.setListData(pravdyMySql.dajVsetky().toArray());
        }

    }//GEN-LAST:event_binButtonActionPerformed

    private void binButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binButtonMouseEntered

        if(!(ListUprava.isSelectionEmpty())){
        
        binButton.setIcon(new javax.swing.ImageIcon("bin2.jpg"));

        }
        
    }//GEN-LAST:event_binButtonMouseEntered

    private void binButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binButtonMouseClicked
    }//GEN-LAST:event_binButtonMouseClicked

    private void binButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binButtonMouseExited
        
     binButton.setIcon(new javax.swing.ImageIcon("bin1.jpg"));

    }//GEN-LAST:event_binButtonMouseExited

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
            java.util.logging.Logger.getLogger(upravitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(upravitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(upravitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(upravitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new upravitForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListUprava;
    private javax.swing.JButton binButton;
    private javax.swing.JTextField change1;
    private javax.swing.JTextArea change2;
    private java.awt.Choice choice1;
    private javax.swing.JLabel coUpravujem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ulozButton;
    private javax.swing.JButton upravButton;
    private javax.swing.JButton zrusButton;
    // End of variables declaration//GEN-END:variables
}
