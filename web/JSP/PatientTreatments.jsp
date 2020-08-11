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
        <title>Listado de tratamientos+66</title>
    </head>
    <body>
        <h1>Listado de tratamientos de los pacientes</h1>
    <s:form action="getTreatmentsFilter">


        <select id="ddselect" onchange="ddlselect();">
            <option value="0">Seleccione fecha del tratamiento</option>
            <%
                Conexion conexion = new Conexion();
                Connection cin = conexion.getConnection();
                PreparedStatement ps;
                try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM tratamientoPaciente ";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("fechaTratamiento") + "</option>");
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
                    String login = "SELECT * FROM catalogoTratamientos";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("tipo") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        <select id="docselect" onchange="docselect();">
            <option value="0">Seleccione nombre</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT * FROM tratamientoPaciente ";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("nombreTratamiento") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        
        <s:textfield label="Fecha:" id="txtvalue" name="treatments.date"></s:textfield>
        <s:textfield label="Tipo:" id="txtareavalue" name="treatments.type"></s:textfield>
        <s:textfield label="Nombre:" id="txtidvalue" name="treatments.name"></s:textfield>
        <s:submit value="Buscar"></s:submit>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Tratamiento</th>
                    <th scope="col">Diagnostico</th>
                    <th scope="col">Dosis de tratamiento</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Paciente</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="list">
                <tr>
                    <th scope="row"><s:property value="name"></s:property></th>
                <td><s:property value="idDiagnostic"></s:property></td>
                <td><s:property value="quantity"></s:property></td>
                <td><s:property value="type"></s:property></td>
                <td><s:property value="idPatient"></s:property></td>

                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:form>
</body>
</html>
