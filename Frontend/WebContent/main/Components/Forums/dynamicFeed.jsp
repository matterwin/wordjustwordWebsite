<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feed</title>
<link rel="stylesheet" href="feed.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Catamaran:wght@500;800&family=Days+One&display=swap');
    </style>
    <link rel="stylesheet" href="../Navbar/__nav__.css">
    <link rel="icon" href="../../icons/w.png">
    <style><%@include file="./feed.css"%></style>
    
    <style><%@include file="../Navbar/__nav__.css"%></style>
</head>
<body>

        <!--Navigation bar-->
        <div id="nav-placeholder"></div>

        
        <div id="index-div">

            <div id="side-profile">
                <center>
                    <div id="inside-side">
                        <p>Happy Holidays to you!</p>
                    </div>
                </center>
            </div>

            
            <c:forEach var="post" items="${listOfPosts}" > 
            	<div id="card">
	                <div id="word">
	                        ${post.value[0]}
	                </div>
	                <div id="language">
	                    <p>${post.value[2]}</p>
	                </div>
	                
	                <div id="desc">${post.value[1]}</div>
	                
	                <br>
	                <br>
	                <div id="row">
	                        <a>Comments</a>
	                        <a>${post.value[4]} Likes</a>
	                        <p id="username">${post.value[3]}</p>
	                </div>
            	</div>
            </c:forEach>
            
        </div>


        <script>
            $(function(){
                $("#nav-placeholder").load("/FinalProject/main/Components/Navbar/__dynamicFeed__nav__.html");
                
            });
        </script>
        
        
        
    </body>
</html>