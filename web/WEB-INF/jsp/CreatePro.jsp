<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        <title>JSP Page</title>
        <style>
            li{
                
            }
            body{
                background-image: url('./velvet1.jpg');
            }
           
        </style>
        
        <script>
            
                $(function() {
                    $("#addMore").click(function(e) {
                    e.preventDefault();
                    $("#fieldList").append("<tr>&nbsp;</tr>");
                    $("#fieldList").append("<li><input type='text' name='stoneDescr' placeholder='stoneDescr' /></li>");
                    $("#fieldList").append("<li><input type='text' name='weight' placeholder='weight' /></li>");
                    $("#fieldList").append("<li><input type='text' name='quantity' placeholder='quantity' /></li><br>");
                    });
                });

        </script>
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
    <h5 style="margin-left:120px">Create New Product</h5>
                   <spring:form modelAttribute="combined" action="creationhandler.htm" method="POST" enctype="multipart/form-data" class="center" id="comb">
                       
                       <div class="form-group">
                           <label for="code">product code:</label>
                           <spring:input path="product.productCode" required="required" pattern="^[A-Z0-9][a-zA-Z0-9]*{6}" id="code" class="form-control"/>
                           <spring:errors path="product.productCode" cssClass="error"/>
                        </div>
                        
                       <div class="form-group">
                           <label for="desc">item description:</label>
                            <spring:input path="product.itemDesc" id="desc" class="form-control"/>
                            <spring:errors path="product.itemDesc" cssClass="error"/>
                       </div>
                      
                       <div class="form-group">
                            <label for="category">category:</label>
                            <spring:select path="category.categoryId" id="category" required="required" class="form-control">
                                 <c:forEach items="${categories}" var="current">
                                      <spring:option value="${current.categoryId}" path="${current.categoryId}" label="${current.categoryDesc}"/>
                                 </c:forEach>
                            </spring:select>
                      </div>
                       
                      <div class="form-group">
                           <label for="price">price:</label>
                           <spring:input path="product.price" pattern="[0-9]+([.][0-9]{1,2})?" required="required" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ 1800" id="price" />
                           <spring:errors path="product.price" cssClass="error"/>
                     </div>
                     
                     <div class="form-group">
                         <label for="producer">producer code:</label>
                               <spring:select path="producer.producerCode" id="producer" required="required" class="form-control">
                                   <c:forEach items="${producers}" var="current">
                                         <spring:option value="${current.producerCode}" path="${current.producerCode}" label="${current.producerName}"/>
                                   </c:forEach>
                              </spring:select>
                      </div>
              
                     <div class="form-group">
                         <label for="eu">cost EU:</label>
                               <spring:input path="product.costEu" required="required" pattern="[0-9]+([.][0-9]{1,2})?" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ 1800" id="eu" />
                               <spring:errors path="product.costEu" cssClass="error"/>
                    </div>
                    
                    <div class="form-group">
                         <label for="usd">cost USD:</label>
                              <spring:input path="product.costUsd" required="required" pattern="[0-9]+([.][0-9]{1,2})?" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ 1800" id="usd" />
                              <spring:errors path="product.costUsd" cssClass="error"/>
                    </div>
                    
                    <div class="form-group">
                        <label for="gold">gold weight:</label>
                             <spring:input path="alloy.goldWeight" pattern="[0-9]+([.][0-9]{1,2})?" class="mandatory form-control" value="" onkeyup="this.setAttribute('value', this.value);" title="Πχ 0.2" id="gold" />
                             <spring:errors path="alloy.goldWeight" cssClass="error"/>
                    </div>
               
                    <div class="form-group">
                        <label for="silver">silver weight:</label>
                           <spring:input path="alloy.silverWeight" pattern="[0-9]+([.][0-9]{1,2})?" id="silver" class="form-control"/>
                           <spring:errors path="alloy.silverWeight" cssClass="error"/>
                    </div>
               
                   <div class="form-group">
                           <label for="karats">karats</label>
                           <spring:select path="alloy.karats" class="form-control" id="karats">               
                           <spring:option value="9" path="$alloy.karats"/>
                           <spring:option value="14" path="$alloy.karats"/>
                           <spring:option value="18" path="$alloy.karats"/>
                           </spring:select>
                   
                   </div>
               
                   <div for="image" class="form-group">
                        <form:label path="file" class="form-control" id="image">Choose image</form:label>
                        <input type="file" name="file" />
                   </div>             


                   
                      <button type="submit" class="btn btn-default btn-lg" style="padding:14px 40px">Submit</button>
                   
         </div>
      

                  
<div class="column sideright"> 
              <h5 style="margin-left:80px">Insert Stone</h5>
               <div class="item1">
                    <div class="row">
                      <div id="fieldList"> 
                          <div for="stone1" class="form-group">
                               <div><input name="stoneDescr" type="text" placeholder="stoneDescr" id="stone1" class="form-control"/></div>
                          </div>
                          <div for="stone2" class="form-group">
                              <div><input name="weight" type="text" placeholder="weight" id="stone2" class="form-control"/></div>
                          </div>
                          <div for="stone3" class="form-group">
                              <div><input name="quantity" type="text" placeholder="Quantity" id="stone3" class="form-control"></div>
                         </div>
                      </div>
                           <div><button type="submit" class="btn btn-default btn-lg" id="addMore">Add more stones</button></div>
                     </div>
                  
               </div>
           </div>

     
    
       </spring:form>
                 
<div class="column sidecarousell">
</div>
     
   </body>
</html>
