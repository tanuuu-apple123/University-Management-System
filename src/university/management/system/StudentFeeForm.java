package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    JTextField tfRoll;
    JComboBox cbcourse, cbsemester;
    JLabel labelName, labelFname, labelTotal;
    JButton update, pay, back;

    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(205, 133, 63));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hello.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(400, 50, 500, 300);
        add(image);

        JLabel lblRoll = new JLabel("Enter Roll");
        lblRoll.setBounds(40, 60, 150, 20);
        lblRoll.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblRoll);

        tfRoll = new JTextField();
        tfRoll.setBounds(200, 60, 150, 25);
        add(tfRoll);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 100, 150, 20);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(200, 100, 150, 20);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelName);

        JLabel lblFname = new JLabel("Father's Name");
        lblFname.setBounds(40, 140, 150, 20);
        lblFname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblFname);

        labelFname = new JLabel();
        labelFname.setBounds(200, 140, 150, 20);
        labelFname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelFname);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setBounds(40, 180, 150, 20);
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblCourse);

        String courses[] = {
            "B.Teach - Computer Science","B.Teach - Electronics","B.Teach - Mechanical","B.Teach - Civil",
            "BBA - Marketing","BBA - Finance","BBA - HR",
            "MBA - Marketing","MBA - Finance","MBA - HR","MBA - Operations",
            "Bsc - Computer Science","Bsc - Physics","Bsc - Mathematics",
            "B.ed - Maths","B.ed - Science","B.ed - English",
            "MCA - Computer Applications",
            "BA - English","BA - Economics","BA - History",
            "MA - English","MA - Psychology","MA - Political Science"
        };
        cbcourse = new JComboBox(courses);
        cbcourse.setBounds(200, 180, 200, 25);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(40, 220, 150, 20);
        lblSemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblSemester);

        String semester[] = {
            "Semester1", "Semester2", "Semester3", "Semester4",
            "Semester5", "Semester6", "Semester7", "Semester8"
        };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 220, 150, 25);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblTotal = new JLabel("Total Payable");
        lblTotal.setBounds(40, 260, 150, 20);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblTotal);

        labelTotal = new JLabel();
        labelTotal.setBounds(200, 260, 150, 20);
        labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTotal);

        update = new JButton("Update");
        update.setBounds(30, 320, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 320, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 320, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        // Fetch student details when roll is typed and focus lost
        tfRoll.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent fe) {
                try {
                    String roll = tfRoll.getText();
                    Connec c = new Connec();
                    String query = "select * from studentinfo where roll='"+roll+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()) {
                        labelName.setText(rs.getString("name"));
                        labelFname.setText(rs.getString("fname"));
                    } else {
                        labelName.setText("");
                        labelFname.setText("");
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            try {
                Connec c = new Connec();
                ResultSet rs = c.s.executeQuery("select * from fee where course='"+course+"'");
                if(rs.next()) {
                    labelTotal.setText(rs.getString("semfee"));
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == pay) {
            String roll = tfRoll.getText();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = labelTotal.getText();

            try {
                Connec c = new Connec();
                String query = "insert into collegefee(roll, course, semester, total) values('"+roll+"', '"+course+"', '"+semester+"', '"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
