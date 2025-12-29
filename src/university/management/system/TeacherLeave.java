
package university.management.system;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TeacherLeave extends JFrame implements ActionListener {
    JTextField empid;
    JDateChooser dobf;
    JComboBox fftime;
    JButton submit,cancel;
    TeacherLeave(){
        setSize(600,600);
        setLocation(350,50);
        getContentPane().setBackground(new Color(193, 232, 198));
        
        setLayout(null);
        JLabel heading=new JLabel("Apply Leave");
        heading.setBounds(200,30,500,50);
        add(heading);
        heading.setFont(new Font("serif",Font.BOLD,40));
        
        JLabel head = new JLabel("Search by employee ID");
        head.setBounds(50, 80, 200, 25);
        head.setFont(new Font("serif",Font.PLAIN,20));
        add(head);

        empid = new JTextField();
        empid.setBounds(250, 80, 150, 25);
        add(empid);
        
        JLabel date = new JLabel("date");
        date.setBounds(50, 140, 160, 25);
        date.setFont(new Font("serif",Font.PLAIN,20));
        add(date);
        
        dobf=new JDateChooser();
        dobf.setBounds(100,140,160,25);
        add(dobf);
        
        JLabel htime = new JLabel("Time");
        htime.setBounds(50, 180, 200, 25);
        htime.setFont(new Font("serif",Font.PLAIN,20));
        add(htime);

        String[] gfhfh={"Full Day","Half Day"};
        fftime = new JComboBox(gfhfh);
        fftime.setBounds(100, 180, 150, 25);
        add(fftime);
        
        submit=new JButton("Submit");//to create button we use jbutton
        submit.setBounds(100,300,160,50);
        submit.setFont(new Font("serif",Font.BOLD,30));
       submit.addActionListener(this);
        add(submit);
        submit.setBackground(Color.WHITE);
        
        cancel=new JButton("Close");//to create button we use jbutton
        cancel.setBounds(300,300,160,50);
        cancel.setFont(new Font("serif",Font.BOLD,30));
       cancel.addActionListener(this);
        add(cancel);
        cancel.setBackground(Color.WHITE);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String emp=empid.getText();
            String date=((JTextField)dobf.getDateEditor().getUiComponent()).getText();
            String duration=(String)fftime.getSelectedItem();
            
            String query="insert into leavefaculty values('"+emp+"','"+date+"','"+duration+"')";
           
            try{
               Connec c=new Connec();
               c.s.executeUpdate(query); 
               JOptionPane.showMessageDialog(null,"Leave Conformed");
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
        new TeacherLeave();
    }
}
