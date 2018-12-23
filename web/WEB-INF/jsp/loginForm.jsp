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
<!--<script>
            
            $(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $("#firstbtn").click(function () { // Βάλε handler στο input type
                    var text = $(this).val(); // Το κείμενο του χρήστη
                    alert(text);
                    $.ajax({
                      
                        url: 'ajaxsearch1.htm?text2='+text,
                        contentType: 'application/json',
                        method: 'POST',
                        
                        success: function (result) {
                            $("#ajaxoutput").empty();
                            var jsonobj = $.parseJSON(result);
                                
                            $.each(jsonobj, function (i,item) {
                                $tr = $('<tr>').append(
                                        $('<td>').text(item.pcode),
                                        $('<td>').text(item.quant),
                                        $('<td>').text(item.date),
                                        
                                        );
                                $("#ajaxoutput").append($tr);
                                $("#firsttable").hide();
                            });
                        }
                    });
                });
            });
        </script> -->
<!-- <script>
<!--$(document).ready(function(){
  $("#button").hide();
  $("#hide").click(function(){
    $("#button").show();
  });
}); 
</script> -->
<style>
     
    
    

.form-heading { color:#fff; font-size:23px;}
.panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
.panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
.login-form .form-control {
  
  border: 1px solid #117a8b;
  border-radius: 4px;
  font-size: 14px;
  height: 50px;
  line-height: 50px;
}
.main-div {
    
    border-width: 0px;
    border-color: darkblue;
  background:  #eeeeee ;
  
  margin: 10px auto 30px;
  max-width: 38%;
  padding: 50px 70px 70px 71px;
}

.login-form .form-group {
  margin-bottom:10px;
}
.login-form{ 
    text-align:center;
}

.login-form  .btn.btn-primary {
  background: #f0ad4e none repeat scroll 0 0;
  border-color: #117a8b;
  color: #ffffff;
  font-size: 14px;
  width: 100%;
  height: 50px;
  line-height: 50px;
  padding: 0;
}
.forgot {
  text-align: left; margin-bottom:30px;
}
.botto-text {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login-form .btn.btn-primary.reset {
  background:#eeeeee none repeat scroll 0 0;
}
.back { 
    text-align: left; margin-top:50px;
}
.back a {
    color: #444444; font-size: 13px;text-decoration: none;
}


</style>
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
                   
                   
                   
                   <!--<div id="button">
                       <input type="text" name="changepass" > 
                       <button  id="secondbtn" >Hide</button>
                   </div> -->
        </spring:form> 
    
                </div>
                </div>
                </div>              
      <script>
        
      </script>
          
        
    </body>
</html>