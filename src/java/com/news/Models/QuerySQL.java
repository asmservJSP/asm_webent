/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Models;

import static com.news.Models.DataAccess.getInstance;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class QuerySQL {
    DataAccess DA=getInstance();
    String path=getPathClass();
    public QuerySQL(){
        
    }
    public String getPathClass(){
        try {
            return Class.forName("com.news.Controller.Add").getResource("").getPath().substring(1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuerySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public boolean checkUsername(String username,String password) throws SQLException, ClassNotFoundException{
        java.sql.PreparedStatement pstm=DA.getStatement("select * from login where username=? and password=?");
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs= pstm.executeQuery();
        if(rs.first()){
            return true;
        }else{
            return false;
        }
    }
    public void addNews(News product) throws SQLException, ClassNotFoundException{
        java.sql.PreparedStatement pstm=DA.getStatement("insert into news(id,name,date,title,description,details,category,pathimage) values (?,?,?,?,?,?,?,?)");
        pstm.setString(1, product.getId());
        pstm.setString(2, product.getName());
        Date dt=new Date();
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        pstm.setString(3, formater.format(dt));
        pstm.setString(4, product.getTitle());
        pstm.setString(5, product.getDescription());
        pstm.setString(6, product.getDetails());
        pstm.setString(7, product.getCategory());
        pstm.setString(8,product.getPathimage());
        pstm.executeUpdate();
    }
    public  List<News>  showAll() throws SQLException, ClassNotFoundException{
        List<News> ls=new ArrayList<>();
        java.sql.PreparedStatement pstm=DA.getStatement("select * from news");
        ResultSet rs= pstm.executeQuery();
        SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy");
        while(rs.next()){
            String date=rs.getTime("date")+" "+ formater.format(rs.getDate("date"));
            ls.add(new News(rs.getString("id"),rs.getString("name"),date,rs.getString("title"),rs.getString("description"),rs.getString("details"),rs.getString("category"),rs.getString("pathimage")));
        }
        //ls=ls.stream().sorted().collect(Collectors.toList());
        return ls;
    }
    public News readNews(String id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstm=DA.getStatement("select * from news where id='"+id+"'");
        ResultSet rs=pstm.executeQuery();
        News a = null;
        while(rs.next()){
            a=new News(rs.getString("id"),rs.getString("name"),rs.getString("date"),rs.getString("title"),rs.getString("description"),rs.getString("details"),rs.getString("category"),rs.getString("pathimage"));
        }
        return a;
    }
    public News readLatest(int id) throws SQLException, ClassNotFoundException{
        List<News> ls=new ArrayList<>();
        java.sql.PreparedStatement pstm=DA.getStatement("select * from news");
        ResultSet rs= pstm.executeQuery();
        SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy");
        while(rs.next()){
            String date=rs.getTime("date")+" "+ formater.format(rs.getDate("date"));
            ls.add(new News(rs.getString("id"),rs.getString("name"),date,rs.getString("title"),rs.getString("description"),rs.getString("details"),rs.getString("category"),rs.getString("pathimage")));
        }
        News result=ls.stream().sorted(Comparator.comparing(News::getDate)).collect(Collectors.toList()).get(id);
        return result;
    }
    
    public void removeNews(String id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstm=DA.getStatement("select * from news where id='"+id+"'");
        ResultSet rs=pstm.executeQuery();
        String pathimg=getPath();
        while(rs.next()){
            pathimg=pathimg+"/"+rs.getString("pathimage");
            File fl=new File(pathimg);
            fl.delete();
        }
        pstm=DA.getStatement("delete from news where id='"+id+"'");
        pstm.executeUpdate();
    }
    public void updateNews(News product) throws SQLException, ClassNotFoundException{
        PreparedStatement pstm=DA.getStatement("select * from news where id='"+product.getId()+"'");
        ResultSet rs=pstm.executeQuery();
        String pathimg=getPath();
        while(rs.next()){
            pathimg=pathimg+"/"+rs.getString("pathimage");
            File fl=new File(pathimg);
            fl.delete();
        }
        pstm=DA.getStatement("update news set name=?,date=?,title=?,description=?,details=?,category=?,pathimage=? where id=?");
        pstm.setString(1, product.getName());
        Date dt=new Date();
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        pstm.setString(2, formater.format(dt));
        pstm.setString(3, product.getTitle());
        pstm.setString(4, product.getDescription());
        pstm.setString(5, product.getDetails());
        pstm.setString(6, product.getCategory());
        pstm.setString(7, product.getPathimage());
        pstm.setString(8, product.getId());
        pstm.executeUpdate();
    }
    public List<News> getByCategory(String category) throws SQLException, ClassNotFoundException{
        List<News> ls=new ArrayList<>();
        PreparedStatement pstm=DA.getStatement("select * from news where category=?");
        pstm.setString(1, category);
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){
            ls.add(new News(rs.getString("id"),rs.getString("name"),String.valueOf(rs.getDate("date")),rs.getString("title"),rs.getString("description"),rs.getString("details"),rs.getString("category"),rs.getString("pathimage")));
        }
        return ls;
    }
    public List<String> getCategory() throws SQLException, ClassNotFoundException{
        List<String> ct=new ArrayList<>();
        PreparedStatement pstm=DA.getStatement("select * from news");
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){
            ct.add(rs.getString("category"));
        }
        ct=ct.stream().distinct().collect(Collectors.toList());
        return ct;
    }
    public List<Object> getlabel() throws SQLException, ClassNotFoundException{
        getInstance();
        PreparedStatement pstm=DA.getStatement("select * from news");
        ResultSet rs=pstm.executeQuery();
        ResultSetMetaData rsdt=rs.getMetaData();
        int count=rsdt.getColumnCount();
        List<Object> ls=new ArrayList<>();
        for(int t=1;t<=count;t++){
            ls.add(rsdt.getColumnName(t));
        }
        return ls;
    }
    public String getPath(){
        String fullpath="";
        String[] pathArr=new String[99];
        try {
            
            fullpath = URLDecoder.decode(path, "UTF-8");
            pathArr=fullpath.split("/build/web");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(QuerySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pathArr[0]+"/web";
    }
//    public static void main(String[] args) throws ClassNotFoundException {
//        QuerySQL sl=new QuerySQL();
//        System.out.println(sl.getPathClass());
//        System.out.println(sl.getPath());
//    }
}
