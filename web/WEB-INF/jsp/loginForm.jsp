<%-- 
    Document   : loginForm
    Created on : 10 Δεκ 2018, 3:03:03 μμ
    Author     : Tasos
--%>
<%@page import="model.Store"%>
<%@page import="model.Stock"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value= "/resources/css/StyleLogIn.css "/>" rel="stylesheet">

  </head>
  
  <body style="background-image: url(/images/bg-01.jpg);" >
           <div class="container">
             <div class="login-form">
               <div class="main-div">
                 <div class="panel">
                   <h2 style="font-family: italic; ">Login</h2>
                 </div>
        
                <spring:form modelAttribute="emptystore" action="handleLogin.htm" method="POST"  id="Login" >
                   <div class="form-group">
                      <spring:input path="username"  pattern="^[A-Za-z]{3,15}$" placeholder="Username" class="form-control" id="inputEmail" value="" onkeyup="this.setAttribute('value', this.value);" title="The username must contain till 10 letters. For example 'kostas' " />
                      <spring:errors path="username" cssClass="error"/>
                   </div>
                   <div class="form-group  has-feedback">                                                                                    <!--allagh-->
                      <spring:input type="password" path="password" class="form-control" id="inputPassword" placeholder="Password" pattern="^((?!.*[\s])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,15})" value="" onkeyup="this.setAttribute('value', this.value);" title="The password must contain at least 8 characters and less than 15, without spaces, including one uppercase one special character and one number ."/>
                      <spring:errors type="password" path="password" cssClass="error"/>
                      <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                  </div> 
                   
                  <div class="container-login100-form-btn m-t-32">
                      <button id="firstbtn" type="submit" class="btn btn-primary" style="background-color: #17a2b8b5;" >Login</button>
                  </div>
               </spring:form> 
    
             </div>
           </div>
         </div>   
    </body>
</html>