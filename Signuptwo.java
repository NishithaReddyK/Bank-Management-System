package bank.management.system;

/**
 *
 * @author chetankoliparthi
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Signuptwo extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String Formno;
    Signuptwo(String Formno){
        this.Formno=Formno;
        setLayout(null);
        JLabel l1=new JLabel("PAGE-2:ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        setSize(900,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("SAVINGS ACCOUNT");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup g= new ButtonGroup();
        g.add(r1);
        g.add(r2);
        g.add(r3);
        g.add(r4);
        
        JLabel card=new JLabel("Card Type:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel detail=new JLabel("(Your 16 digit Card Number)");
        detail.setFont(new Font("Raleway",Font.ITALIC,12));
        detail.setBounds(100,330,300,20);
        add(detail);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pdetail=new JLabel("(Your 4 digit Pin Number)");
        pdetail.setFont(new Font("Raleway",Font.ITALIC,12));
        pdetail.setBounds(100,400,300,20);
        add(pdetail);
        
        JLabel s=new JLabel("Services required: ");
        s.setFont(new Font("Raleway",Font.BOLD,22));
        s.setBounds(100,450,200,30);
        add(s);
        
        c1= new JCheckBox("ATM card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4= new JCheckBox("Email & SMS-Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6= new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7= new JCheckBox("Ihereby declare that the above details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,640,600,30);
        add(c7);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(420,700,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(600,700,100,30);
        add(cancel);
        cancel.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()) {
                accountType="saving account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            Random random=new Random();
            String cardnumber=""+(Math.abs(random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber=""+(Math.abs(random.nextLong() % 9000L) + 1000L);
            
            
            String facility="";
            if(c1.isSelected()){
                facility=facility+"ATM CARD";
            }else if(c2.isSelected()){
                facility=facility+"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+"Email&SMS Alerts";
            }else if(c5.isSelected()){
                facility=facility+"Cheque Box";
            }else if(c6.isSelected()){
                facility=facility+"E-Statement";
            }
            try{
              if(accountType.equals("")){
                  JOptionPane.showMessageDialog(null,"AccountType is required");
              }else if(ae.getSource()==cancel){
                  setVisible(false);
                  new Login().setVisible(true);
                  
                  
                  
              }else{
                  Conn conn=new Conn();
                  String query1="insert into Signuptwo values('"+Formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber +"','"+facility+"')";
                  String query2="insert into login values('"+Formno+"','"+cardnumber+"','"+pinnumber+"')";
                  conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null,"CARD NUMBER:"+cardnumber+"\n PIN NUMBER:"+pinnumber);
                  
                  setVisible(false);
                  new Deposit(pinnumber).setVisible(false);
                  
              }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new Signuptwo("");
        
    }
}
