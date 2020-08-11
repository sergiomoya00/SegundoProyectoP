<%-- 
    Document   : DiagnosticList
    Created on : 27-jul-2020, 22:24:25
    Author     : jabre
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
        <h1>DIAGNOSTICOS REGISTRADOS</h1>
        <a class="btn btn-dark" href="getDiagnostics">ver listado de diagnosticos</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">nombre</th>
                    <th scope="col">nivel</th>
                    <th scope="col">observaciones</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="list">
                <tr>
                    <th scope="row"><s:property value="name"></s:property></th>
                <td><s:property value="level"></s:property></td>
                <td><s:property value="observations"></s:property></td>

                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
