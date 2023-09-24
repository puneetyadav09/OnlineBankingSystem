package BankManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            s = c.createStatement();
            String a = "CREATE DATABASE IF NOT EXISTS OnlineBankingSystem";
            s.execute(a);
            String query1 = "USE OnlineBankingSystem";
            s.execute(query1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
