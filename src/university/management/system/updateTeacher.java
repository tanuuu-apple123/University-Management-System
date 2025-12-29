package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateTeacher extends JFrame implements ActionListener {

    JTextField tfroll, tfaddress, tfphone, tfemail;
    JTextField tfqualification, tfdepartment, tfdesignation;

    JLabel labelname, labelfname, labeldob, labelroll;
    JButton search, update, cancel;

    updateTeacher() {

        setSize(900, 650);
        setLocation(300, 100);
        setLayout(null);

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(260, 20, 400, 30);
        add(heading);

        // ---- ENTER ROLL ----
        JLabel lblroll = new JLabel("Enter Faculty Roll");
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
        JLabel lblroll2 = new JLabel("Roll");
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

        // ---- QUALIFICATION ----
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 320, 100, 25);
        add(lblqualification);

        tfqualification = new JTextField();
        tfqualification.setBounds(200, 320, 200, 25);
        add(tfqualification);

        // ---- DEPARTMENT ----
        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(450, 320, 100, 25);
        add(lbldepartment);

        tfdepartment = new JTextField();
        tfdepartment.setBounds(600, 320, 200, 25);
        add(tfdepartment);

        // ---- DESIGNATION ----
        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50, 360, 100, 25);
        add(lbldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 360, 200, 25);
        add(tfdesignation);

        // ---- BUTTONS ----
        update = new JButton("Update");
        update.setBounds(250, 430, 120, 30);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 430, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    // ---------------- ACTIONS ----------------
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            fetchFaculty();
        } else if (ae.getSource() == update) {
            updateTeacher();
        } else {
            setVisible(false);
        }
    }

    // ---------------- FETCH ----------------
    private void fetchFaculty() {
        try {
            Connec c = new Connec();
            String query = "select * from facultyinfo where roll='" + tfroll.getText() + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                labelroll.setText(rs.getString("roll"));

                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phoneno"));
                tfemail.setText(rs.getString("email"));
                tfqualification.setText(rs.getString("qualification"));
                tfdepartment.setText(rs.getString("department"));
                tfdesignation.setText(rs.getString("designation"));

            } else {
                JOptionPane.showMessageDialog(null, "No faculty found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- UPDATE ----------------
    private void updateTeacher() {
        try {
            Connec c = new Connec();

            String query =
                "update facultyinfo set " +
                "address='" + tfaddress.getText() + "', " +
                "phoneno='" + tfphone.getText() + "', " +
                "email='" + tfemail.getText() + "', " +
                "qualification='" + tfqualification.getText() + "', " +
                "department='" + tfdepartment.getText() + "', " +
                "designation='" + tfdesignation.getText() + "' " +
                "where roll='" + labelroll.getText() + "'";

            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Faculty Details Updated Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new updateTeacher();
    }
}
