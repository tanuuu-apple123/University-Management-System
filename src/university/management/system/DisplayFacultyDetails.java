
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class DisplayFacultyDetails extends JFrame implements ActionListener {
JTextField rollNoField;
    JTable table;
    JButton search, print, update, add, cancel;
    DisplayFacultyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 160, 25);
        add(heading);

        rollNoField = new JTextField();
        rollNoField.setBounds(190, 20, 150, 25);
        add(rollNoField);

        table = new JTable();

        try {
            Connec c = new Connec();
            ResultSet rs = c.s.executeQuery("select * from facultyinfo");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Improve column visibility
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

int[] widths = {
    120, // name
    120, // fname
    120, // mname
    80,  // roll
    100, // dob
    200, // address
    120, // phoneno
    200, // email
    80,  // tenper
    80,  // interper
    120, // aadhar
    80,  // course
    120  // branch
};

for (int i = 0; i < widths.length; i++) {
    table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
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

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 25);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 25);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 25);
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
                JOptionPane.showMessageDialog(null, "Please enter a employeeid");
                return;
            }

            try {
                Connec c = new Connec();

                String query = "select * from facultyinfo where roll = ?";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, rollno);

                ResultSet rs = pst.executeQuery();

                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "faculty not found");

                    // reload full table
                    ResultSet all = c.s.executeQuery("select * from facultyinfo");
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

        } else if (ae.getSource() == add) {

            setVisible(false);
            new AddFaculty();

        } else if (ae.getSource() == update) {

            setVisible(false);
            new updateTeacher();

        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new DisplayFacultyDetails();
    }

}

