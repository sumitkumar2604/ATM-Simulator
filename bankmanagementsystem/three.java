package bankmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class three extends JFrame implements ActionListener{   
    JRadioButton savingaccount , currentaccount , fixeddeposit , recurringdeposit;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel ;
    String formno;

    three(String formno){
        this.formno = formno;
        //FRAME
        setSize(850 , 820);
        setVisible(true);
        setLocation(350,10);
        setTitle("Account Details");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


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

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBounds(100,470,200,30);
        c1.setBackground(Color.WHITE);
        add(c1); 

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBounds(350,470,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBounds(100,520,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBounds(350,520,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBounds(100,570,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBounds(350,570,400,30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBounds(100,630,600,30);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        add(cancel);
        cancel.addActionListener(this);//that we want some action is performed on click of this button

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype = null;
            if(savingaccount.isSelected()){
                accounttype = "Saving Account";
            }else if(currentaccount.isSelected()){
                accounttype = "Current Account";
            }else if(fixeddeposit.isSelected()){
                accounttype = "Fixed Deposit Account";
            }else if(recurringdeposit.isSelected()){
                accounttype = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = " "+Math.abs((random.nextLong()%90000000L))+50409360L;//" " this is concatenated to convert long to string
            String pinnumber = " "+Math.abs((random.nextLong()%9000L)); 
            
            String services = "";
            if(c1.isSelected()){
                services=services+" ATM CARD";
            }else if(c2.isSelected()){
                services=services+" Internet Banking";
            }else if(c1.isSelected()){
                services=services+" Mobile Banking";
            }else if(c1.isSelected()){
                services=services+" EMAIL & SMS Alerts";
            }else if(c1.isSelected()){
                services=services+" Cheque Book";
            }else if(c1.isSelected()){
                services=services+" E-Statement";
            }

            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Required  ");
                }else {
                    conn c = new conn();
                    String query1 =  "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
                    String query2 =  "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    c.s.executeUpdate(query1);//excecuteupdate command is for datamanipulation
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null , "Card Number: "+ cardnumber +  " Pin Number: "+pinnumber);
                }

            }catch(Exception e){
                System.out.println(e);  
            }
        }else if(ae.getSource()==cancel){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new three("");
    }
    
}
