package bankmanagementsystem;
import java.awt.*;

import javax.swing.*;
public class three extends JFrame{   
    JRadioButton savingaccount , currentaccount , fixeddeposit , recurringdeposit;
    three(){
        //FRAME
        setSize(850 , 820);
        setVisible(true);
        setLocation(350,10);
        setTitle("Account Details");
        setLayout(null);
        setBackground(Color.WHITE);


        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(100,140,200,40);
        add(type);

        savingaccount  = new JRadioButton("Saving Account");
        savingaccount.setFont(new Font("raleway",Font.BOLD,16));
        savingaccount.setBounds(100,190,150,20);
        savingaccount.setBackground(Color.white);
        add(savingaccount);

        currentaccount  = new JRadioButton("Current Account");
        currentaccount.setFont(new Font("raleway",Font.BOLD,16));
        currentaccount.setBounds(100,230,150,20);
        currentaccount.setBackground(Color.white);
        add(currentaccount);
        
        fixeddeposit  = new JRadioButton("Fixed Deposit Account");
        fixeddeposit.setFont(new Font("raleway",Font.BOLD,16));
        fixeddeposit.setBounds(300,190,200,20);
        fixeddeposit.setBackground(Color.white);
        add(fixeddeposit);

        recurringdeposit  = new JRadioButton("Recurring Deposit Account");
        recurringdeposit.setFont(new Font("raleway",Font.BOLD,16));
        recurringdeposit.setBounds(300,230,230,20);
        recurringdeposit.setBackground(Color.white);
        add(recurringdeposit);

        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(currentaccount);
        accounttype.add(savingaccount);
        accounttype.add(fixeddeposit);
        accounttype.add(recurringdeposit);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(100,280,200,40);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("raleway",Font.BOLD,22));
        number.setBounds(300,280,300,40);
        add(number);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("raleway",Font.BOLD,12));
        carddetails.setBounds(100,310,300,20);
        add(carddetails);

        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,40);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,22));
        pnumber.setBounds(300,350,100,40);
        add(pnumber);

        JLabel pindetails = new JLabel("Your 4 Digit Password");
        pindetails.setFont(new Font("raleway",Font.BOLD,12)); 
        pindetails.setBounds(100,380,300,20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(100,420,250,40);
        add(services);

    }
    public static void main(String[] args) {
        new three();
    }
    
}
