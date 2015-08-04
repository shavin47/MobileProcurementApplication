/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class MainUI extends javax.swing.JFrame {

    private static final String ItemFile = "Item.ser";
    private SetOfItems<Item> itemList = new SetOfItems();
    private ItemService itemService;  
    
    private static final String SupplierFile = "Supplier.ser";
    private SetOfSuppliers<Supplier> supplierList = new SetOfSuppliers();
    private SupplierService supplierService;
        
    private static final String UserFile = "User.ser";
    private SetOfUsers<User> userList = new SetOfUsers();
    private UserService userService;
    
    private static final String SiteFile = "Site.ser";
    private SetOfSites<Site> siteList = new SetOfSites();
    private SiteService siteService;
    
    private static final String RequisitionOrderFile = "RequisitionOrder.ser";
    private SetOfRequisitionOrders<RequisitionOrder> orderList = new SetOfRequisitionOrders();
    private RequisitionOrderService orderService;
    
    private static final String PurchaseOrderFile = "PurchaseOrder.ser";
    private SetOfPurchaseOrders<PurchaseOrder> purchaseOrderList = new SetOfPurchaseOrders();
    private PurchaseOrderService purchaseOrderService;
    
    private static String Username = "";
    
    public MainUI(String UserName) {
        initComponents();
        
        //Setting the username
        Username = UserName;
        
        //Setting the initial position of the window to center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        itemService = new ItemService();
        supplierService = new SupplierService();        
        userService = new UserService();
        siteService = new SiteService();
        orderService = new RequisitionOrderService();
        purchaseOrderService = new PurchaseOrderService();
        
        try {            
            itemList = this.itemService.Deserialize(ItemFile);
            supplierList = this.supplierService.Deserialize(SupplierFile);            
            userList = this.userService.Deserialize(UserFile);
            siteList = this.siteService.Deserialize(SiteFile);
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
            purchaseOrderList = this.purchaseOrderService.Deserialize(PurchaseOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        //Creating a jTable model       
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ItemID");
        model.addColumn("Item Name");
        model.addColumn("Item Type");
        model.addColumn("Item Price");
        
        jTable1.setModel(model);        
        
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("User ID");
        model1.addColumn("Full Name");
        model1.addColumn("Telephone Number");
        model1.addColumn("Username");
        model1.addColumn("User Type");
        
        jTable2.setModel(model1);
        
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Order ID");
        model2.addColumn("Number of Items Ordered");
        model2.addColumn("Total Price of Items");
        model2.addColumn("Site Manager");
        model2.addColumn("Site Name");
        model2.addColumn("Required Date");
        
        jTable3.setModel(model2);
        
        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("Purchase Order Ref");
        model3.addColumn("Total Price");
        model3.addColumn("Required Date");        
        model3.addColumn("Comments");        
        model3.addColumn("Approved By");
        model3.addColumn("Approved Date");
        model3.addColumn("Site Name");
        
        jTable4.setModel(model3);
                
        //Setting todays date to the date chooser
        Date today = new Date();
        jDateCheckOrders.setDate(today);
        
        //Populating jtable4 with approved orders waiting to be placed        
        for(PurchaseOrder order : purchaseOrderList)
        {
            if(order.getApprovalStatus().equals("Approved"))
            {
                model3.addRow(new Object[]{order.getPurchaseOrderID(), order.getTotalPriceOfItems(), order.getRequiredDate(), order.getComments(), order.getApprovedBy(), order.getApprovedDate(), order.getSiteName()});
            }
        }
                
        
    }

    private MainUI() {
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

        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ItemPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchItemName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSearchItemType = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        SupplierPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        txtTelephoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAddSupplier = new javax.swing.JButton();
        btnResetSupplier = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnViewAllSuppliers = new javax.swing.JButton();
        cmbAllSuppliers = new javax.swing.JComboBox();
        btnSupplier = new javax.swing.JButton();
        ConstructionPanel = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSiteName = new javax.swing.JTextField();
        txtSiteAddress = new javax.swing.JTextField();
        txtSiteManagerUsername = new javax.swing.JTextField();
        txtSiteTelephoneNumber = new javax.swing.JTextField();
        btnAddSite = new javax.swing.JButton();
        btnSiteReset = new javax.swing.JButton();
        btnSearchManager = new javax.swing.JButton();
        btnGetNumber = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnViewAllSites = new javax.swing.JButton();
        cmbViewAllSites = new javax.swing.JComboBox();
        btnDeleteSite = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtSiteManagerUsernameSearchBySiteManager = new javax.swing.JTextField();
        btnSearchManager1 = new javax.swing.JButton();
        btnSearchSiteBySiteManager = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtSiteNameSearchBySiteManager = new javax.swing.JTextField();
        btnDeleteSiteSearchBySiteManager = new javax.swing.JButton();
        UserPanel = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnSearchFullName = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnViewAllUsers = new javax.swing.JButton();
        btnViewInDetail = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnSearchUsername = new javax.swing.JButton();
        PurchaseOrderPanel = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jDateCheckOrders = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnHandleOrder = new javax.swing.JButton();
        btnSearchOrders = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnGetApprovedOrders = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnViewAllSuppliers1 = new javax.swing.JButton();
        cmbAllSuppliers1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        btnEmailPurchaseOrder = new javax.swing.JButton();
        LogoutPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Item Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Item Price");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Item Type");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnReset))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Item", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Item Name");

        txtSearchItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchItemNameActionPerformed(evt);
            }
        });
        txtSearchItemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchItemNameKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Search By Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Search By Type");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Item Type");

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

        btnDelete.setText("Delete Item");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        btnSearch2.setText("Search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnViewAll.setText("View All Items");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtSearchItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtSearchItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch2)
                            .addComponent(btnSearch1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnViewAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch1))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSearchItemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(39, 39, 39))))
        );

        jTabbedPane2.addTab("Search and Delete Item", jPanel3);

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Item", ItemPanel);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Supplier Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telephone Number");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Email");

        btnAddSupplier.setText("Add");
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
            }
        });

        btnResetSupplier.setText("Reset");
        btnResetSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(68, 68, 68)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSupplier)
                    .addComponent(btnResetSupplier))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Add Supplier", jPanel5);

        btnViewAllSuppliers.setText("View All Suppliers");
        btnViewAllSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllSuppliersActionPerformed(evt);
            }
        });

        btnSupplier.setText("Delete Supplier");
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnViewAllSuppliers)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAllSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btnSupplier)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAllSuppliers)
                    .addComponent(cmbAllSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSupplier)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Search and Delete Supplier", jPanel6);

        javax.swing.GroupLayout SupplierPanelLayout = new javax.swing.GroupLayout(SupplierPanel);
        SupplierPanel.setLayout(SupplierPanelLayout);
        SupplierPanelLayout.setHorizontalGroup(
            SupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        SupplierPanelLayout.setVerticalGroup(
            SupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Supplier", SupplierPanel);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Site Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Address");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Telephone Number");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Site Manager Username");

        btnAddSite.setText("Add");
        btnAddSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSiteActionPerformed(evt);
            }
        });

        btnSiteReset.setText("Reset");
        btnSiteReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiteResetActionPerformed(evt);
            }
        });

        btnSearchManager.setText("Search Manager");
        btnSearchManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchManagerActionPerformed(evt);
            }
        });

        btnGetNumber.setText("Get Number");
        btnGetNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSiteAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtSiteManagerUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchManager))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtSiteTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGetNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnAddSite, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiteReset, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSiteAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSiteManagerUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchManager))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSiteTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSite)
                    .addComponent(btnSiteReset))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Add Site", jPanel8);

        btnViewAllSites.setText("View All Sites");
        btnViewAllSites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllSitesActionPerformed(evt);
            }
        });

        btnDeleteSite.setText("Delete Site");
        btnDeleteSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnViewAllSites, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbViewAllSites, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnDeleteSite)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAllSites)
                    .addComponent(cmbViewAllSites))
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSite)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Search All Sites", jPanel9);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Site Manager Username");

        btnSearchManager1.setText("Search Manager");
        btnSearchManager1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchManager1ActionPerformed(evt);
            }
        });

        btnSearchSiteBySiteManager.setText("Search Site");
        btnSearchSiteBySiteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSiteBySiteManagerActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Site Name");

        txtSiteNameSearchBySiteManager.setEditable(false);

        btnDeleteSiteSearchBySiteManager.setText("Delete Site");
        btnDeleteSiteSearchBySiteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSiteSearchBySiteManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnSearchSiteBySiteManager))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtSiteManagerUsernameSearchBySiteManager, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchManager1))
                            .addComponent(txtSiteNameSearchBySiteManager, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnDeleteSiteSearchBySiteManager)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSiteManagerUsernameSearchBySiteManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchManager1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchSiteBySiteManager)
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSiteNameSearchBySiteManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSiteSearchBySiteManager)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Search By SiteManager", jPanel11);

        javax.swing.GroupLayout ConstructionPanelLayout = new javax.swing.GroupLayout(ConstructionPanel);
        ConstructionPanel.setLayout(ConstructionPanelLayout);
        ConstructionPanelLayout.setHorizontalGroup(
            ConstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );
        ConstructionPanelLayout.setVerticalGroup(
            ConstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Construction Site", ConstructionPanel);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Enter Users Full Name");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Enter Username");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Search By User's Name or Username");

        btnSearchFullName.setText("Search");
        btnSearchFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFullNameActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(jTable2);

        btnViewAllUsers.setText("View All Users");
        btnViewAllUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllUsersActionPerformed(evt);
            }
        });

        btnViewInDetail.setText("View in Detail");
        btnViewInDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewInDetailActionPerformed(evt);
            }
        });

        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnSearchUsername.setText("Search");
        btnSearchUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(27, 27, 27)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchUsername)
                    .addComponent(btnSearchFullName)
                    .addComponent(btnViewAllUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewInDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteUser, btnViewAllUsers, btnViewInDetail});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchFullName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchUsername))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnViewAllUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewInDetail))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteUser, btnViewAllUsers, btnViewInDetail});

        jTabbedPane4.addTab("Manage Users", jPanel1);

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("User", UserPanel);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Handle Requisition Orders");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Select Date to Check Orders:");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        btnHandleOrder.setText("Handle Order");
        btnHandleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandleOrderActionPerformed(evt);
            }
        });

        btnSearchOrders.setText("Search Orders");
        btnSearchOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchOrdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateCheckOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchOrders)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(btnHandleOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel24)
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addComponent(jDateCheckOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHandleOrder)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Handle Orders", jPanel7);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable4);

        btnGetApprovedOrders.setText("Get Approved Orders");
        btnGetApprovedOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetApprovedOrdersActionPerformed(evt);
            }
        });

        jLabel22.setText("Please Select a Supplier");

        btnViewAllSuppliers1.setText("View All Suppliers");
        btnViewAllSuppliers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllSuppliers1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Place Purchase Orders To Supplier");

        btnEmailPurchaseOrder.setText("Email Purchase Order to Supplier");
        btnEmailPurchaseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailPurchaseOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGetApprovedOrders)
                            .addComponent(jLabel22)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnViewAllSuppliers1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbAllSuppliers1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btnEmailPurchaseOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(btnGetApprovedOrders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAllSuppliers1)
                    .addComponent(cmbAllSuppliers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEmailPurchaseOrder)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Place Order", jPanel4);

        javax.swing.GroupLayout PurchaseOrderPanelLayout = new javax.swing.GroupLayout(PurchaseOrderPanel);
        PurchaseOrderPanel.setLayout(PurchaseOrderPanelLayout);
        PurchaseOrderPanelLayout.setHorizontalGroup(
            PurchaseOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        PurchaseOrderPanelLayout.setVerticalGroup(
            PurchaseOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Purchase Orders", PurchaseOrderPanel);

        jLabel15.setText("System Developed By: Shavin/Ismail/Shivaram/Abhiramy");

        jLabel16.setText("Contact:                          0771870683/Sri Lanka");

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
                .addContainerGap(399, Short.MAX_VALUE)
                .addGroup(LogoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Logout", LogoutPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if(txtName.getText().equals("") || txtType.getText().equals("") || txtPrice.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter details for all fields");            
        }
        else
        {
            Item aItem = new Item(txtName.getText(), txtType.getText(), Double.parseDouble(txtPrice.getText()));
        
            try {
                this.itemService.addItem(aItem, itemList);
                JOptionPane.showMessageDialog(null, "Item " + aItem.getItemName() + " Successfully Added.");
                reset();
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }   
        
    }//GEN-LAST:event_btnAddActionPerformed

        
    public void reset()
    {
        //resetting the values
        
        txtName.setText("");
        txtType.setText("");
        txtPrice.setText("");
    }
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        //calling the rest function
        reset();
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchItemNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchItemNameKeyPressed
              
        
        
    }//GEN-LAST:event_txtSearchItemNameKeyPressed

    private void txtSearchItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchItemNameActionPerformed
       
        txtSearchItemName.getDocument().addDocumentListener(new DocumentListener() {

            
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                addToTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                addToTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                addToTable();
            }
            
            public void addToTable()
            {
                
            }
        });
        
    }//GEN-LAST:event_txtSearchItemNameActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed

        //Deserializing
        try {
                itemList = this.itemService.Deserialize(ItemFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        txtSearchItemType.setText("");
        
        //Adding items to jTable1
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        //removing table rows
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        boolean found = false;  //temp found variable, says true if item exists
        
        for(Item aItem : itemList)
        {
            if(aItem.getItemName().equals(txtSearchItemName.getText()))
            {
                model.addRow(new Object[]{aItem.getItemID(), aItem.getItemName(), aItem.getItemType(), aItem.getItemPrice()});
                found = true;
            }        
                    
        }
        
        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "There isnt an item with this name");
        }
        
                               
            
        
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed

        //Deserializing
        try {
                itemList = this.itemService.Deserialize(ItemFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        txtSearchItemName.setText("");
        
        //Adding items to jTable1
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        //removing table rows
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        boolean found = false;  //temp found variable, says true if item exists
        
        for(Item aItem : itemList)
        {
            if(aItem.getItemType().equals(txtSearchItemType.getText()))
            {
                model.addRow(new Object[]{aItem.getItemID(), aItem.getItemName(), aItem.getItemType(), aItem.getItemPrice()});
                found = true;
            }        
                    
        }
        
        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "There isnt an item with this type");
        }
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        
        try {
                itemList = this.itemService.Deserialize(ItemFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //Adding items to jTable1
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        //removing table rows
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
                
        for(Item aItem : itemList)
        {
            if(model.getRowCount() == -1)
            {
                JOptionPane.showMessageDialog(null, "No Items Found");                 
            }
            else
            {
                model.addRow(new Object[]{aItem.getItemID(), aItem.getItemName(), aItem.getItemType(), aItem.getItemPrice()});
            }
                    
        }
        
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         //Deleting an item from the file
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        if(jTable1.getSelectedRow() == -1)
        {
            if(jTable1.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select an item");
            }
        }
        else
        {
            int rowid = jTable1.getSelectedRow();            
            int itemID = (int) jTable1.getValueAt(rowid, 0);
            
            try {
                itemList = this.itemService.Deserialize(ItemFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            SetOfItems<Item> modifiedList = new SetOfItems();
            modifiedList.addAll(itemList);
            
            for(Item item : itemList)
            {
                if(item.getItemID() == itemID)
                {
                    modifiedList.remove(item);
                    
                    try {
                        this.itemService.Serialize(modifiedList, ItemFile);
                        model.removeRow(jTable1.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Item Successfully Removed");
                        
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void SupplierReset()
    {
        //Reset fields in supplier tab 
        
        txtSupplierName.setText("");
        txtTelephoneNumber.setText("");
        txtEmail.setText("");
           
    }
    
    private void btnResetSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSupplierActionPerformed
        //Calling the function to reset
        
        SupplierReset();
    }//GEN-LAST:event_btnResetSupplierActionPerformed
   
    
    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
        
        //validations 
        if(txtSupplierName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a supplier name");            
        }
        else if(txtTelephoneNumber.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a telephone number");
        }
        else if(txtEmail.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a email");
        }
        else
        {
            try {
                supplierList = this.supplierService.Deserialize(SupplierFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Supplier aSupplier = new Supplier(txtSupplierName.getText(), txtTelephoneNumber.getText(), txtEmail.getText());
            
            try {
                this.supplierService.addSupplier(aSupplier, supplierList);
                JOptionPane.showMessageDialog(null, "Supplier: " + aSupplier.getSupplierName() + " was Successfully Added");
                SupplierReset();
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    private void btnViewAllSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllSuppliersActionPerformed
        
        //Clearing the combo box        
        cmbAllSuppliers.removeAllItems();
        
        //Deserialize
        try {
            supplierList = this.supplierService.Deserialize(SupplierFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Supplier supplier : supplierList)
        {
            cmbAllSuppliers.addItem(supplier.getSupplierName());
        }
        
    }//GEN-LAST:event_btnViewAllSuppliersActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
        
        if(cmbAllSuppliers.getItemCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Supplier");
        }
        else
        {
            try {
                supplierList = this.supplierService.Deserialize(SupplierFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            SetOfSuppliers<Supplier> modifiedList = new SetOfSuppliers();
            modifiedList.addAll(supplierList);
            
            for(Supplier supplier : supplierList)
            {
                if(supplier.getSupplierName().equals(cmbAllSuppliers.getSelectedItem().toString()))
                {
                    modifiedList.remove(supplier);
                    
                    try {
                        this.supplierService.Serialize(modifiedList, SupplierFile);
                        JOptionPane.showMessageDialog(null, "Supplier Successfully Deleted");                        
                        cmbAllSuppliers.removeItemAt(cmbAllSuppliers.getSelectedIndex());
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
                
        
    }//GEN-LAST:event_btnSupplierActionPerformed

    public void resetSite()
    {
        txtSiteName.setText("");
        txtSiteAddress.setText("");
        txtSiteManagerUsername.setText("");
        txtSiteTelephoneNumber.setText("");
    
    }
    
    private void btnSiteResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiteResetActionPerformed
       
        //calling the resetSite function 
        resetSite();
        
    }//GEN-LAST:event_btnSiteResetActionPerformed

    private void btnSearchManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchManagerActionPerformed
        SearchSiteManagerUI searchManager = new SearchSiteManagerUI();
        searchManager.setVisible(true);
        
        
    }//GEN-LAST:event_btnSearchManagerActionPerformed

    private void btnAddSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSiteActionPerformed
        
        //Temp varibale to check if it was added successfully
        boolean added = false;
        
        //Temp variable to check if site manager exists
        boolean exists = false;
        
        //deserialize
        
        try {
            siteList = this.siteService.Deserialize(SiteFile);
            userList = this.userService.Deserialize(UserFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        if(txtSiteName.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a Site Name");
        else if(txtSiteAddress.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter an Address");
        else if(txtSiteManagerUsername.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter the Site Manager's Username");
        else if(txtSiteTelephoneNumber.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a Telephone Number");
        else
        {
            for(User aUser : userList)
            {
                if(aUser.getUsername().equals(txtSiteManagerUsername.getText()) && aUser.getUserType().equals("Site Manager"))
                {
                    Site newSite = new Site(txtSiteName.getText(), txtSiteAddress.getText(), txtSiteManagerUsername.getText(), txtSiteTelephoneNumber.getText());
                    
                    try {
                        this.siteService.addSite(newSite, siteList);
                        added = true;
                        exists = true;                        
                        resetSite();
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }                
                    
                }                
            }
            
            if(added == true)
            {
                JOptionPane.showMessageDialog(null, "Site Successfully Added");
            }
            else if(exists == false)
            {
                JOptionPane.showMessageDialog(null, "There are no Site Managers with this Username");
                resetSite();
            }
        }
        
    }//GEN-LAST:event_btnAddSiteActionPerformed

    private void btnViewAllSitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllSitesActionPerformed
        cmbViewAllSites.removeAllItems();
        
        //Deserialize
        try {
            siteList = this.siteService.Deserialize(SiteFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Site site : siteList)
        {
            cmbViewAllSites.addItem(site.getSiteName());
        }
    }//GEN-LAST:event_btnViewAllSitesActionPerformed

    private void btnDeleteSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSiteActionPerformed
        
        try {
            siteList = this.siteService.Deserialize(SiteFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SetOfSites<Site> modifiedList = new SetOfSites();
        modifiedList.addAll(siteList);

        if(cmbViewAllSites.getItemCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a Site to delete");
        }
        else
        {
            for(Site site : siteList)
            {
                if(site.getSiteName().equals(cmbViewAllSites.getSelectedItem().toString()))
                {
                    modifiedList.remove(site);
                    
                    try {
                        this.siteService.Serialize(modifiedList, SiteFile);
                        JOptionPane.showMessageDialog(null, "Site Successfully Deleted");
                        cmbViewAllSites.removeItemAt(cmbViewAllSites.getSelectedIndex());
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }        
        }
            
        
    }//GEN-LAST:event_btnDeleteSiteActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginUI lui = new LoginUI();
        lui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSearchManager1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchManager1ActionPerformed
        SearchSiteManagerUI searchManager = new SearchSiteManagerUI();
        searchManager.setVisible(true);
    }//GEN-LAST:event_btnSearchManager1ActionPerformed

    private void btnSearchSiteBySiteManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSiteBySiteManagerActionPerformed
        
        //Temporary Variable to hold the site
        Site newSite = new Site();
        
        //Deserialize

        try {            
            siteList = this.siteService.Deserialize(SiteFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Site aSite : siteList) 
        {
            if(aSite.getSiteManagersUsername().equals(txtSiteManagerUsernameSearchBySiteManager.getText()))
            {
                newSite = aSite;
            }
        }
        
        if(newSite.getSiteName() != null)
        {
            txtSiteNameSearchBySiteManager.setText(newSite.getSiteName());                   
        }
        else
        {
            JOptionPane.showMessageDialog(null, "This User either does not exist or does not have a Site");
            txtSiteNameSearchBySiteManager.setText("");
        }     
        
        
        
        
    }//GEN-LAST:event_btnSearchSiteBySiteManagerActionPerformed

    public void resetSearchBySiteManager()
    {
        txtSiteManagerUsernameSearchBySiteManager.setText("");
        txtSiteNameSearchBySiteManager.setText("");
    }
    
    private void btnDeleteSiteSearchBySiteManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSiteSearchBySiteManagerActionPerformed
        if(txtSiteNameSearchBySiteManager.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You need to search for a Site Manager who is assigned to a Site to delete");
        }
        else
        {
            //deserializing
            try {
                siteList = this.siteService.Deserialize(SiteFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(Site aSite : siteList)
            {
                if(aSite.getSiteName().equals(txtSiteNameSearchBySiteManager.getText()))
                {
                    siteList.removeSite(aSite);
                    
                    try {
                        this.siteService.Serialize(siteList, SiteFile);
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Site Successfully Deleted!");
                    resetSearchBySiteManager();
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnDeleteSiteSearchBySiteManagerActionPerformed

    private void btnSearchFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFullNameActionPerformed
        
        if(txtFullName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Users Full Name to Search");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
            //removing table rows
            int rows = model.getRowCount(); 
            for(int i = rows - 1; i >=0; i--)
            {
               model.removeRow(i); 
            }

            txtUsername.setText("");

            //deserializing the userlist
            try {
                userList = this.userService.Deserialize(UserFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            //temporary variable to check if user exists
            boolean found = false;

            for(User aUser : userList)
            {
                if(aUser.getUserFullName().equals(txtFullName.getText()))
                {
                    model.addRow(new Object[]{aUser.getUserID(), aUser.getUserFullName(), aUser.getTelephoneNumber(), aUser.getUsername(), aUser.getUserType()});
                    found = true;
                    break;
                }
            }

            if(found == false)
            {
                JOptionPane.showMessageDialog(null, "User Not Found. Please Re-try.");
            }
        }
        
        
        
    }//GEN-LAST:event_btnSearchFullNameActionPerformed

    private void btnSearchUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUsernameActionPerformed
        
        if(txtUsername.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Username to Search");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
            //removing table rows
            int rows = model.getRowCount(); 
            for(int i = rows - 1; i >=0; i--)
            {
               model.removeRow(i); 
            }

            txtFullName.setText("");

            //deserializing the userlist
            try {
                userList = this.userService.Deserialize(UserFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            //temporary variable to check if user exists
            boolean found = false;

            for(User aUser : userList)
            {
                if(aUser.getUsername().equals(txtUsername.getText()))
                {
                    model.addRow(new Object[]{aUser.getUserID(), aUser.getUserFullName(), aUser.getTelephoneNumber(), aUser.getUsername(), aUser.getUserType()});
                    found = true;
                    break;
                }
            }

            if(found == false)
            {
                JOptionPane.showMessageDialog(null, "Username Does Not Exist. Please Re-try.");
            }
        }
        
        
    }//GEN-LAST:event_btnSearchUsernameActionPerformed

    private void btnViewAllUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllUsersActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        //removing table rows
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }

        txtFullName.setText("");
        txtUsername.setText("");
                

        //deserializing the userlist
        try {
            userList = this.userService.Deserialize(UserFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //temporary variable to check if user exists
        boolean found = false;

        for(User aUser : userList)
        {            
            model.addRow(new Object[]{aUser.getUserID(), aUser.getUserFullName(), aUser.getTelephoneNumber(), aUser.getUsername(), aUser.getUserType()});           
        }
        
    }//GEN-LAST:event_btnViewAllUsersActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        
        //verifying delete
        int choice = JOptionPane.showConfirmDialog(null, "Are You Sure?");
        
        if(choice == 0)
        {
            //Deleting a user from the file
        
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            if(jTable2.getSelectedRow() == -1)
            {
                if(jTable2.getRowCount() == 0)
                {
                    JOptionPane.showMessageDialog(null, "The Table is Empty");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You Must Choose a User From the Table");
                }
            }
            else
            {                
                int rowid = jTable2.getSelectedRow();            
                int userID = (int) jTable2.getValueAt(rowid, 0);

                try {
                    userList = this.userService.Deserialize(UserFile);
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                for(User aUser : userList)
                {
                    if(aUser.getUserID() == userID)
                    {
                        userList.remove(aUser);

                        try {
                            this.userService.Serialize(userList, UserFile);
                        } catch (IOException ex) {
                            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        JOptionPane.showMessageDialog(null, "User Successfully Deleted");
                        model.removeRow(jTable2.getSelectedRow());
                        break;
                    }
                }
            }
        }

        
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnViewInDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewInDetailActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        if(jTable2.getSelectedRow() == -1)
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty", null, JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select an user to view", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            int SelectedRow = jTable2.getSelectedRow();        
            int UserID = (int) model.getValueAt(SelectedRow, 0);
        
            UpdateUserUI uui = new UpdateUserUI(UserID, Username);
            this.dispose();
            uui.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnViewInDetailActionPerformed

    private void btnSearchOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchOrdersActionPerformed
        
        //Temp variable to check if entries exist in file
        boolean found = false;
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();

        int rows = model.getRowCount();

        //Clearing jTable2
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }

        //Deserializing

        try {                      
            orderList = this.orderService.Deserialize(RequisitionOrderFile);
            userList = this.userService.Deserialize(UserFile);
        } catch (IOException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiteManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(RequisitionOrder order : orderList)
        {
            //Setting the dateformat of the jDateChooser
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            
            if(order.getPlacedDate().equals(sdf.format(jDateCheckOrders.getDate())) && order.getStatusOfApproval().equals("Pending"))
            {
                String SiteManager = ""; 
                
                for(User siteManager: userList)
                {
                    if(siteManager.getUsername().equals(order.getUsername()))
                    {
                        SiteManager = siteManager.getUserFullName();
                        break;
                    }
                }
                
                model.addRow(new Object[]{order.getOrderID(), order.getItemCount(), order.getTotalPriceOfItems(), SiteManager, order.getSitename(), order.getRequiredDate()});
                found = true;                
            }
        }

        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "There were no pending orders placed on this date");
        }
        
    }//GEN-LAST:event_btnSearchOrdersActionPerformed

    private void btnGetNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetNumberActionPerformed
        if(txtSiteManagerUsername.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You need to enter the username", null, JOptionPane.ERROR_MESSAGE);            
        }
        else
        {
            try {
                userList = this.userService.Deserialize(UserFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            boolean found = false;
            
            for(User aUser : userList)
            {
                if(aUser.getUsername().equals(txtSiteManagerUsername.getText()) && aUser.getUserType().equals("Site Manager"))
                {
                    txtSiteTelephoneNumber.setText(aUser.getTelephoneNumber());
                    found = true;
                    break;
                }
                
            }
            
            if(found == false)
            {
                JOptionPane.showMessageDialog(null, "Invalid Username", null, JOptionPane.ERROR_MESSAGE);
                txtSiteTelephoneNumber.setText("");
            }
            
        }
    }//GEN-LAST:event_btnGetNumberActionPerformed

    private void btnHandleOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHandleOrderActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        
        if(jTable3.getSelectedRow() == -1)
        {
            if(jTable3.getRowCount() == 0)
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
            int SelectedRow = jTable3.getSelectedRow();        
            int OrderID = (int) model.getValueAt(SelectedRow, 0);
        
            HandleRequisitionOrderUI hroui = new HandleRequisitionOrderUI(OrderID, Username);           
            hroui.setVisible(true);
        }
        
    }//GEN-LAST:event_btnHandleOrderActionPerformed

    private void btnGetApprovedOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetApprovedOrdersActionPerformed
       
        DefaultTableModel model = (DefaultTableModel) (jTable4.getModel());
        
        //removing table rows
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        boolean found = false;
        
        //Deserialize purchase order file
        try {            
            purchaseOrderList = this.purchaseOrderService.Deserialize(PurchaseOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Populating jtable4 with approved orders waiting to be placed        
        for(PurchaseOrder order : purchaseOrderList)
        {
            if(order.getApprovalStatus().equals("Approved"))
            {
                model.addRow(new Object[]{order.getPurchaseOrderID(), order.getTotalPriceOfItems(), order.getRequiredDate(), order.getComments(), order.getApprovedBy(), order.getApprovedDate(), order.getSiteName()});
                found = true;
            }
        }
        
        if(found == false)
        {
            JOptionPane.showMessageDialog(null, "There are no Approved Purchase Orders");
        }
    }//GEN-LAST:event_btnGetApprovedOrdersActionPerformed

    private void btnViewAllSuppliers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllSuppliers1ActionPerformed
        
        //Clearing the combo box        
        cmbAllSuppliers1.removeAllItems();
        
        //Deserialize
        try {
            supplierList = this.supplierService.Deserialize(SupplierFile);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Supplier supplier : supplierList)
        {
            cmbAllSuppliers1.addItem(supplier.getSupplierName());
        }
    }//GEN-LAST:event_btnViewAllSuppliers1ActionPerformed

    private void btnEmailPurchaseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailPurchaseOrderActionPerformed
    
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        
        if(jTable4.getSelectedRow() == -1)
        {
            if(jTable4.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "The table is empty", null, JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You must select an order from the table", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(cmbAllSuppliers1.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "You need to select a supplier", null, JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int SelectedRow = jTable4.getSelectedRow();
            int PurchaseOrderID = (int) jTable4.getValueAt(SelectedRow, 0);
            
            String CommentsToSupplier = JOptionPane.showInputDialog("Do you have any notes for the supplier");
            
            try {
                purchaseOrderList = this.purchaseOrderService.Deserialize(PurchaseOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            PurchaseOrder updateOrder = new PurchaseOrder();
            
            for(PurchaseOrder order : purchaseOrderList)
            {
                if(order.getPurchaseOrderID() == PurchaseOrderID)
                {
                    updateOrder = order;
                    
                    purchaseOrderList.remove(order);
                    
                    try {
                        this.purchaseOrderService.Serialize(purchaseOrderList, PurchaseOrderFile);
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
            //setting the approval status in requisition order file to placed            
            try {                
                orderList = this.orderService.Deserialize(RequisitionOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequisitionOrder updateRequisitionOrder = new RequisitionOrder();
            
            for(RequisitionOrder order : orderList)
            {
                if(order.getPurchaseOrderReferenceNumber() == updateOrder.getPurchaseOrderID())
                {
                    updateRequisitionOrder = order;
                    
                    orderList.remove(order);
                    
                    try {
                        this.orderService.Serialize(orderList, RequisitionOrderFile);
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    updateRequisitionOrder.setApprovalStatus("Placed");
                    
                    orderList.add(updateRequisitionOrder);
                    
                    try {
                        this.orderService.Serialize(orderList, RequisitionOrderFile);
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
            //Retrieving Suppliers Email
            try {             
                supplierList = this.supplierService.Deserialize(SupplierFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String SupplierEmail = ""; 
            
            for(Supplier supplier : supplierList)
            {
                if(supplier.getSupplierName().equals(cmbAllSuppliers1.getSelectedItem()))
                {
                    SupplierEmail = supplier.getSupplierEmail();
                    break;
                }
            }
            
            updateOrder.setPlaceOrder(SupplierEmail, CommentsToSupplier);
            updateOrder.setApprovalStatus("Placed");
            
            
            purchaseOrderList.add(updateOrder);
            
            try {
                this.purchaseOrderService.Serialize(purchaseOrderList, PurchaseOrderFile);
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }     
            
            JOptionPane.showMessageDialog(null, "Order Successfully Sent to Supplier");
            
            
            
        }
       
        
        
    }//GEN-LAST:event_btnEmailPurchaseOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });       
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConstructionPanel;
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JPanel LogoutPanel;
    private javax.swing.JPanel PurchaseOrderPanel;
    private javax.swing.JPanel SupplierPanel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSite;
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteSite;
    private javax.swing.JButton btnDeleteSiteSearchBySiteManager;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEmailPurchaseOrder;
    private javax.swing.JButton btnGetApprovedOrders;
    private javax.swing.JButton btnGetNumber;
    private javax.swing.JButton btnHandleOrder;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetSupplier;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearchFullName;
    private javax.swing.JButton btnSearchManager;
    private javax.swing.JButton btnSearchManager1;
    private javax.swing.JButton btnSearchOrders;
    private javax.swing.JButton btnSearchSiteBySiteManager;
    private javax.swing.JButton btnSearchUsername;
    private javax.swing.JButton btnSiteReset;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton btnViewAllSites;
    private javax.swing.JButton btnViewAllSuppliers;
    private javax.swing.JButton btnViewAllSuppliers1;
    private javax.swing.JButton btnViewAllUsers;
    private javax.swing.JButton btnViewInDetail;
    private javax.swing.JComboBox cmbAllSuppliers;
    private javax.swing.JComboBox cmbAllSuppliers1;
    private javax.swing.JComboBox cmbViewAllSites;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateCheckOrders;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearchItemName;
    private javax.swing.JTextField txtSearchItemType;
    private javax.swing.JTextField txtSiteAddress;
    private javax.swing.JTextField txtSiteManagerUsername;
    private javax.swing.JTextField txtSiteManagerUsernameSearchBySiteManager;
    private javax.swing.JTextField txtSiteName;
    private javax.swing.JTextField txtSiteNameSearchBySiteManager;
    private javax.swing.JTextField txtSiteTelephoneNumber;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtTelephoneNumber;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
