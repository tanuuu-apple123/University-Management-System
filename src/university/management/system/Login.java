package university.management.system;
import javax.swing.*; //for frame we need it
import java.awt.*;//here we used this to import things needed to change backgroung colour
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,cancel;//if declared inside constructer actionperformd cannot access it hence declare globally
     JTextField tusername;
     JPasswordField tpassword;
    Login(){
        getContentPane().setBackground(new Color(193, 232, 198));//to cahnge background colour
        setLayout(null);//removes the username so now we have explicitly give bounds to it
        
        JLabel IbUserName=new JLabel("Username");//jlabel is used to write something on the frame
        IbUserName.setBounds(40,40,500,50);
        IbUserName.setFont(new Font("serif",Font.BOLD,20));
        add(IbUserName);//it adds username on frame which we created using jlabel in ibusername
        tusername=new JTextField();
        tusername.setBounds(150,53,150,30);//distance from left,distance from above,width of username,height of username with this we can explixitly show username on frame
        add(tusername);
        
        JLabel IbPassword=new JLabel("Password");//jlabel is used to write something on the frame
        IbPassword.setBounds(40,150,500,50);
        IbPassword.setFont(new Font("serif",Font.BOLD,20));
        add(IbPassword);//it adds username on frame which we created using jlabel in ibusername
        tpassword=new JPasswordField();//jpasswordfeild to hide password as **
        tpassword.setBounds(150,163,150,30);
        add(tpassword);
        
        login=new JButton("Login");//to create button we use jbutton
        login.setBounds(140,300,150,50);
        login.setFont(new Font("serif",Font.BOLD,30));
        login.addActionListener(this);
        add(login);
        login.setBackground(Color.WHITE);
        
        cancel=new JButton("cancel");//to create button we use jbutton
        cancel.setBounds(300,300,150,50);
        cancel.setFont(new Font("serif",Font.BOLD,30));
        cancel.setBackground(Color.WHITE);
        cancel.addActionListener(this);//this calls actionperformed whatever one there addaction only tells if we clicked the logic has to be written separately
         add(cancel);
        
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/haitam.png"));//to get icons in our system write where it is inside""
        Image i2=i.getImage().getScaledInstance(2000, 2000,Image.SCALE_DEFAULT);/*to adjust size of image it needs to import java.awt.*; package to work*/
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i);
        image.setBounds(350,20,200,200);//because we used setlayout(null) so we have to expilicity set bounds
        add(image);//to place a component on a frame
        
        setSize(600,600);
        setLocation(400,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){//actionevent differentiates if it was called by either login or cancel since both call it 
        if(ae.getSource()==login){
            String username=tusername.getText();
            String password=tpassword.getText();
            try {
    Connec c = new Connec();

    ResultSet rs = c.s.executeQuery(
        "select * from student where username='" + username + "' and password='" + password + "'"
    );

    if (rs.next()) {
        setVisible(false);
        new Student();
    } else {
        rs = c.s.executeQuery(
            "select * from teacher where username='" + username + "' and password='" + password + "'"
        );

        if (rs.next()) {
            setVisible(false);
            new Faculty();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

} catch (Exception e) {
    e.printStackTrace();
}

            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
/*actionlistener is used for suppose the the dialoge has to close when we press 
on close button it is in java.awt.event.* pacakage*/