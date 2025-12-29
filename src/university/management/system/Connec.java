
package university.management.system;
import java.sql.*;
public class Connec {
    Connection c;//Connection is an interface from the java.sql package.
    Statement s;
    Connec(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","Durin50@50@1");
           s=c.createStatement();//to execute mysql statements
        }catch(Exception e){   //if port number is3306 can be removed//databasename,username,password
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Connec();
    }
}
