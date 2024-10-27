package bank.management.system;

/**
 *
 * @author NISHITHAKARNATI
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdraw(String pinnumber){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/OIP.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        text.setFont(new Font("System", Font.BOLD, 10));
        
        text.setBounds(275,375,700,35);
        text.setForeground(Color.BLACK);
        image.add(text);
        amount=new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBounds(285,410,200,30);
        image.add(amount);
        
        withdraw=new JButton("WITHDRAW");
        withdraw.setFont(new Font("System",Font.BOLD,12));
        withdraw.setBounds(340,450,100,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back=new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,12));
        back.setBounds(430,500,75,20);
        back.addActionListener(this);
        image.add(back);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount");
            }else{
                try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS:"+number+"Withdraw from your account successfully");
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
        new Withdraw("");
    }
}
