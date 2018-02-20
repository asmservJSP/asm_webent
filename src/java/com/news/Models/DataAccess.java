/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Minh
 */
public class DataAccess {
    //Start Singleton
    private DataAccess(){};
    private static final DataAccess instance= new DataAccess();
    public static DataAccess getInstance(){
        return instance;
    }
    //End Singleton
    //Start Database
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String user="root";
        String pass="123456";
        String url="jdbc:mysql://localhost:3306/webent_asm";
        return DriverManager.getConnection(url, user, pass);
    }
    public java.sql.PreparedStatement getStatement(String sql) throws SQLException, ClassNotFoundException{
        
        return getConnection().prepareStatement(sql);
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        getInstance().getConnection();
//    }
   
}
