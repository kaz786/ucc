
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucc;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author Ritik
 */
public class dr extends javax.swing.JFrame {
class MyCustomFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean  accept (File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".jpg");
    }
    @Override
    public String getDescription()
    {
        return "JPG documents (*.jpg)";
    }
}
JFileChooser jfc =new JFileChooser();    
/**
     * Creates new form NewJFrame2
     */
    public dr() {
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
        jTextField4.setText("EMAIL ID");
        jTextField5.setText("ALTERNATE NUMBER");
        jTextField6.setText("DL NO");
        jTextField7.setText("UIDAI");
        jTextArea1.setText("TEMPORARY ADDRESS");
        jTextArea2.setText("PERMANENT ADDRESS");
        jXDatePicker1.setDate(null);
        jTextField1.setForeground(Color.DARK_GRAY);
        jTextField2.setForeground(Color.DARK_GRAY);
        jTextField3.setForeground(Color.DARK_GRAY);
        jTextField4.setForeground(Color.DARK_GRAY);
        jTextField5.setForeground(Color.DARK_GRAY);
        jTextField6.setForeground(Color.DARK_GRAY);
        jTextField7.setForeground(Color.DARK_GRAY);
        jTextArea1.setForeground(Color.DARK_GRAY);
        jTextArea2.setForeground(Color.DARK_GRAY);
        
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
        jTextArea1.setForeground(Color.BLACK);
        jTextArea2.setForeground(Color.BLACK);
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
    public void  load()
    {
        try
        {
            String connectionURL="jdbc:derby:u_cars";
            Connection connection=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        //ImageIcon p =new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(164,161,Image.SCALE_SMOOTH));
           connection=DriverManager.getConnection(connectionURL,"ritik","ritik");
         
           String sql="select d_img from d_ddetails where d_id=?";
           ps=connection.prepareStatement(sql);
           ps.setString(1,jTextField1.getText());
           rs=ps.executeQuery();
           while(rs.next())
           {    
           Blob imageData=rs.getBlob("d_img");
           
           InputStream is=imageData.getBinaryStream(1,imageData.length());
           BufferedImage img=ImageIO.read(is);
           Image image= img;
           ImageIcon icon=new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(164,161,Image.SCALE_SMOOTH));
           jLabel11.setIcon(icon);
              
           }}
        catch(NullPointerException se)
        {
            JOptionPane.showMessageDialog(null,"No image is found");
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
            String sql="select * from d_ddetails";
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
     String sql="select D_ID from d_ddetails";
     rs=s.executeQuery(sql);
     while(rs.next())
     {
         jTextField1.setText(String.valueOf(rs.getInt("D_ID")));
         
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        reg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(217, 30, 24));

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

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Driver Registration Form");

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField2.setBackground(new java.awt.Color(108, 122, 137));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField2.setText("NAME");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(108, 122, 137));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("ID");

        jTextField3.setBackground(new java.awt.Color(108, 122, 137));
        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setText("MOBILE NUMBER");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(108, 122, 137));
        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.setText("EMAIL ID");
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
        jTextField5.setForeground(new java.awt.Color(204, 204, 204));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.setText("ALTERNATE NUMBER");
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
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField6.setText("DL NO");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });

        jXDatePicker1.setBackground(new java.awt.Color(108, 122, 137));
        jXDatePicker1.setForeground(new java.awt.Color(108, 122, 137));
        jXDatePicker1.setFormats("yyyy-MM-dd");
        jXDatePicker1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jXDatePicker1MouseDragged(evt);
            }
        });
        jXDatePicker1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jXDatePicker1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jXDatePicker1FocusLost(evt);
            }
        });
        jXDatePicker1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXDatePicker1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jXDatePicker1MouseEntered(evt);
            }
        });
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(108, 122, 137));
        jTextField7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(204, 204, 204));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField7.setText("UIDAI");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(108, 122, 137));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setRows(5);
        jTextArea1.setText("TEMPORARY ADDRESS");
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(108, 122, 137));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea2.setRows(5);
        jTextArea2.setText("PERMANENT ADDRESS");
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea2FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Andalus", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("upload the image here");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel11FocusLost(evt);
            }
        });
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

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
                .addGap(52, 52, 52)
                .addComponent(Save)
                .addGap(28, 28, 28)
                .addComponent(search1)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(31, 31, 31)
                .addComponent(delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Save)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update)
                        .addComponent(search1))
                    .addComponent(delete))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
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

        search.setPreferredSize(new java.awt.Dimension(546, 553));

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
                "Id", "Name", "Number", "Email Id", "Number2", "DL", "Valid upto", "Uidai", "T Add.", "P Add.", "Image"
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
        jScrollPane3.setViewportView(jTable1);

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(search, "card3");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if(jTextField2.getText().trim().equals("NAME"))
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

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        if(jTextField4.getText().trim().equals("EMAIL ID"))
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
            jTextField4.setText("EMAIL ID");
        }
        else if(jTextField4.getText().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"))
        {
            
        }
        else if( jTextField4.getText().matches("EMAIL ID"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Email ID","Error",JOptionPane.ERROR_MESSAGE);
            jTextField4.setForeground(Color.DARK_GRAY);
            jTextField4.setText("EMAIL ID");
            jTextField4.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        if(jTextField5.getText().trim().equals("ALTERNATE NUMBER"))
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
            jTextField5.setText("ALTERNATE NUMBER");
        }
        else if(jTextField5.getText().matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$"))
        {
            
        }
        else if( jTextField5.getText().matches("ALTERNATE NUMBER"))
        {
        } 
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid Mobile Number","Error",JOptionPane.ERROR_MESSAGE);
            jTextField5.setForeground(Color.DARK_GRAY);
            jTextField5.setText("ALTERNATE NUMBER");
            jTextField5.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        if(jTextField6.getText().trim().equals("DL NO"))
        {
            jTextField6.setForeground(Color.BLACK);
            jTextField6.setText("");

        }
        //JOptionPane.showMessageDialog(null,"Please enter the DL Validity"); // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if(jTextField6.getText().trim().equals(""))
        {
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("DL NO"); 
            
        }
        else if( jTextField6.getText().matches("DL NO"))
        {
        } 
        else if(jTextField6.getText().matches("^(?<intro>[A-Z]{2})(?<numeric>\\d{2})(?<year>\\d{4})(?<tail>\\d{7})$"))
        {
            
        }
        
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid DL NO","Error",JOptionPane.ERROR_MESSAGE);
            jTextField6.setForeground(Color.DARK_GRAY);
            jTextField6.setText("DL NO");
            jTextField6.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jXDatePicker1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXDatePicker1MouseDragged
        //JOptionPane.showMessageDialog(null,"Please Enter the Validity of Dl.No");        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1MouseDragged

    private void jXDatePicker1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXDatePicker1FocusGained
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1FocusGained

    private void jXDatePicker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXDatePicker1MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1MouseClicked

    private void jXDatePicker1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXDatePicker1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1MouseEntered

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained

        if(jTextField7.getText().trim().equals("UIDAI"))
        {
            jTextField7.setForeground(Color.BLACK);
            jTextField7.setText("");
        }
        if(jXDatePicker1.getDate()==null)
            {
              JOptionPane.showMessageDialog(null,"Please Enter The Validy Of DL");
              jXDatePicker1.requestFocus();  
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        if(jTextField7.getText().trim().equals(""))
        {
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("UIDAI");
        }
        else if( jTextField7.getText().matches("UIDAI"))
        {
        } 
        else if(jTextField7.getText().matches("^[0-9]{12}$"))
        {
            
        }
        
        else
            {
            JOptionPane.showMessageDialog(null,"Enter a valid UIDAI NO","Error",JOptionPane.ERROR_MESSAGE);
            jTextField7.setForeground(Color.DARK_GRAY);
            jTextField7.setText("UIDAI");
            jTextField7.requestFocus();
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        if(jTextArea1.getText().trim().equals("TEMPORARY ADDRESS"))
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
            jTextArea1.setText("TEMPORARY ADDRESS");
        }
        if(jTextArea1.getText().matches("^[#.0-9a-zA-Z\\s,-]+$"))
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Address","Error",JOptionPane.ERROR_MESSAGE);
            jTextArea1.setForeground(Color.DARK_GRAY);
            jTextArea1.setText("TEMPORARY ADDRESS");
            jTextArea1.requestFocus();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextArea2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusGained
        if(jTextArea2.getText().trim().equals("PERMANENT ADDRESS"))
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
            jTextArea2.setText("PERMANENT ADDRESS");
        }
        else if(jTextArea2.getText().matches("^[#.0-9a-zA-Z\\s,-]+$"))
        {
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Enter a valid Address","Error",JOptionPane.ERROR_MESSAGE);
            jTextArea2.setForeground(Color.DARK_GRAY);
            jTextArea2.setText("PERMANENT ADDRESS");
            jTextArea2.requestFocus();
            
        }
        if(jLabel11.getIcon()==null)
        {
            JOptionPane.showMessageDialog(null,"Please Upload the image","Error",JOptionPane.ERROR_MESSAGE);
            jLabel11.requestFocus();
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusLost

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        int returnVal=jfc.showOpenDialog(this);
        if(returnVal == jfc.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            ImageIcon p =new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(164,161,Image.SCALE_SMOOTH));
            jLabel11.setText("");
            jLabel11.setIcon(p);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if(jTextField2.getText().matches("NAME") || jTextArea1.getText().matches("TEMPORARY ADDRESS") ||
           jTextField3.getText().matches("MOBILE NUMBER") || jTextArea2.getText().matches("PERMANENT ADDRESS")
       || jTextField4.getText().matches("EMAIL ID") || jTextField5.getText().matches("ALTERNATE NUMBER") 
       || jTextField6.getText().matches("DL NO") || jTextField7.getText().matches("UIDAI")
       || jXDatePicker1.getDate()==null ||jLabel11.getIcon()==null     )
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
            double mob=Double.parseDouble(jTextField3.getText());
            String em=jTextField4.getText();
            double anum=Double.parseDouble(jTextField5.getText());
            String dl=jTextField6.getText();
            java.util.Date doj=new java.util.Date();
            doj=jXDatePicker1.getDate();
            java.sql.Date doj1=new java.sql.Date(doj.getTime());
            
            String ui=jTextField7.getText();
            String tadd=jTextArea1.getText();
            String padd=jTextArea2.getText();
            File f = jfc.getSelectedFile();
            InputStream input=null;
            input=new FileInputStream(new File(f.getAbsolutePath()));
            String sql="insert into d_ddetails values(?,?,?,?,?,?,?,?,?,?,?)";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setDouble(3,mob);
            st.setString(4,em);
            st.setDouble(5,anum);
            st.setString(6,dl);
            st.setDate(7,doj1);
            st.setString(8,ui);
            st.setString(9,tadd);
            st.setString(10,padd);
            st.setBlob(11,input);
            st.executeUpdate();
            
            try
        {
            URL u = new URL("http://www.google.com");
            URLConnection ca = u.openConnection();
            ca.connect();
            emai.send("vishalagarwal181@gmail.com","17121976",em,"Welcome Email","Welcome Mr."+name+"!!"
                    + " You have"
                    + " been registered with us.Your Booking Information Will Be Sent"
                    + " To You By Email.\n\nRegards\nUsha Cars");
            System.out.println("Internet is  connected");
        }
        catch(UnknownHostException ab)
        {
            db(em,"Welcome Email","Welcome Mr."+name+"!!"
                    + " You have"
                    + " been registered with us.Your Booking Information Will Be Sent"
                    + " To You By Email.\n\nRegards\nUsha Cars");
            JOptionPane.showMessageDialog(null,"Please Connect to the Internet for sending emails!!!");
        }
        catch(Exception eb)
        {
            JOptionPane.showMessageDialog(null,eb.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            JOptionPane.showMessageDialog(null,"Data is saved");
            clear();
            jLabel11.setIcon(null);

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
        //fc();
        //jTable1.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        reg.setVisible(false);
        search.setVisible(true);
        fc();
        dt();
    }//GEN-LAST:event_search1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
 if(jTextField2.getText().matches("NAME") || jTextArea1.getText().matches("TEMPORARY ADDRESS") ||
           jTextField3.getText().matches("MOBILE NUMBER") || jTextArea2.getText().matches("PERMANENT ADDRESS")
       || jTextField4.getText().matches("EMAIL ID") || jTextField5.getText().matches("ALTERNATE NUMBER") 
       || jTextField6.getText().matches("DL NO") || jTextField7.getText().matches("UIDAI")
       || jXDatePicker1.getDate()==null ||jLabel11.getIcon()==null     )
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
            double mob=Double.parseDouble(jTextField3.getText());
            String em=jTextField4.getText();
            double anum=Double.parseDouble(jTextField5.getText());
            String dl=jTextField6.getText();
            java.util.Date doj=new java.util.Date();
            doj=jXDatePicker1.getDate();
            java.sql.Date doj1=new java.sql.Date(doj.getTime());
            
            String ui=jTextField7.getText();
            String tadd=jTextArea1.getText();
            
            String padd=jTextArea2.getText();
            if(jfc.getSelectedFile()==null)
            {
                String sql="update d_ddetails set d_name=?,d_mob=?,d_emid=?,d_anum=?,d_dl=?,d_vailid=?,d_ui=?,d_temp=?,d_perm=?  where d_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setString(1,name);
            st.setDouble(2,mob);
            st.setString(3,em);
            st.setDouble(4,anum);
            st.setString(5,dl);
            st.setDate(6,doj1);
            st.setString(7,ui);
            st.setString(8,tadd);
            st.setString(9,padd);
            //st.setBlob(10,input);
            st.setInt(10, id);
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is updated");
            clear();
            jTable1.repaint();
            jLabel11.setIcon(null);
            update.setEnabled(false);
            delete.setEnabled(false);
            Save.setEnabled(true);
            }
            else
            {
            File f = jfc.getSelectedFile();
            InputStream input=null;
            input=new FileInputStream(new File(f.getAbsolutePath()));
            String sql="update d_ddetails set d_name=?,d_mob=?,d_emid=?,d_anum=?,d_dl=?,d_vailid=?,d_ui=?,d_temp=?,d_perm=?,d_img=?  where d_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);
            st.setString(1,name);
            st.setDouble(2,mob);
            st.setString(3,em);
            st.setDouble(4,anum);
            st.setString(5,dl);
            st.setDate(6,doj1);
            st.setString(7,ui);
            st.setString(8,tadd);
            st.setString(9,padd);
            st.setBlob(10,input);
            st.setInt(11, id);
            
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is updated");
            clear();
            jTable1.repaint();
            jLabel11.setIcon(null);
            update.setEnabled(false);
            delete.setEnabled(false);
            Save.setEnabled(true);
        }}
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
 }      
                // TODO add your handling code here:
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

            String sql="delete from d_ddetails where d_id=?";
            c=DriverManager.getConnection(cu,"ritik","ritik");
            st=c.prepareStatement(sql);

            st.setInt(1,id);
            //ps.setString(2,em);
            //ps.setInt(3,rno);
            st.execute();
            JOptionPane.showMessageDialog(null,"Data is deleted");
            
            
            //clear();
            jLabel11.setIcon(null);
            update.setEnabled(false);
            delete.setEnabled(false);
            Save.setEnabled(true);
            //jButton1.setEnabled(true);
            jTable1.repaint();
            jTable1.clearSelection();
            jComboBox2.removeAllItems();
            fc();
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
        }       // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        

    try {
        en();
        update.setEnabled(true);
        delete.setEnabled(true);
        Save.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedrow = jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedrow,0).toString());
        jTextField2.setText(model.getValueAt(selectedrow,1).toString());
        jTextField3.setText(model.getValueAt(selectedrow,2).toString());
        jTextField4.setText(model.getValueAt(selectedrow,3).toString());
        jTextField5.setText(model.getValueAt(selectedrow,4).toString());
        jTextField6.setText(model.getValueAt(selectedrow,5).toString());
        search.setVisible(false);
        reg.setVisible(true);
       String a = model.getValueAt(selectedrow,6).toString();
       //Date ab = new SimpleDateFormat("yyyy-MM-dd");
       //jXDatePicker1.setDate(ab);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(a);
        jXDatePicker1.setDate(d);
        //(JTextField)dateChooserCombo1.getDateFormat().ge
        /* try
        {
        java.util.Date a =  new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedrow, 6));
        jXDatePicker1.setDate(a);
        }
        catch(ParseException ex)
        {
        Logger.getLogger(NewJFrame2.class.getName().log(Level.SEVERE,null,ex));
        }*/
        //jXDatePicker1.setText(model.getValueAt(selectedrow,6).toString());
        jTextField7.setText(model.getValueAt(selectedrow,7).toString());
        jTextArea1.setText(model.getValueAt(selectedrow,8).toString());
        jTextArea2.setText(model.getValueAt(selectedrow,9).toString());
        load();
        // TODO add your handling code here:
    } catch (ParseException ex) {
        Logger.getLogger(dr.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
if(jComboBox2.getSelectedItem().toString().matches("Driver Name"))
{
    
}
    else
{    String cu="jdbc:derby:u_cars";
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
            String sql="select * from d_ddetails where d_name=?";
            st=c.prepareStatement(sql);
            st.setString(1, roll);
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
this.setState(JFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       this.setVisible(false);
      main a = new main();
      a.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
      
         
      
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        
            // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
           // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jXDatePicker1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXDatePicker1FocusLost
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1FocusLost

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jLabel11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11FocusLost

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
            java.util.logging.Logger.getLogger(dr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel reg;
    private javax.swing.JPanel search;
    private javax.swing.JButton search1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
