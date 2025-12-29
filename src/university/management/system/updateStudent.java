package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateStudent extends JFrame implements ActionListener {

    JTextField tfroll, tfaddress, tfphone, tfemail, tfcourse, tfbranch;
    JLabel labelname, labelfname, labeldob, labelroll;
    JButton search, update, cancel;

    updateStudent() {

        setSize(900, 650);
        setLocation(300, 100);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(250, 20, 400, 30);
        add(heading);

        // ---- ENTER ROLL ----
        JLabel lblroll = new JLabel("Enter Roll Number");
        lblroll.setBounds(50, 80, 150, 25);
        add(lblroll);

        tfroll = new JTextField();
        tfroll.setBounds(200, 80, 200, 25);
        add(tfroll);

        search = new JButton("Search");
        search.setBounds(420, 80, 100, 25);
        search.addActionListener(this);
        add(search);

        // ---- NAME ----
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 140, 100, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 140, 200, 25);
        add(labelname);

        // ---- FATHER NAME ----
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 140, 120, 25);
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 140, 200, 25);
        add(labelfname);

        // ---- DOB ----
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 180, 120, 25);
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 180, 200, 25);
        add(labeldob);

        // ---- ROLL DISPLAY ----
        JLabel lblroll2 = new JLabel("Roll Number");
        lblroll2.setBounds(50, 180, 100, 25);
        add(lblroll2);

        labelroll = new JLabel();
        labelroll.setBounds(200, 180, 200, 25);
        add(labelroll);

        // ---- ADDRESS ----
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 240, 100, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 240, 200, 25);
        add(tfaddress);

        // ---- PHONE ----
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(450, 240, 100, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 240, 200, 25);
        add(tfphone);

        // ---- EMAIL ----
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 280, 100, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 280, 200, 25);
        add(tfemail);

        // ---- COURSE ----
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 320, 100, 25);
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 320, 200, 25);
        add(tfcourse);

        // ---- BRANCH ----
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(450, 320, 100, 25);
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 320, 200, 25);
        add(tfbranch);

        // ---- BUTTONS ----
        update = new JButton("Update");
        update.setBounds(250, 400, 120, 30);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 400, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    // ---------------- ACTIONS ----------------
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            fetchStudent();
        } else if (ae.getSource() == update) {
            updateStudent();
        } else {
            setVisible(false);
        }
    }

    // ---------------- FETCH ----------------
    private void fetchStudent() {
        try {
            Connec c = new Connec();
            String query = "select * from studentinfo where roll='" + tfroll.getText() + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                labelroll.setText(rs.getString("roll"));

                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phoneno"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));

            } else {
                JOptionPane.showMessageDialog(null, "No student found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- UPDATE ----------------
    private void updateStudent() {
        try {
            Connec c = new Connec();

            String query =
                "update studentinfo set " +
                "address='" + tfaddress.getText() + "', " +
                "phoneno='" + tfphone.getText() + "', " +
                "email='" + tfemail.getText() + "', " +
                "course='" + tfcourse.getText() + "', " +
                "branch='" + tfbranch.getText() + "' " +
                "where roll='" + labelroll.getText() + "'";

            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Updated Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new updateStudent();
    }
}
