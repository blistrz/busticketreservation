
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PaymentDetails extends javax.swing.JFrame implements InterfaceA,InterfaceB{

    /**
     * Creates new form PaymentDetails
     */
     String [] data;
     DbConnectivity db;
     
    public PaymentDetails() {
        initComponents();
        jPanel6.setBackground(new Color(0,0,0,10));
        jPanel7.setBackground(new Color(0,0,0,10));
        jPanel4.setBackground(new Color(0,0,0,10));
        //combo1.setBackground(Color.BLACK);
       // BackButton1.setBackground(Color.BLACK);
       this.paymentdetail();
       
        db=DbConnectivity.getobject();
        currentuser.setText(db.retrievecurrentuser()); 
        
        
    }
    JframeFactory jf=new JframeFactory();
    public void x()
    {
        this.setVisible(true);
    }
    public void back()
    {
        this.setVisible(true);
    }

    public boolean paymentdetail()
    {
        DbConnectivity db;
        db=DbConnectivity.getobject();
        boolean done=false;
        Connection con=db.DbConnection();
 
 try{
           String regnum=db.currentuserregnum();
           System.out.println(regnum);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("exec Procedure1 '"+db.currentuserregnum()+"'");
            
            int i=0;
            while(rs.next()){
                done=true;
               String id=String.valueOf(i+1);
               String date=rs.getString("date1");
                System.out.println(date);
               String time=rs.getString("time1");
                System.out.println(time);
               String amount=rs.getString("amount");
                System.out.println(amount);
               
               
               String tbtable[]={id,date,time,amount};
               data=tbtable;
               DefaultTableModel tm1=(DefaultTableModel)jTable1.getModel();
               
               tm1.addRow(data);
               i++;
            }
            
        }
        catch(Exception e){
            
        }
 return done;
    }
      
     public boolean search( String searchtype,String searchby)
    {
        
        boolean found=false;
        db=DbConnectivity.getobject();
        Connection con=db.DbConnection();
        DefaultTableModel tm1=(DefaultTableModel)jTable1.getModel();
               while(tm1.getRowCount()> 0)
               {
                tm1.removeRow(0);
               }
               
        if(searchtype.equals("Date"))
        {

            //searchby=searchbar.getText();

             try{
                String regnum=db.currentuserregnum();
                System.out.println(regnum);
                Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("exec Procedure6 '"+searchby+"','"+db.currentuserregnum()+"'");
            
            int i=0;
            while(rs.next()){
                found=true;
               String id=String.valueOf(i+1);
               String date=rs.getString("date1");
                System.out.println(date);
               String time=rs.getString("time1");
                System.out.println(time);
               String amount=rs.getString("amount");
                System.out.println(amount);
               
               
               String tbtable[]={id,date,time,amount};
               data=tbtable;
               DefaultTableModel tm2=(DefaultTableModel)jTable1.getModel();
               
               tm2.addRow(data);
               i++;
                }

            }
            catch(Exception e){
            }
        }
        else
        {
            try{
                String regnum=db.currentuserregnum();
                System.out.println(regnum);
                Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("exec Procedure7 '"+searchby+"','"+db.currentuserregnum()+"'");
            
            int i=0;
            while(rs.next()){
                found=true;
               String id=String.valueOf(i+1);
               String date=rs.getString("date1");
                System.out.println(date);
               String time=rs.getString("time1");
                System.out.println(time);
               String amount=rs.getString("amount");
                System.out.println(amount);
               
               
               String tbtable[]={id,date,time,amount};
               data=tbtable;
               DefaultTableModel tm2=(DefaultTableModel)jTable1.getModel();
               
               tm2.addRow(data);
               i++;
                }

            }
            catch(Exception e){
            }
        }
               
    return found;
    }
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        BackButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        currentuser = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        SearchComboBox1 = new javax.swing.JComboBox<>();
        searchbar = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        BackButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackButton1.setText("BACK");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FAUX Ticket Reservation");

        currentuser.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        currentuser.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, Short.MAX_VALUE)
                .addComponent(currentuser, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentuser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(730, 339));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Display", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Account Details");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Payment");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, -1));

        combo1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payment", "Login", "Reservation", "Personal" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        jPanel6.add(combo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 130, -1));

        SearchComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Time" }));
        jPanel6.add(SearchComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 130, -1));

        searchbar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        jPanel6.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 120, -1));

        searchbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchbutton.setText("Search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });
        jPanel6.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("NEED HELP!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 930, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Serial #");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 66, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Amount");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setText("Date");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 66, -1));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setText("Time");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 66, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 930, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 850, 180));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 247, 930, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resize invitación.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 1000, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        // TODO add your handling code here:
        InterfaceB ua=jf.getObject2("useraccount");
        ua.back();
        this.dispose();
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
        if(combo1.getSelectedItem().equals("Login"))
        {
            InterfaceA c1=jf.getObject("login");
            c1.x();
            this.dispose();
        }
        else if(combo1.getSelectedItem().equals("Payment"))
        {
            InterfaceA c2=jf.getObject("payment");
            c2.x();
            this.dispose();
        }
        else if(combo1.getSelectedItem().equals("Reservation"))
        {
            InterfaceA c3=jf.getObject("reservation");
            c3.x();
            this.dispose();
        }else
        {
            PersonalDetails p=new PersonalDetails();
            p.setVisible(true);
            this.dispose();
        }
        

    }//GEN-LAST:event_combo1ActionPerformed

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
        String searchtype;
String searchby;
        if(SearchComboBox1.getSelectedItem().equals("Date"))
        {
            searchtype="Date";
        }

        else//time
        {
           searchtype="Time";
        }

        
        searchby=searchbar.getText();
       boolean found=search(searchtype,searchby);
       if(found)
       {
           JOptionPane.showMessageDialog(null,"Search is Successfull");
       }
       else
       {
           JOptionPane.showMessageDialog(null,"NO such data exist");
       }
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        chatbox2 c=new chatbox2();
        c.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton1;
    private javax.swing.JComboBox<String> SearchComboBox1;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel currentuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField searchbar;
    private javax.swing.JButton searchbutton;
    // End of variables declaration//GEN-END:variables
}
