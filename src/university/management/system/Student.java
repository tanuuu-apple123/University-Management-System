
package university.management.system;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Student extends JFrame implements ActionListener{
    Student(){
        
        setSize(1540,850);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/akademiya-6441.png"));//to get icons in our system write where it is inside""
        Image i2=i.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);/*to adjust size of image it needs to import java.awt.*; package to work*/
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);//to place a component on a frame
        
        JMenuBar mb=new JMenuBar();//to create menubar
        
        JMenu details=new JMenu("view details");//create title on menubar
        details.setForeground(Color.BLACK);
        details.setFont(new Font("serif",Font.BOLD,15));
        mb.add(details);
        
         JMenuItem studentdetails=new JMenuItem("View Student Details");//to add items in new information
        details.add(studentdetails);//add jmenuitem facultyinfo into newinformation
         studentdetails.setForeground(Color.BLACK);
         studentdetails.addActionListener(this);
         
        
         JMenu leave=new JMenu("Apply/Check Leave");//create title on menubar
        leave.setForeground(Color.BLACK);
        leave.setFont(new Font("serif",Font.BOLD,15));
        mb.add(leave);
        
        JMenuItem studentleave=new JMenuItem("apply leave for students");//to add items in new information
        leave.add(studentleave);//add jmenuitem facultyinfo into newinformation
         studentdetails.setForeground(Color.BLACK);
         studentleave.addActionListener(this);
         
         JMenuItem studentleavedetails=new JMenuItem("View Student Leave Details");//to add items in new information
        leave.add(studentleavedetails);//add jmenuitem facultyinfo into newinformation
         studentleavedetails.setForeground(Color.BLACK);
         studentleavedetails.addActionListener(this);
         JMenu exams=new JMenu("Examination");//create title on menubar
        exams.setForeground(Color.BLACK);
        exams.setFont(new Font("serif",Font.BOLD,15));
        mb.add(exams);
        
        JMenuItem examdetails=new JMenuItem("Exam Results");//to add items in new information
        exams.add( examdetails);//add jmenuitem facultyinfo into newinformation
         examdetails.setForeground(Color.BLACK);
          examdetails.addActionListener(this);
        
         JMenu fee=new JMenu("fee details");//create title on menubar
        fee.setForeground(Color.BLACK);
        fee.setFont(new Font("serif",Font.BOLD,15));
        mb.add(fee);
        
        JMenuItem feestructure=new JMenuItem("fee details");//to add items in new information
         fee.add(feestructure);//add jmenuitem facultyinfo into newinformation
         feestructure.setForeground(Color.BLACK);
        feestructure.addActionListener(this);
        
         JMenuItem feeform=new JMenuItem("submit fee form");//to add items in new information
         fee.add(fee);//add jmenuitem facultyinfo into newinformation
         feeform.setForeground(Color.BLACK);
         feeform.addActionListener(this);
         
         //utility
         JMenu utility=new JMenu("Utility");//create title on menubar
        utility.setForeground(Color.BLACK);
        utility.setFont(new Font("serif",Font.BOLD,15));
        mb.add(utility);
        
        JMenuItem notepad=new JMenuItem("Notepad");//to add items in new information
         utility.add(notepad);//add jmenuitem facultyinfo into newinformation
         notepad.setForeground(Color.BLACK);
         notepad.addActionListener(this);
        
         JMenuItem calci=new JMenuItem("Calculator");//to add items in new information
         utility.add(calci);//add jmenuitem facultyinfo into newinformation
         calci.setForeground(Color.BLACK);
         calci.addActionListener(this);
         
         //exit
         JMenu exit=new JMenu("Exit");//create title on menubar
        exit.setForeground(Color.RED);
        exit.setFont(new Font("serif",Font.BOLD,15));
        mb.add(exit);
        
        
        JMenuItem e=new JMenuItem("exit");//to add items in new information
         e.setForeground(Color.BLACK);
         e.addActionListener(this);
         exit.add(e);//add jmenuitem facultyinfo into newinformation
         

        setJMenuBar(mb);//for menu instead of add we use setjmenubar
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("calc.exe");//since calci is like taken from the computer
        }catch(Exception e){
            
        }
    }
        else if(msg.equals("Notepad")){
        try{
            Runtime.getRuntime().exec("notepad.exe");//since calci is like taken from the computer
        }catch(Exception e){
            
        }
    }
        else if(msg.equals(("View Student Details"))){
            new DisplayStudentDetails();
        }
        else if(msg.equals("apply leave for students")){
            new StudentLeave();
        }
        else if(msg.equals("View Student Details")){
            new ViewStudentLeave();
        }
        else if(msg.equals("Exam Results")){
            new ExaminationDetails();
        }
        else if(msg.equals("fee details")){
            new FeeStructure();
        }
        else if(msg.equals("submit fee form")){
            new StudentFeeForm();
        }
        else if(msg.equals("View Student Leave Details")){
            new ViewStudentLeave();
        }
    }
    public static void main(String args[]){
        new Student();
    }
}
