package bankmanagementsystem;
import javax.swing.*;//to creat deskptop graphicasl user interface , Imageicon class

import java.sql.*;

import java.awt.*;//to creat deskptop graphicasl user interface , image class
import java.awt.event.*;//to perform action task 

public class Login extends JFrame implements ActionListener {
  JButton Login, Clear , signup;//globaly defined
  JTextField cardtextfield;//globaly defined
  JPasswordField pintextfield;//globaly defined because we need to use it i action buttons and that comes uunder different class and different package
    Login(){
        setTitle("AUTOMATED TELLER MACHINE"); 
        setLayout(null);//to make our own alignment of text
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100 , 100 , Image.SCALE_DEFAULT);
        //we cannot place i2 directly in JLabel because IMage class is part of awT package so we need to convert it into ImageIcon4
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Label = new JLabel(i3);//to add image on frame we need to put it into label first
        Label.setBounds(70, 10, 100, 100);//to make our own custom layout so that alignment is not in center
        add(Label);*/
        JLabel text = new JLabel("Welcome To ATM");//main function of JLabel class is to add text on the frame
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.PLAIN, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        cardtextfield = new JTextField();//to add the box where user can enter the card number
        cardtextfield.setBounds(270, 150, 250, 30);
        add(cardtextfield);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.PLAIN, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);
        pintextfield = new JPasswordField();
        pintextfield.setBounds(270, 220, 250, 30);
        add(pintextfield);

        Login = new JButton("Sign In");//to add button 
        Login.setBounds(270, 270, 103, 30);
        add(Login);
        Login.addActionListener(this);
        Clear = new JButton("Clear");//to add button 
        Clear.setBounds(415, 270, 103, 30);
        add(Clear);
        Clear.addActionListener(this);
        signup = new JButton("Sign up");//to add button 
        signup.setBounds(270, 315, 250, 30);
        add(signup);
        signup.addActionListener(this); 

        //FRAME
        setSize(800 , 480);
        setVisible(true);
        setLocation(400 , 200);
        getContentPane().setBackground(Color.WHITE);
    } 
    public void actionPerformed(ActionEvent ae){//to perform action of buttons
      if(ae.getSource() == Clear){
        cardtextfield.setText(null);//settext is used to set the value of the tescxtfield
        pintextfield.setText(null);
      }else if (ae.getSource()==Login){
        conn c = new conn();
        String cardnumber1 = cardtextfield.getText();
        String pinnumber1 = pintextfield.getText();
        String query = "select * from login where cardnumber = '"+cardnumber1+"' and pinnumber = '"+pinnumber1+"' ";
        try{
          ResultSet rs = c.s.executeQuery(query);//excecutequery command is used for DDL sql queries
          if(rs.next()){//this rs.next() function check if the data is driven from the database
            setVisible(false);
            new transactions().setVisible(true);
          }else {
            JOptionPane.showMessageDialog(null, "Incorrect Card Number  or Pin"); 
          }
        }catch(Exception e){
          System.out.println(e);
        }
      }else if (ae.getSource()==signup){
        setVisible(false);
        new SignUpOne().setVisible(true);
      }
    }
    public static void main(String[] args) {
      new Login();
    }
}