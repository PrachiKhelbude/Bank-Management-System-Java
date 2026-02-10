package bank.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textName, textFname, textEmail, textAdd, textCity, textPIN, textState;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignUp() {

        super("APPLICATION FORM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100, 240, 200, 30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setBounds(300, 240, 400, 30);
        add(textFname);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBounds(300, 290, 80, 30);
        r2.setBounds(420, 290, 100, 30);
        r1.setBackground(new Color(222, 255, 228));
        r2.setBackground(new Color(222, 255, 228));

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);

        JLabel DOB = new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);

        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300, 390, 400, 30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 440, 200, 30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m2 = new JRadioButton("Unmarried");
        m3 = new JRadioButton("Other");

        m1.setBounds(300, 440, 100, 30);
        m2.setBounds(420, 440, 120, 30);
        m3.setBounds(560, 440, 100, 30);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(m1);
        bg2.add(m2);
        bg2.add(m3);

        add(m1);
        add(m2);
        add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setBounds(100, 490, 200, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(300, 490, 400, 30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setBounds(100, 540, 200, 30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300, 540, 400, 30);
        add(textCity);

        JLabel labelPin = new JLabel("PIN Code :");
        labelPin.setBounds(100, 590, 200, 30);
        add(labelPin);

        textPIN = new JTextField();
        textPIN.setBounds(300, 590, 400, 30);
        add(textPIN);

        JLabel labelState = new JLabel("State :");
        labelState.setBounds(100, 640, 200, 30);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300, 640, 400, 30);
        add(textState);

        next = new JButton("Next");
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(360, 40);
        setUndecorated(true);
        getContentPane().setBackground(new Color(222, 255, 228));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String email = textEmail.getText();
        String address = textAdd.getText();
        String city = textCity.getText();
        String pin = textPIN.getText();
        String state = textState.getText();

        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
        String marital = m1.isSelected() ? "Married" : m2.isSelected() ? "Unmarried" : m3.isSelected() ? "Other" : "";

        if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || email.isEmpty()
                || address.isEmpty() || city.isEmpty() || pin.isEmpty() || state.isEmpty()
                || gender.isEmpty() || marital.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please fill all fields properly");
            return;
        }

        if (!name.matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(null, "Invalid Name");
            return;
        }

        if (!email.matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email");
            return;
        }

        if (!pin.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(null, "PIN must be 6 digits");
            return;
        }

        try {
            Con con = new Con();
            String q = "INSERT INTO signup VALUES('" + first + "','" + name + "','" + fname + "','" +
                    dob + "','" + gender + "','" + email + "','" + marital + "','" +
                    address + "','" + city + "','" + pin + "','" + state + "')";
            con.statement.executeUpdate(q);

            new Signup2(first);
            setVisible(false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
