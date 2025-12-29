package university.management.system;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Faculty extends JFrame implements ActionListener{
    Faculty(){
        setSize(1540,850);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/akademiya-6441.png"));//to get icons in our system write where it is inside""
        Image i2=i.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);/*to adjust size of image it needs to import java.awt.*; package to work*/
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);//to place a component on a frame
        
        JMenuBar mb=new JMenuBar();//to create menubar
        
        JMenu newInformation=new JMenu("New Information");//create title on menubar
        newInformation.setForeground(Color.BLACK);
        newInformation.setFont(new Font("serif",Font.BOLD,15));
        mb.add(newInformation);
        JMenuItem facultyinfo=new JMenuItem("New Faculty Information");//to add items in new information
        newInformation.add(facultyinfo);//add jmenuitem facultyinfo into newinformation
         facultyinfo.setForeground(Color.BLACK);
         facultyinfo.addActionListener(this);
         newInformation.add(facultyinfo);
        
         JMenuItem studentinfo=new JMenuItem("New student Information");//to add items in new information
        newInformation.add(studentinfo);//add jmenuitem facultyinfo into newinformation
         studentinfo.setForeground(Color.BLACK);
         studentinfo.addActionListener(this);
         newInformation.add(studentinfo);
         
         JMenu details=new JMenu("view details");//create title on menubar
        details.setForeground(Color.BLACK);
        details.setFont(new Font("serif",Font.BOLD,15));
        mb.add(details);
         details.addActionListener(this);
        
        JMenuItem facultydetails=new JMenuItem("View Faculty Details");//to add items in new information
        details.add(facultydetails);//add jmenuitem facultyinfo into newinformation
         facultydetails.setForeground(Color.BLACK);
         facultydetails.addActionListener(this);
         
         JMenu leave=new JMenu("Apply/Check Leave");//create title on menubar
        leave.setForeground(Color.BLACK);
        leave.setFont(new Font("serif",Font.BOLD,15));
        mb.add(leave);
        
        JMenuItem facultyleave=new JMenuItem("apply leave for faculty");//to add items in new information
        leave.add(facultyleave);//add jmenuitem facultyinfo into newinformation
         facultyleave.setForeground(Color.BLACK);
         facultyleave.addActionListener(this);
         
         JMenuItem facultyleavedetails=new JMenuItem("View Faculty Leave Details");//to add items in new information
        leave.add(facultyleavedetails);//add jmenuitem facultyinfo into newinformation
         facultyleavedetails.setForeground(Color.BLACK);
         facultyleavedetails.addActionListener(this);
        
         JMenu exams=new JMenu("Examination");//create title on menubar
        exams.setForeground(Color.BLACK);
        exams.setFont(new Font("serif",Font.BOLD,15));
        mb.add(exams);
        
        JMenuItem entermarks=new JMenuItem("Enter Marks");//to add items in new information
         exams.add(entermarks);//add jmenuitem facultyinfo into newinformation
         entermarks.setForeground(Color.BLACK);
         entermarks.addActionListener(this);
         
         //updateinfo
         JMenu updateinfo=new JMenu("UpdateInformaton");//create title on menubar
        updateinfo.setForeground(Color.BLACK);
        updateinfo.setFont(new Font("serif",Font.BOLD,15));
        mb.add(updateinfo);
        
        JMenuItem ufacultyinfo=new JMenuItem("Update Faculty info");//to add items in new information
        updateinfo.add(ufacultyinfo);//add jmenuitem facultyinfo into newinformation
         ufacultyinfo.setForeground(Color.BLACK);
         ufacultyinfo.addActionListener(this);
        
         JMenuItem ustudentinfo=new JMenuItem("Update Student info");//to add items in new information
         updateinfo.add(ustudentinfo);//add jmenuitem facultyinfo into newinformation
         ustudentinfo.setForeground(Color.BLACK);
         ustudentinfo.addActionListener(this);
         
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
        else if(msg.equals(("New Faculty Information"))){
            new AddFaculty();
        }
        else if(msg.equals(("New student Information"))){
            new AddStudent();
        }
        else if(msg.equals(("View Faculty Details"))){
            new DisplayFacultyDetails();
        }
        else if(msg.equals("apply leave for faculty")){
            new TeacherLeave();
        }
        else if(msg.equals("View Faculty Leave Details")){
            new ViewFacultyLeave();
        }
        else if(msg.equals("Update Faculty info")){
            new updateTeacher();
        }
        else if(msg.equals("Update Student info")){
        new updateStudent();
    }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
    }
    public static void main(String args[]){
        new Faculty();
    }
    
}
