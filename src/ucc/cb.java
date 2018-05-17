/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucc;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ritik
 */
public class cb extends javax.swing.JFrame {

    /**
     * Creates new form cb
     */
    public cb() {
        initComponents();
        jTextField9.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);
        jTextField15.setEnabled(false);
        jTextField1.setVisible(false);
        fc();
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
            String sql="select * from bp";
            rs1=s.executeQuery(sql);
            int i=0;
            while(rs1.next())
            {
                jTable1.setValueAt(rs1.getInt(1), i, 0);
                jTable1.setValueAt(rs1.getString(2), i, 1);
                
                jTable1.setValueAt(rs1.getString(6), i, 2);
                
                jTable1.setValueAt(rs1.getString(11), i, 3);
                
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
        
    String de = "Open";
    String d = "Close";
     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
     c=DriverManager.getConnection(cu,"ritik","ritik");
     
     String sql="select b_id from booking where b_status!=? and b_status!=?";
     c=DriverManager.getConnection(cu,"ritik","ritik");
     st=c.prepareStatement(sql);
     st.setString(1,de);
     st.setString(2,d);
     rs=st.executeQuery();
     jComboBox1.removeAllItems();
     jComboBox1.addItem("BOOKING ID");
     
     while(rs.next())
     {
         jComboBox1.addItem(rs.getString("b_id"));
         
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
public void clear()
    {
        reg.requestFocus();
        jTextField1.setText("");
        jTextField3.setText("START KM");
        jTextField4.setText("ENDING KM");
        jTextField7.setText("EXTRA KM");
        jTextField9.setText("TOTAL KM");
        jTextField11.setText("OTHER");
        jTextField12.setText("TOLL & PARKING");
        jTextField13.setText("PRICE");
        jTextField14.setText("GST 5%");
        jTextField15.setText("TOTAL PRICE");
        
        //jTextArea2.setText("PERMANENT ADDRESS");
        //jXDatePicker1.setDate(null);
        jTextField1.setForeground(Color.DARK_GRAY);
        jTextField3.setForeground(Color.DARK_GRAY);
        jTextField4.setForeground(Color.DARK_GRAY);
        jTextField7.setForeground(Color.DARK_GRAY);
        jTextField9.setForeground(Color.DARK_GRAY);
        jTextField11.setForeground(Color.DARK_GRAY);
        jTextField12.setForeground(Color.DARK_GRAY);
        jTextField13.setForeground(Color.DARK_GRAY);
        jTextField14.setForeground(Color.DARK_GRAY);
        jTextField15.setForeground(Color.DARK_GRAY);
        jComboBox1.removeAllItems();
        jComboBox1.addItem("BOOKING ID");
        fc();
        //jTextArea2.setForeground(Color.DARK_GRAY);
        
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
     String sql="select b_no from bp";
     rs=s.executeQuery(sql);
     jComboBox2.removeAllItems();
     jComboBox2.addItem("BILL NO");
     
     while(rs.next())
     {
         jComboBox2.addItem(rs.getString("b_no"));
         
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

        reg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        reg.setBackground(new java.awt.Color(217, 30, 24));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setForeground(new java.awt.Color(44, 62, 80));

        jTextField3.setBackground(new java.awt.Color(108, 122, 137));
        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setText("START KM");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(108, 122, 137));
        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.setText("ENDING KM");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(108, 122, 137));
        jTextField7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(204, 204, 204));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField7.setText("EXTRA KM");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(108, 122, 137));
        jTextField9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(204, 204, 204));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField9.setText("TOTAL KM");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jTextField11.setBackground(new java.awt.Color(108, 122, 137));
        jTextField11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(204, 204, 204));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField11.setText("OTHERS");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jTextField12.setBackground(new java.awt.Color(108, 122, 137));
        jTextField12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(204, 204, 204));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField12.setText("TOLL & PARKING");
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jTextField13.setBackground(new java.awt.Color(108, 122, 137));
        jTextField13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(204, 204, 204));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField13.setText("PRICE");
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField13FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField13FocusLost(evt);
            }
        });
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jTextField14.setBackground(new java.awt.Color(108, 122, 137));
        jTextField14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(204, 204, 204));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField14.setText("GST 5%");
        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField14FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jTextField15.setBackground(new java.awt.Color(108, 122, 137));
        jTextField15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(204, 204, 204));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField15.setText("TOTAL PRICE");
        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField15FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOOKING ID" }));

        Save.setBackground(new java.awt.Color(246, 36, 89));
        Save.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Save.setText("Save");
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

        jTextField1.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Save)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(search1)
                                .addGap(52, 52, 52)
                                .addComponent(update))
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Save)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update)
                        .addComponent(search1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILL PREPARATION");

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout regLayout = new javax.swing.GroupLayout(reg);
        reg.setLayout(regLayout);
        regLayout.setHorizontalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(regLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8))
        );
        regLayout.setVerticalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(reg, "card2");

        search.setPreferredSize(new java.awt.Dimension(407, 345));

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
                "Bill No", "Booking Id", "Total Km", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setViewportView(jTable1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BILL NO" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        a.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        
        
        if(jTextField3.getText().trim().equals("START KM"))
        {
            jTextField3.setForeground(Color.BLACK);
            jTextField3.setText("");
            
        }
        if(jComboBox1.getSelectedItem().toString().matches("BOOKING ID"))
        {
            JOptionPane.showMessageDialog(null,"Please Select Booking Id","Error",JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if(jTextField3.getText().trim().equals(""))
        {
            jTextField3.setForeground(Color.DARK_GRAY);
            jTextField3.setText("START KM");
            
        }
        else if(jTextField3.getText().matches(".*[0-9].*"))
        {
            
        }
        else if( jTextField3.getText().matches("START KM"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid  Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField3.setForeground(Color.DARK_GRAY);
            jTextField3.setText("START KM");
            jTextField3.requestFocus();
            }
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
         if(jTextField4.getText().trim().equals("ENDING KM"))
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
            jTextField4.setText("ENDING KM");
            
        }
       else if(jTextField4.getText().matches(".*[0-9].*"))
        {
            
        }
        else if( jTextField4.getText().matches("ENDING KM"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid  Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField4.setForeground(Color.DARK_GRAY);
            jTextField4.setText("ENDING KM");
            jTextField4.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
         if(jTextField7.getText().trim().equals("EXTRA KM"))
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
            jTextField7.setText("EXTRA KM");
            
        }
         else if(jTextField7.getText().matches(".*[0-9].*"))
        {
            
        }
        else if( jTextField7.getText().matches("EXTRA KM"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid  Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("EXTRA KM");
            jTextField7.requestFocus();
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        if(jTextField11.getText().trim().equals("OTHERS"))
        {
            jTextField11.setForeground(Color.BLACK);
            jTextField11.setText("");
            
        }
        int sk = Integer.parseInt(jTextField3.getText());
        int ek = Integer.parseInt(jTextField4.getText());
        int ex = Integer.parseInt(jTextField7.getText());
        int tk = ek-sk;
        tk=tk+ex;
        jTextField9.setText(String.valueOf(tk));
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
    if(jTextField11.getText().trim().equals(""))
        {
            jTextField11.setForeground(Color.DARK_GRAY);
            jTextField11.setText("OTHERS");
            
        }
    else if(jTextField11.getText().matches(".*[0-9].*"))
        {
            
        }
        else if( jTextField11.getText().matches("OTHERS"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid  Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField11.setForeground(Color.DARK_GRAY);
            jTextField11.setText("OTHERS");
            jTextField11.requestFocus();
            }
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        if(jTextField12.getText().trim().equals("TOLL & PARKING"))
        {
            jTextField12.setForeground(Color.BLACK);
            jTextField12.setText("");
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusGained

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
       if(jTextField12.getText().trim().equals(""))
        {
            jTextField12.setForeground(Color.DARK_GRAY);
            jTextField12.setText("TOLL & PARKING");
            
        }
        else if(jTextField12.getText().matches(".*[0-9].*"))
        {
           int a = Integer.parseInt(jTextField9.getText());
       a=a*18;
       int p = a + Integer.parseInt(jTextField11.getText());
       jTextField13.setText(String.valueOf(p));
       float g = (p*5)/100;
       int t = Integer.parseInt(jTextField12.getText());
       jTextField14.setText(String.valueOf(g));
       jTextField15.setText(String.valueOf(p+g+t)); 
        }
        else if( jTextField12.getText().matches("TOLL & PARKING"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid  Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField12.setForeground(Color.DARK_GRAY);
            jTextField12.setText("TOLL & PARKING");
            jTextField12.requestFocus();
       
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusLost

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13FocusGained

    private void jTextField13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13FocusLost

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusGained

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusLost

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField15FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusGained

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusLost

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyPressed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyReleased

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyTyped
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
     String sql="select b_no from bp";
     rs=s.executeQuery(sql);
     while(rs.next())
     {
         jTextField1.setText(String.valueOf(rs.getInt("b_no")));
         
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
public void stau()
{
    String cu="jdbc:derby:u_cars";
        Connection c=null;
        PreparedStatement st=null;
        ResultSet rs,rs1=null;
        Statement s=null;        
    try{
            String sta="Close";
            String sql1="update booking set b_status=?  where b_id=?";
            int idd=Integer.parseInt(jComboBox1.getSelectedItem().toString());
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql1);
            st.setString(1,sta);
            st.setInt(2,idd);
            st.execute();
            jComboBox1.removeAllItems();
            
            fc();
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
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
if(jTextField3.getText().matches("START KM") ||jTextField3.getText().matches("ENDING KM")
        ||jTextField7.getText().matches("START KM") || jTextField11.getText().matches("OTHERS")
        || jTextField12.getText().matches("TOLL & PARKING") )
{
    JOptionPane.showMessageDialog(null,"Information Missing! Data is not saved yet","Error",JOptionPane.ERROR_MESSAGE);
}
else{        
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
            double bid =Double.parseDouble(jComboBox1.getSelectedItem().toString());
            double sk=Double.parseDouble(jTextField3.getText());
            double ek=Double.parseDouble(jTextField4.getText());
            double ex=Double.parseDouble(jTextField7.getText());
            double tk=Double.parseDouble(jTextField9.getText());
            double ot=Double.parseDouble(jTextField11.getText());
            double tp=Double.parseDouble(jTextField12.getText());
            double pr=Double.parseDouble(jTextField13.getText());
            double gst=Double.parseDouble(jTextField14.getText());
            double tpr=Double.parseDouble(jTextField15.getText());
           
            String sql="insert into bp values(?,?,?,?,?,?,?,?,?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setInt(1,id);
            st.setDouble(2,bid);
            st.setDouble(3,sk);
            st.setDouble(4,ek);
            st.setDouble(5,ex);
            st.setDouble(6,tk);
            st.setDouble(7,ot);
            st.setDouble(8,tp);
            st.setDouble(9,pr);
            st.setDouble(10,gst);
            st.setDouble(11,tpr);
            st.executeUpdate();

            stau();
            JOptionPane.showMessageDialog(null,"Bill is generated");
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
}   //fc();
        //jTable1.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        reg.setVisible(false);
        search.setVisible(true);
        fc1();
        dt();
    }//GEN-LAST:event_search1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(jTextField3.getText().matches("START KM") ||jTextField3.getText().matches("ENDING KM")
        ||jTextField7.getText().matches("START KM") || jTextField11.getText().matches("OTHERS")
        || jTextField12.getText().matches("TOLL & PARKING") )
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
            int id=Integer.parseInt(jTextField1.getText());
            double bid =Double.parseDouble(jComboBox1.getSelectedItem().toString());
            double sk=Double.parseDouble(jTextField3.getText());
            double ek=Double.parseDouble(jTextField4.getText());
            double ex=Double.parseDouble(jTextField7.getText());
            double tk=Double.parseDouble(jTextField9.getText());
            double ot=Double.parseDouble(jTextField11.getText());
            double tp=Double.parseDouble(jTextField12.getText());
            double pr=Double.parseDouble(jTextField13.getText());
            double gst=Double.parseDouble(jTextField14.getText());
            double tpr=Double.parseDouble(jTextField15.getText());
            String sql="update bp set bid=?,skm=?,"
                    + "ekm=?,ex=?,tkm=?,othe=?,"
                    + "tp=?,pri=?,gst=?,ttp=? where b_no=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            
            st.setDouble(1,bid);
            st.setDouble(2,sk);
            st.setDouble(3,ek);
            st.setDouble(4,ex);
            st.setDouble(5,tk);
            st.setDouble(6,ot);
            st.setDouble(7,tp);
            st.setDouble(8,pr);
            st.setDouble(9,gst);
            st.setDouble(10,tpr);
            st.setInt(11,id);
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is updated");
            jTable1.repaint();
            //jLabel11.setIcon(null);
            clear();
            update.setEnabled(false);
            //delete.setEnabled(false);
            Save.setEnabled(true);
        }
        catch (NumberFormatException a)
        {
            JOptionPane.showMessageDialog(null,"The fields cannot be empty");
            update.setEnabled(false);
            
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
        
        }   // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String cu="jdbc:derby:u_cars";
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
            String sql="select * from bp where b_no=?";
            st=c.prepareStatement(sql);
            st.setString(1,roll);
            rs=st.executeQuery();
            
            int i=0;
            while(rs.next())
            {
                jTable1.setValueAt(rs.getInt(1), i, 0);
                jTable1.setValueAt(rs.getString(2), i, 1);
                
                jTable1.setValueAt(rs.getString(6), i, 2);
                
                jTable1.setValueAt(rs.getString(11), i, 3);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged
public void  load()
    {
        try
        {
            String connectionURL="jdbc:derby:u_cars";
            Connection connection=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        
           connection=DriverManager.getConnection(connectionURL,"ritik","ritik");
         
           String sql="select * from bp where b_no=?";
           ps=connection.prepareStatement(sql);
           ps.setString(1,jTextField1.getText());
           rs=ps.executeQuery();
           if(rs.next())
           {    
           jTextField3.setText(rs.getString(3));
           jTextField4.setText(rs.getString(4));
           jTextField7.setText(rs.getString(5));
           jTextField11.setText(rs.getString(7));
           jTextField12.setText(rs.getString(8));
           jTextField13.setText(rs.getString(9));
           jTextField14.setText(rs.getString(10));
              
           }}
        catch(NullPointerException se)
        {
            JOptionPane.showMessageDialog(null,"No Data is found");
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
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        reg.setVisible(true);
        search.setVisible(false);
        update.setEnabled(true);
        
        Save.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedrow,0).toString());
        jComboBox1.setSelectedItem(model.getValueAt(selectedrow,1).toString());
        jTextField9.setText(model.getValueAt(selectedrow,2).toString());
        jTextField15.setText(model.getValueAt(selectedrow,3).toString());
        load();
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
            java.util.logging.Logger.getLogger(cb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel reg;
    private javax.swing.JPanel search;
    private javax.swing.JButton search1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
