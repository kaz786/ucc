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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ritik
 */
public class cr extends javax.swing.JFrame {

    /**
     * Creates new form cr
     */
    public cr() {
        initComponents();
        jTextField1.setVisible(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        reg.requestFocus();
    }
    public void clear()
    {
        reg.requestFocus();
        jTextField1.setText("");
        jTextField2.setText("NAME");
        jTextField3.setText("MOBILE NUMBER");
        jTextField9.setText("EMAIL ID");
        jTextField4.setText("GST NO");
        jTextField5.setText("ACCOUNT NUMBER");
        jTextField6.setText("IFSC CODE");
        jTextField7.setText("BOOKER NAME");
        jTextField8.setText("BOOKER MOBILE NUMBER");
        jTextArea1.setText("ADDRESS");
        //jTextArea2.setText("PERMANENT ADDRESS");
        //jXDatePicker1.setDate(null);
        jTextField1.setForeground(Color.DARK_GRAY);
        jTextField2.setForeground(Color.DARK_GRAY);
        jTextField3.setForeground(Color.DARK_GRAY);
        jTextField4.setForeground(Color.DARK_GRAY);
        jTextField5.setForeground(Color.DARK_GRAY);
        jTextField6.setForeground(Color.DARK_GRAY);
        jTextField7.setForeground(Color.DARK_GRAY);
        jTextField8.setForeground(Color.DARK_GRAY);
        jTextField9.setForeground(Color.DARK_GRAY);
        jTextArea1.setForeground(Color.DARK_GRAY);
        //jTextArea2.setForeground(Color.DARK_GRAY);
        
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
    public void en()
    {
        jTextField1.setForeground(Color.BLACK);
        jTextField2.setForeground(Color.BLACK);
        jTextField3.setForeground(Color.BLACK);
        jTextField4.setForeground(Color.BLACK);
        jTextField5.setForeground(Color.BLACK);
        jTextField6.setForeground(Color.BLACK);
        jTextField7.setForeground(Color.BLACK);
        jTextField8.setForeground(Color.BLACK);
        jTextField9.setForeground(Color.BLACK);
        jTextArea1.setForeground(Color.BLACK);
        //jComboBox1.removeAllItems();
        //jComboBox1.addItem("Choose any one");
        //jTextArea2.setForeground(Color.BLACK);
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
     String sql="select c_id from c_details";
     rs=s.executeQuery(sql);
     while(rs.next())
     {
         jTextField1.setText(String.valueOf(rs.getInt("C_ID")));
         
     }
     int a = Integer.parseInt(jTextField1.getText());
     a=a+1;
     jTextField1.setText(String.valueOf(a));
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
     jComboBox2.addItem("Choose any one");
     
     while(rs.next())
     {
         jComboBox2.addItem(rs.getString("c_name"));
         
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
            String sql="select * from c_details";
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        sear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(217, 30, 24));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setBackground(new java.awt.Color(108, 122, 137));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setText("ID");

        jTextField2.setBackground(new java.awt.Color(108, 122, 137));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setText("NAME");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(108, 122, 137));
        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setText("MOBILE NUMBER");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(108, 122, 137));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("ADDRESS");
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jTextField4.setBackground(new java.awt.Color(108, 122, 137));
        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setText("GST NO");
        jTextField4.setToolTipText("");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(108, 122, 137));
        jTextField5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField5.setText("ACCOUNT NUMBER");
        jTextField5.setToolTipText("");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(108, 122, 137));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Type Of Account", "Saving", "Current", "Other" }));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(108, 122, 137));
        jTextField7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField7.setText("BOOKER NAME");
        jTextField7.setToolTipText("");
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
        jTextField8.setText("BOOKER MOBILE NUMBER");
        jTextField8.setToolTipText("");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });

        Save.setBackground(new java.awt.Color(246, 36, 89));
        Save.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Save.setText("Save");
        Save.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SaveFocusGained(evt);
            }
        });
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveMouseClicked(evt);
            }
        });
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        sear.setBackground(new java.awt.Color(246, 36, 89));
        sear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sear.setText("Search");
        sear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(246, 36, 89));
        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("Update");
        update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateFocusGained(evt);
            }
        });
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
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

        jTextField6.setBackground(new java.awt.Color(108, 122, 137));
        jTextField6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField6.setText("IFSC CODE");
        jTextField6.setToolTipText("");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(108, 122, 137));
        jTextField9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField9.setText("EMAIL ID");
        jTextField9.setToolTipText("");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete)
                    .addComponent(sear))
                .addGap(146, 146, 146))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(sear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update)
                    .addComponent(delete))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Company Registration Form");

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout regLayout = new javax.swing.GroupLayout(reg);
        reg.setLayout(regLayout);
        regLayout.setHorizontalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        regLayout.setVerticalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(reg, "card2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Company Id", "Company Name", "Company Add.", "Company Mob.", "Email ID", "Company Gst", "Company Acc.", "Company Type", "Company Ifsc", "Booker Name", "Booker Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
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
      a.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
    if(jTextField2.getText().matches("NAME") || jTextArea1.getText().matches("ADDRESS") || jTextField3.getText().matches("MOBILE NUMBER")
       || jTextField9.getText().matches("EMAIL ID") || jTextField4.getText().matches("GST NO") 
       || jTextField5.getText().matches("ACCOUNT NUMBER") || jTextField6.getText().matches("IFSC CODE")
       || jTextField7.getText().matches("BOOKER NAME") ||  jTextField7.getText().matches("BOOKER MOBILE NUMBER")
       || jComboBox1.getSelectedItem().toString().matches("Type Of Account")     )
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
            int id=Integer.parseInt(jTextField1.getText());
            String name= jTextField2.getText();
            String add=jTextArea1.getText();
            double mob=Double.parseDouble(jTextField3.getText());
            String gst=jTextField4.getText();
            double acc=Double.parseDouble(jTextField5.getText());
            String ifs=jTextField6.getText();
            String bname=jTextField7.getText();
            double bnum=Double.parseDouble(jTextField8.getText());
            String tacc=jComboBox1.getSelectedItem().toString();
            String em=jTextField9.getText();
            
            String sql="insert into c_details values(?,?,?,?,?,?,?,?,?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,add);
            st.setDouble(4,mob);
            st.setString(5,em);
            st.setString(6,gst);
            st.setDouble(7,acc);
            st.setString(8,tacc);
            st.setString(9,ifs);
            st.setString(10,bname);
            st.setDouble(11,bnum);
            
            
            st.executeUpdate();
            
            try
        {
            URL u = new URL("http://www.google.com");
            URLConnection ca = u.openConnection();
            ca.connect();
            emai.send("vishalagarwal181@gmail.com","17121976",em,"Welcome Email","Welcome"+name+"!!"
                    + " You Our Company Has Been Registered With Us.Your Company Information "
                    + "As Per Your Record is\nCompany Address:-"+add+
                    "\nCompany Address:-"+add+"\nCompany Email:-"+em+
                    "\nCompany Mobile:-"+String.valueOf(mob)+
                    "\nCompany Gst No:-"+gst+
                    "\nCompany Account No:-"+String.valueOf(acc)+
                    "\nType Of Account:-"+tacc+
                    "\nIFSC Code:-"+ifs+
                    "\nBooker Name:-"+bname+
                    "\nBooker Number:-"+String.valueOf(bnum)+
                    "\n\nRegards\nUsha Cars");
            System.out.println("Internet is  connected");
        }
        catch(UnknownHostException ab)
        {
            db(em,"Welcome Email","Welcome"+name+"!!"
                    + " You Our Company Has Been Registered With Us.Your Company Information "
                    + "As Per Your Record is\nCompany Address:-"+add+
                    "\nCompany Address:-"+add+"\nCompany Email:-"+em+
                    "\nCompany Mobile:-"+String.valueOf(mob)+
                    "\nCompany Gst No:-"+gst+
                    "\nCompany Account No:-"+String.valueOf(acc)+
                    "\nType Of Account:-"+tacc+
                    "\nIFSC Code:-"+ifs+
                    "\nBooker Name:-"+bname+
                    "\nBooker Number:-"+String.valueOf(bnum)+
                    "\n\nRegards\nUsha Cars");
            JOptionPane.showMessageDialog(null,"Please Connect to the Internet for sending emails!!!");
        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            
            JOptionPane.showMessageDialog(null,"Data is saved");
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
        
    }         // TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void searActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searActionPerformed

        reg.setVisible(false);
        search.setVisible(true);
        fc();
        dt();        // TODO add your handling code here:
    }//GEN-LAST:event_searActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(jTextField2.getText().matches("NAME") || jTextArea1.getText().matches("ADDRESS") || jTextField3.getText().matches("MOBILE NUMBER")
       || jTextField9.getText().matches("EMAIL ID") || jTextField4.getText().matches("GST NO") 
       || jTextField5.getText().matches("ACCOUNT NUMBER") || jTextField6.getText().matches("IFSC CODE")
       || jTextField7.getText().matches("BOOKER NAME") ||  jTextField7.getText().matches("BOOKER MOBILE NUMBER")
       || jComboBox1.getSelectedItem().toString().matches("Type Of Account")     )
    {
        JOptionPane.showMessageDialog(null,"Information Missing! Data is not updated yet","Error",JOptionPane.ERROR_MESSAGE);
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
            int id=Integer.parseInt(jTextField1.getText());
            String name= jTextField2.getText();
            String add=jTextArea1.getText();
            double mob=Double.parseDouble(jTextField3.getText());
            String gst=jTextField4.getText();
            double acc=Double.parseDouble(jTextField5.getText());
            String ifs=jTextField6.getText();
            String bname=jTextField7.getText();
            double bnum=Double.parseDouble(jTextField8.getText());
            String tacc=jComboBox1.getSelectedItem().toString();
            String em=jTextField9.getText();
            String sql="update c_details set c_name=?,c_add=?,c_mob=?,c_eid=?,c_gst=?,c_acc=?,c_type=?,"
                    + "c_if=?,c_bname=?,c_bnum=? where c_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            
            st.setString(1,name);
            st.setString(2,add);
            st.setDouble(3,mob);
            st.setString(4, em);
            st.setString(5,gst);
            st.setDouble(6,acc);
            st.setString(7,tacc);
            st.setString(8,ifs);
            st.setString(9,bname);
            st.setDouble(10,bnum);
            st.setInt(11,id);
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
        }        // TODO add your handling code here:
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
            int id=Integer.parseInt(jTextField1.getText());

            String sql="delete from c_details where c_id=?";
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
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        en();
        reg.setVisible(true);
        search.setVisible(false);
        update.setEnabled(true);
        delete.setEnabled(true);
        Save.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedrow,0).toString());
        jTextField2.setText(model.getValueAt(selectedrow,1).toString());
        jTextArea1.setText(model.getValueAt(selectedrow,2).toString());
        jTextField3.setText(model.getValueAt(selectedrow,3).toString());
        jTextField9.setText(model.getValueAt(selectedrow,4).toString());
        jTextField4.setText(model.getValueAt(selectedrow,5).toString());
        jTextField5.setText(model.getValueAt(selectedrow,6).toString());
        jComboBox1.setSelectedItem(model.getValueAt(selectedrow,7).toString());
        jTextField6.setText(model.getValueAt(selectedrow,8).toString());
        jTextField7.setText(model.getValueAt(selectedrow,9).toString());
        jTextField8.setText(model.getValueAt(selectedrow,10).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if(jTextField2.getText().trim().equals("NAME"))
        {
            jTextField2.setForeground(Color.BLACK);
            jTextField2.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if(jTextField2.getText().trim().equals(""))
        {
            jTextField2.setForeground(Color.DARK_GRAY);
            jTextField2.setText("NAME");
        }   
        
        else if(jTextField2.getText().length()==1)
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setForeground(Color.DARK_GRAY);
            jTextField2.setText("NAME");
            jTextField2.requestFocus();
            
        }
        else if(jTextField2.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setForeground(Color.DARK_GRAY);
            jTextField2.setText("NAME");
            jTextField2.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        if(jTextArea1.getText().trim().equals("ADDRESS"))
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
            jTextArea1.setText("ADDRESS");
        }
        if(jTextArea1.getText().matches("^[#.0-9a-zA-Z\\s,-]+$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Address","Error",JOptionPane.ERROR_MESSAGE);
            jTextArea1.setForeground(Color.DARK_GRAY);
            jTextArea1.setText("ADDRESS");
            jTextArea1.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        if(jTextField3.getText().trim().equals("MOBILE NUMBER"))
        {
            jTextField3.setForeground(Color.BLACK);
            jTextField3.setText("");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if(jTextField3.getText().trim().equals(""))
        {
            jTextField3.setForeground(Color.DARK_GRAY);
            jTextField3.setText("MOBILE NUMBER");
        }
        //
        else if(jTextField3.getText().matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$"))
        {
            
        }
        else if( jTextField3.getText().matches("MOBILE NUMBER"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Mobile Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField3.setForeground(Color.DARK_GRAY);
            jTextField3.setText("MOBILE NUMBER");
            jTextField3.requestFocus();
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        if(jTextField9.getText().trim().equals("EMAIL ID"))
        {
            jTextField9.setForeground(Color.BLACK);
            jTextField9.setText("");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        if(jTextField9.getText().trim().equals(""))
        {
            jTextField9.setForeground(Color.DARK_GRAY);
            jTextField9.setText("EMAIL ID");
        }
        else if(jTextField9.getText().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"))
        {
            
        }
        else if( jTextField9.getText().matches("EMAIL ID"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Email ID","Error",JOptionPane.ERROR_MESSAGE);
            jTextField9.setForeground(Color.DARK_GRAY);
            jTextField9.setText("EMAIL ID");
            jTextField9.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        if(jTextField4.getText().trim().equals("GST NO"))
        {
            jTextField4.setForeground(Color.BLACK);
            jTextField4.setText("");
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if(jTextField4.getText().trim().equals(""))
        {
            jTextField4.setForeground(Color.DARK_GRAY);
            jTextField4.setText("GST NO");
        }
        //
        else if(jTextField4.getText().matches("^([0][1-9]|[1-2][0-9]|[3][0-5])([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})+$"))
        {
            
        }
        else if( jTextField4.getText().matches("ACCOUNT NUMBER"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid format for GST","Error",JOptionPane.ERROR_MESSAGE);
            jTextField4.setForeground(Color.DARK_GRAY);
            jTextField4.setText("GST NO");
            jTextField4.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        if(jTextField6.getText().trim().equals("IFSC CODE"))
        {
            jTextField6.setForeground(Color.BLACK);
            jTextField6.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if(jTextField6.getText().trim().equals(""))
        {
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("IFSC CODE");
        }
        else if(jTextField6.getText().matches("^[A-Za-z]{4}[a-zA-Z0-9]{7}$"))
        {
            
        }
        else if( jTextField6.getText().matches("IFSC CODE"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid format for IFSC CODE","Error",JOptionPane.ERROR_MESSAGE);
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("IFSC CODE");
            jTextField6.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        if(jTextField5.getText().trim().equals("ACCOUNT NUMBER"))
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
            jTextField5.setText("ACCOUNT NUMBER");
        }
        else if(jTextField5.getText().matches("^\\d{9,18}$"))
        {
            
        }
        else if( jTextField5.getText().matches("ACCOUNT NUMBER"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Account Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField5.setForeground(Color.DARK_GRAY);
            jTextField5.setText("ACCOUNT NUMBER");
            jTextField5.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained

        if(jTextField7.getText().trim().equals("BOOKER NAME"))
        {
            jTextField7.setForeground(Color.BLACK);
            jTextField7.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        if(jTextField7.getText().trim().equals(""))
        {
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("BOOKER NAME");
        }
        else if(jTextField7.getText().length()==1)
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("BOOKER NAME");
            jTextField7.requestFocus();
            
        }
        else if(jTextField7.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("BOOKER NAME");
            jTextField7.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        if(jTextField8.getText().trim().equals("BOOKER MOBILE NUMBER"))
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
            jTextField8.setText("BOOKER MOBILE NUMBER");
        }
        else if(jTextField8.getText().matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$"))
        {
            
        }
        else if( jTextField8.getText().matches("BOOKER MOBILE NUMBER"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Mobile Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField8.setForeground(Color.DARK_GRAY);
            jTextField8.setText("BOOKER MOBILE NUMBER");
            jTextField8.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if(jComboBox2.getSelectedItem().toString().matches("COMPANY NAME"))
        {
            
        }
        else
        {String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs=null;

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

            String roll=jComboBox2.getSelectedItem().toString();
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            c=DriverManager.getConnection(cu,"ritik","ritik");
            String sql="select * from c_details where c_name=?";
            st=c.prepareStatement(sql);
            st.setString(1,roll);
            rs=st.executeQuery();
            
            int i=0;
            while(rs.next())
            {
                jTable1.setValueAt(rs.getInt(1), i, 0);
                jTable1.setValueAt(rs.getString(2), i, 1);
                jTable1.setValueAt(rs.getString(3), i, 2);
                jTable1.setValueAt(rs.getString(4), i, 3);
                jTable1.setValueAt(rs.getString(5), i, 4);
                jTable1.setValueAt(rs.getString(6), i, 5);
                jTable1.setValueAt(rs.getString(7), i, 6);
                jTable1.setValueAt(rs.getString(8), i, 7);
                jTable1.setValueAt(rs.getString(9), i, 8);
                jTable1.setValueAt(rs.getString(10), i, 9);
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
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void SaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SaveFocusGained
       // TODO add your handling code here:
    }//GEN-LAST:event_SaveFocusGained

    private void updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateFocusGained
        
    }//GEN-LAST:event_updateFocusGained

    private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        
        if(jComboBox1.getSelectedItem().toString()=="Type Of Account")
        {
            JOptionPane.showMessageDialog(null,"Please Select Type of Account","Error",JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1FocusLost

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
            java.util.logging.Logger.getLogger(cr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel reg;
    private javax.swing.JButton sear;
    private javax.swing.JPanel search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
