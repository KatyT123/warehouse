<%-- 
    Document   : zoomProduct
    Created on : 02-Dec-2018, 15:45:44
    Author     : Katy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <link href="<c:url value= "/resources/css/Style1.css "/>" rel="stylesheet">
        <link href="<c:url value= "/resources/css/productCard.css "/>" rel="stylesheet">
        
        <title>JSP Page</title>
        <style>
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
        </header>
        <div class="topnav">
            <div style="color:white"><h6 style="float:left" style="margin-left:2px">CATEGORIES</h6></div>
            <a href="logout.htm" class="logout" style="float:right">Logout</a>
               <a href="${contextPath}/creator.htm" style="float:right">Create new Product</a>
                 <a href="${contextPath}/history.htm" style="float:right">Stock History</a>
                   <a href="${contextPath}/registrationFormController.htm" style="float:right">Create new Store</a>
          
      </div>
       
        <div class="column side">
            
            
            <c:forEach items="${categories}" var="current">
                <a href="searchByCategory/${current.categoryId}.htm" class="myclass" >${current.categoryDesc}</a>
            </c:forEach>  
         </div>    
    <div class="column middle">
        <div class="container">
                    <c:forEach items="${wrapped}" var="current">
                      <div class="item2">
                         <div class="card">
                           <c:choose>  
                                <c:when test="${current.prview.pcolor=='W'}"><p class="price">White</p> </c:when>
                                <c:when test="${current.prview.pcolor=='Y'}"><p class="price">Yellow</p> </c:when>
                                <c:when test="${current.prview.pcolor=='R'}"><p class="price">Pink</p> </c:when>
                                <c:otherwise><p class="price">No color inserted</p></c:otherwise>
                            </c:choose> 
                           <img src="/images/${current.product.img}" alt="ProductImage" style="width:100%">
                           <p class="price">Stone: ${current.prview.stoneDesc}</p> 
                           <p class="desc">Gold: <c:if test="${current.alloy.goldWeight > 0}"><span> ${current.alloy.silverWeight}</span></c:if>Silver: <c:if test="${current.alloy.silverWeight > 0}"><span>${current.alloy.silverWeight}</span> </c:if> </p> 
                           <p class="desc">Producer: ${current.producer.producerName}</p>
                           <p class="price">Price:  ${current.product.price}</p>
                           <p class="price">Product code: ${current.product.productCode}</p>
                           <button class="button"><a href="zoomProduct/${current.product.productCode}.htm">Show</a></button>
                    </div>
                      </div>
                    </c:forEach>
        </div>
    </div>
            <div class="columnr side">
                
            </div>
            
    </body>
    
</html>
