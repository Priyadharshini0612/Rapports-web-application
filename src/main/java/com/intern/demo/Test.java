package com.intern.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Test {
    public static void main (String args[])
    {

        String url="jdbc:mysql://localhost:3306/rapports";
        String user="root";
        String password="Jacksparrow@123";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,password);
            System.out.println("Connection is Successful to the database"+url);
            String query="Insert roles(role_id,role_name)values(102,'diya')";
            Statement statement =connection.createStatement();
            statement.execute (query);


        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException throwables ){
            throwables.printStackTrace();
        }

    }
}


