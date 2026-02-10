package bank.Management.System;

import java.sql.*;


public class Con {
    Connection connection;
    public Statement statement;
    public Con(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem1", "root", "admin2821");
statement=connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
