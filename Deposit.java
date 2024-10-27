package bank.management.system;

/**
 *
 * @author chetankoliparthi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/OIP.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setFont(new Font("System", Font.BOLD, 12));
        
        text.setBounds(275,455,700,35);
        text.setForeground(Color.BLACK);
        image.add(text);
        amount=new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBounds(285,490,200,30);
        image.add(amount);
        
        deposit=new JButton("DEPOSIT");
        deposit.setFont(new Font("System",Font.BOLD,12));
        deposit.setBounds(350,530,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,12));
        back.setBounds(430,580,75,20);
        back.addActionListener(this);
        image.add(back);
        }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount");
            }else{
                try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS:"+number+"Deposited to your account successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                     System.out.println(e);
                }
            }
        }else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
            new Deposit("");
        
    }
}