package ttl_democlientdesktop;

import java.util.Timer;
import java.util.TimerTask;

public class frmQuestion extends javax.swing.JFrame {
    public frmQuestion() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bHelp = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        pbProgress = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Popup Question");
        setMaximumSize(new java.awt.Dimension(352, 386));
        setMinimumSize(new java.awt.Dimension(352, 386));
        setPreferredSize(new java.awt.Dimension(352, 386));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Χρειάζεστε βοήθεια;");

        bHelp.setText("Help");
        bHelp.setToolTipText("");
        bHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bHelpMouseClicked(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelMouseClicked(evt);
            }
        });

        pbProgress.setForeground(new java.awt.Color(204, 0, 0));
        pbProgress.setMaximum(10);
        pbProgress.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pbProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pbProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void bCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelMouseClicked
        cancel() ;
    }//GEN-LAST:event_bCancelMouseClicked
    
    private void bHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHelpMouseClicked
        
        goToAlarm() ;
    }//GEN-LAST:event_bHelpMouseClicked
    
    
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
            java.util.logging.Logger.getLogger(frmQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuestion().setVisible(true);
            }
        });
    }
    
    private void goToAlarm()
    {
        Globals.glQuestionForm.setVisible(false);
        Globals.glAlarmForm.setVisible(true);
        Globals.glAlarmForm.setLocation(Globals.glQuestionForm.getLocation());
        Globals.ms.sendMessage(Globals.getSocketMessage()) ;
        disableProgressBar();
        Globals.glAlarmForm.startSendBIOMetrics() ;
    }
    private void cancel()
    {
        this.setVisible(false);
        Globals.glStartForm.setVisible(true);
        Globals.glStartForm.setLocation(this.getLocation());
        
        
        disableProgressBar();
    }
    public void enableProgressBar()
    {
        pbProgress.setValue(0);
        Globals.timer = new Timer() ;
        Globals.timer.schedule(new RemindTask(), 0,1000);
    }
    public void disableProgressBar()
    {
        Globals.timer.purge() ;
        Globals.timer.cancel();
        pbProgress.setValue(0);
    }
    class RemindTask extends TimerTask {
        @Override
        public void run() {
            if (pbProgress.getValue()<pbProgress.getMaximum())
                pbProgress.setValue(pbProgress.getValue()+1);
            else
            {
                goToAlarm() ;
            }
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar pbProgress;
    // End of variables declaration//GEN-END:variables
}
