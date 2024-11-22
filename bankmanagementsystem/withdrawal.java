package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class withdrawal extends JFrame implements ActionListener{
    JTextField amttxtfld;
    JButton wthdrw , back;
    String pinno;
    withdrawal(String pinno){
        this.pinno = pinno;
        setSize(900,900);
        setLayout(null);
        setLocation(300,0);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);;
        add(image);

        JLabel amount = new JLabel("Enter amount you want to Withdraw");
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("raleway",Font.BOLD,16));
        amount.setBounds(170,300,400,20);
        image.add(amount);

        amttxtfld = new JTextField();
        amttxtfld.setFont(new Font("Raleway",Font.BOLD,22));
        amttxtfld.setBounds(170,350,320,25);
        image.add(amttxtfld);
        
        wthdrw = new JButton("Withdraw");
        wthdrw.setBounds(340,485,150,30);
        image.add(wthdrw);
        wthdrw.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(340,520,150,30);
        image.add(back);
        back.addActionListener(this);   
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==wthdrw){
        String wth = amttxtfld.getText();
        Date date = new Date();
        if(wth.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
        }else {
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
                    if(ae.getSource()!=back && balance < Integer.parseInt(wth)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
            String query = "insert into bank values ('"+pinno+"','"+date+"','Withdraw','"+wth+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs"+wth+" Debited Successfully");
            setVisible(false);
            new transactions(pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }       
    }else if(ae.getSource()==back){
        setVisible(false);
        new transactions(pinno).setVisible(true);
    }
 }

    
    public static void main(String[] args) {
        new withdrawal("");
    }
    
}
