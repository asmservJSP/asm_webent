/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Models;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class multipart_form_data {
    String path=new QuerySQL().getPath();
    public multipart_form_data(){
    }
    public String getPathFileUpload(String pathProject,FileItem item) throws Exception{
        String fname="";
        String pathResult="";
        fname=UUID.randomUUID()+item.getName();
        pathResult=pathProject+"/images"+"/"+fname;
        item.write(new File(pathResult));
        pathResult=pathResult.substring(pathProject.length()+1);
        return pathResult;
    }
    public void getValueForm(List<String> ta,FileItem item,String pathProject) throws UnsupportedEncodingException, Exception{
        switch(item.getFieldName()){
                                    case "idProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "nameProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "titleProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "descriptionProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "detailsProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "categoryProduct":
                                        ta.add(item.getString("UTF-8"));
                                        break;
                                    case "file":
                                        if(item.getSize()>0){
                                        ta.add(getPathFileUpload(pathProject, item));
                                        }else{
                                        ta.add("Vui lòng cập nhật ảnh");
                                        }
                                        break;
                                }        
    }
    public ServletFileUpload getServletFileUpload(){
        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setFileSizeMax(maxFileSize);
        return upload;
    }
}
