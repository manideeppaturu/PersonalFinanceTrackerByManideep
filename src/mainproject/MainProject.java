
package mainproject;

import User.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Manideep
 */
public class MainProject extends javax.swing.JFrame {

   
    public MainProject() {
        initComponents();
        Show_Users_In_JTable();
    }
    
    //Method designed for establishing a connection(when asked for different situations)
    public Connection getConnection()
    {
    
       Connection con;
        try{
           //Establishing connection on NJIT database with my login details
         con= DriverManager.getConnection("jdbc:mysql://sql2.njit.edu/mp672", "mp672", "Jbmjysrhjr89");
        return con;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    //getting data from database and saving it in an array for further use
    public ArrayList<User> getUsersList(){
        ArrayList<User> usersList=new ArrayList<User>();
        Connection connection = getConnection();
        //Deriving all data
        String query ="SELECT * FROM `transactions` ";
        Statement st;
        ResultSet rs;
        
        try {
            st=connection.createStatement();
            rs=st.executeQuery(query);
            User user;
            //while loop is used to get 'ALL' rows.Untill next() is empty this runs
            while(rs.next())
            {
                user= new User(rs.getInt("ID"),rs.getString("TransactionType"),rs.getString("PayeeOrSource"),rs.getString("Description"),rs.getString("Date"),rs.getString("Amount"),rs.getString("PaymentMethod"));
                usersList.add(user);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    //Method uses earlier getUsersList and displays in the Jframe design
     public void Show_Users_In_JTable(){
        
       ArrayList<User> list= getUsersList();
        DefaultTableModel model =(DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getID();
        row[1]=list.get(i).getTransactionType();
        row[2]=list.get(i).getPayeeOrSource();
        row[3]=list.get(i).getDescription();
        row[4]=list.get(i).getDate();
        row[5]=list.get(i).getAmount();
        row[6]=list.get(i).getPaymentMethod();
       
        
        model.addRow(row);
        }
    }
     
    //An Query can be executed from wherever inside the project using this method.Due to complexions this method doesnt 
     //take SELECT queries,Hence they are executed seperately
    public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refreshing table data
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully"); 
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    

    //Auto-Generated Code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_NameSearch = new javax.swing.JTextField();
        jTextField_FromDate = new javax.swing.JTextField();
        jTextField_ToDate = new javax.swing.JTextField();
        jTextField_payee = new javax.swing.JTextField();
        jTextField_description = new javax.swing.JTextField();
        jTextField_date = new javax.swing.JTextField();
        jTextField_amount = new javax.swing.JTextField();
        jComboBox_ExpenseIncome = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton_insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jTextField_ID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_payment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setPreferredSize(new java.awt.Dimension(656, 514));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 147));

        jTextField_NameSearch.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField_NameSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_NameSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_NameSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NameSearchKeyTyped(evt);
            }
        });

        jTextField_FromDate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField_FromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FromDateActionPerformed(evt);
            }
        });

        jTextField_ToDate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTextField_payee.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTextField_description.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTextField_date.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTextField_amount.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jComboBox_ExpenseIncome.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox_ExpenseIncome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income", " " }));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel1.setText("Search by Payee/Source");

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        jLabel2.setText("From Date");

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        jLabel3.setText("To Date");

        jButton1_search.setBackground(java.awt.SystemColor.activeCaption);
        jButton1_search.setText("Search");
        jButton1_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_searchMouseClicked(evt);
            }
        });

        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Expense/Income", "Payee/Source", "Description", "Date", "Amount", "PaymentMethod"
            }
        ));
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);
        if (jTable_Display_Users.getColumnModel().getColumnCount() > 0) {
            jTable_Display_Users.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable_Display_Users.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable_Display_Users.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable_Display_Users.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable_Display_Users.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable_Display_Users.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel4.setText("Expense/Income");

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel5.setText("Payee/Source");

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel6.setText("Description");

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel7.setText("Date");

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel8.setText("Amount");

        jLabel9.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel9.setText("PaymentMethod");

        jButton_insert.setBackground(java.awt.SystemColor.activeCaption);
        jButton_insert.setText("New");
        jButton_insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_insertMouseClicked(evt);
            }
        });

        jButton_update.setBackground(java.awt.SystemColor.activeCaption);
        jButton_update.setText("Update");
        jButton_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_updateMouseClicked(evt);
            }
        });

        jButton_delete.setBackground(java.awt.SystemColor.activeCaption);
        jButton_delete.setText("Delete");
        jButton_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_deleteMouseClicked(evt);
            }
        });

        jTextField_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 3, 10)); // NOI18N
        jLabel10.setText("Id");

        jComboBox_payment.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "Cash", "Direct Deposit", "Check" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1_search)
                .addGap(168, 168, 168))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_ExpenseIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_payee, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_description, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jButton_insert)
                        .addGap(40, 40, 40)
                        .addComponent(jButton_update)
                        .addGap(34, 34, 34)
                        .addComponent(jButton_delete)
                        .addGap(58, 58, 58)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_NameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_FromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_NameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jButton1_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_payee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_ExpenseIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_insert)
                    .addComponent(jButton_update)
                    .addComponent(jButton_delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method Designed to set the selected values in the TextBoxes
    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        
        int i = jTable_Display_Users.getSelectedRow();

        TableModel model = jTable_Display_Users.getModel();
        
        
        jTextField_ID.setText(model.getValueAt(i,0).toString());
        
        jComboBox_ExpenseIncome.setSelectedItem(model.getValueAt(i,1).toString());
        
        jTextField_payee.setText(model.getValueAt(i,2).toString());

        jTextField_description.setText(model.getValueAt(i,3).toString());

        jTextField_date.setText(model.getValueAt(i,4).toString());

        jTextField_amount.setText(model.getValueAt(i,5).toString());
        
        jComboBox_payment.setSelectedItem(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

//To inssert values in the Database 
    private void jButton_insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_insertMouseClicked
        
        //If an Id is not entered auto generation takes place here
        if(jTextField_ID.getText().equals("")){
            
        {String query = "INSERT INTO `transactions` VALUES (NULL,'"+jComboBox_ExpenseIncome.getSelectedItem().toString()+"','"+jTextField_payee.getText()+"','"+jTextField_description.getText()+"','"+jTextField_date.getText()+"','"+jTextField_amount.getText()+"','"+jComboBox_payment.getSelectedItem().toString()+"')";
        executeSQlQuery(query, "Inserted");}}
        //If a specific ID is mentioned then this part is executed
        else{
            
            {String query = "INSERT INTO `transactions` VALUES ('"+jTextField_ID.getText()+"','"+jComboBox_ExpenseIncome.getSelectedItem().toString()+"','"+jTextField_payee.getText()+"','"+jTextField_description.getText()+"','"+jTextField_date.getText()+"','"+jTextField_amount.getText()+"','"+jComboBox_payment.getSelectedItem().toString()+"')";
        executeSQlQuery(query, "Inserted");}
        }
    }//GEN-LAST:event_jButton_insertMouseClicked

    //Method to Update the Transactions Database When Clicked
    private void jButton_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_updateMouseClicked
        
        String query = "UPDATE `transactions` SET `TransactionType`='"+jComboBox_ExpenseIncome.getSelectedItem().toString()+"',`PayeeOrSource`='"+jTextField_payee.getText()+"',`Description`='"+jTextField_description.getText()+"',`Date`='"+jTextField_date.getText()+"',`Amount`='"+jTextField_amount.getText()+"',`PaymentMethod`='"+jComboBox_payment.getSelectedItem().toString()+"' WHERE `ID` = "+jTextField_ID.getText();
        
        executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_jButton_updateMouseClicked
//To delete a specific row using ID
    private void jButton_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_deleteMouseClicked
        
        String query = "DELETE FROM `transactions` WHERE ID = "+jTextField_ID.getText();

        executeSQlQuery(query, "Deleted");
    }//GEN-LAST:event_jButton_deleteMouseClicked

    private void jTextField_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IDActionPerformed
//Method Designed to search in between given dates
    private void jButton1_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_searchMouseClicked
        
       ResultSet rs = null;
       String s=(jTextField_NameSearch.getText());
       String p=jTextField_FromDate.getText();
       String q=jTextField_ToDate.getText();
       //if all fields are empty
       if(p.equals("")&&s.equals("")&&q.equals("")){
           JOptionPane.showMessageDialog(null, "Enter atleast One Detail to Search With");
       }
       else{
        Connection con = null;
        PreparedStatement ps = null;
        try{
               con = DriverManager.getConnection("jdbc:mysql://sql2.njit.edu/mp672", "mp672", "Jbmjysrhjr89");
               //if only Payee/Source field is entered
               if(p.equals("")&&(!s.equals(""))&&(q.equals(""))){
               ps = con.prepareStatement("select * from transactions where PayeeOrSource = ?");
               
               ps.setString(1,s);
               }
               //if only from-date field is entered
               if(s.equals("")&&(!p.equals(""))&&(q.equals(""))){
               ps = con.prepareStatement("select * from transactions where Date >= ?");
               ps.setString(1,p);
               }
               //if only to-date field is entered
               if(s.equals("")&&(!q.equals(""))&&(p.equals(""))){
               ps = con.prepareStatement("select * from transactions where Date <= ?");
               ps.setString(1,q);
               }
               //if both from-date and to-date fields are entered
               if(s.equals("")&&(!q.equals(""))&&(!p.equals(""))){
               ps = con.prepareStatement("select * from transactions where Date >= ? and Date <=?");
               ps.setString(1,p);
               ps.setString(2,q);
               
               }
               //if both from-date and Payee/Source fields are entered
               if(!s.equals("")&&(q.equals(""))&&(!p.equals(""))){
               ps = con.prepareStatement("select * from transactions where PayeeOrSource= ? and Date >=?");
               ps.setString(1,s);
               ps.setString(2,p);
               }
               //if both Payee/Source and to-date fields are entered
               if(!s.equals("")&&(!q.equals(""))&&(p.equals(""))){
               ps = con.prepareStatement("select * from transactions where PayeeOrSource= ? and Date <=?");
               ps.setString(1,s);
               ps.setString(2,q);
               }
               //if all the fields are given
               if(!s.equals("")&&(!q.equals(""))&&(!p.equals(""))){
               ps = con.prepareStatement("select * from transactions where PayeeOrSource= ? and Date >=? and Date<=?");
               ps.setString(1,s);
               ps.setString(2,p);
               ps.setString(3,q);
               }
               //Since Select cannot be used in executeUpdate, whole code is retyped using execute Query
               rs = ps.executeQuery();
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               }catch(Exception ex){
                  JOptionPane.showMessageDialog(null, ex.getMessage());
               }
        
        ArrayList<User> usersList=new ArrayList<User>();
        User user;
        try{
            
            while(rs.next())
            {
                user= new User(rs.getInt("ID"),rs.getString("TransactionType"),rs.getString("PayeeOrSource"),rs.getString("Description"),rs.getString("Date"),rs.getString("Amount"),rs.getString("PaymentMethod"));
                usersList.add(user);
                
            }}catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<User> list= usersList;
        DefaultTableModel model =(DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getID();
        row[1]=list.get(i).getTransactionType();
        row[2]=list.get(i).getPayeeOrSource();
        row[3]=list.get(i).getDescription();
        row[4]=list.get(i).getDate();
        row[5]=list.get(i).getAmount();
        row[6]=list.get(i).getPaymentMethod();
        
        model.addRow(row);
    
        }
       }
       
    }//GEN-LAST:event_jButton1_searchMouseClicked
//method not used in final implementation
    private void jTextField_NameSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NameSearchKeyTyped
      /*  // TODO add your handling code here:
        ResultSet rs = null;
       String s=(jTextField_NameSearch.getText());
       Connection con = null;
        PreparedStatement ps = null;
        try{
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
               ps = con.prepareStatement("select * from transactions where PayeeOrSource like ?");
               System.out.print(ps);
               s=s+"%";
               ps.setString(1,s);
               //ps.setString(2,"%");
               rs = ps.executeQuery();
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               }
        catch(Exception ex){
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        ArrayList<User> usersList=new ArrayList<User>();
        User user;
        try{
            System.out.println("4");
            while(rs.next())
            {System.out.println("5");
                user= new User(rs.getInt("ID"),rs.getString("TransactionType"),rs.getString("PayeeOrSource"),rs.getString("Description"),rs.getString("Date"),rs.getInt("Amount"),rs.getString("PaymentMethod"));
                System.out.print(user);
                usersList.add(user);
                
            }}catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("6");
        ArrayList<User> list= usersList;
        DefaultTableModel model =(DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getID();
        row[1]=list.get(i).getTransactionType();
        row[2]=list.get(i).getPayeeOrSource();
        row[3]=list.get(i).getDescription();
        row[4]=list.get(i).getDate();
        row[5]=list.get(i).getAmount();
        row[6]=list.get(i).getPaymentMethod();
       
        
        model.addRow(row);}*/
    }//GEN-LAST:event_jTextField_NameSearchKeyTyped
//method not used in final implementation
    private void jTextField_NameSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NameSearchKeyPressed
       /*
       ResultSet rs = null;
       String s=(jTextField_NameSearch.getText());
       Connection con = null;
       PreparedStatement ps = null;
        try{
               con = DriverManager.getConnection("jdbc:mysql://sql2.njit.edu/mp672", "mp672", "Jbmjysrhjr89");
               ps = con.prepareStatement("select * from transactions where PayeeOrSource like ?");
               s=s+"%";
               ps.setString(1,s);
               rs = ps.executeQuery();
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               }
        catch(Exception ex){
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        ArrayList<User> usersList=new ArrayList<User>();
        User user;
        try{
            while(rs.next())
            {
                user= new User(rs.getInt("ID"),rs.getString("TransactionType"),rs.getString("PayeeOrSource"),rs.getString("Description"),rs.getString("Date"),rs.getString("Amount"),rs.getString("PaymentMethod"));
                usersList.add(user);
                
            }}catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<User> list= usersList;
        DefaultTableModel model =(DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getID();
        row[1]=list.get(i).getTransactionType();
        row[2]=list.get(i).getPayeeOrSource();
        row[3]=list.get(i).getDescription();
        row[4]=list.get(i).getDate();
        row[5]=list.get(i).getAmount();
        row[6]=list.get(i).getPaymentMethod();
        model.addRow(row);}
        */
    }//GEN-LAST:event_jTextField_NameSearchKeyPressed
//Method used to filter the database based on the entered payee/source field
    private void jTextField_NameSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NameSearchKeyReleased
       ResultSet rs = null;
       String s=(jTextField_NameSearch.getText());
       Connection con = null;
        PreparedStatement ps = null;
        try{
               con = DriverManager.getConnection("jdbc:mysql://sql2.njit.edu/mp672", "mp672", "Jbmjysrhjr89");
               ps = con.prepareStatement("select * from transactions where PayeeOrSource like ?");
               //Using like and concatinating entered text field data with %, such that the query
                //gives the expected result 
               s=s+"%";
               ps.setString(1,s);
               rs = ps.executeQuery();
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               }
        catch(Exception ex){
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        ArrayList<User> usersList=new ArrayList<User>();
        User user;
        try{
            
            while(rs.next())
            {
                user= new User(rs.getInt("ID"),rs.getString("TransactionType"),rs.getString("PayeeOrSource"),rs.getString("Description"),rs.getString("Date"),rs.getString("Amount"),rs.getString("PaymentMethod"));
                usersList.add(user);
                
            }}catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<User> list= usersList;
        DefaultTableModel model =(DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getID();
        row[1]=list.get(i).getTransactionType();
        row[2]=list.get(i).getPayeeOrSource();
        row[3]=list.get(i).getDescription();
        row[4]=list.get(i).getDate();
        row[5]=list.get(i).getAmount();
        row[6]=list.get(i).getPaymentMethod();
        model.addRow(row);}
    }//GEN-LAST:event_jTextField_NameSearchKeyReleased

    private void jTextField_FromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FromDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FromDateActionPerformed
             
        
        
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_search;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox<String> jComboBox_ExpenseIncome;
    private javax.swing.JComboBox<String> jComboBox_payment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField_FromDate;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_NameSearch;
    private javax.swing.JTextField jTextField_ToDate;
    private javax.swing.JTextField jTextField_amount;
    private javax.swing.JTextField jTextField_date;
    private javax.swing.JTextField jTextField_description;
    private javax.swing.JTextField jTextField_payee;
    // End of variables declaration//GEN-END:variables
}
