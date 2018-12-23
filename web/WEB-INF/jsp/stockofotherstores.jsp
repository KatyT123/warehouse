<%-- 
    Document   : stockofotherstores
    Created on : Dec 13, 2018, 3:25:56 PM
    Author     : chern
--%>

<%@page import="model.Store"%>
<%@page import="model.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ArrayList<Stock> stock = (ArrayList)request.getAttribute("stock");%>
        <% ArrayList<Store> stores = (ArrayList)request.getAttribute("stores");%>
        <h1>Hello World!</h1>
         <% for (Store st: stores){%>   
                         <% for (Stock s: stock){%>
                            <% if( (st.getStoreId() == s.getStoreId().getStoreId())&&(st.getStoreId() != 1) ){%> <p> Store <%= st.getLocation() %> <%= s.getQuantity()%> pieces </p> <%}%>
                            <%}%> <%}%>   
    </body>
</html>
