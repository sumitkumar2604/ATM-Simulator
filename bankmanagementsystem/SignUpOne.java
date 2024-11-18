package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//done by adding calender jar file in refernced libraries under java project section
import java.awt.event.*; //to perform action task 


public class SignUpOne extends JFrame implements ActionListener  {
    long Random;
    JTextField nameTextField , fnameTextField , dobTextField  , emailTextField  , addressTextField , cityTextField , stateTextField , pincodeTextField;
    JRadioButton married , unmarried , other , female , male;
    JDateChooser date;
    JButton next;
    SignUpOne(){
        //frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850 , 800);
        setLocation(350 , 10);
        setVisible(true);

        Random ran = new Random();//comes under util package
        Long Random = Math.abs(ran.nextLong()%9000L + 1000L);
        JLabel formno = new JLabel("Application Form No. " + Random);
        formno.setFont(new Font("Raleway" , Font.BOLD , 38));
        formno.setBounds(170, 20, 600, 40);//setbound will work only if setlayout is null
        add(formno);
        setLayout(null);//to make our own alignment of text

        JLabel personaldetails = new JLabel("Page 1 : Personal Details");
        personaldetails.setFont(new Font("Raleway" , Font.BOLD , 22));
        personaldetails.setBounds(275, 80, 400, 30);
        add(personaldetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway" , Font.BOLD , 20));
        name.setBounds(100,140, 100, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway" , Font.BOLD , 20));    
        fname.setBounds(100,190, 200, 30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(100,240, 400, 30);
        add(dob);
        date = new JDateChooser();
        date.setBounds(300 , 240 , 400 , 30);
        add(date);

        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        Gender.setBounds(100,290, 200, 30);
        add(Gender);
        male = new JRadioButton("Male");
        male.setBounds(300 , 290,60 , 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450 , 290,150 , 30);
        female.setBackground(Color.WHITE);
        add(female);
        //to select only one at a time out of male or female we use Buttongroup class
        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(100,340, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway" , Font.BOLD , 20));
        marital.setBounds(100,390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300 , 390,100 , 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450 , 390,100 , 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
  
        other = new JRadioButton("Other");
        other.setBounds(630 , 390,120 , 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway" , Font.BOLD , 20));
        address.setBounds(100,440, 200, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway" , Font.BOLD , 20));
        city.setBounds(100,490, 200, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(100,540, 200, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(100,590, 200, 30);
        add(pincode);
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.white);
        add(next);
        next.setBounds(300 , 640 , 120, 30);
        next.setFont(new Font("Raleway" , Font.BOLD , 14));
        next.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){//we are doing it to save our data in the database and data is given in the form of string
        String formno = "" + Random;
        String name = nameTextField.getText();//gettext is used to get the value of the textfield
        String fname = fnameTextField.getText();
        String dob =  ((JTextField) date.getDateEditor().getUiComponent()).getText();//getUicompoxtfield returns textfield so we neen to concatenate it with jtextfield
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if(female.isSelected()){
            gender = "female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);//to rujn the query in database

                //two class
                if(ae.getSource()==next){//to go to next page
                setVisible(false);
                new two(formno).setVisible(true);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        

    
    public static void main(String[] args) {
        new SignUpOne();
    }    
}
