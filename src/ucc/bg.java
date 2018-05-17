
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ritik
 */
public class bg extends javax.swing.JFrame {

    /**
     * Creates new form bg
     */
    public bg() {
        initComponents();
        fc();
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jXDatePicker1.getMonthView().setLowerBound(new Date());
        update.setEnabled(false);
        delete.setEnabled(false);
        jPanel1.requestFocus();
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
     String sql="select b_id from booking";
     rs=s.executeQuery(sql);
     jComboBox5.removeAllItems();
     jComboBox5.addItem("BOOKING ID");
     
     while(rs.next())
     {
         jComboBox5.addItem(rs.getString("b_id"));
         
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
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c=DriverManager.getConnection(cu,"ritik","ritik");
            s=c.createStatement();
            String sql="select * from booking";
            rs1=s.executeQuery(sql);
            int i=0;
            while(rs1.next())
            {
                jTable1.setValueAt(rs1.getInt(1), i, 0);
                jTable1.setValueAt(rs1.getString(2), i, 1);
                jTable1.setValueAt(rs1.getString(3), i, 2);
                jTable1.setValueAt(rs1.getString(4), i, 3);
                jTable1.setValueAt(rs1.getString(5), i, 4);
                jTable1.setValueAt(rs1.getString(6), i, 5);
                jTable1.setValueAt(rs1.getString(7), i, 6);
                jTable1.setValueAt(rs1.getString(8), i, 7);
                jTable1.setValueAt(rs1.getString(9), i, 8);
                jTable1.setValueAt(rs1.getString(10), i, 9);
                jTable1.setValueAt(rs1.getString(11), i, 10);
                jTable1.setValueAt(rs1.getString(12), i, 11);
                jTable1.setValueAt(rs1.getString(13), i, 12);
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
    void fc()
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
     String sql="select c_name from c_details";
     rs=s.executeQuery(sql);
     jComboBox2.removeAllItems();
     jComboBox2.addItem("COMPANY NAME");
     
     while(rs.next())
     {
         jComboBox2.addItem(rs.getString("c_name"));
         
     }
     
     }
     catch(NullPointerException a)
     {
         System.out.println(a);
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
    void c()
    {
         String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs,rs1=null;
        Statement s=null;
        try
        {
            //incr();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            int id=Integer.parseInt(jTextField2.getText());
            String name= jTextField5.getText();
            double cmob=Double.parseDouble(jTextField6.getText());
            String em=jTextField7.getText();
            String sql="insert into customer values(?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
           
            st.setString(1,name);
            st.setDouble(2,cmob);
            st.setString(3,em);
            
            st.executeUpdate();
            //JOptionPane.showMessageDialog(null,"Data is saved");
            
            
            //clear();
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
void incr()
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
     String sql="select b_id from booking";
     rs=s.executeQuery(sql);
     while(rs.next())
     {
         jTextField2.setText(String.valueOf(rs.getInt("b_id")));
         
     }
     int a = Integer.parseInt(jTextField2.getText());
     a=a+1;
     jTextField2.setText(String.valueOf(a));
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
public void clear()
    {
        reg.requestFocus();
        
        jTextField2.setText("BOOKING ID");
        jXDatePicker1.setDate(null);
        jComboBox2.setSelectedItem("COMPANY NAME");
        jComboBox3.setSelectedItem("STATE");
        jComboBox4.setSelectedItem("Type Of Service");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        jTextField3.setText("BOOKER NAME");
        jTextField4.setText("BOOKER MOBILE");
        jTextField5.setText("CUSTOMER NAME");
        jTextField6.setText("CUSTOMER MOBILE");
        jTextField7.setText("CUSTOMER EMAIL ID");
        jTextField8.setText("REPORTING TIME");
        jTextArea2.setText("PICKUP LOCATION");
        jTextArea1.setText("DROP LOCATION");
        jTextField5.setForeground(Color.DARK_GRAY);
        jTextField6.setForeground(Color.DARK_GRAY);
        jTextField7.setForeground(Color.DARK_GRAY);
        jTextField8.setForeground(Color.DARK_GRAY);
        jTextArea1.setForeground(Color.DARK_GRAY);
        jTextArea2.setForeground(Color.DARK_GRAY);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        reg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Save = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox5 = new javax.swing.JComboBox<>();

        jTextField1.setText("BOOKING ID");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(217, 30, 24));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BOOKING GENERATION");

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
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField2.setBackground(new java.awt.Color(108, 122, 137));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("BOOKING ID");

        jXDatePicker1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jXDatePicker1FocusGained(evt);
            }
        });
        jXDatePicker1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXDatePicker1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(217, 30, 24));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Company Information");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTextField3.setBackground(new java.awt.Color(108, 122, 137));
        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setText("BOOKER NAME");

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox2FocusLost(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(108, 122, 137));
        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setText("BOOKER MOBILE");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STATE", "Andaman and Nicobar Islands  ", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh  ", "Chhattisgarh", "Dadra and Nagar Haveli  ", "Daman and Diu  ", "National Capital Territory of Delhi  ", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep  ", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry  ", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal" }));
        jComboBox3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox3FocusLost(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Type Of Service", "Car 4 Seater", "Car 7 Seater", "Luxury Car", "Bus 10 Seater", "Bus 12 Seater", "Bus 18 Seater", "Bus 24 Seater", "Bus 39 Seater", "Bus 42 Seater", "Bus 53 Seater" }));
        jComboBox4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox4FocusLost(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(108, 122, 137));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Guide Required");

        jRadioButton9.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton9.setText("Yes");

        jRadioButton8.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton8.setSelected(true);
        jRadioButton8.setText("No");

        jLabel16.setBackground(new java.awt.Color(108, 122, 137));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Type Of Booking");

        jRadioButton1.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Local");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton2.setText("Outstation");

        jRadioButton3.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton3.setText("Airport Transfer");

        jRadioButton4.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton4.setText("Other");

        jRadioButton5.setBackground(new java.awt.Color(44, 62, 80));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton5.setText("Driver Batta");

        jPanel4.setBackground(new java.awt.Color(217, 30, 24));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CUSTOMER INFORMATION");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField5.setBackground(new java.awt.Color(108, 122, 137));
        jTextField5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(204, 204, 204));
        jTextField5.setText("CUSTOMER NAME");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(108, 122, 137));
        jTextField6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(204, 204, 204));
        jTextField6.setText("CUSTOMER MOBILE");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(108, 122, 137));
        jTextField7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(204, 204, 204));
        jTextField7.setText("CUSTOMER EMAIL ID");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });

        jTextField8.setBackground(new java.awt.Color(108, 122, 137));
        jTextField8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(204, 204, 204));
        jTextField8.setText("REPORTING TIME");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });

        jTextArea2.setBackground(new java.awt.Color(108, 122, 137));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea2.setRows(5);
        jTextArea2.setText("DROP LOCATION");
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea2FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea2);

        jTextArea1.setBackground(new java.awt.Color(108, 122, 137));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setRows(5);
        jTextArea1.setText("PICKUP LOCATION");
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        Save.setBackground(new java.awt.Color(246, 36, 89));
        Save.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Save.setText("Generate Booking");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        search1.setBackground(new java.awt.Color(246, 36, 89));
        search1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        search1.setText("Search");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(246, 36, 89));
        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(246, 36, 89));
        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jRadioButton9)
                        .addGap(29, 29, 29)
                        .addComponent(jRadioButton8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRadioButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton3)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search1)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delete)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Save)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update)
                        .addComponent(search1)
                        .addComponent(delete)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout regLayout = new javax.swing.GroupLayout(reg);
        reg.setLayout(regLayout);
        regLayout.setHorizontalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        regLayout.setVerticalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(reg, "card2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "C_name", "State", "TYS", "GR", "TOB", "NAME", "MOB", "EMAIL", "RT", "PICK", "DROP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOOKING ID" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        getContentPane().add(search, "card3");

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if(jComboBox2.getSelectedItem().toString().matches("COMPANY NAME") ||
        jComboBox3.getSelectedItem().toString().matches("STATE") ||
           jComboBox3.getSelectedItem().toString().matches("Type Of Service")
       || jTextField8.getText().matches("REPORTING TIME") || jTextField5.getText().matches("CUSTOMER NAME") 
       || jTextField6.getText().matches("CUSTOMER MOBILE") || jTextField7.getText().matches("CUSTOMER EMAIL ID")
       || jXDatePicker1.getDate()==null || jTextArea1.getText().matches("PICKUP LOCATION") 
        ||jTextArea2.getText().matches("DROP LOCATION") )
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
            incr();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            int id=Integer.parseInt(jTextField2.getText());
            java.util.Date doj=new java.util.Date();
            doj=jXDatePicker1.getDate();
            java.sql.Date doj1=new java.sql.Date(doj.getTime());
            String cname=jComboBox2.getSelectedItem().toString();
            String state=jComboBox3.getSelectedItem().toString();
            String tos=jComboBox4.getSelectedItem().toString();
            String sta="Open";
            String gr="";
            if(jRadioButton9.isSelected())
            {
                gr=jRadioButton9.getText();
            }
            else if(jRadioButton8.isSelected())
            {
                gr=jRadioButton8.getText();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"As you have not selected the Guide requirement ny default it is no");
                gr=jRadioButton8.getText();
            }
            String tob="";
            if(jRadioButton1.isSelected())
            {
                tob=jRadioButton1.getText();
            }
            else if(jRadioButton2.isSelected())
            {
                tob=jRadioButton2.getText();
            }
            else if(jRadioButton3.isSelected())
            {
                tob=jRadioButton3.getText();
            }
            else if(jRadioButton4.isSelected())
            {
                tob=jRadioButton4.getText();
            }
            else if(jRadioButton5.isSelected())
            {
                tob=jRadioButton5.getText();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Select Type of Booking");
               
            }
            
            
            
            
            
            
            
            String name= jTextField5.getText();
            double cmob=Double.parseDouble(jTextField6.getText());
            String em=jTextField7.getText();
            String rt=jTextField8.getText();
            String padd=jTextArea1.getText();
            String dadd=jTextArea2.getText();
            
            
            String sql="insert into booking values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setInt(1,id);
            st.setDate(2,doj1);
            st.setString(3,cname);
            st.setString(4,state);
            st.setString(5,tos);
            st.setString(6,gr);
            st.setString(7,tob);
            st.setString(8,name);
            st.setDouble(9,cmob);
            st.setString(10,em);
            st.setString(11,rt);
            st.setString(12,padd);
            st.setString(13,dadd);
            st.setString(14,sta);
            st.executeUpdate();
            c();
            
            try
        {
            URL u = new URL("http://www.google.com");
            URLConnection ca = u.openConnection();
            ca.connect();
            emai.send("vishalagarwal181@gmail.com","17121976",em,"Booking Confirmation","Your Booking Id is "+id+".\n"
                    + "Please quote Your Booking id while having conversation with us.\n"
                    +"Your Boking Information as per our Record is as follows:-\n"+
                    "Date of booking "+doj1+"\n"
                    +"Compnay Name "+cname+"\n"+"Customer Name "+name+"\n"+"Customer Mobile "+cmob+"\n"+"Customer Email\n"+em+"\n"+
                    "Pick Up address "+padd+"\n"+
                    "Drop Address "+dadd+"\n"
                    
                    +"Thank You for choosing Ushacars.Have a safe journey.\n"
                    +"You will get the Driver Informartion as the Driver will be allotted.\n"
                    + "\nRegards\nUsha Cars");
            
            System.out.println("Internet is  connected");
        }
        catch(UnknownHostException ab)
        {
            db(em,"Booking Confirmation","Your Booking Id is "+String.valueOf(id)+".\n"
                    + "Please quote Your Booking id while having conversation with us.\n"
                    +"Your Boking Information as per our Record is as follows:-\n"+
                    "Date of booking "+doj1+"\n"
                    +"Compnay Name "+cname+"\n"+"Customer Name "+name+"\n"+"Customer Mobile "+String.valueOf(cmob)+"\n"+"Customer Email\n"+em+"\n"+
                    "Pick Up address "+padd+"\n"+
                    "Drop Address "+dadd+"\n"
                    
                    +"Thank You for choosing Ushacars.Have a safe journey.\n"
                    +"You will get the Driver Informartion as the Driver will be allotted.\n"
                    + "\nRegards\nUsha Cars");
            JOptionPane.showMessageDialog(null,"Please Connect to the Internet for sending emails!!!");
            
        }
         catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            
            
        JOptionPane.showMessageDialog(null,"Booking Generated Your Booking No is"+id);    
            
            clear();
        }

        catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //fc();
        jTable1.repaint();
}// TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        reg.setVisible(false);
        search.setVisible(true);
        fc1();
        dt();
        jXDatePicker1.getMonthView().setLowerBound(null);
        
    }//GEN-LAST:event_search1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
if(jComboBox2.getSelectedItem().toString().matches("COMPANY NAME") ||
        jComboBox3.getSelectedItem().toString().matches("STATE") ||
           jComboBox3.getSelectedItem().toString().matches("Type Of Service")
       || jTextField8.getText().matches("REPORTING TIME") || jTextField5.getText().matches("CUSTOMER NAME") 
       || jTextField6.getText().matches("CUSTOMER MOBILE") || jTextField7.getText().matches("CUSTOMER EMAIL ID")
       || jXDatePicker1.getDate()==null || jTextArea1.getText().matches("PICKUP LOCATION") 
        ||jTextArea2.getText().matches("DROP LOCATION") )
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
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            int id=Integer.parseInt(jTextField2.getText());
            
            java.util.Date doj=new java.util.Date();
            doj=jXDatePicker1.getDate();
            java.sql.Date doj1=new java.sql.Date(doj.getTime());
            String cname=jComboBox2.getSelectedItem().toString();
            String state=jComboBox3.getSelectedItem().toString();
            String tos=jComboBox4.getSelectedItem().toString();
            String gr="";
            if(jRadioButton9.isSelected())
            {
                gr=jRadioButton9.getText();
            }
            else if(jRadioButton8.isSelected())
            {
                gr=jRadioButton8.getText();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"As you have not selected the Guide requirement ny default it is no");
                gr=jRadioButton8.getText();
            }
            String tob="";
            if(jRadioButton1.isSelected())
            {
                tob=jRadioButton1.getText();
            }
            else if(jRadioButton2.isSelected())
            {
                tob=jRadioButton2.getText();
            }
            else if(jRadioButton3.isSelected())
            {
                tob=jRadioButton3.getText();
            }
            else if(jRadioButton4.isSelected())
            {
                tob=jRadioButton4.getText();
            }
            else if(jRadioButton5.isSelected())
            {
                tob=jRadioButton5.getText();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Select Type of Booking");
               
            }
            
            
            
            
            
            
            
            String name= jTextField5.getText();
            double cmob=Double.parseDouble(jTextField6.getText());
            String em=jTextField7.getText();
            String rt=jTextField8.getText();
            String padd=jTextArea1.getText();
            String dadd=jTextArea2.getText();
            String sql="update booking set b_date=?,b_cname=?,b_state=?,b_tys=?,b_gr=?,b_tob=?,b_name=?,b_cmob=?,b_email=?,b_rt=?"
                    + ",b_pick=?,b_drop=?"
                    + " where b_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            
            
            st.setDate(1,doj1);
            st.setString(2,cname);
            st.setString(3,state);
            st.setString(4,tos);
            st.setString(5,gr);
            st.setString(6,tob);
            st.setString(7,name);
            st.setDouble(8,cmob);
            st.setString(9,em);
            st.setString(10,rt);
            st.setString(11,padd);
            st.setString(12,dadd);
            st.setInt(13,id);
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is updated");
            jTable1.repaint();
            //jLabel11.setIcon(null);
            clear();
            update.setEnabled(false);
            delete.setEnabled(false);
            Save.setEnabled(true);
        }
        catch (NumberFormatException a)
        {
            JOptionPane.showMessageDialog(null,"The fields cannot be empty");
            update.setEnabled(false);
            delete.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            for (int i=0;i<model.getRowCount();i++)
            {
                for(int j=0;j<model.getColumnCount();j++)
                {
                    model.setValueAt("",i,j);
                }
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
jXDatePicker1.getMonthView().setLowerBound(new Date());
}           // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    String cu="jdbc:derby:u_cars";
    Connection c=null;
    PreparedStatement st=null;
    ResultSet rs,rs1=null;
    Statement s=null;
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            int id=Integer.parseInt(jTextField2.getText());

            String sql="delete from booking where b_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);

            st.setInt(1,id);
            //ps.setString(2,em);
            //ps.setInt(3,rno);
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is deleted");
            
            
            clear();
            
            update.setEnabled(false);
            delete.setEnabled(false);
            Save.setEnabled(true);
            //jButton1.setEnabled(true);
            jTable1.repaint();
            jTable1.clearSelection();
            
            //fc();
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            for (int i=0;i<model.getRowCount();i++)
            {
                for(int j=0;j<model.getColumnCount();j++)
                {
                    model.setValueAt("",i,j);
                }
            }
            
        }
       
        catch (NumberFormatException a)
        {
            JOptionPane.showMessageDialog(null,"The fields cannot be empty");
            update.setEnabled(false);
            delete.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            for (int i=0;i<model.getRowCount();i++)
            {
                for(int j=0;j<model.getColumnCount();j++)
                {
                    model.setValueAt("",i,j);
                }
            }
        }
         catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
if(jComboBox2.getSelectedItem().toString().matches("COMPANY NAME"))
{
    
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
            String roll=jComboBox2.getSelectedItem().toString();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql="select * from c_details where c_name=?";
            st=c.prepareStatement(sql);
            st.setString(1, roll);
            rs=st.executeQuery();
            
                  
    if(rs.next())
    {
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField3.setText(rs.getString(10));
        jTextField4.setText(rs.getString(11));
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
}       // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        if(jComboBox5.getSelectedItem().toString().matches("BOOKING ID"))
        {
            
        }
        
        else
        {String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs1=null;

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int i=0;i<model.getRowCount();i++)
        {
            for(int j=0;j<model.getColumnCount();j++)
            {
                model.setValueAt("",i,j);
            }
        }
        jTable1.clearSelection();
        
        try
        {

            String roll=jComboBox5.getSelectedItem().toString();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql="select * from booking where b_id=?";
            st=c.prepareStatement(sql);
            st.setString(1,roll);
            rs1=st.executeQuery();
            
            int i=0;
            while(rs1.next())
            {
                jTable1.setValueAt(rs1.getInt(1), i, 0);
                jTable1.setValueAt(rs1.getString(2), i, 1);
                jTable1.setValueAt(rs1.getString(3), i, 2);
                jTable1.setValueAt(rs1.getString(4), i, 3);
                jTable1.setValueAt(rs1.getString(5), i, 4);
                jTable1.setValueAt(rs1.getString(6), i, 5);
                jTable1.setValueAt(rs1.getString(7), i, 6);
                jTable1.setValueAt(rs1.getString(8), i, 7);
                jTable1.setValueAt(rs1.getString(9), i, 8);
                jTable1.setValueAt(rs1.getString(10), i, 9);
                jTable1.setValueAt(rs1.getString(11), i, 10);
                jTable1.setValueAt(rs1.getString(12), i, 11);
                jTable1.setValueAt(rs1.getString(13), i, 12);
                i++;

            }

        }
        /* catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Please select a name for searching");
        }*/
        catch(SQLException ab)
        {
            JOptionPane.showMessageDialog(null,ab.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try
        {
            reg.setVisible(true);
        
        search.setVisible(false);
        update.setEnabled(true);
        delete.setEnabled(true);
        Save.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField2.setText(model.getValueAt(selectedrow,0).toString());
        String a = model.getValueAt(selectedrow,1).toString();
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(a);
        jXDatePicker1.setDate(d);
        jComboBox2.setSelectedItem(model.getValueAt(selectedrow,2).toString());
        jComboBox3.setSelectedItem(model.getValueAt(selectedrow,3).toString());
        jComboBox4.setSelectedItem(model.getValueAt(selectedrow,4).toString());
        String gr = model.getValueAt(selectedrow,5).toString();
        if(gr.equals("Yes"))
        {
            jRadioButton9.setSelected(true);
        }
        else
        {
            jRadioButton8.setSelected(true);
        }
        String ty=model.getValueAt(selectedrow,6).toString();
        if(ty.equals("Local"))
        {
            jRadioButton1.setSelected(true);
        }
        else if(ty.equals("Outstation"))
        {
            jRadioButton2.setSelected(true);
        }
        else if(ty.equals("Airport Transfer"))
        {
            jRadioButton3.setSelected(true);
        }
        else if(ty.equals("Other"))
        {
            jRadioButton4.setSelected(true);
        }
        else
        {
            jRadioButton5.setSelected(true);
        }
        jTextField5.setText(model.getValueAt(selectedrow,7).toString());
        jTextField6.setText(model.getValueAt(selectedrow,8).toString());
        jTextField7.setText(model.getValueAt(selectedrow,9).toString());
        jTextField8.setText(model.getValueAt(selectedrow,10).toString());
        jTextArea2.setText(model.getValueAt(selectedrow,11).toString());
        jTextArea1.setText(model.getValueAt(selectedrow,12).toString());
        
        }
        catch (ParseException ex) {
        Logger.getLogger(dr.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jXDatePicker1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXDatePicker1FocusGained
      // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1FocusGained

    private void jXDatePicker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXDatePicker1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1MouseClicked

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
         if(jTextField5.getText().trim().equals("CUSTOMER NAME"))
        {
            jTextField5.setForeground(Color.BLACK);
            jTextField5.setText("");
        }   
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        if(jTextField5.getText().trim().equals(""))
        {
            jTextField5.setForeground(Color.DARK_GRAY);
            jTextField5.setText("CUSTOMER NAME");
        }
        else if(jTextField5.getText().length()==1)
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField5.setForeground(Color.DARK_GRAY);
            jTextField5.setText("CUSTOMER NAME");
            jTextField5.requestFocus();
            
        }
        else if(jTextField5.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField5.setForeground(Color.DARK_GRAY);
            jTextField5.setText("CUSTOMER NAME");
            jTextField5.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        if(jTextField6.getText().trim().equals("CUSTOMER MOBILE"))
        {
            jTextField6.setForeground(Color.BLACK);
            jTextField6.setText("");
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if(jTextField6.getText().trim().equals(""))
        {
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("CUSTOMER MOBILE");
        } 
        else if(jTextField6.getText().matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$"))
        {
            
        }
        else if( jTextField6.getText().matches("CUSTOMER MOBILE"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Mobile Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("CUSTOMER MOBILE");
            jTextField6.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        if(jTextField7.getText().trim().equals("CUSTOMER EMAIL ID"))
        {
            jTextField7.setForeground(Color.BLACK);
            jTextField7.setText("");
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        if(jTextField7.getText().trim().equals(""))
        {
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("CUSTOMER EMAIL ID");
        }
        else if(jTextField7.getText().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"))
        {
            
        }
        else if( jTextField7.getText().matches("CUSTOMER EMAIL ID"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Email ID","Error",JOptionPane.ERROR_MESSAGE);
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("CUSTOMER EMAIL ID");
            jTextField7.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        if(jTextField8.getText().trim().equals("REPORTING TIME"))
        {
            jTextField8.setForeground(Color.BLACK);
            jTextField8.setText("");
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusGained

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        if(jTextField8.getText().trim().equals(""))
        {
            jTextField8.setForeground(Color.DARK_GRAY);
            jTextField8.setText("REPORTING TIME");
        }
        else if(jTextField8.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
        {
            
        }
        else if( jTextField8.getText().matches("REPORTING TIME"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid time Ex 10:20","Error",JOptionPane.ERROR_MESSAGE);
           jTextField8.setForeground(Color.DARK_GRAY);
            jTextField8.setText("REPORTING TIME");
            jTextField8.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        if(jTextArea1.getText().trim().equals("PICKUP LOCATION"))
        {
            jTextArea1.setForeground(Color.BLACK);
            jTextArea1.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost

        if(jTextArea1.getText().trim().equals(""))
        {
            jTextArea1.setForeground(Color.DARK_GRAY);
            jTextArea1.setText("PICKUP LOCATION");
        }
        if(jTextArea1.getText().matches("^[#.0-9a-zA-Z\\s,-]+$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Pickup Address","Error",JOptionPane.ERROR_MESSAGE);
            jTextArea1.setForeground(Color.DARK_GRAY);
            jTextArea1.setText("PICKUP LOCATION");
            jTextArea1.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextArea2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusGained
        if(jTextArea2.getText().trim().equals("DROP LOCATION"))
        {
            jTextArea2.setForeground(Color.BLACK);
            jTextArea2.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusGained

    private void jTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusLost
        if(jTextArea2.getText().trim().equals(""))
        {
            jTextArea2.setForeground(Color.DARK_GRAY);
            jTextArea2.setText("DROP LOCATION");
        }
        else if(jTextArea2.getText().matches("^[#.0-9a-zA-Z\\s,-]+$"))
        {
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid drop location","Error",JOptionPane.ERROR_MESSAGE);
            jTextArea2.setForeground(Color.DARK_GRAY);
            jTextArea2.setText("DROP LOCATION");
            jTextArea2.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusLost

    private void jComboBox2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusGained
        if(jXDatePicker1.getDate()==null)
            {
              JOptionPane.showMessageDialog(null,"Please Enter The DATE OF BOOKING");
              jXDatePicker1.requestFocus();  
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2FocusGained

    private void jComboBox2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusLost
        if(jComboBox2.getSelectedItem().toString().matches("COMPANY NAME"))
        {
            JOptionPane.showMessageDialog(null,"Please select the Company Name");
              jComboBox2.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2FocusLost

    private void jComboBox3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox3FocusLost
        if(jComboBox3.getSelectedItem().toString().matches("STATE"))
        {
            JOptionPane.showMessageDialog(null,"Please select the State");
              jComboBox3.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3FocusLost

    private void jComboBox4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox4FocusLost
        if(jComboBox4.getSelectedItem().toString().matches("Type Of Service"))
        {
            JOptionPane.showMessageDialog(null,"Please select the type of service");
              jComboBox4.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4FocusLost

    
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
            java.util.logging.Logger.getLogger(bg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel reg;
    private javax.swing.JPanel search;
    private javax.swing.JButton search1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}