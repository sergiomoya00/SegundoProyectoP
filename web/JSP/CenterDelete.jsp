<%-- 
    Document   : CenterDelete
    Created on : 27-jul-2020, 18:31:02
    Author     : jabre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:select label="Select Country"
                  name="country"
                  headerValue="Select Country"
                  list="%{country}"
                  />
    </body>
</html>
