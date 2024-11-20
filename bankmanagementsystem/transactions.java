package bankmanagementsystem;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener{
    JButton deposit , fastcash , cashwithdraw ,ministatement , pinchange , balanceenquiry , exit;
    transactions(){
        //FRAME
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transactoin");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);//if we just add the text it will on frame but not on the top of image

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        image.add(deposit); 
        deposit.addActionListener(this);

        cashwithdraw = new JButton("Cash Withdraw");
        cashwithdraw.setBounds(355,415,150,30);
        image.add(cashwithdraw); 
        cashwithdraw.addActionListener(this);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash); 
        fastcash.addActionListener(this);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement); 
        ministatement.addActionListener(this);

        pinchange = new JButton("Fast Cash");
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange); 
        pinchange.addActionListener(this);

        balanceenquiry = new JButton("Balace Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry); 
        balanceenquiry.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
      
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new transactions();
    }
}