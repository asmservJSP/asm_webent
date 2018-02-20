/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Controller;

import com.news.Models.News;
import com.news.Models.QuerySQL;
import com.news.Models.multipart_form_data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class edit extends HttpServlet {
    QuerySQL qr=new QuerySQL();
    String path=qr.getPath();
    multipart_form_data mul=new multipart_form_data();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        try {
            News ls=qr.readNews(id);
            request.setAttribute("products", ls);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
                String id="",name="",title="",description="",details="",category="",pathImage="";
                ServletFileUpload upload=mul.getServletFileUpload();
                List<String> st=new ArrayList<>();
                if(upload.isMultipartContent(request)){
                        List<FileItem> multiparts=upload.parseRequest(request);
                        Iterator<FileItem> iter = multiparts.iterator();
                        while(iter.hasNext()){
                            FileItem item=iter.next();
                            if(item.isFormField()){
                                 mul.getValueForm(st, item,path);
                            }
                            else{
                                mul.getValueForm(st, item,path);
                            }
                        } 
                 }
                id=st.get(0);name=st.get(1);title=st.get(2);description=st.get(3);details=st.get(4);category=st.get(5);
                pathImage=st.get(6);
                News product=new News(id, name, title, description, details, category, pathImage);
                qr.updateNews(product);
                response.sendRedirect("admin.jsp");
                } catch (Exception ex) { 
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<script language=\"javascript\">");
                out.println("alert(\"Edit fail!\");");
                out.println("location='admin.jsp';");
                out.println("</script>");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
