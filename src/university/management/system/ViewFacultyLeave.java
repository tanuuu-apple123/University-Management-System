
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class ViewFacultyLeave extends JFrame implements ActionListener {
JTextField rollNoField;
    JTable table;
    JButton search, print,cancel;
    ViewFacultyLeave(){
      getContentPane().setBackground(new Color(176, 224, 230));
        setLayout(null);

        JLabel heading = new JLabel("Search by employee id");
        heading.setBounds(20, 20, 160, 25);
        add(heading);

        rollNoField = new JTextField();
        rollNoField.setBounds(190, 20, 150, 25);
        add(rollNoField);

        table = new JTable();

        try {
            Connec c = new Connec();
            ResultSet rs = c.s.executeQuery("select * from leavesfaculty");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);//create scroll bar
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 25);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 25);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 70, 80, 25);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            String rollno = rollNoField.getText().trim();

            if (rollno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a remployee id");
                return;
            }

            try {
                Connec c = new Connec();

                String query = "select * from leavefaculty where empid = ?";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, rollno);

                ResultSet rs = pst.executeQuery();

                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Faculty not found");

                    // reload full table
                    ResultSet all = c.s.executeQuery("select * from leavefaculty");
                    table.setModel(DbUtils.resultSetToTableModel(all));
                } else {
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }  else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ViewStudentLeave();
    }

}
