<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h5 style="margin-left:90px">Insert Stock of product : ${creation.productCode}</h5>
            
            
             <spring:form modelAttribute="mystock" action="createstock.htm" method="POST" class="center">
                 
              <div class="form-group">
                    <label for="quant">quantity:</label>
                    <spring:input path="stock.quantity" required="required" id="quant" class="form-control"/>
                    <spring:errors path="stock.quantity" cssClass="error"/>
              </div>
              
              <div class="form-group">
                    <label for="store">store:</label>
                        <spring:select path="store.storeId" class="form-control">
                            <c:forEach items="${stores}" var="current">
                                <c:if test = "${current.storeId != 999}">
                                    <spring:option value="${current.storeId}" path="${current.storeId}" label="${current.location}"/>
                                </c:if>
                            </c:forEach>
                       </spring:select>
              </div>  
              <input type="radio" name="creation" value="${creation.productCode}" checked="checked" hidden>
              <button type="submit" class="btn btn-default btn-lg" style="padding:14px 40px">Submit</button>
       </spring:form>
        </div>
</div>
    </body>
</html>
