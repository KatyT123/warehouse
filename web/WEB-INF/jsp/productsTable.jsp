<%-- 
    Document   : productsTable
    Created on : Nov 18, 2018, 6:24:10 PM
    Author     : KATY
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <link href="<c:url value= "/resources/css/Style1.css "/>" rel="stylesheet">
        <link href="<c:url value= "/resources/css/productCard.css "/>" rel="stylesheet">
        <title>JSP Page</title>
        
    </head>
    <body>
           <header><span class ="headerText">My Warehouse</span></header>
           <nav>
         <c:forEach items="${categories}" var="current">
              <a href="${current.categoryId}.htm" class="myclass" >${current.categoryDesc}</a>
          </c:forEach>
           </nav>
           <section>
                <div class="container">
                    <c:forEach items="${wrapped}" var="current">
                      <div class="item">
                         <div class="card">
                           <c:if test="${current.prview.pcolor=='W'}"><p class="price">White</p> </c:if>
                           <c:if test="${current.prview.pcolor=='Y'}"><p class="price">Yellow</p> </c:if>
                           <c:if test="${current.prview.pcolor=='R'}"><p class="price">Pink</p> </c:if>
                           <img src="/myimages/${current.product.img}" alt="ProductImage" style="width:100%">
                           <p class="price">Stone: ${current.prview.stoneDesc}</p> 
                           <p class="desc"><c:if test="${current.alloy.goldWeight > 0}"><span>Gold: ${current.alloy.silverWeight}</span></c:if>  <c:if test="${current.alloy.silverWeight > 0}"><span>Silver: ${current.alloy.silverWeight}</span> </c:if> </p> 
                           <p class="desc">Producer: ${current.producer.producerName}</p>
                           <p class="price">Price:  ${current.product.price}</p>
                           <p class="price">Product code: ${current.product.productCode}</p>
                           <button class="button"><a href="zoomProduct.htm">Show</a></button>
                    </div>
                </div>
                    </c:forEach>
               
               </div>
               </section>
    </body>
</html>
