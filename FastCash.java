package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton deposit,wd,f,m,pinchange,balance,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/OIP.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount to withdraw");
        text.setBounds(275,455,700,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit=new JButton("RS.500");
        deposit.setBounds(275,510,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
         wd=new JButton("RS.1000");
        wd.setBounds(400,510,100,20);
        wd.addActionListener(this);
        image.add(wd);
        
        f=new JButton("RS.2000");
        f.setBounds(275,540,100,20);
        f.addActionListener(this);
        image.add(f);
        
       m=new JButton("RS.5000");
        m.setBounds(400,540,100,20);
        m.addActionListener(this);
        image.add(m);
        
        pinchange=new JButton("RS.10000");
        pinchange.setBounds(275,570,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balance=new JButton("RS.25000");
        balance.setBounds(400,570,100,20);
        balance.addActionListener(this);
        image.add(balance);
        
         exit=new JButton("BACK");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
                int Balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        Balance+=Integer.parseInt(rs.getString("amount"));
                        
                    }else{
                        Balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() !=exit && Balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS"+amount+"Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true); 
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}