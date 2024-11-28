import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ReserveTicket extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form ReserveTicket
     */
    int fare = 1000;
    int tax = 35;
   // int miles = 0;
    int Tfare = 0;
    int Dtax=0;
    int SubTotal = 0;
    String to = null; 
    String from = null;
    String time; 
    String date; String ticket; String classtype, passengers, seats;
    String username, regnum;
    
    @Override
    public void run(){
        
    }
    public ReserveTicket() {
        initComponents();
        jPanel4.setBackground(new Color (0,0,0,10));
        jPanel5.setBackground(new Color (0,0,0,10));
        jPanel6.setBackground(new Color (0,0,0,10));
       
        this.currentUser();
        this.currentuserregnum();
    }
    
    public void currentUser(){
        //String username;
        Stack s=new Stack();
        DbConnectivity db;
        db=DbConnectivity.getobject();
        Connection con=db.DbConnection();
       
       try
       {
           Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select username from loginDetail");
           
           while(rs.next()){
               
               username=rs.getString(1);
               s.push(username);
           }
           
           currentuser.setText(s.pop());
           System.out.println("currentuser="+username);
       }
       catch(Exception e)
       {}
  
    }
    
    
    public void addPaymentData()
    {
        DbConnectivity db;
        db=DbConnectivity.getobject();
        Connection con=db.DbConnection();
        String time=null,date=null,amount=null;
        
        try
        {
            Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select currentdate,currenttime,amount from Reservation1 where reser_id='"+db.currentreserid()+"'");
           
           while(rs.next()){
               
               date=rs.getString(1);
               time=rs.getString(2);
               amount=rs.getString(3);
           }
           System.out.println(time+" "+date+" "+amount);
           
           PreparedStatement pst=con.prepareStatement("INSERT INTO PaymentStatus(reser_id,payment_status,date1,time1) VALUES (?,?,?,?)");
            pst.setString(1,db.currentreserid());
            pst.setString(2,"paid");
            pst.setString(3,date);
            pst.setString(4,time);
            
            
            pst.executeUpdate();
          con.close();
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
    
    
    
    public String currentuserregnum()
    {
        Stack s=new Stack();
        DbConnectivity db;
        db=DbConnectivity.getobject();
        Connection con=db.DbConnection();
       
       try
       {
           Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select regid from Registration where username='"+username+"'");
           
           while(rs.next()){
               
               regnum=rs.getString(1);
               
           }
           System.out.println("regnum="+regnum);
       }
       catch(Exception e)
       {}
       return regnum;
    }
    
    
    public void book(){
    Thread t1=new Thread (new Runnable(){
               @Override
               public void run()
               {
                 passengers=passengers1.getText();
            int passengers = Integer.parseInt(passengers1.getText());
            passengers1.setText(passengers1.getText());
            
            seats=seat.getText();
            int s = Integer.parseInt(seat.getText());
            if(s>0){
            int a = s - passengers;
            String t = Integer.toString(a);
            seat.setText(t);
            }
            else{
                 JOptionPane.showMessageDialog(null,"Seats Unavailable");
            }
            
            Tfare= (fare*passengers);
            Dtax = (tax*passengers);
            SubTotal = (Dtax + Tfare);
            String Totalfare= String.format("%d",Tfare);
            String DisplayTax = String.format("%d",Dtax);
            String Stotal = String.format("%d",SubTotal);
            total1Field.setText(Totalfare);
            tax1field.setText(DisplayTax);
            SubTotalField1.setText(Stotal);
               }
            });
           t1.start();
    }
    
    
    public void reserve(){
        Thread t=new Thread(new Runnable(){
     @Override
     public void run()
     {
         to = (String) dest1field3.getSelectedItem(); 
        from = (String) depc.getSelectedItem();
           to2.setText(to);
           from2.setText(from);
           
           time = (String) dep1field3.getSelectedItem();
           dep2field1.setText(time);
           
           date = doj1.getDateFormatString();
           doj2.setText(date);
           
           passengers=passengers1.getText();
           passengers2.setText(passengers);
            
           if(SingleButton3.isSelected()){
               ticket="Single";
               tickettype.setText("Single");
           }
           else if(ReturnButton3.isSelected()){
               ticket="Return";
               tickettype.setText("Return");
           }
           
           
            if(EconomyButton3.isSelected()){
                classtype="Economy";
               class2Field1.setText("Economy");
           }
           else if(FirstClassButton3.isSelected()){
               classtype="First Class";
               class2Field1.setText("First Class");
           }
            
           SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            doj2.setText(f.format(doj1.getDate()));
           
       amountpaid2field1.setText(SubTotalField1.getText());
       bus2.setText(bus.getText());
       seat2.setText(passengers);
     }
 });
 
 t.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        doj4 = new javax.swing.JLabel();
        dep4 = new javax.swing.JLabel();
        dest3 = new javax.swing.JLabel();
        ticket_type4 = new javax.swing.JLabel();
        class4 = new javax.swing.JLabel();
        passengers4 = new javax.swing.JLabel();
        dest1field3 = new javax.swing.JComboBox<>();
        dep1field3 = new javax.swing.JComboBox<>();
        SingleButton3 = new javax.swing.JRadioButton();
        ReturnButton3 = new javax.swing.JRadioButton();
        FirstClassButton3 = new javax.swing.JRadioButton();
        EconomyButton3 = new javax.swing.JRadioButton();
        passengers1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        depc = new javax.swing.JComboBox<>();
        doj1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bus = new javax.swing.JTextField();
        seat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        total1 = new javax.swing.JLabel();
        tax1 = new javax.swing.JLabel();
        sub_total1 = new javax.swing.JLabel();
        total1Field = new javax.swing.JTextField();
        tax1field = new javax.swing.JTextField();
        SubTotalField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        passengers2 = new javax.swing.JTextField();
        passengers5 = new javax.swing.JLabel();
        amountpaid2field1 = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        from2 = new javax.swing.JTextField();
        to2 = new javax.swing.JTextField();
        doj2 = new javax.swing.JTextField();
        doj5 = new javax.swing.JLabel();
        dep2field1 = new javax.swing.JTextField();
        tickettype = new javax.swing.JTextField();
        class2Field1 = new javax.swing.JTextField();
        amountpaid3 = new javax.swing.JLabel();
        class5 = new javax.swing.JLabel();
        T_type2 = new javax.swing.JLabel();
        dep5 = new javax.swing.JLabel();
        To3 = new javax.swing.JLabel();
        From3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bus2 = new javax.swing.JTextField();
        seat2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        BackButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        currentuser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        review = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1326, 838));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doj4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        doj4.setForeground(new java.awt.Color(102, 102, 102));
        doj4.setText("DATE OF JOURNEY");

        dep4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dep4.setForeground(new java.awt.Color(102, 102, 102));
        dep4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dep4.setText("DEPARTURE TIME");

        dest3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dest3.setForeground(new java.awt.Color(102, 102, 102));
        dest3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dest3.setText("DESTINATION");

        ticket_type4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ticket_type4.setForeground(new java.awt.Color(102, 102, 102));
        ticket_type4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ticket_type4.setText("TICKET TYPE");

        class4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        class4.setForeground(new java.awt.Color(102, 102, 102));
        class4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        class4.setText("CLASS");

        passengers4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passengers4.setForeground(new java.awt.Color(102, 102, 102));
        passengers4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passengers4.setText("NUMBER OF PASSENGERS");

        dest1field3.setForeground(new java.awt.Color(102, 102, 102));
        dest1field3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lahore", "Peshawar", "Karachi", "Kashmir", "Multan", "Islamabad" }));
        dest1field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dest1field3ActionPerformed(evt);
            }
        });

        dep1field3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dep1field3.setForeground(new java.awt.Color(102, 102, 102));
        dep1field3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:30 am", "6:30 pm", "10:30 pm" }));
        dep1field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dep1field3ActionPerformed(evt);
            }
        });

        SingleButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SingleButton3.setForeground(new java.awt.Color(102, 102, 102));
        SingleButton3.setText("SINGLE");
        SingleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SingleButton3ActionPerformed(evt);
            }
        });

        ReturnButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ReturnButton3.setForeground(new java.awt.Color(102, 102, 102));
        ReturnButton3.setText("RETURN");
        ReturnButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButton3ActionPerformed(evt);
            }
        });

        FirstClassButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FirstClassButton3.setForeground(new java.awt.Color(102, 102, 102));
        FirstClassButton3.setText("FIRST CLASS");
        FirstClassButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstClassButton3ActionPerformed(evt);
            }
        });

        EconomyButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EconomyButton3.setForeground(new java.awt.Color(102, 102, 102));
        EconomyButton3.setText("ECONOMY");

        passengers1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passengers1.setForeground(new java.awt.Color(102, 102, 102));
        passengers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengers1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("DEPARTURE");

        depc.setForeground(new java.awt.Color(102, 102, 102));
        depc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lahore", "Islamabad", "Peshawer", "Kashmir", "Multan" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("BUS AVAILABLE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("SEATS AVAILABLE");

        bus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bus.setForeground(new java.awt.Color(102, 102, 102));
        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });

        seat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seat.setForeground(new java.awt.Color(102, 102, 102));
        seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dest3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(class4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dep1field3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dest1field3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depc, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doj1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirstClassButton3)
                                    .addComponent(SingleButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReturnButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EconomyButton3)))
                            .addComponent(passengers1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doj4)
                            .addComponent(dep4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ticket_type4)
                            .addComponent(passengers4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dest1field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dest3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doj4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(dep4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dep1field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticket_type4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SingleButton3)
                        .addComponent(ReturnButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(class4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EconomyButton3)
                        .addComponent(FirstClassButton3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(passengers4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passengers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 520, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESERVE TICKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 530, 60));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total1.setForeground(new java.awt.Color(102, 102, 102));
        total1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total1.setText("TOTAL");
        jPanel5.add(total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 28, -1, -1));

        tax1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tax1.setForeground(new java.awt.Color(102, 102, 102));
        tax1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tax1.setText("TAX");
        jPanel5.add(tax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 63, -1, -1));

        sub_total1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sub_total1.setForeground(new java.awt.Color(102, 102, 102));
        sub_total1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sub_total1.setText("SUB TOTAL");
        jPanel5.add(sub_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 105, -1, -1));

        total1Field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total1Field.setForeground(new java.awt.Color(102, 102, 102));
        total1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1FieldActionPerformed(evt);
            }
        });
        jPanel5.add(total1Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 29, 185, -1));

        tax1field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tax1field.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.add(tax1field, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 64, 185, -1));

        SubTotalField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubTotalField1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.add(SubTotalField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 106, 185, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, 150));

        jPanel6.setMaximumSize(new java.awt.Dimension(37627, 37627));

        passengers2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passengers2.setForeground(new java.awt.Color(102, 102, 102));
        passengers2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengers2ActionPerformed(evt);
            }
        });

        passengers5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passengers5.setForeground(new java.awt.Color(102, 102, 102));
        passengers5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passengers5.setText("NUMBER OF PASSENGERS");

        amountpaid2field1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountpaid2field1.setForeground(new java.awt.Color(102, 102, 102));
        amountpaid2field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountpaid2field1ActionPerformed(evt);
            }
        });

        confirm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        confirm.setForeground(new java.awt.Color(102, 102, 102));
        confirm.setText("CONFIRM");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(102, 102, 102));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        from2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        from2.setForeground(new java.awt.Color(102, 102, 102));
        from2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                from2ActionPerformed(evt);
            }
        });

        to2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        to2.setForeground(new java.awt.Color(102, 102, 102));
        to2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                to2ActionPerformed(evt);
            }
        });

        doj2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doj2.setForeground(new java.awt.Color(102, 102, 102));
        doj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doj2ActionPerformed(evt);
            }
        });

        doj5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        doj5.setForeground(new java.awt.Color(102, 102, 102));
        doj5.setText("DATE OF JOURNEY");

        dep2field1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dep2field1.setForeground(new java.awt.Color(102, 102, 102));
        dep2field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dep2field1ActionPerformed(evt);
            }
        });

        tickettype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tickettype.setForeground(new java.awt.Color(102, 102, 102));

        class2Field1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        class2Field1.setForeground(new java.awt.Color(102, 102, 102));
        class2Field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class2Field1ActionPerformed(evt);
            }
        });

        amountpaid3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        amountpaid3.setForeground(new java.awt.Color(102, 102, 102));
        amountpaid3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        amountpaid3.setText("AMOUNT PAID");

        class5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        class5.setForeground(new java.awt.Color(102, 102, 102));
        class5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        class5.setText("CLASS");

        T_type2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        T_type2.setForeground(new java.awt.Color(102, 102, 102));
        T_type2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        T_type2.setText("TICKET TYPE");

        dep5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dep5.setForeground(new java.awt.Color(102, 102, 102));
        dep5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dep5.setText("DEPARTURE TIME");

        To3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        To3.setForeground(new java.awt.Color(102, 102, 102));
        To3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        To3.setText("TO");

        From3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        From3.setForeground(new java.awt.Color(102, 102, 102));
        From3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        From3.setText("FROM");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REVIEW PORTAL");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("BUS ALLOTTED");

        bus2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bus2.setForeground(new java.awt.Color(102, 102, 102));

        seat2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seat2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("SEAT(S) BOOKED");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(From3)
                        .addGap(266, 266, 266)
                        .addComponent(from2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(To3)
                        .addGap(294, 294, 294)
                        .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(doj5)
                        .addGap(151, 151, 151)
                        .addComponent(doj2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(dep5)
                        .addGap(157, 157, 157)
                        .addComponent(dep2field1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(T_type2)
                        .addGap(201, 201, 201)
                        .addComponent(tickettype, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(class5)
                        .addGap(263, 263, 263)
                        .addComponent(class2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(passengers5)
                        .addGap(87, 87, 87)
                        .addComponent(passengers2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(amountpaid3)
                        .addGap(187, 187, 187)
                        .addComponent(amountpaid2field1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addComponent(bus2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel9)
                        .addGap(164, 164, 164)
                        .addComponent(seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(From3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(from2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(To3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doj5)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(doj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dep5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dep2field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(T_type2)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(tickettype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(class5))
                            .addComponent(class2Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passengers5)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(passengers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountpaid3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(amountpaid2field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(bus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(seat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirm)
                            .addComponent(exit))
                        .addContainerGap())))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 700, 650));

        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(102, 102, 102));
        submit.setText("BOOK");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 120, -1));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton1.setBackground(new java.awt.Color(255, 255, 255));
        BackButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackButton1.setText("BACK");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(BackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 90, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FAUX Ticket Reservation");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 30));

        currentuser.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        currentuser.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(currentuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 80, 20));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 40));

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("NEED HELP!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, -1, -1));

        review.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        review.setForeground(new java.awt.Color(102, 102, 102));
        review.setText("REVIEW");
        review.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewActionPerformed(evt);
            }
        });
        getContentPane().add(review, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 740, 130, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resize invitación.jpeg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1670, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dest1field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dest1field3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dest1field3ActionPerformed

    private void dep1field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep1field3ActionPerformed
 if(dep1field3.getSelectedItem().equals("8:30 am")){
            bus.setText("SCD 9807");
            seat.setText("40");
        }
 else if(dep1field3.getSelectedItem().equals("6:30 pm")){
     bus.setText("SCD 6754");
     seat.setText("40");
 }
 else if(dep1field3.getSelectedItem().equals("10:30 pm")){
     bus.setText("SCD 0912");
     seat.setText("40");
 }
    }//GEN-LAST:event_dep1field3ActionPerformed

    private void SingleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SingleButton3ActionPerformed

    }//GEN-LAST:event_SingleButton3ActionPerformed

    private void ReturnButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReturnButton3ActionPerformed

    private void FirstClassButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstClassButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstClassButton3ActionPerformed

    private void passengers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengers1ActionPerformed

    }//GEN-LAST:event_passengers1ActionPerformed

    private void total1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total1FieldActionPerformed

    private void passengers2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengers2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passengers2ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        DbConnectivity db;
       db=DbConnectivity.getobject();
       
      Connection con= db.DbConnection();
      // String sql = "exec login ";
       
      try{ 
          
          PreparedStatement pst=con.prepareStatement("INSERT INTO Reservation1(reser_reg_id,depart,dest,depart_date,depart_time,tickettype,class,numofpassengers,currentdate,currenttime,amount) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
          
          System.out.println(this.currentuserregnum());
          pst.setString(1,this.currentuserregnum());
          
          System.out.println(String.valueOf(depc.getSelectedItem()));
          pst.setString(2,String.valueOf(depc.getSelectedItem()));
          
          System.out.println(String.valueOf(dest1field3.getSelectedItem()));
          pst.setString(3,String.valueOf(dest1field3.getSelectedItem()));
          
          SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
         // doj2.setText();
         date=f.format(doj1.getDate());
          
          System.out.println(date);
          pst.setString(4,date);
          
          System.out.println(String.valueOf(dep1field3.getSelectedItem()));
          pst.setString(5,String.valueOf(dep1field3.getSelectedItem()));
          
          
                      
           if(SingleButton3.isSelected()){
               ticket="Single";
               tickettype.setText("Single");
           }
           else if(ReturnButton3.isSelected()){
               ticket="Return";
               tickettype.setText("Return");
           }
           System.out.println(ticket);
           
            if(EconomyButton3.isSelected()){
                classtype="Economy";
               class2Field1.setText("Economy");
           }
           else if(FirstClassButton3.isSelected()){
               classtype="First Class";
               class2Field1.setText("First Class");
           }
          System.out.println(classtype);
          
          pst.setString(6,ticket);
          pst.setString(7,classtype);
          
          System.out.println(passengers1.getText());
          pst.setString(8,passengers1.getText());
          
          
          LocalDate date=java.time.LocalDate.now();
          String date2=String.valueOf(date);
          System.out.println(date2);
          pst.setString(9,date2);
          
          String time=String.valueOf(java.time.LocalTime.now());
          System.out.println(time);
          pst.setString(10,time);
          
          System.out.println(SubTotalField1.getText());
          pst.setString(11,String.valueOf(SubTotalField1.getText()));
          
          pst.executeUpdate();
          
 
         // JOptionPane.showMessageDialog(null,"Your Ticket is Reserved");
          con.close();
          
          addPaymentData();
          
          
       
        JOptionPane.showMessageDialog(null,"Your Ticket is Reserved");
        //this.dispose();
        this.setVisible(true);//resetting the page 
     
      }
      catch(Exception e)
      {
          
      }
    }//GEN-LAST:event_confirmActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void from2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_from2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_from2ActionPerformed

    private void to2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_to2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_to2ActionPerformed

    private void doj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doj2ActionPerformed

    private void class2Field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class2Field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_class2Field1ActionPerformed

    private void reviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewActionPerformed
this.reserve();
    }//GEN-LAST:event_reviewActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
 this.book();    
    }//GEN-LAST:event_submitActionPerformed

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        // TODO add your handling code here:
        Menu m=new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
       
    }//GEN-LAST:event_busActionPerformed

    private void amountpaid2field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountpaid2field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountpaid2field1ActionPerformed

    private void dep2field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep2field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dep2field1ActionPerformed

    private void seatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatActionPerformed

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
            java.util.logging.Logger.getLogger(ReserveTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReserveTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReserveTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReserveTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReserveTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton1;
    private javax.swing.JRadioButton EconomyButton3;
    private javax.swing.JRadioButton FirstClassButton3;
    private javax.swing.JLabel From3;
    private javax.swing.JRadioButton ReturnButton3;
    private javax.swing.JRadioButton SingleButton3;
    private javax.swing.JTextField SubTotalField1;
    private javax.swing.JLabel T_type2;
    private javax.swing.JLabel To3;
    private javax.swing.JTextField amountpaid2field1;
    private javax.swing.JLabel amountpaid3;
    private javax.swing.JTextField bus;
    private javax.swing.JTextField bus2;
    private javax.swing.JTextField class2Field1;
    private javax.swing.JLabel class4;
    private javax.swing.JLabel class5;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel currentuser;
    private javax.swing.JComboBox<String> dep1field3;
    private javax.swing.JTextField dep2field1;
    private javax.swing.JLabel dep4;
    private javax.swing.JLabel dep5;
    private javax.swing.JComboBox<String> depc;
    private javax.swing.JComboBox<String> dest1field3;
    private javax.swing.JLabel dest3;
    private com.toedter.calendar.JDateChooser doj1;
    private javax.swing.JTextField doj2;
    private javax.swing.JLabel doj4;
    private javax.swing.JLabel doj5;
    private javax.swing.JButton exit;
    private javax.swing.JTextField from2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField passengers1;
    private javax.swing.JTextField passengers2;
    private javax.swing.JLabel passengers4;
    private javax.swing.JLabel passengers5;
    private javax.swing.JButton review;
    private javax.swing.JTextField seat;
    private javax.swing.JTextField seat2;
    private javax.swing.JLabel sub_total1;
    private javax.swing.JButton submit;
    private javax.swing.JLabel tax1;
    private javax.swing.JTextField tax1field;
    private javax.swing.JLabel ticket_type4;
    private javax.swing.JTextField tickettype;
    private javax.swing.JTextField to2;
    private javax.swing.JLabel total1;
    private javax.swing.JTextField total1Field;
    // End of variables declaration//GEN-END:variables
}
class Stack{
    int top;
    String  [] arr;
    int size=50;
    
    Stack(){
        arr=new String [size];
        top=-1;
    }
    
    public void push(String data)
    {
        if(top>=arr.length-1)
        {
            System.out.println("stack is full");
        }
        else
        {
            top++;
            arr[top]=data;
            System.out.println("data:"+arr[top]);
        }
    }
    String data;
    public String pop()
    {
        if(top<0){
            System.out.println("stack is empty");
        }
        else
        {
            data=arr[top];
            top--;
        }
        
        return data;
    }
    
    public String peek(){
        return arr[top];
    }
    
    public boolean isEmpty()
    {
        if(top<0){
            return true;
        }
        else
            return false;
    }
    
    public void stackdisplay(){
        for(int i=top;i>=0;i--){
            System.out.println("data="+arr[top]);
        }
    }
}
