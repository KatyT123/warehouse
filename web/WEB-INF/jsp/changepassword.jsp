<%-- 
    Document   : changepassword
    Created on : 11 Δεκ 2018, 3:05:50 μμ
    Author     : Tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
    .field-icon {
        float: right;
        margin-left: -25px;
        margin-top: -25px;
        position: relative;
        z-index: 2;
    }

    .container{
        padding-top:50px;
         margin: auto;
    }
</style>
<script>
    $(".toggle-password").click(function() {

    $(this).toggleClass("fa-eye fa-eye-slash");
    var input = $($(this).attr("toggle"));
    if (input.attr("type") == "password") {
        input.attr("type", "text");
    } else {
        input.attr("type", "password");
    }
    });
</script>
    </head>
    <body style="background-image: url(/images/bg-01.jpg);" ><form action="changepass.htm" method="POST">
            <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Change password:</label>
    <div class="col-md-6">
              <input id="password-field" type="text" class="form-control" name="password" >
              
              <input type="submit">
            </div>
  </div>
        </form>
    </body>
</html>