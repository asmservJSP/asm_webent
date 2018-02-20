<%-- 
    Document   : edit
    Created on : Jan 18, 2018, 12:13:17 AM
    Author     : Admin
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <jsp:useBean id="dataBean" class="com.news.Models.QuerySQL" />
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Edit</title>
                <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
                <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
                <!-- MetisMenu CSS -->
                <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

                <!-- Custom CSS -->
                <link href="dist/css/sb-admin-2.css" rel="stylesheet">

                <!-- Morris Charts CSS -->
                <link href="vendor/morrisjs/morris.css" rel="stylesheet">

                <!-- Custom Fonts -->
                <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
                
            </head>

            <body>
                <div id="wrapper">
                    <%@include file="header.html" %>
                    <div id="page-wrapper">
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">Edit</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <!-- /.panel -->
                                <div class="panel panel-default">
                                    <!-- /.panel-heading -->
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <form method="post" action="edit" enctype="multipart/form-data">
                                                    <div class="form-group row">
                                                        <label for="ID" class="col-sm-2 col-form-label">ID Product</label>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" name="idProduct" id="ID" value="${products.id}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="name" class="col-sm-2 col-form-label">Name</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="nameProduct" id="name" required value="${products.name}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="title" class="col-sm-2 col-form-label">Title</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="titleProduct" id="title" value="${products.title}" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="description" class="col-sm-2 col-form-label">Description</label>
                                                        <div class="col-sm-8">
                                                            <textarea class="form-control" name="descriptionProduct" id="description">${products.description}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="details" class="col-sm-2 col-form-label">Details</label>
                                                        <div class="col-sm-8">
                                                            <textarea class="form-control" style="height: 200px !important" name="detailsProduct" id="details">${products.details}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="category" class="col-sm-2 col-form-label">Category</label>
                                                        <div class="col-sm-8">
                                                            <div class="input-group dropdown">
                                                                <input type="text" class="form-control countrycode dropdown-toggle" name="categoryProduct" id="category" value="${products.category}">
                                                                <ul class="dropdown-menu col-sm-12">
                                                                    <c:forEach items="${dataBean.category}" var="ct">
                                                                        <li><a href="#" data-value="${ct}">${ct}</a></li>
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
                                                        <img id="imageShow" src="<c:if test='${products.pathimage!=" Vui lòng cập nhật ảnh "}'>../${products.pathimage}</c:if><c:if test='${products.pathimage=="Vui lòng cập nhật ảnh "}'>../images/notImage.jpg</c:if>" width="100px" height="100px" />
                                                    </div>
                                                    <div class="form-group row">
                                                        <button type="submit" class="btn btn-primary col-sm-2 col-sm-offset-3">Edit</button>
                                                        <a class="btn btn-primary col-sm-2 col-sm-offset-2" href="admin.jsp">Back</a>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="vendor/jquery/jquery.min.js"></script>

                <!-- Bootstrap Core JavaScript -->
                <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

                <!-- Metis Menu Plugin JavaScript -->
                <script src="vendor/metisMenu/metisMenu.min.js"></script>

                <!-- Morris Charts JavaScript -->
                <script src="vendor/raphael/raphael.min.js"></script>
                <script src="vendor/morrisjs/morris.min.js"></script>
                <script src="data/morris-data.js"></script>

                <!-- Custom Theme JavaScript -->
                <script src="dist/js/sb-admin-2.js"></script>
                <script src="js/minh.js"></script>
                <script src="js/angular.min.js"></script>
            </body>

            </html>
