package bank.management.system;

/**
 *
 * @author NISHITHAKARNATI
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton Login,SIGNUP,clear;
    JTextField CARDTextField;
    JPasswordField PINTextField;
    Login(){
        setTitle("BANK_MANAGEMENT");
        setLayout(null);
        //displaying the logo
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo-bank-png-10.jpg"));
        //adjusting the icon
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);//moves the logo to desired location
        add(label);
        
        //writing the content
        JLabel text= new JLabel("WELCOME TO THE BANK");
        //changing the font
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,500,40);
        add(text);
        
        JLabel CARD= new JLabel("CARD NUMBER");
        //changing the font
        CARD.setFont(new Font("Raleway",Font.BOLD,20));
        CARD.setBounds(120,150,220,30);
        add(CARD);
        CARDTextField= new JTextField();
        CARDTextField.setBounds(300,150,250,30);
        add(CARDTextField);
        JLabel PIN=new JLabel("ENTER YOUR PIN");
        //changing the font
        PIN.setFont(new Font("Raleway",Font.BOLD,20));
        PIN.setBounds(120,220,220,30);
        add(PIN);
        PINTextField= new JPasswordField();
        PINTextField.setBounds(300,220,250,30);
        add(PINTextField);
        Login = new JButton("SIGN IN");
        Login.setBounds(300,280,100,30);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);
        
        SIGNUP = new JButton("SIGN UP");
        SIGNUP.setBounds(300,320,230,30);
        SIGNUP.setBackground(Color.black);
        SIGNUP.setForeground(Color.white);
        SIGNUP.addActionListener(this);
        add(SIGNUP);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,280,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        getContentPane().setBackground(Color.white);
        setSize(800,400); //define the frame length and breadth
        setVisible(true); //visible to the user
        setLocation(350,200);//when the code is compiled the frame opens at the desired location
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            CARDTextField.setText(" ");
            PINTextField.setText(" ");
        }else if(ae.getSource()==SIGNUP){
            setVisible(false);
            new Signup().setVisible(true);
        }else if(ae.getSource()==Login){
            Conn conn=new Conn();
            String cardnumber=CARDTextField.getText();
            String pinnumber=PINTextField.getText();
            String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect pin or cardnumber");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}
