/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucc;

import java.awt.Color;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ritik
 */
public class assign extends javax.swing.JFrame {

    /**
     * Creates new form assign
     */
    public assign() {
        initComponents();
        fc1();
        dt();
        jPanel1.requestFocus();
        jTextField2.setEnabled(false);
        jTextField1.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
    }
    public void db(String em,String subj,String cont)
    {
        String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs,rs1=null;
        Statement s=null;
        try
        {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String sql="insert into p_email values(?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setString(1,em);
            st.setString(2,subj);
            st.setString(3,cont);
            st.executeUpdate();
    }
        catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void em()
            {
                String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st,st1,st2=null;
    ResultSet rs,rs1,rs2=null;
    Statement s=null;
            try
    {
            int id=Integer.parseInt(jTextField2.getText());
            String id1=jComboBox2.getSelectedItem().toString();
            String id2=jTextField4.getText();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql="select * from booking where b_id=?";
            
            st=c.prepareStatement(sql);
            st.setInt(1,id);
            rs=st.executeQuery();
            if(rs.next())
    {
        
        jTextField1.setText(rs.getString(10));
        jTextField4.setText(rs.getString(3));
    }
            
    }
           
    catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            }
    public void em1()
    
            {
                String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st,st1,st2=null;
    ResultSet rs,rs1,rs2=null;
    Statement s=null;
            try
    {
            String id=jComboBox2.getSelectedItem().toString();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql1="select * from d_ddetails where d_name=?";
            
            st1=c.prepareStatement(sql1);
            
            st1.setString(1,id);
            
          
            rs=st1.executeQuery();
           
            
                  
    if(rs.next())
    {
        
        jTextField3.setText(rs.getString(4));
        jTextField5.setText(rs.getString(3));
    }
    
    }
           
    catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            }
    public void em2()
            {
                String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st,st1,st2=null;
    ResultSet rs,rs1,rs2=null;
    Statement s=null;
            try
    {
            String id2=jTextField4.getText();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql2="select * from c_details where c_name=?";
            
            st2=c.prepareStatement(sql2);
            
            st2.setString(1,id2);
            
          
            rs2=st2.executeQuery();
           
            
                  
    if(rs2.next())
    {
        
        jTextField4.setText(rs2.getString(5));
    }
    
    }
           
    catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            }
    public void dt()
    {
        String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st=null;
    ResultSet rs,rs1=null;
    Statement s=null;
        try
        {
            
            LocalDate a = LocalDate.now().plusDays(7);
            DateTimeFormatter b =DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String d =(a).format(b);
            LocalDate ab = LocalDate.now();
            String de =(ab).format(b);
            String sta="Open";
            //jLabel1.setText("Booking For The Date Between "+de+" to "+d);
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            String sql="select * from booking where b_date>=? and b_date<=? and b_status=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setString(1,de);
            st.setString(2,d);
            st.setString(3,sta);
            
            rs1=st.executeQuery();
            int i=0;
            while(rs1.next())
            {
                jTable1.setValueAt(rs1.getInt(1), i, 0);
                jTable1.setValueAt(rs1.getString(8), i, 1);
                jTable1.setValueAt(rs1.getString(9), i, 2);
                jTable1.setValueAt(rs1.getString(14), i, 3);
                i++;
                
                
               
                
            }
            jTable1.repaint();
            
        }
    catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            }
 void fc1()
    {
        String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st=null;
    ResultSet rs,rs1=null;
    Statement s=null;
     try
     {
        
    
     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
     c=DriverManager.getConnection(cu,"ritik","ritik");
     s=c.createStatement();
     String sql="select d_name from d_ddetails";
     rs=s.executeQuery(sql);
     jComboBox2.removeAllItems();
     jComboBox2.addItem("Driver Name");
     
     while(rs.next())
     {
         jComboBox2.addItem(rs.getString("d_name"));
         
     }
     
     }
        catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        search1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(217, 30, 24));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASSIGN BOOKING");

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jTextField2.setBackground(new java.awt.Color(108, 122, 137));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("BOOKING ID");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DRIVER NAME" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        search1.setBackground(new java.awt.Color(246, 36, 89));
        search1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        search1.setText("Assign Booking");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Booking Id", "Customer Name", "Customer Mobile", "Booking Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField1");

        jTextField4.setText("jTextField1");

        jTextField5.setText("jTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(search1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        this.setVisible(false);
        main a = new main();
        a.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        if(jTextField2.getText().matches("BOOKING ID")
                || jComboBox2.getSelectedItem().toString().matches("DRIVER NAME"))
        {
            JOptionPane.showMessageDialog(null,"Information Missing! Data is not saved yet","Error",JOptionPane.ERROR_MESSAGE);
        }
else
        {   
        String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs,rs1=null;
        Statement s=null;
       try
       {
           em();
           em1();
           em2();
           
           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           String sta="Assigned to "+jComboBox2.getSelectedItem().toString();
           String sql="update booking set b_status=?  where b_id=?";
           int id=Integer.parseInt(jTextField2.getText());
           c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setString(1,sta);
            st.setInt(2,id);
            st.execute();
            
           JOptionPane.showMessageDialog(null,"Your Booking is assigned");
            try
        {
            URL u = new URL("http://www.google.com");
            URLConnection ca = u.openConnection();
            
            ca.connect();
            String d = jTextField1.getText();
            String e = jTextField3.getText();
            String f = jTextField4.getText();
            String com = d+","+e+","+f;
            emai.send("vishalagarwal181@gmail.com","17121976",com,"Booking Assigned","Your Booking id is "+id+" .\n"
                    + " You Booking is alloted"
                    + " Your Driver Number is "+jTextField5.getText()
                    + " Driver Will Contact you Shortly.\n\nRegards\nUsha Cars");
            
            System.out.println("Internet is  connected");
        }
        catch(UnknownHostException ab)
        {
            String d = jTextField1.getText();
            String e = jTextField3.getText();
            String f = jTextField4.getText();
            String com = d+","+e+","+f;
            db(com,"Booking Assigned","Your Booking id is "+id+" .\n"
                    + " You Booking is alloted"
                    + " Your Driver Number is "+jTextField5.getText()
                    + " Driver Will Contact you Shortly.\n\nRegards\nUsha Cars");
            JOptionPane.showMessageDialog(null,"Please Connect to the Internet for sending emails!!!");
        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
           
           jTable1.repaint();
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            for (int i=0;i<model.getRowCount();i++)
            {
                for(int j=0;j<model.getColumnCount();j++)
                {
                    model.setValueAt("",i,j);
                }
            }
            dt();
            fc1();
           
            jTextField2.setText("BOOKING ID");
       }
       catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_search1ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if(jTextField2.getText().trim().equals("BOOKING ID"))
        {
            jTextField2.setForeground(Color.BLACK);
            jTextField2.setText("");
        }   
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if(jTextField2.getText().trim().equals(""))
        {
            jTextField2.setForeground(Color.DARK_GRAY);
            jTextField2.setText("BOOKING ID");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField2.setText(model.getValueAt(selectedrow,0).toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(assign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton search1;
    // End of variables declaration//GEN-END:variables
}
