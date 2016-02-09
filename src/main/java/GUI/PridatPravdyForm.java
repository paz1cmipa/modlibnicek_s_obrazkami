
package GUI;

import Entity.PravdyViery;
import InterfacesMysqlobjectOther.PravdyVieryDao;
import InterfacesMysqlobjectOther.PravdyVieryDaoFactory;
import javax.swing.JOptionPane;


public class PridatPravdyForm extends javax.swing.JDialog {

     private PravdyVieryDao pravdyMySql = PravdyVieryDaoFactory.INSTANCE.getPravdyVieryDao();
    
    public PridatPravdyForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Pridať");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nazovLabel = new javax.swing.JLabel();
        nazovTextField = new javax.swing.JTextField();
        znenieLabel = new javax.swing.JLabel();
        pridatButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        znenieTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nazovLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nazovLabel.setForeground(new java.awt.Color(255, 255, 255));
        nazovLabel.setText("Názov");
        getContentPane().add(nazovLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        getContentPane().add(nazovTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 218, 30));

        znenieLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        znenieLabel.setForeground(new java.awt.Color(255, 255, 255));
        znenieLabel.setText("Znenie");
        getContentPane().add(znenieLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, -1, -1));

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        znenieTextArea.setColumns(20);
        znenieTextArea.setRows(5);
        jScrollPane1.setViewportView(znenieTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 320, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pandita\\Pictures\\vitraz_kriz_cut.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 350, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        PravdyViery pravda = new PravdyViery();
        if(nazovTextField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nie je zadaný názov", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(znenieTextArea.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nie je zadané znenie", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        pravda.setNazov(nazovTextField.getText());
        pravda.setObsah(znenieTextArea.getText());
        pravdyMySql.pridat(pravda);
        setVisible(false);
    }//GEN-LAST:event_pridatButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PridatPravdyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridatPravdyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridatPravdyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridatPravdyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PridatPravdyForm dialog = new PridatPravdyForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nazovLabel;
    private javax.swing.JTextField nazovTextField;
    private javax.swing.JButton pridatButton;
    private javax.swing.JLabel znenieLabel;
    private javax.swing.JTextArea znenieTextArea;
    // End of variables declaration//GEN-END:variables
}
