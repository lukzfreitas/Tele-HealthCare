/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientWorkArea;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neelu
 */
public class BookAppointmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
            
    /**
     * Creates new form PatientJPanel
     */
    public BookAppointmentJPanel(JPanel upc, UserAccount ua, Organization o, Enterprise e) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        organization = o;
        enterprise = e;
        
        populateDoctorCombo();
                
    }
    
    private void populateDoctorCombo(){
         Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DoctorOrganization){
                org = organization;
                break;
            }
        }
        
        if(org!=null){
            for(Employee employee: org.getEmployeeDirectory().getEmployeeList()){
                doctorCombo.addItem(employee);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        doctorCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jButtonBookAppointment = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jButtonBack = new javax.swing.JButton();
        jButtonPopulateRequestTable = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Patient Welcome Area");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Book an Appointment");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Doctor Name");

        doctorCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Date");

        dateChooser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButtonBookAppointment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBookAppointment.setText("Book Appointment");
        jButtonBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookAppointmentActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Check Request Status");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Request Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        jButtonBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBack.setText("<<Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonPopulateRequestTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonPopulateRequestTable.setText("Refresh");
        jButtonPopulateRequestTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPopulateRequestTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonBookAppointment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(35, 35, 35)
                                    .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPopulateRequestTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonBack))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jButtonPopulateRequestTable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBookAppointment))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookAppointmentActionPerformed
        // TODO add your handling code here:
        
        Employee doctor = (Employee)doctorCombo.getSelectedItem();
        if(dateChooser.getDate()==null){
            JOptionPane.showMessageDialog(null,"Please enter Date!");
            return;
        }
        
       AppointmentWorkRequest request = new AppointmentWorkRequest();
        request.setMessage("Book Appointment");
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setRequestDate(dateChooser.getDate());
        request.setDoctorName(doctor.getName());
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DoctorOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        
        populateRequestTable();
    }//GEN-LAST:event_jButtonBookAppointmentActionPerformed

    private void jButtonPopulateRequestTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPopulateRequestTableActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_jButtonPopulateRequestTableActionPerformed

    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof AppointmentWorkRequest){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((AppointmentWorkRequest) request).getResult();
            row[3] = result == null ? "Waiting" : result;
            row[4] = request.getRequestDate();
            
            model.addRow(row);
        }
        }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JComboBox doctorCombo;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonBookAppointment;
    private javax.swing.JButton jButtonPopulateRequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
