/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Models;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author Admin
 */
public class test {
    public String pa() throws UnsupportedEncodingException{
        String path=this.getClass().getClassLoader().getResource("").getPath();
                //getClassLoader().getResource("").getPath();
        String fullpath=URLDecoder.decode(path, "UTF-8");
        String[] pathArr=fullpath.split("/WEB-INF/classes/");
        return pathArr[0];
    }
    public test(){
        
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        test n=new test();
        String a=n.pa();
        System.out.println(a);
    }
}
