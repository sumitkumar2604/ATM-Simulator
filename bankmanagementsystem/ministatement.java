package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class ministatement extends JFrame  {
    String pinno;
    ministatement(String pinno){
        this.pinno = pinno;

        setSize(400,600);
        setVisible(true);
        setLayout(null);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select cardnumber from login where pinnumber = '"+pinno+"'");
            while(rs.next()){
                    card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e ){
            System.out.println(e);
        }
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            int bal = 0;
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");//<html> tag for space
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Your current accoutn balance is Rs "+bal);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
    public static void main(String[] args) {
        new ministatement("");
    }
}
