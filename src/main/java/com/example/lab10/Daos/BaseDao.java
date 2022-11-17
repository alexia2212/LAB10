package com.example.lab10.Daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BaseDao {
    public Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/bi_corp_business";
        return DriverManager.getConnection(url, user, pass);
    }
}