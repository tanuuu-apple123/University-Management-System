package university.management.system;
import javax.swing.*;//for frame we need it
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/genshin-x-gigo-ayaka-thoma-xinqiu-chongyun.png"));//to get icons in our system write where it is inside""
        Image i2=i.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);/*to adjust size of image it needs to import java.awt.*; package to work*/
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i);
        add(image);//to place a component on a frame
        t=new Thread(this);
        t.start();
        setSize(800,600);
        setLocation(400,100);
        setVisible(true);
       
    }
     public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            //next frame
            new Login(); //creating object of login here fromlogin
        }catch(Exception e){}
    }
    public static void main(String[] args){
        new Splash();
    }
}

