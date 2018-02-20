<%-- 
    Document   : admin
    Created on : Jan 14, 2018, 8:52:08 PM
    Author     : Admin
--%>

    <%@page language="java" contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>ADMIN</title>

            <!-- Bootstrap Core CSS -->
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


            <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        </head>

        <body>

            <div id="wrapper">

                <!-- Navigation -->
                <%@include file="header.html" %>
                <%@include file="add.jsp" %>

                        <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- jQuery -->
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
            <script type="text/javascript" src="js/minh.js"></script>
            <script src="js/angular.min.js"></script>
            <script>
                var app = angular.module('myApp', []);
                app.controller('myController', function($scope, $http) {
                    $http.get("admin.jsp").then(function(response) {
                        $scope.datas = response.data.records;
                    })
                    //                    $scope.datas=[1,2,3,4,5,6];
                });

            </script>
        </body>

        </html>
