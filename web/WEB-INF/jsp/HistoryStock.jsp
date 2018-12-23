<%-- 
    Document   : HistoryStock
    Created on : 16-Dec-2018, 20:05:44
    Author     : Tasos
--%>
<%@page import="model.Stock"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
      
    }
    .navbar-nav {
    margin: 0px!important;
    }
 
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
       }
        table {
        border-collapse: collapse;
        width: 100%;
        
        }

        th, td {
        padding: 10px;
        text-align: center;
        border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color:#f5f5f5;
        }
        
        #headline{
            position: sticky;
        }
        .affix {
      top: 0;
      width: 72%;
      z-index: 9999 !important;
  }
  .sidefix{
      top: 0;
      width:30%;
      position:fixed;
  }
   .form-control {
    height: 28px!important;
   }
  </style>
  <script>
            
            $(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $("#ajaxtext").keyup(function () { // Βάλε handler στο input type
                    var text = $(this).val(); // Το κείμενο του χρήστη
                    
                    $.ajax({
                      
                        url: 'ajaxsearch.htm?text2='+text,
                        contentType: 'application/json',
                        
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
        </script>
</head>
<body>

<div class="container">
  <div class="row content">
    <div class="col-sm-3 sidenav affix-top" data-spy="scroll" data-offset-top="50">
      <h4>Stock History</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><form action="${contextPath}/homeController.htm" method="POST">
                       <button class="btn btn-default" type="submit" style="padding: 10px 110px;background-color: #008CBA" value="Home">Home</button>
            </form></li>
      </ul><br>
      <div class="input-group ">
        <input type="text" name="text2" id="ajaxtext" class="form-control" placeholder="Search Product..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

    <div class="col-sm-9"style="padding:0px;"><div id="headline">
            
        <table data-spy="affix" data-offset-top="50" class="nav navbar-nav" >
            <tr style="background-color:#f5f5f5">
               <td style="width:150px;" class="text-center">
                   <label for="ajaxoutput" >Product Code</label>
               </td>
               <td style="width:150px;" class="text-center">
                   <label for="ajaxoutput">Quantity</label>
               </td>
               <td style="width:150px;" class="text-center">
                   <label for="ajaxoutput">Date/Time</label>
               </td>
           </tr>
       </table>
               
        </div>
       <table  class="text-center" id="ajaxoutput" ></table>
       <table class="text-center" id="firsttable" >  
           
   <c:forEach items="${stocks}" var="stock">
       <tr>
           <td style="width:150px;"> ${stock.productCode}</td>
           <td style="width:150px;"> ${stock.quantity}</td>
           <td style="width:150px;"> ${stock.currentdate}</td>
       </tr>
       </c:forEach>
           
       </table>
      <br><br>
      </div>
  </div>
</div>

    
    
<footer class="container-fluid" >
  <nav aria-label="...">
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item active">
      <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
    </li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>
</footer>

</body>
</html>