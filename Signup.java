package bank.management.system;


/**
 *
 * @author chetankoliparthi
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField ,emailTextField,addressTextField;
    JButton next;
    JRadioButton male,Female;
    JDateChooser dateChooser;
    Signup(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs(ran.nextLong() % 9000L) +1000L;
        JLabel Formno=new JLabel("APPLICATION FORM NO.:"+random);
        Formno.setFont(new Font("Raleway",Font.BOLD,38));
        Formno.setBounds(140,20,600,40);
        add(Formno);
        JLabel personal=new JLabel("Personal details");
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        personal.setBounds(290,80,600,40);
        add(personal);
        
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,200,30);
        add(name);
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel DOB=new JLabel("Date of birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,22));
        DOB.setBounds(100,190,200,30);
        add(DOB);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,190,200,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,240,200,30);
        add(gender);
        male=new JRadioButton("MALE");
        male.setBounds(300,240,60,30);
        male.setBackground(Color.white);
        add(male);
        Female=new JRadioButton("FEMALE");
        Female.setBounds(450,240,120,30);
        Female.setBackground(Color.white);
        add(Female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(Female);
        
        
        JLabel email=new JLabel("Email address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,290,200,30);
        add(email);
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 290, 400, 30);
        add(emailTextField);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,340,200,30);
        add(address);
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 340, 400, 30);
        add(addressTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,410,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,600);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String Formno="",random; //longvalue
        String name=nameTextField.getText();
        String DOB=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        } else if(Female.isSelected()){
            gender="female";
        }
        String email=emailTextField.getText();
        String address=addressTextField.getText();
        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is required");
           }else {
               Conn c= new Conn();
               String query ="insert into Signup Values('"+Formno+"','"+name+"','"+DOB+"','"+gender+"','"+email+"','"+address+"')";
               c.s.executeUpdate(query);
           } 
           setVisible(false);
           new Signuptwo(Formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new Signup();
    }
}
