package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class two extends JFrame implements ActionListener{
    JTextField pantTextField , aadharTextField;
    JRadioButton extaccno , extaccyes;
    JComboBox occ , edu , rel ,inc;
    JButton next;
    String formno;
    two(String formno){
        this.formno = formno;//to save get the formno of user so that data can be saved for particular user
        //FRAME
        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
        setTitle("Application Form Page 2");
        setLayout(null);

        JLabel additionnaldetails = new JLabel("Additional Details");
        additionnaldetails.setBounds(265, 80, 400, 30);
        additionnaldetails.setFont(new Font("Raleway",Font.BOLD,38));
        add(additionnaldetails);
        getContentPane().setBackground(Color.white);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100, 140, 100, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
        
        String valreligion[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        rel = new JComboBox<>(valreligion);//for dropdown list
        rel.setFont(new Font("Ralway" , Font.BOLD, 14));
        rel.setBounds(300,140,400,30);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel income= new JLabel("Income:");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(100,190,100,20);
        add(income);

        String valincome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        inc = new JComboBox<>(valincome);
        inc.setFont(new Font("raleway",Font.BOLD,14));
        inc.setBounds(300,190,400,30);
        inc.setBackground(Color.WHITE);
        add(inc);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("raleway",Font.BOLD,20));
        educational.setBounds(100,240,200,30);
        add(educational);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("raleway",Font.BOLD,20));
        qualification.setBounds(100,265,200,30);
        add(qualification);

        String valeducation[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        edu = new JComboBox<>(valeducation);
        edu.setFont(new Font("raleway",Font.BOLD,14));
        edu.setBounds(300,265,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);  

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100, 315, 200, 30);
        add(occupation);

        String valoccupation[]={"Salaried","Self-Employed","Businessman","Student","Other"};
        occ = new JComboBox<>(valoccupation);
        occ.setFont(new Font("raleway",Font.BOLD,14));
        occ.setBounds(300, 315, 400, 30);
        occ.setBackground(Color.WHITE);
        add(occ);

        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100, 365, 200, 30);
        add(pan);

        pantTextField = new JTextField();
        pantTextField.setFont(new Font("raleway",Font.BOLD,14));
        pantTextField.setBounds(300,365,400,30);
        add(pantTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100, 415, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,415,400,30);
        add(aadharTextField);

        JLabel Existingaccount = new JLabel("Existing Account:");
        Existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        Existingaccount.setBounds(100, 465, 200, 30);
        add(Existingaccount);

        extaccyes = new JRadioButton("Yes");
        extaccyes.setBounds(300, 465, 150, 30);
        extaccyes.setBackground(Color.WHITE);
        add(extaccyes);

        extaccno = new JRadioButton("No");
        extaccno.setBounds(450, 465, 170, 30);
        extaccno.setBackground(Color.WHITE);
        add(extaccno);

        ButtonGroup Extaccgrp = new ButtonGroup();
        Extaccgrp.add(extaccyes);
        Extaccgrp.add(extaccno);

        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setFont(new Font("raleway",Font.BOLD,14));
        add(next);
        next.setBounds(300 , 640 , 120, 30);
        next.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        String religion = (String)rel.getSelectedItem();
        String income = (String)inc.getSelectedItem();
        String education = (String)edu.getSelectedItem();
        String occupation = (String)occ.getSelectedItem();
        String pannumber = pantTextField.getText();
        String aadhar = aadharTextField.getText();
        String extacc = null;
        if(extaccyes.isSelected()){
            extacc = "Yes";
        }else{
            extacc = "No";
        } 
        try{
            conn c = new conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+income+"','"+education+"','"+occupation+"','"+pannumber+"','"+aadhar+"','"+extacc+"') ";
            c.s.executeUpdate(query);

            //signupthree
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new two("");
    }
}
