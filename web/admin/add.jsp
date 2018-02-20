<%-- 
    Document   : add
    Created on : Jan 18, 2018, 4:24:44 PM
    Author     : Admin
--%>

    <%@page language="java" contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <jsp:useBean id="tableBean" class="com.news.Models.QuerySQL" />
                <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Product</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">

                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <button style="margin-bottom: 5px" type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" id="addProduct">Add product  <span class="glyphicon glyphicon-plus-sign"></span></button>

                            <!-- Modal -->
                            <div id="myModal" class="modal fade" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Add product</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form method="post" action="add" enctype="multipart/form-data">
                                                <div class="form-group row">
                                                    <label for="ID" class="col-sm-2 col-form-label">ID Product</label>
                                                    <div class="col-sm-2 form-group">
                                                        <input type="text" class="form-control text-center" value="ID" disabled>
                                                    </div>
                                                    <div class="col-sm-1" style="margin-top: 5px;">
                                                        <span>+</span>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <input type="text" class="form-control" name="idProduct" id="ID" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="nameProduct" id="name" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="title" class="col-sm-2 col-form-label">Title</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="titleProduct" id="title" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="description" class="col-sm-2 col-form-label">Description</label>
                                                    <div class="col-sm-8">
                                                        <textarea class="form-control" name="descriptionProduct" id="description"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="details" class="col-sm-2 col-form-label">Details</label>
                                                    <div class="col-sm-8">
                                                        <textarea class="form-control" name="detailsProduct" id="details"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="category" class="col-sm-2 col-form-label">Category</label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group dropdown">
                                                            <input type="text" class="form-control countrycode dropdown-toggle" value=" " name="categoryProduct" id="category">
                                                            <ul class="dropdown-menu" style="width: 100%">
                                                                <c:forEach items="${tableBean.category}" var="ct">
                                                                    <li><a href="#" data-value="${ct}" >${ct}</a></li>
                                                                </c:forEach>
                                                            </ul>
                                                            <span role="button" class="input-group-addon dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="caret"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="form-group row">
                                                        <label for="filechoose" class="col-sm-2 col-form-label">Path image</label>
                                                        <div class="col-sm-5">
                                                            <input type="file" class="form-control-file" id="filechoose" name="file">
                                                        </div>
                                                    </div>
                                                    <img id="imageShow" src=" " width="100px" height="100px" />
                                                </div>
                                                <button type="submit" class="btn btn-primary">Add</button>
                                            </form>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="row" >
                                <div class="sidebar-search col-sm-5" style="margin-bottom: 5px">
                                    <div class="input-group custom-search-form ">
                                        <input type="text" id="resultSearch1"   class="form-control resultSearch1" placeholder="Search...">
                                        
                                    </div>
                                    <!-- /input-group -->
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped display dataTable" id="tableAdd1">
                                            <thead>
                                                <tr>
                                                    <c:forEach items="${tableBean.getlabel()}" var="sp">
                                                        <c:if test="${sp != 'details'}">
                                                            <th class="text-capitalize">${sp}</th>
                                                        </c:if>
                                                    </c:forEach>
                                                    <th class="text-capitalize">Manager</th>
                                                </tr>
                                            </thead>
<!--                                            <tbody>
                                                <tr ng-repeat="sp in datas | filter : resultSearch">
                                                    <td>{{sp.td}}</td>
                                                    <td>{{sp.name}}</td>
                                                    <td>{{sp.date}}</td>
                                                    <td>{{sp.title}}</td>
                                                    <td>{{sp.description}}</td>
                                                    <td>{{sp.category}}</td>
                                                </tr>
                                            </tbody>-->
                                            <tbody>
                                                <c:forEach items="${tableBean.showAll()}" var="sp">
                                                    <tr>
                                                        <td>${sp.id}</td>
                                                        <td>${sp.name}</td>
                                                        <td>${sp.date}</td>
                                                        <td>${sp.title}</td>
                                                        <td>${sp.description}</td>
                                                        <td>${sp.category}</td>
                                                        <td <c:if test="${sp.pathimage =='Vui lòng cập nhật ảnh'}">class="text-danger"</c:if>
                                                            >${sp.pathimage}</td>
                                                        <td>
                                                            <a href="delete?id=${sp.id}">Delete</a>
                                                            <a href="edit?id=${sp.id}">Edit</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->

                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->

                <!-- /.col-lg-4 -->
            </div>
                    <!-- /.row -->
                </div>

