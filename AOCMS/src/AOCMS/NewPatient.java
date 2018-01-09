package AOCMS;

import AOCMS.option;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;

public class NewPatient extends javax.swing.JFrame implements Printable {
Connection cn=null;
Statement st=null;
ResultSet rs=null;
String sql="";


String gender="",Category="";
int tokenvalue;

public NewPatient() {
        initComponents();
    }
public NewPatient(int tokenvalue)  //constructor to take token value passed from option frame
{
     initComponents();
     this.tokenvalue=tokenvalue;
}
  @Override   //print the token and opticket
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
    g.setFont(new Font("TimesRoman", Font.BOLD, 12));     
    g.drawString("         GOVERNMENT MEDICAL COLLEGE" ,100,100);
    g.drawString("                       Mulankunnathukavu," ,100,110);
    g.drawString("                       Thrissur, 680531" ,100,120);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,125);
    g.drawString("                            |   OP TICKET  |         ",100,135);
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,147);
    g.drawString("NAME: "+name.getText(),100,155);
    g.drawString("AGE : "+age.getText(),100,165);
    g.drawString("SEX : "+gender+"                      OP UNIT: "+op_unit.getSelectedItem(),100,175);  
    g.drawString("DATE: "+date.getText(),100,185);
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,190);
    g.drawString("OP NUMBER    :"+op_display.getText(),100,200);
    if(Category.equals("Oncology"))
    {g.drawString("CR NUMBER    :"+cr_display.getText(),100,210);}
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,215);
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,500);
    g.setFont(new Font("TimesRoman", Font.BOLD, 12)); 
    g.drawString(       "          Vidya Academy of Science & Technology ",100,510 );
    g.drawString(       "                     P.O. Thalakottukara",100,520 );
    g.drawString(       "                 Thrissur, Kerala 680501",100,530);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,540);
  //--------------------------------------------------------------------------------------------------------------  
   if(Category.equals("Oncology"))
    {
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,575);
    g.setFont(new Font("TimesRoman", Font.BOLD, 12)); 
    g.drawString("         GOVERNMENT MEDICAL COLLEGE" ,100,600);
    g.drawString("                       Mulankunnathukavu," ,100,610);
    g.drawString("                       Thrissur, 680531" ,100,620);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,625);
    g.drawString(op_unit.getSelectedItem()+"          |    TOKEN    |         DATE:"+date.getText(),100,635);
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,645);
    g.drawString("NAME :"+name.getText(),100,655);
    g.drawString("AGE :"+age.getText(),100,665);
    g.drawString("CR NUMBER:"+cr_display.getText()+   "              |OP NUMBER:"+op_display.getText(),100,675);
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,685);
    g.setFont(new Font("TimesRoman",Font.PLAIN, 30)); 
    g.drawString("              "+(tokenvalue),100,710);  
    g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
    g.drawString("                                           TOKEN NUMBER",100,720);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,725);
    g.setFont(new Font("TimesRoman", Font.BOLD, 12)); 
    g.drawString("     Vidya Academy of Science & Technology",100,735);
    g.drawString(       "                  P.O. Thalakottukara ",100,745 );
    g.drawString(       "                     Thrissur-680501",100,755 );
    g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
    g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",100,760);
    
    } return PAGE_EXISTS;
    }
    
    public class progress implements ActionListener
    { 
        public void actionPerformed(ActionEvent evt)
        { 
            int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
            }
              else
        {
            timer.stop();
            jProgressBar1.setMaximum(0);
           
         option op=new option();
          try{
    PrintWriter writer = new PrintWriter("token.txt", "UTF-8");
    writer.println(tokenvalue);
    writer.close();
             } 
          catch (IOException e) {}
        new option(tokenvalue).setVisible(true);
        dispose(); }
        jProgressBar1.setValue(n);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        token = new javax.swing.JLabel();
        token1 = new javax.swing.JLabel();
        sep1 = new javax.swing.JSeparator();
        name = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        sep2 = new javax.swing.JSeparator();
        phone_no = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        label3 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        sep3 = new javax.swing.JSeparator();
        age = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        label6 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        op_unit = new javax.swing.JComboBox<>();
        reference = new javax.swing.JComboBox<>();
        label10 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        Casuality = new javax.swing.JRadioButton();
        op_list = new javax.swing.JComboBox<>();
        OP = new javax.swing.JRadioButton();
        Speciality = new javax.swing.JRadioButton();
        speciality_list = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        op_display = new javax.swing.JLabel();
        op_text = new javax.swing.JLabel();
        cr_display = new javax.swing.JLabel();
        cr_text = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("| _ |");
        jLabel18.setToolTipText(" Minimize the screen");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 40, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("| AOCMS | NEW PATIENT |");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 30));

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("| X |");
        jLabel16.setToolTipText("Exit from AOCMS");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 60, 30));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("| Government Medical College , Mulankunnathukavu Thrissur |");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 400, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 48)); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, -1));

        jLabel3.setFont(new java.awt.Font("Poor Richard", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("Automated OP Counter Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/1491425454_back_on_top.png"))); // NOI18N
        jLabel6.setToolTipText("Back to the Main Page");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 30, 50));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Back");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, -1, -1));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Save and Generate Token");
        jLabel8.setToolTipText("To save patient record and to produce token");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(0, 0, 0)));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 260, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/1491430428_Backspace_erase_delete_back.png"))); // NOI18N
        jLabel9.setToolTipText("Clear the selections & texts completely");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 140, 120));

        jLabel15.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 48)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/medlogo.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 120));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/vidya2.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 180, 130));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Clear");
        jLabel10.setToolTipText("Clear the selections & texts completely");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, -1, -1));

        jProgressBar1.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar1.setForeground(new java.awt.Color(51, 0, 0));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 520, 10));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        token.setBackground(new java.awt.Color(102, 18, 25));
        token.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        token.setForeground(new java.awt.Color(0, 102, 102));
        token.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        token.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.add(token, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 150, 180));

        token1.setFont(new java.awt.Font("High Tower Text", 0, 16)); // NOI18N
        token1.setText("Token Number");
        jPanel2.add(token1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 110, -1));

        sep1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(sep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 210, 10));

        name.setBackground(new java.awt.Color(204, 204, 204));
        name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        name.setBorder(null);
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, 30));

        label1.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label1.setText("Name:");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        label2.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label2.setText("Phone No:");
        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        label5.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label5.setText("Address: ");
        jPanel2.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        sep2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(sep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 210, 10));

        phone_no.setBackground(new java.awt.Color(204, 204, 204));
        phone_no.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        phone_no.setBorder(null);
        phone_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone_noFocusGained(evt);
            }
        });
        phone_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_noActionPerformed(evt);
            }
        });
        jPanel2.add(phone_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, 30));

        address.setBackground(new java.awt.Color(204, 204, 204));
        address.setColumns(20);
        address.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address.setLineWrap(true);
        address.setRows(3);
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 18, 25)));
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(address);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 390, -1));

        label3.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label3.setText("Age:");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        date.setBackground(new java.awt.Color(204, 204, 204));
        date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        date.setBorder(null);
        date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateFocusGained(evt);
            }
        });
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 210, 30));

        label9.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label9.setText("Date:");
        jPanel2.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        sep3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(sep3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, 10));

        age.setBackground(new java.awt.Color(204, 204, 204));
        age.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        age.setBorder(null);
        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageFocusGained(evt);
            }
        });
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        jPanel2.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 140, 30));

        label4.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label4.setText("Gender: ");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        male.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        male.setText("Male");
        male.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maleFocusGained(evt);
            }
        });
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel2.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        female.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        female.setText("Female");
        female.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                femaleFocusGained(evt);
            }
        });
        jPanel2.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 480, 340));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label6.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label6.setText("OP Unit:");
        jPanel4.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        label8.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label8.setText("Reference:");
        jPanel4.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        op_unit.setBackground(new java.awt.Color(204, 204, 204));
        op_unit.setFont(new java.awt.Font("High Tower Text", 0, 16)); // NOI18N
        op_unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oncology", "Chest Pulmonary Medicine", "ART" }));
        op_unit.setSelectedIndex(-1);
        op_unit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                op_unitItemStateChanged(evt);
            }
        });
        op_unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                op_unitFocusGained(evt);
            }
        });
        op_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_unitActionPerformed(evt);
            }
        });
        jPanel4.add(op_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 380, -1));

        reference.setBackground(new java.awt.Color(204, 204, 204));
        reference.setFont(new java.awt.Font("High Tower Text", 0, 16)); // NOI18N
        reference.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Private", "Government", "Others", "" }));
        reference.setSelectedIndex(-1);
        reference.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                referenceFocusGained(evt);
            }
        });
        jPanel4.add(reference, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 380, -1));

        label10.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label10.setText("Diagnosis:");
        jPanel4.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        label7.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        label7.setText("Category:");
        jPanel4.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, -1, 30));

        Casuality.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(Casuality);
        Casuality.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        Casuality.setText("Casuality");
        Casuality.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CasualityFocusGained(evt);
            }
        });
        Casuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasualityActionPerformed(evt);
            }
        });
        jPanel4.add(Casuality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 120, 40));

        op_list.setBackground(new java.awt.Color(204, 204, 204));
        op_list.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        op_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL", "LYMPHOMA (NHL, DLBCL,HODGKIN’S DISEASE)", "SARCOMA (SYNOVIAL SARCOMA, LIPOSARCOMA)", "MALIGNANT MELANOMA", "SKIN", "LEUKEMIA(ALL, AML, CML,CLL)", "LUNG(BRONCHOGENIC CARCINOMA)", "ESOPHAGUS", "STOMACH\t", "GE JUNCTION", "OG JUNCTION", "CAECUM", "RECTUM", "RECTOSIGMOID", "ANAL CANAL", "ANUS", "COLON", "BLADDER(GALL BLADDER, URINARY BLADDER)", "PROSTATE", "RENAL CELL CARCINOMA(KIDNEY)", "TESTIS", "PENIS", "HEPATO CELLULAR CARCINOMA(LIVER)", "PERIAMPULLARY CARCINOMA (BILE DUCT)", "MULTIPLE MYELOMA", "UNKNOWN PRIMARY", "INTESINES(SMALL INTESTINE, LARGE INTESTINE)", "THYROID GLAND", " " }));
        op_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                op_listMouseClicked(evt);
            }
        });
        op_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_listActionPerformed(evt);
            }
        });
        jPanel4.add(op_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 380, -1));

        OP.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(OP);
        OP.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        OP.setText("OP");
        OP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OPFocusGained(evt);
            }
        });
        OP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPActionPerformed(evt);
            }
        });
        jPanel4.add(OP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 40));

        Speciality.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(Speciality);
        Speciality.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        Speciality.setText("Speciality");
        Speciality.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SpecialityFocusGained(evt);
            }
        });
        Speciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecialityActionPerformed(evt);
            }
        });
        jPanel4.add(Speciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 120, 60));

        speciality_list.setBackground(new java.awt.Color(204, 204, 204));
        speciality_list.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        speciality_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL", "LIP", "ORAL CAVITY-  TONGUE", "ORAL CAVITY-  FLOOR OF MOUTH", "ORAL CAVITY-   PALATE", "ORAL CAVITY-  CHEEK MUCOSA", "ORAL CAVITY-   BUCCAL MUCOSA", "ORAL CAVITY-   RETROMOLAR AREA", "PHARYNX-  TONSIL", "PHARYNX-   UVULA", "PHARYNX-  VALLECULA", "PHARYNX-  OROPHARYNX", "PHARYNX-   NASOPHARYNX", "PHARYNX-  PYRIFORM SINUS", "PHARYNX-  POST CRICOID", "PHARYNX-  HYPOPHARYNX", "LARYNX-   EPIGLOTTIS", "LARYNX-    GLOTTIS", "LARYNX-   SUPRAGLOTTIS", "NASAL CAVITY", " MAXILLARY SINUS", "PAROTID GLAND", "SUBMANDIBULAR GLAND", "SUBLINGUAL GLAND", "SALIVARY GLAND", "VULVA", "VAGINA", "CERVIX", "ENDOMETRIUM", "UTERUS", "OVARY", "FALLOPIAN TUBE", "PLACENTA", "BREAST ", "BRAIN-  ASTROCYTOMA", "BRAIN-  GLIOBLASTOMA MULTIFORME", "BRAIN-  MEDULOBLASTOMA", " " }));
        speciality_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                speciality_listMouseClicked(evt);
            }
        });
        speciality_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciality_listActionPerformed(evt);
            }
        });
        jPanel4.add(speciality_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 380, -1));
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 480, 200));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        op_display.setBackground(new java.awt.Color(102, 18, 25));
        op_display.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        op_display.setForeground(new java.awt.Color(0, 51, 153));
        op_display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        op_display.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel5.add(op_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 110));

        op_text.setFont(new java.awt.Font("High Tower Text", 0, 16)); // NOI18N
        op_text.setText("OP Number");
        jPanel5.add(op_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 110, -1));

        cr_display.setBackground(new java.awt.Color(102, 18, 25));
        cr_display.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cr_display.setForeground(new java.awt.Color(0, 51, 153));
        cr_display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cr_display.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel5.add(cr_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 220, 110));

        cr_text.setFont(new java.awt.Font("High Tower Text", 0, 16)); // NOI18N
        cr_text.setText("CR Number");
        jPanel5.add(cr_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 480, 130));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AOCMS/ddd.jpg"))); // NOI18N
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 660));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1060, 630));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setForeground(new java.awt.Color(153, 153, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("| Powered By: CSE-Vidya Academy Of Science And Technology, Thalakkottukara Thrissur |");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 570, 20));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1160, 20));

        setSize(new java.awt.Dimension(1060, 680));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
  String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        try{
    PrintWriter writer = new PrintWriter("date.txt", "UTF-8");
    writer.println(timeStamp);
    writer.close();
       } catch (IOException e) {}
        
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        option op=new option();
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
    sep1.setBackground(new Color(0,0,0));
    label1.setForeground(new Color(51,0,153));
    label2.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label4.setForeground(new Color(0,0,0));
    label5.setForeground(new Color(0,0,0));
    label6.setForeground(new Color(0,0,0));
    label7.setForeground(new Color(0,0,0));
    label8.setForeground(new Color(0,0,0));
    label9.setForeground(new Color(0,0,0));
    label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_nameFocusGained

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
   
    }//GEN-LAST:event_nameActionPerformed

    private void phone_noFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_noFocusGained
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(51,0,153));
    sep1.setBackground(new Color(0,0,0));
    label1.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label4.setForeground(new Color(0,0,0));
    label5.setForeground(new Color(0,0,0));
    label6.setForeground(new Color(0,0,0));
    label7.setForeground(new Color(0,0,0));
    label8.setForeground(new Color(0,0,0));
    label9.setForeground(new Color(0,0,0));
    label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_phone_noFocusGained

    private void phone_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_noActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if(name.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"Please enter the Patient's name!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        
        else if(age.getText().equals(""))
        { JOptionPane.showMessageDialog(null,"Please enter the Patient's age!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        else if(buttonGroup1.getSelection()==null)
        {JOptionPane.showMessageDialog(null,"Please enter the Patient's gender!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        else if(address.getText().equals(""))
        { JOptionPane.showMessageDialog(null,"Please enter the Patient's address!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        else if(op_unit.getSelectedIndex()==-1)
        {JOptionPane.showMessageDialog(null,"Please select the OP Unit!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        else if(buttonGroup2.getSelection()==null)
        {JOptionPane.showMessageDialog(null,"Please enter the Patient's Category!","AOCMS",JOptionPane.ERROR_MESSAGE);}
        else if(reference.getSelectedIndex()==-1)
        {JOptionPane.showMessageDialog(null,"Please select the Referenced By Details!","AOCMS",JOptionPane.ERROR_MESSAGE);}

        else
        {try
            {if(male.isSelected())
       {        jLabel4.setText("M");
                gender="Male";
       }
       else if(female.isSelected())
       {
           jLabel4.setText("F");
           gender="Female";
       }
      if(op_unit.getSelectedItem().equals("Oncology")) Category="Oncology";
      if(phone_no.getText().equals(""))
          phone_no.setText("0");
      if(Casuality.isSelected())
       {    jLabel5.setText("Casuality");
            jLabel11.setText("NULL");
       }
       else if(OP.isSelected())
       {
           jLabel5.setText("OP");
           jLabel11.setText((String) op_list.getSelectedItem());
       }
       else if(Speciality.isSelected())
       {
           jLabel5.setText("Speciality");
           jLabel11.setText((String) speciality_list.getSelectedItem());
       }
        if(op_unit.getSelectedItem().equals("Oncology"))
 {
        try{
    PrintWriter writer = new PrintWriter("crnumber.txt", "UTF-8");
    writer.println(cr_display.getText());
    writer.close();
    
}
        catch (IOException e) {}
}
        int ans=0;
	ans=JOptionPane.showConfirmDialog(null,"Press OK to save the record to the database","AOCMS",
JOptionPane.YES_NO_OPTION);
	if(ans==JOptionPane.YES_OPTION)
	{
            if(cr_display.getText().equals("NULL"))
                {
		  sql="insert into patients values("+"'"+name.getText()+"',"+cr_display.getText()+","+op_display.getText()+","+phone_no.getText()+","+"'"+
address.getText()+"','"+age.getText()+"','"+date.getText()+"','"+date.getText()+"','"+jLabel5.getText()+"','"+jLabel4.getText()+"','"+reference.getSelectedItem()+"','"+op_unit.getSelectedItem()+"','"+jLabel11.getText()+"');";
                }
                else
                {
                     sql="insert into patients values("+"'"+name.getText()+"','"+cr_display.getText()+"',"+op_display.getText()+","+phone_no.getText()+","+"'"+
address.getText()+"','"+age.getText()+"','"+date.getText()+"','"+date.getText()+"','"+jLabel5.getText()+"','"+jLabel4.getText()+"','"+reference.getSelectedItem()+"','"+op_unit.getSelectedItem()+"','"+jLabel11.getText()+"');";
                }
st = cn.createStatement();
st.executeUpdate(sql);
sql="select * from patients;";
st=cn.createStatement();
rs=st.executeQuery(sql);
       
jLabel16.setVisible(false);                           
token.setVisible(false);
token1.setVisible(false);
if(op_unit.getSelectedItem().equals("Oncology"))
{
tokenvalue++;   
token.setVisible(true);
token1.setVisible(true);
}
token.setText(""+tokenvalue);  
PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) { }
         }
            timer.start();
        }   
}
catch (Exception e)
    {JOptionPane.showMessageDialog(null,e.toString());}
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    this.dispose();
    NewPatient np=new NewPatient();
    np.setVisible(true);
         
    }//GEN-LAST:event_jLabel9MouseClicked

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
timer = new Timer(50,new progress());        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void maleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maleFocusGained
    sep1.setBackground(new Color(0,0,0));
    label4.setForeground(new Color(51,0,153));    
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label1.setForeground(new Color(0,0,0));
    label5.setForeground(new Color(0,0,0));
    label6.setForeground(new Color(0,0,0));
    label7.setForeground(new Color(0,0,0));
    label8.setForeground(new Color(0,0,0));
    label9.setForeground(new Color(0,0,0));
    label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_maleFocusGained

    private void femaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_femaleFocusGained
     sep1.setBackground(new Color(0,0,0));
    label4.setForeground(new Color(51,0,153));
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label1.setForeground(new Color(0,0,0));
    label5.setForeground(new Color(0,0,0));
    label6.setForeground(new Color(0,0,0));
    label7.setForeground(new Color(0,0,0));
    label8.setForeground(new Color(0,0,0));
    label9.setForeground(new Color(0,0,0));
    label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_femaleFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
OP.setVisible(false);
Casuality.setVisible(false);
Speciality.setVisible(false);
        jLabel11.setVisible(false);
op_list.setVisible(false);
speciality_list.setVisible(false);
        try
{
    Class.forName("java.sql.Driver");	
    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aocms","root","amrutha1996*");
sql="select * from patients;";
	st=cn.createStatement();
	rs=st.executeQuery(sql);
	rs.next();
	}
catch(Exception e)
{
	JOptionPane.showMessageDialog(null,e.toString());
}
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        date.setText(""+timeStamp);
        date.setEditable(false);
        token.setVisible(false);
        token1.setVisible(false);
try
{
Class.forName("java.sql.Driver");	
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aocms","root","amrutha1996*");
        sql="select * from patients;";
	st=cn.createStatement();
	rs=st.executeQuery(sql);
	rs.next();
}

catch(Exception e)
{JOptionPane.showMessageDialog(null,"Failed to add the record","AOCMS",JOptionPane.ERROR_MESSAGE);}

try
{
	rs.last();
        int op; 
        op=Integer.parseInt(rs.getString("op_number"));
      	op_display.setText(""+(op+1));
}

catch(Exception e)
{JOptionPane.showMessageDialog(null,e.toString());}
    }//GEN-LAST:event_formComponentShown

    private void ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusGained
sep3.setBackground(new Color(0,0,0));
label3.setForeground(new Color(51,0,153));
sep2.setBackground(new Color(0,0,0));
label2.setForeground(new Color(0,0,0));
sep1.setBackground(new Color(0,0,0));
label1.setForeground(new Color(0,0,0));
label4.setForeground(new Color(0,0,0));
label5.setForeground(new Color(0,0,0));
label6.setForeground(new Color(0,0,0));
label7.setForeground(new Color(0,0,0)); 
label8.setForeground(new Color(0,0,0));
label9.setForeground(new Color(0,0,0));
label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_ageFocusGained

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void op_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_unitActionPerformed

        String crnumber="";
String year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        if(op_unit.getSelectedItem().equals("Chest Pulmonary Medicine")||op_unit.getSelectedItem().equals("ART"))
{
    OP.setVisible(true);
    Speciality.setVisible(false);
    Casuality.setVisible(true);
    cr_display.setText("NULL");
    op_list.setVisible(false);
    speciality_list.setVisible(false);
}
        else if(op_unit.getSelectedItem().equals("Oncology"))
{
    Speciality.setVisible(true);
    OP.setVisible(true);
    Casuality.setVisible(true);
    try (BufferedReader br1 = new BufferedReader(new FileReader("crnumber.txt"))) 
    {
        String crno;
	while ((crno = br1.readLine()) != null) 
        {crnumber=crno;}
    }
    catch (IOException e)
    {e.printStackTrace();}
     
    String output = crnumber.substring(0, crnumber.indexOf('/'));
    int si=Integer.parseInt(output);
    cr_display.setText(""+(si+1)+"/"+year);
}    
    }//GEN-LAST:event_op_unitActionPerformed

    private void CasualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasualityActionPerformed
op_list.setVisible(false);
speciality_list.setVisible(false);
    }//GEN-LAST:event_CasualityActionPerformed

    private void CasualityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CasualityFocusGained
sep1.setBackground(new Color(0,0,0));
label7.setForeground(new Color(51,0,153));
sep2.setBackground(new Color(0,0,0));
label2.setForeground(new Color(0,0,0));
sep3.setBackground(new Color(0,0,0));
label3.setForeground(new Color(0,0,0));
label1.setForeground(new Color(0,0,0));
label5.setForeground(new Color(0,0,0));
label4.setForeground(new Color(0,0,0));
label8.setForeground(new Color(0,0,0));
label9.setForeground(new Color(0,0,0));   
label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_CasualityFocusGained

    private void OPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OPFocusGained
sep1.setBackground(new Color(0,0,0));
label7.setForeground(new Color(51,0,153));
sep2.setBackground(new Color(0,0,0));
label2.setForeground(new Color(0,0,0));
sep3.setBackground(new Color(0,0,0));
label3.setForeground(new Color(0,0,0));
label1.setForeground(new Color(0,0,0));
label5.setForeground(new Color(0,0,0));
label4.setForeground(new Color(0,0,0));
label6.setForeground(new Color(0,0,0));
label8.setForeground(new Color(0,0,0));
label9.setForeground(new Color(0,0,0)); 
label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_OPFocusGained

    private void dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFocusGained
sep1.setBackground(new Color(0,0,0));
label9.setForeground(new Color(51,0,153));
sep2.setBackground(new Color(0,0,0));
label2.setForeground(new Color(0,0,0));
sep3.setBackground(new Color(0,0,0));
label3.setForeground(new Color(0,0,0));
label1.setForeground(new Color(0,0,0));
label5.setForeground(new Color(0,0,0));
label4.setForeground(new Color(0,0,0));
label8.setForeground(new Color(0,0,0));
label7.setForeground(new Color(0,0,0));   
label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_dateFocusGained

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusGained
sep1.setBackground(new Color(0,0,0));
label5.setForeground(new Color(51,0,153));
sep2.setBackground(new Color(0,0,0));
label2.setForeground(new Color(0,0,0));
sep3.setBackground(new Color(0,0,0));
label3.setForeground(new Color(0,0,0));
label1.setForeground(new Color(0,0,0));
label4.setForeground(new Color(0,0,0));
label6.setForeground(new Color(0,0,0));
 label7.setForeground(new Color(0,0,0));
label8.setForeground(new Color(0,0,0));
label9.setForeground(new Color(0,0,0)); 
label10.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_addressFocusGained

    private void op_unitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_op_unitFocusGained
sep1.setBackground(new Color(0,0,0));
    label6.setForeground(new Color(51,0,153));
        
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
        
    label1.setForeground(new Color(0,0,0));
       label5.setForeground(new Color(0,0,0));
          label4.setForeground(new Color(0,0,0));
             label7.setForeground(new Color(0,0,0));
                label8.setForeground(new Color(0,0,0));
                   label9.setForeground(new Color(0,0,0)); 
                    label10.setForeground(new Color(0,0,0));
       // TODO add your handling code here:
    }//GEN-LAST:event_op_unitFocusGained

    private void referenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusGained
sep1.setBackground(new Color(0,0,0));
    label8.setForeground(new Color(51,0,153));
        
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
        
    label1.setForeground(new Color(0,0,0));
       label5.setForeground(new Color(0,0,0));
          label4.setForeground(new Color(0,0,0));
             label6.setForeground(new Color(0,0,0));
                label7.setForeground(new Color(0,0,0));
                   label9.setForeground(new Color(0,0,0));   
                    label10.setForeground(new Color(0,0,0));
       // TODO add your handling code here:
    }//GEN-LAST:event_referenceFocusGained

    private void op_unitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_op_unitItemStateChanged
       // TODO add your handling code here:
    }//GEN-LAST:event_op_unitItemStateChanged

    private void SpecialityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpecialityFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecialityFocusGained

    private void op_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_listActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_op_listActionPerformed

    private void OPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPActionPerformed
if(op_unit.getSelectedItem().equals("ART")||op_unit.getSelectedItem().equals("Chest Pulmonary Medicine"))
{
    speciality_list.setVisible(false);
    op_list.setVisible(false);

}
if(op_unit.getSelectedItem().equals("Oncology"))
{
speciality_list.setVisible(false);
op_list.setVisible(true);
}

    }//GEN-LAST:event_OPActionPerformed

    private void SpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecialityActionPerformed
if(op_unit.getSelectedItem().equals("ART")||op_unit.getSelectedItem().equals("Chest Pulmonary Medicine"))
{
    speciality_list.setVisible(false);
    op_list.setVisible(false);

}
if(op_unit.getSelectedItem().equals("Oncology"))
{
speciality_list.setVisible(true);
op_list.setVisible(false);
}
// TODO add your handling code here:
    }//GEN-LAST:event_SpecialityActionPerformed

    private void speciality_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciality_listActionPerformed
   // TODO add your handling code here:
    }//GEN-LAST:event_speciality_listActionPerformed

    private void op_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_op_listMouseClicked
sep1.setBackground(new Color(0,0,0));
    label10.setForeground(new Color(51,0,153));
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label1.setForeground(new Color(0,0,0));
       label5.setForeground(new Color(0,0,0));
          label4.setForeground(new Color(0,0,0));
             label6.setForeground(new Color(0,0,0));
                label7.setForeground(new Color(0,0,0));
                   label9.setForeground(new Color(0,0,0));   
                    label8.setForeground(new Color(0,0,0));             // TODO add your handling code here:
    }//GEN-LAST:event_op_listMouseClicked

    private void speciality_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speciality_listMouseClicked
   sep1.setBackground(new Color(0,0,0));
    label10.setForeground(new Color(51,0,153));
    sep2.setBackground(new Color(0,0,0));
    label2.setForeground(new Color(0,0,0));
    sep3.setBackground(new Color(0,0,0));
    label3.setForeground(new Color(0,0,0));
    label1.setForeground(new Color(0,0,0));
       label5.setForeground(new Color(0,0,0));
          label4.setForeground(new Color(0,0,0));
             label6.setForeground(new Color(0,0,0));
                label7.setForeground(new Color(0,0,0));
                   label9.setForeground(new Color(0,0,0));   
                    label8.setForeground(new Color(0,0,0));         
    }//GEN-LAST:event_speciality_listMouseClicked

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
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPatient().setVisible(true);
            }
        });
    }
private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Casuality;
    private javax.swing.JRadioButton OP;
    private javax.swing.JRadioButton Speciality;
    private javax.swing.JTextArea address;
    private javax.swing.JTextField age;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cr_display;
    private javax.swing.JLabel cr_text;
    private javax.swing.JTextField date;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField name;
    private javax.swing.JLabel op_display;
    private javax.swing.JComboBox<String> op_list;
    private javax.swing.JLabel op_text;
    private javax.swing.JComboBox<String> op_unit;
    private javax.swing.JTextField phone_no;
    private javax.swing.JComboBox<String> reference;
    private javax.swing.JSeparator sep1;
    private javax.swing.JSeparator sep2;
    private javax.swing.JSeparator sep3;
    private javax.swing.JComboBox<String> speciality_list;
    private javax.swing.JLabel token;
    private javax.swing.JLabel token1;
    // End of variables declaration//GEN-END:variables
}
