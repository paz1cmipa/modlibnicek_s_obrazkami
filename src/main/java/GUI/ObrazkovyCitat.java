
package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

/**
 *
 * @author Šimon
 */
public class ObrazkovyCitat extends javax.swing.JFrame {

    
    
    
    List<String> cesty = new ArrayList<>();
    
   
    
 
    public ObrazkovyCitat() {
        initComponents();
        
        File adresar = new File("C:\\Users\\Obrazkové citáty");
        int pocet = this.spocitajObrazky(adresar);
        System.out.println(pocet);
        //System.out.println(cesty.toArray().toString());
       
        
       
        this.setTitle("Obrazkový Citát");
        Image im = Toolkit.getDefaultToolkit().getImage("aa.jpg");
        this.setIconImage(im);
        this.setSize(1200, 900);
        getContentPane().setBackground(new Color(54, 58, 55));
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        
        pozadieL.setIcon(new javax.swing.ImageIcon(cesty.get( (int)(Math.random()*cesty.size()-1))));

        pozadieL.setHorizontalAlignment(SwingConstants.CENTER);
        
        
    }

    public int spocitajObrazky(File adresar){
        
        int pocet=0;
        
        for(File f: adresar.listFiles()){    
           
            cesty.add(f.getAbsolutePath());
        }
        return pocet;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pozadieL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pozadieL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pozadieL, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ObrazkovyCitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObrazkovyCitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObrazkovyCitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObrazkovyCitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObrazkovyCitat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel pozadieL;
    // End of variables declaration//GEN-END:variables
}
