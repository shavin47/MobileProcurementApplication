/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This interface is used by the site managers to add requisition orders
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class SiteManagerUI extends javax.swing.JFrame {

    private static final String UserFile = "User.ser";
    private SetOfUsers<User> userList = new SetOfUsers();
    private UserService userService;  
    
    private static final String ItemFile = "Item.ser";
    private SetOfItems<Item> itemList = new SetOfItems();
    private ItemService itemService;  
    
    private static final String SiteFile = "Site.ser";
    private SetOfSites<Site> siteList = new SetOfSites();
    private SiteService siteService;
    
    private static final String RequisitionOrderFile = "RequisitionOrder.ser";
    private SetOfRequisitionOrders<RequisitionOrder> orderList = new SetOfRequisitionOrders();
    private RequisitionOrderService orderService;    
    
    
    private static String Username = "";
    private static String SiteName = "";   
    
    public SiteManagerUI(String UserName) {
        initComponents();
               
        //Setting window to center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        userService = new UserService();
        itemService = new ItemService();
        orderService = new RequisitionOrderService();
        siteService = new SiteService();
        
        //Deserializing
        
        try {
            userList = this.userService.Deserialize(UserFile);
            itemList = this.itemService.Deserialize(ItemFile);
            siteList = this.siteService.Deserialize(SiteFile);
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
            
        } catch (IOException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Creating a jTable model       
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("Cost");
        
        jTable1.setModel(model);
        
        //Creating jTable2 model
        
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Order ID");
        model1.addColumn("Number of Items Ordered");
        model1.addColumn("Total Price of Items");
        model1.addColumn("Required Date");
        model1.addColumn("Status of Approval");
        
        jTable2.setModel(model1);
        
        
        //Setting the username and sitename
        Username = UserName;
        
        //Temp variable to see if user has a site 
        boolean found = false;
                
        for(Site site : siteList)
        {
            if(site.getSiteManagersUsername().equals(Username))
            {
                SiteName = site.getSiteName();
                found = true;
                break;
            }
            else
            {
                found = false;                
            }
            
            
        }      
        
        if(found == false)
        {
            SiteName = "";

            //disabling the components because the sitemanager doesnt have a site
            Component[] list1 = PlaceRequisitionOrderPanel.getComponents();
            Component[] list2 = SearchRequisitionOrderPanel.getComponents();

            for(int i = 0; i < list1.length; i++ )
            {
                list1[i].setEnabled(false);
            }

            for(int i=0; i < list2.length; i++)
            {
                list2[i].setEnabled(false);
            }

            JOptionPane.showMessageDialog(null, "You are not assigned to a Site, please register your site with the system to continue");

        }
        
        jDateRequired.setDateFormatString("dd/MM/yyyy");
        jDateSet.setDateFormatString("dd/MM/yyyy");
        
        //Setting todays date to the date chooser
        Date today = new Date();
        jDateRequired.setDate(today);
        jDateSet.setDate(today);
    }

    private SiteManagerUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void reset()
    {        
        
        cmbItems.setSelectedIndex(0);
        txtQuantity.setText("");    
        
        Date today = new Date();
        jDateRequired.setDate(today);
        
        txtComments.setText("");        
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        PlaceRequisitionOrderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnViewItems = new javax.swing.JButton();
        cmbItems = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        btnPlaceOrder = new javax.swing.JButton();
        btnCheckTotal = new javax.swing.JButton();
        jDateRequired = new com.toedter.calendar.JDateChooser();
        SearchRequisitionOrderPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnViewOrders = new javax.swing.JButton();
        btnViewOrderInDetail = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        btnViewAllOrders = new javax.swing.JButton();
        jDateSet = new com.toedter.calendar.JDateChooser();
        LogoutPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Place Requisition Order");

        btnViewItems.setText("View All Items");
        btnViewItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewItemsActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Quantity");

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnDeleteItem.setText("Delete Item");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

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

        jLabel3.setText("When are these Items Required?");

        jLabel4.setText("Additional Comments");

        txtComments.setColumns(20);
        txtComments.setLineWrap(true);
        txtComments.setRows(5);
        jScrollPane2.setViewportView(txtComments);

        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        btnCheckTotal.setText("Check Total");
        btnCheckTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlaceRequisitionOrderPanelLayout = new javax.swing.GroupLayout(PlaceRequisitionOrderPanel);
        PlaceRequisitionOrderPanel.setLayout(PlaceRequisitionOrderPanelLayout);
        PlaceRequisitionOrderPanelLayout.setHorizontalGroup(
            PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                        .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                .addComponent(btnViewItems)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCheckTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPlaceOrder)
                                        .addGap(43, 43, 43))
                                    .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                            .addComponent(jDateRequired, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(33, 33, 33))))
        );
        PlaceRequisitionOrderPanelLayout.setVerticalGroup(
            PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewItems)
                    .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem)
                    .addComponent(btnDeleteItem)
                    .addComponent(btnCheckTotal))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateRequired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PlaceRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaceRequisitionOrderPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlaceOrder))
                    .addComponent(jLabel4))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Place Order", PlaceRequisitionOrderPanel);

        jLabel7.setText("Please select the date you set the order:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        btnViewOrders.setText("View Order(s)");
        btnViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrdersActionPerformed(evt);
            }
        });

        btnViewOrderInDetail.setText("View in Detail");
        btnViewOrderInDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderInDetailActionPerformed(evt);
            }
        });

        btnDeleteOrder.setText("Delete Order");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        btnViewAllOrders.setText("View All Orders");
        btnViewAllOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllOrdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchRequisitionOrderPanelLayout = new javax.swing.GroupLayout(SearchRequisitionOrderPanel);
        SearchRequisitionOrderPanel.setLayout(SearchRequisitionOrderPanelLayout);
        SearchRequisitionOrderPanelLayout.setHorizontalGroup(
            SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRequisitionOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchRequisitionOrderPanelLayout.createSequentialGroup()
                        .addGroup(SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(SearchRequisitionOrderPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateSet, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchRequisitionOrderPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnViewOrders)
                        .addGap(53, 53, 53))))
            .addGroup(SearchRequisitionOrderPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnViewAllOrders)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteOrder)
                .addGap(18, 18, 18)
                .addComponent(btnViewOrderInDetail)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SearchRequisitionOrderPanelLayout.setVerticalGroup(
            SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRequisitionOrderPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewOrders)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SearchRequisitionOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteOrder)
                    .addComponent(btnViewAllOrders)
                    .addComponent(btnViewOrderInDetail))
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Search Orders", SearchRequisitionOrderPanel);

        jLabel5.setText("System Developed By: Shavin/Ismail/Shivaram/Abhiramy");

        jLabel6.setText("Contact:                          0771870683/Sri Lanka");

        btnLogin.setText("Logout");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogoutPanelLayout = new javax.swing.GroupLayout(LogoutPanel);
        LogoutPanel.setLayout(LogoutPanelLayout);
        LogoutPanelLayout.setHorizontalGroup(
            LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutPanelLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap())
            .addGroup(LogoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogoutPanelLayout.setVerticalGroup(
            LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Logout", LogoutPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnViewItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewItemsActionPerformed
       
        cmbItems.removeAllItems();
        
        //Deserializing itemlist
        try {
            itemList = this.itemService.Deserialize(ItemFile);
        } catch (IOException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //adding the item to the combo box        
        for(Item item : itemList)
        {
            cmbItems.addItem(item.getItemID() + " " + item.getItemName() + " (" + item.getItemType() + ") " + "Price = " + item.getItemPrice());
        }
        
        
    }//GEN-LAST:event_btnViewItemsActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
       
        //Adding items to jTable1
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        if(cmbItems.getSelectedIndex() == -1) 
        {
            JOptionPane.showMessageDialog(null, "Please select an item to add to order");
        }
        else if(txtQuantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter item quantity");
        }
        else
        {                 
            String cmbItem = cmbItems.getSelectedItem().toString();
            
            double Cost = Double.parseDouble(cmbItem.substring(cmbItem.indexOf('=') + 1)) * Double.parseDouble(txtQuantity.getText());
            
            model.addRow(new Object[]{cmbItems.getSelectedItem(), txtQuantity.getText(), Cost});        
        }
        
       
        
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        //Deleting an item from order
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        if(jTable1.getSelectedRow() == -1)
        {
            if(jTable1.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select a product");
            }
        }
        else
        {
            model.removeRow(jTable1.getSelectedRow());            
        }
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnCheckTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTotalActionPerformed
        //Checking the total of all items
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        double total = 0;
        int nRow = jTable1.getRowCount(), nCol = jTable1.getColumnCount();
        
        if(jTable1.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No orders placed");
        }
        else
        {
                for(int i=0; i<nRow; i++)
                {
                    total = total + Double.parseDouble(jTable1.getValueAt(i, 2).toString());
                }
                
                JOptionPane.showMessageDialog(null, "Total Price of Items = " + total);
        }
        
    }//GEN-LAST:event_btnCheckTotalActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        //Place Requisition Order        
                
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int nRow = jTable1.getRowCount(), nCol = jTable1.getColumnCount();
        
        SetOfItems<Item> tempItemList = new SetOfItems();
        double [] quantityList = new double[nRow];
        
        //Validations
        
        if(nRow == 0)
        {
            JOptionPane.showMessageDialog(null, "No items have been placed in the order");
        }        
        else
        {
            //getting itemID from the jTable and adding it to the item list array
            for(int i=0; i<nRow; i++)
            {                
                int tempItemID = Integer.parseInt(jTable1.getValueAt(i, 0).toString().substring(0, jTable1.getValueAt(i, 0).toString().indexOf(" ")));
                tempItemList.add(this.itemService.getThisItem(tempItemID, itemList));                
            }
            
            //getting the quantity from the jtable and adding it to the quantity list array
            for(int i=0; i<nRow; i++)
            {
                quantityList[i] = Double.parseDouble(jTable1.getValueAt(i, 1).toString());
            }
            
            String DateToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            double totalPriceOfItems = 0;
            
            //Iterating through the table to get the total price of all the items from the jTable
            for(int i=0; i<nRow; i++)
            {
                    totalPriceOfItems = totalPriceOfItems + Double.parseDouble(jTable1.getValueAt(i, 2).toString());
            }
            
            //Setting the dateformat of the jDateChooser
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                       
            RequisitionOrder newOrder = new RequisitionOrder(tempItemList, quantityList, totalPriceOfItems, DateToday, sdf.format(jDateRequired.getDate()), txtComments.getText(), Username, SiteName);
            
                        
            try {
                this.orderService.addOrder(newOrder, orderList);
                JOptionPane.showMessageDialog(null, "Order placed successfully.");
                reset();
            } catch (IOException ex) {
                Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
            }            
            
        }
        
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginUI lui = new LoginUI();
        lui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrdersActionPerformed
        
        
        //Temp variable to check if entries exist in file
        boolean found = false;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        int rows = model.getRowCount();

        //Clearing jTable2
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }

        //Deserializing

        try {                      
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(RequisitionOrder order : orderList)
        {
            //Setting the dateformat of the jDateChooser
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            
            if(order.getPlacedDate().equals(sdf.format(jDateSet.getDate())) && order.getUsername().equals(Username))
            {
                model.addRow(new Object[]{order.getOrderID(), order.getItemCount(), order.getTotalPriceOfItems(), order.getRequiredDate(), order.getStatusOfApproval()});
                found = true;
            }
        }

        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "There were no orders placed on this date");
        }
        
    }//GEN-LAST:event_btnViewOrdersActionPerformed

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        if(jTable2.getSelectedRow() == -1)
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select an order to delete");
            }
        }
        else
        {
            int SelectedRow = jTable2.getSelectedRow();        
            int OrderID = (int) model.getValueAt(SelectedRow, 0);

            //deserializing
            try {
                orderList = this.orderService.Deserialize(RequisitionOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            //verifying delete
            int x = JOptionPane.showConfirmDialog(null, "Are you sure?");
            
            if(x == 0)
            {
                for(RequisitionOrder order : orderList)
                {
                    if(order.getOrderID() == OrderID)
                    {
                        try {
                            this.orderService.removeOrder(order, orderList);
                            model.removeRow(SelectedRow);
                            break;

                        } catch (IOException ex) {
                            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ConcurrentModificationException ex) {
                            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }           
        } 
        
        
        
        
        
        
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void btnViewAllOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllOrdersActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        int row = model.getRowCount();
        
        int rows = model.getRowCount();
        
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        //Deserializing
        try {          
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean found = false;
        
        for(RequisitionOrder order : orderList)
        {
            if(order.getUsername().equals(Username))
            {
                model.addRow(new Object[]{order.getOrderID(), order.getItemCount(), order.getTotalPriceOfItems(), order.getRequiredDate(), order.getStatusOfApproval()});
                found = true;
            }            
        }        
        
        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "You Have Not Placed Any Orders", null, JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnViewAllOrdersActionPerformed

    private void btnViewOrderInDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderInDetailActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        if(jTable2.getSelectedRow() == -1)
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select an order to view");
            }
        }
        else
        {
            int SelectedRow = jTable2.getSelectedRow();        
            int OrderID = (int) model.getValueAt(SelectedRow, 0);
            
            if(jTable2.getValueAt(SelectedRow, 4).equals("Pending"))
            {
                UpdateRequisitionOrderUI uroui = new UpdateRequisitionOrderUI(OrderID, Username, SiteName);
                this.dispose();
                uroui.setVisible(true);
            }
            else if(jTable2.getValueAt(SelectedRow, 4).equals("Approved") || jTable2.getValueAt(SelectedRow, 4).equals("Placed"))
            {
                RequisitionOrder order = new RequisitionOrder();
                
                try {
                    orderList = this.orderService.Deserialize(RequisitionOrderFile);
                } catch (IOException ex) {
                    Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for(RequisitionOrder aOrder : orderList)
                {
                    if(aOrder.getOrderID() == OrderID)
                    {
                        order = aOrder;
                        break;
                    }
                }
                
                if(jTable2.getValueAt(SelectedRow, 4).equals("Approved"))
                {
                    JOptionPane.showMessageDialog(null, "Your Order Has Been Approved. Order Approved By " + order.getApprover());                
                }
                else if(jTable2.getValueAt(SelectedRow, 4).equals("Placed"))
                {
                    JOptionPane.showMessageDialog(null, "Your Order Has Been Sent To The Supplier For Delivery. Order Approved By " + order.getApprover());
                }
                
            }
            else if(jTable2.getValueAt(SelectedRow, 4).equals("Declined"))
            {
                RequisitionOrder order = new RequisitionOrder();
                
                try {
                    orderList = this.orderService.Deserialize(RequisitionOrderFile);
                } catch (IOException ex) {
                    Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for(RequisitionOrder aOrder : orderList)
                {
                    if(aOrder.getOrderID() == OrderID)
                    {
                        order = aOrder;
                        break;
                    }
                }
                
                JOptionPane.showMessageDialog(null, order.getDeclinedComments() + " // Order Handled By " + order.getApprover());
            }
            
        }
        
            
        
        
        
        
        
                
    }//GEN-LAST:event_btnViewOrderInDetailActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SiteManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiteManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiteManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiteManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SiteManagerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogoutPanel;
    private javax.swing.JPanel PlaceRequisitionOrderPanel;
    private javax.swing.JPanel SearchRequisitionOrderPanel;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCheckTotal;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnViewAllOrders;
    private javax.swing.JButton btnViewItems;
    private javax.swing.JButton btnViewOrderInDetail;
    private javax.swing.JButton btnViewOrders;
    private javax.swing.JComboBox cmbItems;
    private com.toedter.calendar.JDateChooser jDateRequired;
    private com.toedter.calendar.JDateChooser jDateSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea txtComments;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
