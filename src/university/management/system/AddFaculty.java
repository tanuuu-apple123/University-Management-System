package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddFaculty extends JFrame implements ActionListener {
    JTextField tnffname,tffname,tfmname,lbfaddr,lfph,lfemail,lf10per,lfinterper,lfaadhar;
    JLabel lbfroll;
    Random r=new Random();
    JDateChooser fdobc;
    JComboBox gfqualification,gfdepartment,cbdesignation;//to cretae drop down menu
    JButton submit,cancel;
    long firstf=Math.abs((r.nextLong()%9000L)+1000L);
    AddFaculty(){
         
        setSize(900,900);
        setLocation(350,50);
        
        
        setLayout(null);
        JLabel heading=new JLabel("New Faculty Details");
        heading.setBounds(200,30,500,50);
        add(heading);
        heading.setFont(new Font("serif",Font.BOLD,40));
        
        JLabel lfname=new JLabel("Name");
        lfname.setBounds(100,120,100,30);
        add(lfname);
        lfname.setFont(new Font("serif",Font.BOLD,30));
        
        tnffname=new JTextField();
        tnffname.setBounds(200,125,200,30);
        add(tnffname);
        
        JLabel lbffname=new JLabel("Father Name");
        lbffname.setBounds(100,170,300,30);
        add(lbffname);
        lbffname.setFont(new Font("serif",Font.BOLD,30));
        
        tffname=new JTextField();
        tffname.setBounds(300,170,200,30);
        add(tffname);
        
        JLabel lbfmname=new JLabel("Mother Name");
        lbfmname.setBounds(100,230,300,30);
        add(lbfmname);
        lbfmname.setFont(new Font("serif",Font.BOLD,30));
        
        tfmname=new JTextField();
        tfmname.setBounds(300,230,200,30);
        add(tfmname);
        
        JLabel lbflroll=new JLabel("Employee ID");
        lbflroll.setBounds(100,290,300,30);
        add(lbflroll);
        lbflroll.setFont(new Font("serif",Font.BOLD,30));
        
        lbfroll=new JLabel("E234"+firstf);
        lbfroll.setBounds(350,290,300,30);
        add(lbfroll);
        lbfroll.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lbfldob=new JLabel("Date of Birth");
        lbfldob.setBounds(100,350,300,30);
        add(lbfldob);
        lbfldob.setFont(new Font("serif",Font.BOLD,30));
        
        fdobc=new JDateChooser();
        fdobc.setBounds(350,350,300,30);
        add(fdobc);
        
        JLabel lbfladdr=new JLabel("Address");
        lbfladdr.setBounds(100,400,300,30);
        add(lbfladdr);
        lbfladdr.setFont(new Font("serif",Font.BOLD,30));
        
        lbfaddr=new JTextField();
        lbfaddr.setBounds(350,400,500,30);
        add(lbfaddr);
        lbfaddr.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblfphr=new JLabel("Phone Number");
        lblfphr.setBounds(100,450,300,30);
        add(lblfphr);
        lblfphr.setFont(new Font("serif",Font.BOLD,30));
        
        lfph=new JTextField();
        lfph.setBounds(350,450,100,30);
        add(lfph);
        lfph.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblfemail=new JLabel("Email ID");
        lblfemail.setBounds(100,500,300,30);
        add(lblfemail);
        lblfemail.setFont(new Font("serif",Font.BOLD,30));
        
        lfemail=new JTextField();
        lfemail.setBounds(350,500,150,30);
        add(lfemail);
        lfemail.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lbfl10per=new JLabel("X percentage");
        lbfl10per.setBounds(100,550,300,30);
        add(lbfl10per);
        lbfl10per.setFont(new Font("serif",Font.BOLD,30));
        
        lf10per=new JTextField();
        lf10per.setBounds(350,550,90,30);
        add(lf10per);
        lf10per.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblfinterper=new JLabel("Inter percentage");
        lblfinterper.setBounds(100,600,300,30);
        add(lblfinterper);
        lblfinterper.setFont(new Font("serif",Font.BOLD,30));
        
        lfinterper=new JTextField();
        lfinterper.setBounds(350,600,90,30);
        add(lfinterper);
        lfinterper.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblfaadhar=new JLabel("Aadhar Number");
        lblfaadhar.setBounds(100,650,300,30);
        add(lblfaadhar);
        lblfaadhar.setFont(new Font("serif",Font.BOLD,30));
        
        lfaadhar=new JTextField();
        lfaadhar.setBounds(350,650,100,30);
        add(lfaadhar);
        lfaadhar.setFont(new Font("serif",Font.BOLD,30));
        
        JLabel lblfcourse=new JLabel("qualification");
        lblfcourse.setBounds(500,110,200,35);
        add(lblfcourse);
        lblfcourse.setFont(new Font("serif",Font.BOLD,30));
        
        String course[]={"B.Teach","BBA","MBA","Bsc","B.ed","MCA","BA","MA","Mtech",};
        gfqualification=new JComboBox(course);
        gfqualification.setBounds(570,150,100,30);
        gfqualification.setBackground(Color.WHITE);
        add(gfqualification);
        
        JLabel lblfdep=new JLabel("Department");
        lblfdep.setBounds(530,200,200,30);
        add(lblfdep);
        lblfdep.setFont(new Font("serif",Font.BOLD,30));
     
String department[] = {
    "Computer Science",
    "Information Technology",
    "Electronics",
    "Mechanical",
    "Civil",
    "Management",
    "Mathematics",
    "Physics","Psychology","Political Science","Economic"
};
        
        gfdepartment=new JComboBox(department);
        gfdepartment.setBounds(630,250,100,30);
        gfdepartment.setBackground(Color.WHITE);
        add(gfdepartment);
     JLabel   lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(630, 500, 200, 30);
        lbldesignation.setFont(new Font("serif", Font.BOLD, 30));
        add(lbldesignation);

String designation[] = {
    "Assistant Professor",
    "Associate Professor",
    "Professor",
    "HOD",
    "Visiting Faculty"
};

cbdesignation = new JComboBox<>(designation);
cbdesignation.setBounds(630, 550, 200, 30);
cbdesignation.setBackground(Color.WHITE);
add(cbdesignation);

        
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
            String vfname=tnffname.getText();
            String vffname=tffname.getText();
            String vfmname=tfmname.getText();
            String vfrollno=lbfroll.getText();
            String vfdob=((JTextField) fdobc.getDateEditor().getUiComponent()).getText();
            String vfaddr=lbfaddr.getText();
            String vfphone=lfph.getText();
            String vfemail=lfemail.getText();
            String vf10=lf10per.getText();
            String vfinter=lfinterper.getText();
            String vfaadhar=lfaadhar.getText();
            String vfcourse=(String)gfqualification.getSelectedItem();//getseletitem returns a object it needs to be type casted to string
            String vfbranch=(String)gfdepartment.getSelectedItem();
            String vfdesig=(String)cbdesignation.getSelectedItem();
            try{
               String query = "insert into facultyinfo values("
    + "'" + vfname + "',"
    + "'" + vffname + "',"
    + "'" + vfmname + "',"
    + "'" + vfrollno + "',"
    + "'" + vfdob + "',"
    + "'" + vfaddr + "',"
    + "'" + vfphone + "',"
    + "'" + vfemail + "',"
    + "'" + vf10 + "',"
    + "'" + vfinter + "',"
    + "'" + vfaadhar + "',"
    + "'" + vfcourse + "',"
    + "'" + vfbranch + "',"
    + "'" + vfdesig + "')";


               Connec con=new Connec();
               con.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Fsculty details added successfully");
               setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
    }
    
public static void main(String args[]){
    new AddFaculty();
}
}
