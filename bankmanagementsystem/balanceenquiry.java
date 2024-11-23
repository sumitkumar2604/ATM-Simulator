package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.CookieHandler;
import java.sql.ResultSet;
public class balanceenquiry extends JFrame implements ActionListener {
    JButton back;
    String pinno;
    balanceenquiry(String pinno){
        this.pinno = pinno;
        setSize(900,900);
        setLayout(null);
        setLocation(300,0);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);    
        back.addActionListener(this);

        int balance = 0;
        try{
            conn c = new conn();
            String Query = "select * from bank where pin = '"+pinno+"'";
            ResultSet rs = c.s.executeQuery(Query);

            while(rs.next()){//helps to go through every row of bank table
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Account Balance is Rs "+ balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transactions(pinno).setVisible(true);
        }else{
           
        }
    }
    public static void main(String[] args) {
        new balanceenquiry("");
    }
    
}
