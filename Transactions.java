
package bank.management.system;

/**
 *
 * @author chetankoliparthi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit,wd,f,m,pinchange,balance,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/OIP.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select the transaction:");
        text.setBounds(275,455,700,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(275,510,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
         wd=new JButton("Withdraw");
        wd.setBounds(400,510,100,20);
        wd.addActionListener(this);
        image.add(wd);
        
        f=new JButton("Fast Cash");
        f.setBounds(275,540,100,20);
        f.addActionListener(this);
        image.add(f);
        
       m=new JButton("Statement");
        m.setBounds(400,540,100,20);
        m.addActionListener(this);
        image.add(m);
        
        pinchange=new JButton("PinChange");
        pinchange.setBounds(275,570,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balance=new JButton("Balance");
        balance.setBounds(400,570,100,20);
        balance.addActionListener(this);
        image.add(balance);
        
         exit=new JButton("EXIT");
        exit.setBounds(400,595,100,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==wd){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==f){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
