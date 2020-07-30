<%-- 
    Document   : CenterList
    Created on : 27-jul-2020, 17:19:36
    Author     : jabre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Centros de Atención</title>
    </head>
    <body>
        <h1>CENTROS REGISTRADOS</h1>
        <a class="btn btn-dark" href="getCenters">ver los centros</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">  codigo   </th>
                    <th scope="col">nombre</th>
                    <th scope="col">ubicacion</th>
                    <th scope="col">capacidad</th>
                    <th scope="col">tipo</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <th scope="row"><s:property value="id"></s:property></th>
                        <td><s:property value="name"></s:property></td>
                        <td><s:property value="ubication"></s:property></td>
                        <td><s:property value="capacity"></s:property></</td>
                        <td><s:property value="type"></s:property></td>

                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
