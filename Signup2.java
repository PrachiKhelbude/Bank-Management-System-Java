package bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1, r2, e1, e2;
    ButtonGroup seniorGroup, accountGroup;
    JButton next;
    String formno;

    public Signup2(String formno) {

        super("APPLICATION FORM - PAGE 2");
        this.formno = formno;
        setLayout(null);

        // 🔹 LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 2 : Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 600, 40);
        add(l1);


        JLabel l3 = new JLabel("Religion:");
        l3.setBounds(100, 120, 150, 30);
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l3);

        comboBox = new JComboBox(new String[]{"Hindu","Muslim","Sikh","Christian","Other"});
        comboBox.setBounds(350,120,320,30);
        add(comboBox);


        JLabel l4 = new JLabel("Category:");
        l4.setBounds(100,170,150,30);
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l4);

        comboBox2 = new JComboBox(new String[]{"General","OBC","SC","ST","Other"});
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income:");
        l5.setBounds(100,220,150,30);
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l5);

        comboBox3 = new JComboBox(new String[]{
                "Null","<1,50,000","<2,50,000","5,00,000",
                "Up to 10,00,000","Above 10,00,000"});
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);


        JLabel l6 = new JLabel("Education:");
        l6.setBounds(100,270,150,30);
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l6);

        comboBox4 = new JComboBox(new String[]{
                "Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"});
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        // Occupation
        JLabel l7 = new JLabel("Occupation:");
        l7.setBounds(100,320,150,30);
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l7);

        comboBox5 = new JComboBox(new String[]{
                "Salaried","Self-Employed","Business","Student","Retired","Other"});
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);


        JLabel l8 = new JLabel("PAN Number:");
        l8.setBounds(100,370,150,30);
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l8);

        textPan = new JTextField();
        textPan.setBounds(350,370,320,30);
        add(textPan);

        // Aadhar
        JLabel l9 = new JLabel("Aadhar Number:");
        l9.setBounds(100,420,180,30);
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setBounds(350,420,320,30);
        add(textAadhar);

        // Senior Citizen
        JLabel l10 = new JLabel("Senior Citizen:");
        l10.setBounds(100,470,180,30);
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setBounds(350,470,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBounds(460,470,100,30);
        add(r2);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(r1);
        seniorGroup.add(r2);

        // Existing Account
        JLabel l11 = new JLabel("Existing Account:");
        l11.setBounds(100,520,180,30);
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setBounds(350,520,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setBounds(460,520,100,30);
        add(e2);
        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);

        accountGroup = new ButtonGroup();
        accountGroup.add(e1);
        accountGroup.add(e2);


        next = new JButton("Next");
        next.setBounds(570,600,100,30);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(170, 232, 216));
        setSize(850,720);
        setUndecorated(true);
        setLocation(450,80);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = r1.isSelected() ? "Yes" : "No";
        String eAccount = e1.isSelected() ? "Yes" : "No";

        // ✅ VALIDATION
        if (pan.equals("") || aadhar.equals("")) {
            JOptionPane.showMessageDialog(null,"Fill all the fields");
            return;
        }

        if (!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
            JOptionPane.showMessageDialog(null,"Invalid PAN format");
            return;
        }

        if (!aadhar.matches("[0-9]{12}")) {
            JOptionPane.showMessageDialog(null,"Aadhar must be 12 digits");
            return;
        }

        try {
            Con c = new Con();

            String q = "INSERT INTO Signuptwo VALUES('" +
                    formno + "','" +
                    comboBox.getSelectedItem() + "','" +
                    comboBox2.getSelectedItem() + "','" +
                    comboBox3.getSelectedItem() + "','" +
                    comboBox4.getSelectedItem() + "','" +
                    comboBox5.getSelectedItem() + "','" +
                    pan + "','" +
                    aadhar + "','" +
                    scitizen + "','" +
                    eAccount + "')";

            c.statement.executeUpdate(q);


            setVisible(false);
            new Signup3(formno);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }

    public static class Signup {
    }
}
