package bank.management.system;
import java.sql.*;

/**
 * THIS CODE CONNECTS YOUR PROJECT TO THE DATABASE
 * 
 */
public class Conn {
    //step-1:CREATE CONNECTION
    //step-2:CREATE STATEMENT
    Statement s;
    Connection c;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","YOUR MYSQL CREATED PASSWORD");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
