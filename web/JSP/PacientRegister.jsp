<%-- 
    Document   : PacientRegister
    Created on : 29/07/2020, 11:32:13 PM
    Author     : samoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso al hospital</h1>
        <s:form action="createcenter">
        <s:textfield label="Ingresar el nombre del centro" name="center.name"></s:textfield>
        <s:textfield label="Ingresar el ubicacion del centro" name="center.ubication"></s:textfield>
        <s:textfield label="Ingresar capacidad del centro" name="center.capacity"></s:textfield>
        <s:textfield label="Ingresar el tipo de centro" name="center.type"></s:textfield>
        <s:submit value="Ingresar"></s:submit>
        </s:form>
    </body>
</html>
