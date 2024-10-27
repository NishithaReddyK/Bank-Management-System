package bank.management.system;
import java.sql.*;

/**
 *
 * @author chetankoliparthi
 */
public class Conn {
    //step-1:CREATE CONNECTION
    //step-2:CREATE STATEMENT
    Statement s;
    Connection c;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Chetan@2707");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
