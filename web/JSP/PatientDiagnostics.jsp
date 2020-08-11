<%-- 
    Document   : PatientDiagnostics
    Created on : 03-ago-2020, 21:26:47
    Author     : jabre
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function ddlselect() {
                var d = document.getElementById("ddselect");
                var displaytext = d.options[d.selectedIndex].text;
                document.getElementById("txtvalue").value = displaytext;

            }
            function dalselect() {
                var d = document.getElementById("daselect");
                var displaytext = d.options[d.selectedIndex].text;
                document.getElementById("txtareavalue").value = displaytext;

            }
            function idselect() {
                var d = document.getElementById("idselect");
                var displaytext = d.options[d.selectedIndex].text;
                document.getElementById("txtidvalue").value = displaytext;

            }
            function docselect() {
                var d = document.getElementById("docselect");
                var displaytext = d.options[d.selectedIndex].text;
                document.getElementById("txtdocvalue").value = displaytext;

            }
        </script>
        <title>Listado de diagnosticos</title>
    </head>
    <body>
        <h1>Listado de diagnosticos de los pacientes</h1>
    <s:form action="getDiagnosticsFilter">


        <select id="ddselect" onchange="ddlselect();">
            <option value="0">Seleccione cedula del paciente</option>
            <%
                Conexion conexion = new Conexion();
                Connection cin = conexion.getConnection();
                PreparedStatement ps;
                try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM diagnosticoPaciente ";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("cedulaPaciente") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        <select id="idselect" onchange="idselect();">
            <option value="0">Seleccione nombre del diagnostico</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM diagnosticoPaciente";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("nombreDiagnostico") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        <select id="docselect" onchange="docselect();">
            <option value="0">Seleccione nivel</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM catalogoDiagnosticos  ";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("nivel") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        <select id="daselect" onchange="dalselect();">
            <option value="0">Seleccione fecha</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM diagnosticoPaciente ";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("fechaDiagnostico") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        <s:textfield label="Cedula del paciente" id="txtvalue" name="diagnostics.idPacient.id"></s:textfield>
        <s:textfield label="Nombre del diagnostico" id="txtareavalue" name="diagnostics.name"></s:textfield>
        <s:textfield label="Nivel " id="txtidvalue" name="diagnostics.level"></s:textfield>
        <s:textfield label="fecha" id="txtdocvalue" name="diagnostics.date"></s:textfield>
        <s:submit value="Buscar"></s:submit>

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
                <td><s:property value="date"></s:property></td>

                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:form>
</body>
</html>
