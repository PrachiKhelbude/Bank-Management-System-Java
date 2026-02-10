package bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    public Login() {
        super("Bank Management System");

        setLayout(null);


        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bg2 = bg1.getImage().getScaledInstance(900, 480, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel background = new JLabel(bg3);
        background.setBounds(0, 0, 900, 480);
        add(background);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        background.add(image);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel card = new JLabel(ii3);
        card.setBounds(630, 350, 100, 100);
        background.add(card);


        JLabel label1 = new JLabel("Welcome To ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        background.add(label1);


        JLabel label2 = new JLabel("Card No:");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150, 190, 200, 30);
        background.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 19));
        background.add(textField2);


        JLabel label3 = new JLabel("PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150, 250, 200, 30);
        background.add(label3);

        passwordField3 = new JPasswordField();
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        background.add(passwordField3);


        button1 = new JButton("Sign In");
        button1.setBounds(300, 300, 100, 30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        background.add(button1);


        button2 = new JButton("Clear");
        button2.setBounds(430, 300, 100, 30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        background.add(button2);


        button3 = new JButton("Sign Up");
        button3.setBounds(300, 350, 230, 30);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        background.add(button3);

        setSize(850, 480);
        setLocation(450, 200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            Con c=new Con();
            String cardno=textField2.getText();
            String pin =passwordField3.getText();

            String q = "SELECT * FROM login WHERE card_number = '" + cardno + "' AND pin = '" + pin + "'";
            ResultSet resultSet = null;
            try {
                resultSet = c.statement.executeQuery(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            try {
                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        } else if (e.getSource() == button2) {
            textField2.setText("");
            passwordField3.setText("");

        } else if (e.getSource() == button3) {
            new SignUp();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
