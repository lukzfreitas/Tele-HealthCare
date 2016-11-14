package userinterface.PatientWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CreateProfileJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Organization organization;

    /**
     * Creates new form CreateProfileJPanel
     */

    public CreateProfileJPanel(JPanel upc, UserAccount ua, Organization o, Enterprise e) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        organization = o;
        enterprise = e;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        skypeTxt = new javax.swing.JTextField();
        jButtonBack = new javax.swing.JButton();
        jButtonUpdateProfile = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Update Patient Profile");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Age");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 204, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Email-ID");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 276, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Enter Skype ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 359, -1, -1));

        ageTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(ageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 204, 200, -1));

        emailTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 275, 200, -1));

        skypeTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(skypeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 358, 200, -1));

        jButtonBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBack.setText("<<Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 632, -1, -1));

        jButtonUpdateProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdateProfile.setText("Update Profile");
        jButtonUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateProfileActionPerformed(evt);
            }
        });
        add(jButtonUpdateProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 485, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateProfileActionPerformed

        int age;
        try{
            age=Integer.parseInt(ageTxt.getText());
            
            userAccount.getEmployee().setAge(Integer.parseInt(ageTxt.getText()));
            if(emailTxt.getText().trim().isEmpty() || skypeTxt.getText().trim().isEmpty()){
                 JOptionPane.showMessageDialog(null,"Email or Skype Id missing!");
                 return;
            }
            
        userAccount.getEmployee().setEmail(emailTxt.getText());
        userAccount.getEmployee().setSkypeId(skypeTxt.getText());
        
        JOptionPane.showMessageDialog(null,"Patient Profile Successfully Updated!");
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please enter a valid Number!");
            return;
        }
    }//GEN-LAST:event_jButtonUpdateProfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonUpdateProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField skypeTxt;
    // End of variables declaration//GEN-END:variables
}
