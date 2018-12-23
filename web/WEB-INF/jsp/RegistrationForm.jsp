<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link href="<c:url value= "/resources/css/Style2.css "/>" rel="stylesheet">
        <link href="<c:url value= "/resources/css/Carosel.css "/>" rel="stylesheet">
        
        <title>JSP Page</title>
        <style>
            li{
                
            }
            body{
                background-image: url('./velvet1.jpg');
            }
           
        </style>
    </head>
    
<body>
        
   <header>
            <h3 class="headerText1" style="margin-left: 50px"></h3>
               <form action="searchById.htm" method="get" style="float:right">
                <input type="text" name="pcode" >
                <input type="submit" name="submit" value="search">
              </form>
            <form action="${contextPath}/homeController.htm" method="POST">
                       <button class="btn btn-default" type="submit" style="float:left" value="Home">Home</button>
            </form>
   </header>
    
  <div class="topnav">
            
            <a href="logout.htm" class="logout" style="float:right">Logout</a>
               <a href="${contextPath}/creator.htm" style="float:right">Create new Product</a>
                 <a href="${contextPath}/history.htm" style="float:right">Stock History</a>
                   <a href="${contextPath}/registrationFormController.htm" style="float:right">Create new Store</a>
 </div>
 
 <div class="column middle">
             <h5 style="margin-left:90px">Create New Store</h5>
                      <spring:form modelAttribute="emptystore" action="${contextPath}/handleregistration.htm" method="POST"  class="center" >
                         <div class="form-group">
                            <label for="id">insert store id (only integers):</label>
                                 <spring:input path="storeId" pattern="^((?!(0))[0-9]{1,2})$" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ Kifisia" id="id" /></td>
                                 <spring:errors path="storeId" cssClass="error"/>
                         </div>
                         
                         <div class="form-group">
                            <label for="user">insert username :</label>
                                 <spring:input path="username" pattern="^[A-Za-z]{3,15}$" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="The username must contain till 10 letters. For example 'kostas' " id="user" />
                                 <spring:errors path="username" cssClass="error"/>
                         </div>
                         
                         <div class="form-group">
                            <label for="pass">insert password :</label>
                                 <spring:input type="password" id="pass" path="password" pattern="^((?!.*[\s])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,15})" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="The password must contain at least 8 characters and less than 15, without spaces, including one uppercase one special character and one number ."/>
                                 <spring:errors type="password" path="password" cssClass="error"/>
                         </div>
                         
                         <div class="form-group">
                              <label for="conf">Confirm Password</label>
                                 <spring:input type="password" id="conf" class="form-control" path="confirmpassword" pattern="^((?!.*[\s])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,15})" value="" onkeyup="this.setAttribute('value', this.value);" title="The password must contain at least 8 characters and less than 15, without spaces, including one uppercase one special character and one number ."/>
                                 <spring:errors type="password" path="confirmpassword" cssClass="error"/>
                         </div>
               
                         <div class="form-group">
                            <label for="loc">insert location :</label>
                                  <spring:input path="location" id="loc" pattern="[A-Za-z]{1,15}" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ Kifisia"/>
                                  <spring:errors path="location" cssClass="error"/>
                         </div>
                         
                          <button type="submit" class="btn btn-default btn-lg" style="padding:14px 40px">Submit</button>

                  
                    </spring:form>
 </div>
 
<script>
            var form1 = document.getElementById('form1');
            form1.onsubmit = function(e){
                var form = this;
                e.preventDefault();
            if(confirm("Are you sure you wish to create this store?"))
            form.submit();
           }
        </script>
    </body>
</html>
