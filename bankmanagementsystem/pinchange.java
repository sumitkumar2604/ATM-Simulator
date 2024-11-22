package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
    JPasswordField newpin , renewpin;
    JButton change , back;
    String pinno;
    pinchange(String pinno){
        this.pinno = pinno;
        setSize(900,900);
        setVisible(true);
        setLayout(null);
        setLocation(300,0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("raleway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);    

        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        newpin = new JPasswordField();
        newpin.setBounds(320,320,100,25);
        newpin.setBackground(Color.white);
        image.add(newpin);

        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("raleway",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        renewpin = new JPasswordField();
        renewpin.setBounds(320,360,100,25);
        renewpin.setBackground(Color.white);
        image.add(renewpin);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
    
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String pin = newpin.getText();  
                String repin = renewpin.getText();
                if(!pin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New Pin");
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
                }

                conn c = new conn();
                String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinno+"'";
                String query2 = "update login set pinnumber = '"+repin+"' where pinnumber = '"+pinno+"'";
                String query3 = "update signupthree set pinnumber = '"+repin+"' where pinnumber = '"+pinno+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin chnaged successfully");

                setVisible(false);
                new transactions(repin).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new transactions(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
         new pinchange("");
    }
}
