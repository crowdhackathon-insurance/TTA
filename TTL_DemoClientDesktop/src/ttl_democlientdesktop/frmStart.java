package ttl_democlientdesktop;

public class frmStart extends javax.swing.JFrame {
    
    public frmStart() {
        initComponents();
        Globals.glStartForm = this ;
        Globals.glQuestionForm = new frmQuestion();
        Globals.glSettingsForm = new frmSettings() ;
        Globals.glAlarmForm = new frmAlarm() ;
        Globals.glHelpForm = new frmHelp() ;
        
        Globals.ms = new ManageSocket();
        if (Globals.ms.openSocketWithServer())
            System.out.println("Ola kala!Egine syndesi me to Server");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bSettings = new javax.swing.JButton();
        bCrush = new javax.swing.JButton();
        bHide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(352, 386));
        setMinimumSize(new java.awt.Dimension(352, 386));

        bSettings.setText("Profile Settings");
        bSettings.setToolTipText("");
        bSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSettingsMouseClicked(evt);
            }
        });

        bCrush.setText("Technical Crash");
        bCrush.setToolTipText("");
        bCrush.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCrushMouseClicked(evt);
            }
        });

        bHide.setText("Hide");
        bHide.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCrush, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHide, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bCrush, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(bHide, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(bSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void bSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSettingsMouseClicked
        Globals.glSettingsForm.setVisible(true);
        Globals.glSettingsForm.setLocation(this.getLocation());
        this.setVisible(false);       
    }//GEN-LAST:event_bSettingsMouseClicked
    
    private void bCrushMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCrushMouseClicked
        
        Globals.glQuestionForm.setVisible(true);
        Globals.glQuestionForm.setLocation(this.getLocation());
        
        this.setVisible(false);
        Globals.glQuestionForm.enableProgressBar();
        
    }//GEN-LAST:event_bCrushMouseClicked
    
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
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmStart().setVisible(true);
            }
        });
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrush;
    private javax.swing.JButton bHide;
    private javax.swing.JButton bSettings;
    // End of variables declaration//GEN-END:variables
}
