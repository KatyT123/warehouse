<%-- 
    Document   : zoomProduct
    Created on : 02-Dec-2018, 15:45:44
    Author     : Katy
--%>
<%@page import="model.Store"%>
<%@page import="model.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link href="<c:url value= "/resources/css/Style1.css "/>" rel="stylesheet">
        <link href="<c:url value= "/resources/css/zoomCard.css "/>" rel="stylesheet">
        
        <title>JSP Page</title>
       
        </head>
        
 <body style="background-image: url(/images/velvet1.jpg);">
     
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
 
<div class="column side"></div>                   
       
<div class="column middle">
              
      <div class="container">
            <div class="item">
                <div class="card">
                    <c:if test="${wrapped.prview.pcolor=='W'}"><p class="price" style="float:left">White</p> </c:if>
                    <c:if test="${wrapped.prview.pcolor=='Y'}"><p class="price" style="float:left">Yellow</p> </c:if>
                    <c:if test="${wrapped.prview.pcolor=='R'}"><p class="price" style="float:left">Pink</p> </c:if>
                    <img src="/images/${wrapped.product.img}" alt="ProductImage" style="width:100%">
                    <c:forEach items="${stones}" var="current">
                        <p class="price">Stone: ${current.stoneDesc}, weight: ${current.stoneWeight}, quantity: ${current.stoneQuant}</p>
                    </c:forEach>
                        <p class="desc" style="float:left">Available Stock: <span id="ajaxoutput">${stock.quantity}</span></p>    
                    <p class="desc" style="float:left"><c:if test="${wrapped.alloy.goldWeight > 0}"><span>Gold: ${wrapped.alloy.silverWeight}</span></c:if>  <c:if test="${wrapped.alloy.silverWeight > 0}"><span>Silver: ${wrapped.alloy.silverWeight}</span> </c:if> </p> 
                    <p class="desc" style="float:left">Producer: ${wrapped.producer.producerName}</p>
                    <p class="price" style="float:left">Price:  ${wrapped.product.price} EU </p>
                    <p class="price" style="float:left">Product code: ${wrapped.product.productCode}</p>
                     
                     
                     <form>
                         <div class="form-group" >
                             <label for="select1"> Add Stock:</label>
                             <input type="number" name="addstock" placeholder="add stock" id="select1" class="form-control">
                        
                         
                         <div><button type="submit" id="submit1"class="btn btn-default " >Submit</button></div>
                            </div>  
                     </form>
                    
                    <form>
                          <div class="form-group" >
                              <label for="select2">Subtract Stock:</label>
                              <input type="number" class="form-control" name="subtractstock" placeholder="subtract stock" id="select2">
                          
                             <div> <button type="submit" id="submit2" class="btn btn-default " >Submit</button></div>
                        </div>
                    </form>
                    
                    <div class="form-group" style="float:right">
                         <label for="submit3"></label>
                         <form class="links desc" style="float:right"><input type="submit" name="submit3" value="Other Stores Stock" id="submit3"></form>
                    </div>   
                </div>

            </div>
          </div>
      </div>

      <div class="columnr side"></div>
     <footer> </footer>
     
     
     
       <script type="text/javascript">

            $(document).ready(function () {
                $('#submit3').click(function (e) {
               e.preventDefault();
               $.ajax({
                  url:'http://localhost:8080/WarehousesKaty/otherStoresStock/${wrapped.product.productCode}.htm',
                  type: 'GET',
                  contentType: 'application/json',

                  success: function (quant) {
                  $('#ajaxoutput').text(quant);
                        }
                    });
                });
            });
        </script>             
       <script type="text/javascript">

            $(document).ready(function () {
                $('#submit1').click(function (e) {

               quantnew = $('#select1').val();
               alert(quantnew);
               e.preventDefault();
               $.ajax({
                  url:'http://localhost:8080/WarehousesKaty/insertStock/${wrapped.product.productCode}/'+quantnew+'.htm',
                  type: 'GET',
                  contentType: 'application/json',

                  success: function (quant) {
                  $('#ajaxoutput').text(quant);
                        }
                    });
                });
            });
        </script>
        <script type="text/javascript">
        $(document).ready(function () {
                $('#submit2').click(function (e) {

               quantnew = $('#select2').val();
               alert(quantnew);
               e.preventDefault();
               $.ajax({
                  url:'http://localhost:8080/WarehousesKaty/substractStock/${wrapped.product.productCode}/'+quantnew+'.htm',
                  type: 'GET',
                  contentType: 'application/json',

                  success: function (quant) {
                  $('#ajaxoutput').text(quant);
                        }
                    });
                });
            });
      </script>
    </body>
</html>