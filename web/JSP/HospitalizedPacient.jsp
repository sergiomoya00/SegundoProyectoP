<%-- 
    Document   : HospitalizedPacient
    Created on : 08/08/2020, 06:22:38 PM
    Author     : samoy
--%>

<%@page import="operations.HospitalizedController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% HospitalizedController calculator = new HospitalizedController();%>
      
        <%= calculator.setID(1)%>
        <%= calculator.getAllHospitalizedPacients()%>
    </head>
    <body>
        <h1>Hospitalizaciones</h1>
        <a class="btn btn-dark" href="getHospitalized">Ver las hospitalizaciones</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">centroAtencion</th>
                    <th scope="col">cedulaPaciente</th>
                    <th scope="col">nombrePaciente</th>
                    <th scope="col">diagnostico</th>
                    <th scope="col">fechaInicio</th>
                    <th scope="col">fechaSalida</th>
                    <th scope="col">area</th>
                    <th scope="col">cedulaFuncionario</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <th scope="row"><s:property value="pacientID"></s:property></th>
                        <td><s:property value="center"></s:property></td>
                        <td><s:property value="pacientName"></s:property></td>
                        <td><s:property value="diagnostic"></s:property></</td>
                        <td><s:property value="startDate"></s:property></td>
                        <td><s:property value="departureDate"></s:property></td>
                        <td><s:property value="area"></s:property></td>
                        <td><s:property value="worker"></s:property></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
