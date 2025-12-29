package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddStudent extends JFrame implements ActionListener{
    JTextField tnfname,tfname,tmname,lbaddr,lph,lemail,l10per,linterper,laadhar;
    JLabel lbroll;
    Random r=new Random();
    JDateChooser dobc;
    JComboBox gcourse,gbranch;//to cretae drop down menu
    JButton submit,cancel;
    long firstf=Math.abs((r.nextLong()%9000L)+1000L);
    AddStudent(){
        setSize(900,900);
        setLocation(350,50);
        
        
        setLayout(null);
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(200,30,500,50);
        add(heading);
        heading.setFont(new Font("serif",Font.BOLD,40));
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(100,120,100,30);
        add(lbname);
        lbname.setFont(new Font("serif",Font.BOLD,30));
        
        tnfname=new JTextField();
        tnfname.setBounds(200,125,200,30);
        add(tnfname);
        
        JLabel lbfname=new JLabel("Father Name");
        lbfname.setBounds(100,170,300,30);
        add(lbfname);
        lbfname.setFont(new Font("serif",Font.BOLD,30));
        
        tfname=new JTextField();
        tfname.setBounds(300,170,200,30);
        add(tfname);
        
        JLabel lbmname=new JLabel("Mother Name");
        lbmname.setBounds(100,230,300,30);
        add(lbmname);
        lbmname.setFont(new Font("serif",Font.BOLD,30));
        
        tmname=new JTextField();
        tmname.setBounds(300,230,200,30);
        add(tmname);
        
        JLabel lblroll=new JLabel("Register Number");
        lblroll.setBounds(100,290,300,30);
        add(lblroll);
        lblroll.setFont(new Font("serif",Font.BOLD,30));
        
        lbroll=new JLabel("1233"+firstf);
        lbroll.setBounds(350,290,300,30);
        add(lbroll);
        lbroll.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lbldob=new JLabel("Date of Birth");
        lbldob.setBounds(100,350,300,30);
        add(lbldob);
        lbldob.setFont(new Font("serif",Font.BOLD,30));
        
        dobc=new JDateChooser();
        dobc.setBounds(350,350,300,30);
        add(dobc);
        
        JLabel lbladdr=new JLabel("Address");
        lbladdr.setBounds(100,400,300,30);
        add(lbladdr);
        lbladdr.setFont(new Font("serif",Font.BOLD,30));
        
        lbaddr=new JTextField();
        lbaddr.setBounds(350,400,500,30);
        add(lbaddr);
        lbaddr.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblphr=new JLabel("Phone Number");
        lblphr.setBounds(100,450,300,30);
        add(lblphr);
        lblphr.setFont(new Font("serif",Font.BOLD,30));
        
        lph=new JTextField();
        lph.setBounds(350,450,500,30);
        add(lph);
        lph.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblemail=new JLabel("Email ID");
        lblemail.setBounds(100,500,300,30);
        add(lblemail);
        lblemail.setFont(new Font("serif",Font.BOLD,30));
        
        lemail=new JTextField();
        lemail.setBounds(350,500,500,30);
        add(lemail);
        lemail.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lbl10per=new JLabel("X percentage");
        lbl10per.setBounds(100,550,300,30);
        add(lbl10per);
        lbl10per.setFont(new Font("serif",Font.BOLD,30));
        
        l10per=new JTextField();
        l10per.setBounds(350,550,500,30);
        add(l10per);
        l10per.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblinterper=new JLabel("Inter percentage");
        lblinterper.setBounds(100,600,300,30);
        add(lblinterper);
        lblinterper.setFont(new Font("serif",Font.BOLD,30));
        
        linterper=new JTextField();
        linterper.setBounds(350,600,500,30);
        add(linterper);
        linterper.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblaadhar=new JLabel("Aadhar Number");
        lblaadhar.setBounds(100,650,300,30);
        add(lblaadhar);
        lblaadhar.setFont(new Font("serif",Font.BOLD,30));
        
        laadhar=new JTextField();
        laadhar.setBounds(350,650,500,30);
        add(laadhar);
        laadhar.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblcourse=new JLabel("Course");
        lblcourse.setBounds(500,125,100,30);
        add(lblcourse);
        lblcourse.setFont(new Font("serif",Font.BOLD,30));
        
        String course[]={"B.Teach","BBA","MBA","Bsc","B.ed","MCA","BA","MA"};
        gcourse=new JComboBox(course);
        gcourse.setBounds(600,125,100,30);
        gcourse.setBackground(Color.WHITE);
        add(gcourse);
        
        JLabel lblbranch=new JLabel("Branch");
        lblbranch.setBounds(530,170,100,30);
        add(lblbranch);
        lblbranch.setFont(new Font("serif",Font.BOLD,30));
     
        
        gbranch=new JComboBox();
        gbranch.setBounds(630,170,100,30);
        gbranch.setBackground(Color.WHITE);
        add(gbranch);
        gcourse.addActionListener(e -> {

    gbranch.removeAllItems();   // clear previous branches

    String selectedCourse = (String) gcourse.getSelectedItem();

    if (selectedCourse.equals("B.Teach")) {
        gbranch.addItem("Computer Science");
        gbranch.addItem("Electronics");
        gbranch.addItem("Mechanical");
        gbranch.addItem("Civil");
    }
    else if (selectedCourse.equals("BBA")) {
        gbranch.addItem("Marketing");
        gbranch.addItem("Finance");
        gbranch.addItem("HR");
    }
    else if (selectedCourse.equals("MBA")) {
        gbranch.addItem("Marketing");
        gbranch.addItem("Finance");
        gbranch.addItem("HR");
        gbranch.addItem("Operations");
    }
    else if (selectedCourse.equals("Bsc")) {
        gbranch.addItem("Computer Science");
        gbranch.addItem("Physics");
        gbranch.addItem("Mathematics");
    }
    else if (selectedCourse.equals("B.ed")) {
        gbranch.addItem("Maths");
        gbranch.addItem("Science");
        gbranch.addItem("English");
    }
    else if (selectedCourse.equals("MCA")) {
        gbranch.addItem("Computer Applications");
    }
    else if (selectedCourse.equals("BA")) {
        gbranch.addItem("English");
        gbranch.addItem("Economics");
        gbranch.addItem("History");
    }
    else if (selectedCourse.equals("MA")) {
        gbranch.addItem("English");
        gbranch.addItem("Psychology");
        gbranch.addItem("Political Science");
    }
});

        
        submit=new JButton("Submit");//to create button we use jbutton
        submit.setBounds(140,700,130,50);
        submit.setFont(new Font("serif",Font.BOLD,30));
       submit.addActionListener(this);
        add(submit);
        submit.setBackground(Color.WHITE);
        
        cancel=new JButton("Close");//to create button we use jbutton
        cancel.setBounds(400,700,130,50);
        cancel.setFont(new Font("serif",Font.BOLD,30));
       cancel.addActionListener(this);
        add(cancel);
        cancel.setBackground(Color.WHITE);
        
        
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String vname=tnfname.getText();
            String vfname=tfname.getText();
            String vmname=tmname.getText();
            String vrollno=lbroll.getText();
            String vdob=((JTextField) dobc.getDateEditor().getUiComponent()).getText();
            String vaddr=lbaddr.getText();
            String vphone=lph.getText();
            String vemail=lemail.getText();
            String v10=l10per.getText();
            String vinter=linterper.getText();
            String vaadhar=laadhar.getText();
            String vcourse=(String)gcourse.getSelectedItem();//getseletitem returns a object it needs to be type casted to string
            String vbranch=(String)gbranch.getSelectedItem();
            try{
                String query = "insert into studentinfo values("
        + "'" + vname + "',"
        + "'" + vfname + "',"
        + "'" + vmname + "',"
        + "'" + vrollno + "',"
        + "'" + vdob + "',"
        + "'" + vaddr + "',"
        + "'" + vphone + "',"
        + "'" + vemail + "',"
        + "'" + v10 + "',"
        + "'" + vinter + "',"
        + "'" + vaadhar + "',"
        + "'" + vcourse + "',"
        + "'" + vbranch + "')";

               Connec con=new Connec();
               con.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Student details added successfully");
               setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddStudent();
    }
    
}
