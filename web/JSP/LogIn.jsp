<%-- 
    Document   : LogIn
    Created on : 25-jul-2020, 20:42:46
    Author     : jabre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="operations.HospitalizedController"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso al hospital</h1>
        <s:form action="login">
            <s:textfield label="Ingresar el nombre de usuario" name="login.email"></s:textfield>
            <s:password label="Ingresar contraseña" name="login.password"></s:password>
            <s:submit value="Ingresar"></s:submit>
        </s:form>
        <s:form action="userP">
            <s:submit value="Registrarse como paciente"></s:submit>
        </s:form>
    </body>
</html>
