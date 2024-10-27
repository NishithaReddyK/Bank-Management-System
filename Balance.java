
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author chetankoliparthi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balance extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    Balance(String pinnumber){
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
        
        back=new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,12));
        back.setBounds(430,580,75,20);
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c=new Conn();
        int Balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    Balance+=Integer.parseInt(rs.getString("amount"));
                        
                }else{
                    Balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Account Balance is:" + Balance);
        text.setForeground(Color.BLACK);
        text.setBounds(275,455,700,35);
        image.add(text);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
        
    
    public static void main(String args[]){
        new Balance("");
    }
}
