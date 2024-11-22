package bankmanagementsystem;

import java.util.Date;
import javax.swing.*;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;

public class fastcash extends JFrame implements ActionListener{
    String pinno;
    JButton o1,o2,o3,o4,o5,back;
    fastcash(String pinno){
        this.pinno = pinno;
        setSize(900,900);
        setVisible(true);
        setLayout(null);
        setLocation(300,0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("raleway" , Font.BOLD,16));
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        o1 = new JButton("Rs 500");
        o1.setBounds(170,415,150,30);
        image.add(o1);
        o1.addActionListener(this);

        o2 = new JButton("Rs 1000");
        o2.setBounds(350,415,150,30);
        image.add(o2);
        o2.addActionListener(this);

        o3 = new JButton("Rs 2000");
        o3.setBounds(170,450,150,30);
        image.add(o3);
        o3.addActionListener(this);

        o4 = new JButton("Rs 5000");
        o4.setBounds(350,450,150,30);
        image.add(o4);
        o4.addActionListener(this);

        o5 = new JButton("Rs 10000");
        o5.setBounds(170,485,150,30);
        image.add(o5);
        o5.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(350,485,150,30);
        image.add(back);
        back.addActionListener(this);

        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==back){
                setVisible(false);
                new transactions(pinno).setVisible(true);
            }else{
                String amount = ((JButton)ae.getSource()).getText().substring(3);
                try{
                    conn c = new conn();
                    String Query = "select * from bank where pin = '"+pinno+"'";
                    ResultSet rs = c.s.executeQuery(Query);
                    int balance = 0;
                    while(rs.next()){//helps to go through every row of bank table
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date date = new Date();//as date class is in both util package and sql package it will show ambiguity if we dont define from which package we need to use date class
                    String query1 = "insert into bank values ('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited Successfully");
                    setVisible(false);
                    new transactions(pinno).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    public static void main(String[] args) {
        new fastcash("");

    }
}
