/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static mobileprocurementapplication.UpdateRequisitionOrderUI.orderNumber;

/**
 *
 * @author ShavinPC
 */
public class HandleRequisitionOrderUI extends javax.swing.JFrame {

    private static final String UserFile = "User.ser";
    private SetOfUsers<User> userList = new SetOfUsers();
    private UserService userService;
    
    private static final String RequisitionOrderFile = "RequisitionOrder.ser";
    private SetOfRequisitionOrders<RequisitionOrder> orderList = new SetOfRequisitionOrders();
    private RequisitionOrderService orderService;
    
    public static int orderNumber; 
    public static String userName;
    
    
    public HandleRequisitionOrderUI(int OrderID, String Username) {
        initComponents();
        
        userName = Username;
        orderNumber = OrderID;
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Setting the initial position of the window to center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        userService = new UserService();        
        orderService = new RequisitionOrderService();
        
        try {
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
            userList = this.userService.Deserialize(UserFile);
        } catch (IOException ex) {
            Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Initializing the table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("Cost");
        
        jTable1.setModel(model);
        
        //Retrieving the Requisition Order        
        RequisitionOrder theOrder = new RequisitionOrder();        
        
        for(RequisitionOrder order : orderList)
        {
            if(order.getOrderID() == orderNumber)
            {
                theOrder = order;
            }
        }
        
        SetOfItems<Item> itemList = new SetOfItems();
        double [] quantityList = new double[theOrder.getQuantityArraySize()];
        
        itemList = theOrder.getItems();
        quantityList = theOrder.getQuantity();
        
        for(int i=0; i<theOrder.getItemCount(); i++)
        {
            model.addRow(new Object[]{itemList.get(i).getItemID() + " " + itemList.get(i), quantityList[i], (itemList.get(i).getItemPrice() * quantityList[i])});
        }
        
        //Retrieving the Site Manager's name using his username in the order
        String ManagerName = "";
        
        for(User aUser : userList)
        {
            if(aUser.getUsername().equals(theOrder.getUsername()))
            {
                ManagerName = aUser.getUserFullName();
                break;
            }
        }
                
        lblSiteManagerName.setText(ManagerName);
        lblSiteName.setText(theOrder.getSitename());
        
        txtRequiredDate.setText(theOrder.getRequiredDate());
        txtRequiredDate.setEditable(false);
        txtSiteManagerComments.setText(theOrder.getComments());
        txtSiteManagerComments.setEditable(false);

        
        
        
        
    }

    private HandleRequisitionOrderUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblRequiredDate = new javax.swing.JLabel();
        txtRequiredDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSiteManagerComments = new javax.swing.JTextArea();
        lblSiteManagerName = new javax.swing.JLabel();
        lblSiteName = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnApprove1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblRequiredDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRequiredDate.setText("Required Date: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Site Manager's Comments:");

        txtSiteManagerComments.setColumns(20);
        txtSiteManagerComments.setRows(5);
        jScrollPane2.setViewportView(txtSiteManagerComments);

        lblSiteManagerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSiteManagerName.setText("jLabel2");

        lblSiteName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSiteName.setText("jLabel2");

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnApprove1.setText("Decline");
        btnApprove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprove1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRequiredDate)
                                .addGap(85, 85, 85)
                                .addComponent(txtRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSiteManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApprove1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSiteManagerName)
                .addGap(16, 16, 16)
                .addComponent(lblSiteName)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequiredDate)
                    .addComponent(txtRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnApprove1))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        
        //Set RequistionOrder Approval Status to Approved
        RequisitionOrder theOrder = new RequisitionOrder();
        
        try {
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(RequisitionOrder aOrder : orderList)
        {
            if(aOrder.getOrderID() == orderNumber)
            {
                theOrder = aOrder;
                
                orderList.remove(aOrder);
                
                try {
                    this.orderService.Serialize(orderList, RequisitionOrderFile);
                } catch (IOException ex) {
                    Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
        }        
        
                
        theOrder.setApproval("Approved", userName);                
        orderList.add(theOrder);
        
        try {
            this.orderService.Serialize(orderList, RequisitionOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnApprove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprove1ActionPerformed
        
        int userDecision = JOptionPane.showConfirmDialog(null, "Are you sure?");
        
        if(userDecision == 0)
        {
            //Set RequistionOrder Approval Status to Approved
            RequisitionOrder theOrder = new RequisitionOrder();

            String userInput = JOptionPane.showInputDialog("Do you have any comments for the Site Manager?", "");

            try {
                orderList = this.orderService.Deserialize(RequisitionOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(RequisitionOrder aOrder : orderList)
            {
                if(aOrder.getOrderID() == orderNumber)
                {
                    theOrder = aOrder;

                    orderList.remove(aOrder);

                    try {
                        this.orderService.Serialize(orderList, RequisitionOrderFile);
                    } catch (IOException ex) {
                        Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                }
            }        


            theOrder.setApproval("Declined", userName);         

            if(userInput.equals(""))
            {
                theOrder.setDeclinedComments("The Approver Has Not Left Any Comments");
            }
            else
            {
                theOrder.setDeclinedComments(userInput);
            }

            orderList.add(theOrder);

            try {
                this.orderService.Serialize(orderList, RequisitionOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Requisition Order Successfully Declined", null, JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnApprove1ActionPerformed

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
            java.util.logging.Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HandleRequisitionOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HandleRequisitionOrderUI().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnApprove1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRequiredDate;
    private javax.swing.JLabel lblSiteManagerName;
    private javax.swing.JLabel lblSiteName;
    private javax.swing.JTextField txtRequiredDate;
    private javax.swing.JTextArea txtSiteManagerComments;
    // End of variables declaration//GEN-END:variables
}
