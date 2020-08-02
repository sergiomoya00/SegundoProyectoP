<%-- 
    Document   : PacientRegister
    Created on : 29/07/2020, 11:32:13 PM
    Author     : samoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Regitro de paciente</h1>
        <s:form action="registerpacient">
        <s:textfield label="Ingresar la cedula del paciente" name="Pacient.id"></s:textfield>
        <s:textfield label="Ingresar el nombre del paciente" name="Pacient.name"></s:textfield>
        <s:textfield label="Ingresar la fecha de nacimiento del paciente" name="Pacient.birthDay"></s:textfield>
        <s:textfield label="Ingresar el tipo de sangre del paciente" name="Pacient.bloodType"></s:textfield>
        <s:textfield label="Ingresar la nacionalidad del paciente" name="Pacient.nationality"></s:textfield>
        <s:textfield label="Ingresar la provincia en la que reside el paciente" name="Pacient.province"></s:textfield>
        <s:textfield label="Ingresar el canton en la que reside el paciente" name="Pacient.canton"></s:textfield>
        <s:textfield label="Ingresar el número de teléfono del paciente" name="Pacient.phone"></s:textfield>
        <s:submit value="Ingresar"></s:submit>
        </s:form>
    </body>
</html>
