<%-- 
    Document   : PatientDiagnostics
    Created on : 08-ago-2020, 21:26:47
    Author     : samoy
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
        </script>
        <title>Listado de diagnosticos</title>
    </head>
    <body>
        <h1>Listado de diagnosticos de los pacientes</h1>
    <s:form action="getPacientDiagnosticsFilter">


        <select id="ddlselect" onchange="ddlselect();">
            <option value="0">Seleccione el nivel del diagnostico del paciente</option>
            <%
                Conexion conexion = new Conexion();
                Connection cin = conexion.getConnection();
                PreparedStatement ps;
                try {

                    ResultSet rs = null;
                    String login = "SELECT A.cedulaPaciente, A.nombreDiagnostico, B.nivel  FROM diagnosticoPaciente A inner join paciente C on A.cedulaPaciente=C.cedula inner join catalogoDiagnosticos B on A.nombreDiagnostico=B.nombreDiagnostico WHERE A.cedulaPaciente=1";
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
        <select id="dalselect" onchange="dalselect();">
            <option value="0">Seleccione nombre del diagnostico</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT A.cedulaPaciente, A.nombreDiagnostico, B.nivel  FROM diagnosticoPaciente A inner join paciente C on A.cedulaPaciente=C.cedula inner join catalogoDiagnosticos B on A.nombreDiagnostico=B.nombreDiagnostico WHERE A.cedulaPaciente=1";
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
        <select id="idselect" onchange="idselect();">
            <option value="0">Seleccione la fecha de la cita</option>
            <%                    try {

                    ResultSet rs = null;
                    String login = "SELECT B.cedulaPaciente, B.nombreDiagnostico, C.fecha, D.nivel FROM paciente A, diagnosticoPaciente B, citas C, catalogoDiagnosticos D WHERE A.cedula=1 and A.cedula=B.cedulaPaciente and C.cedulaPaciente=A.cedula and B.nombreDiagnostico=D.nombreDiagnostico";
                    ps = cin.prepareStatement(login);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        out.print("<option>" + rs.getString("fecha") + "</option>");
                    }
                    ps.close();

                } catch (SQLException ex) {

                }


            %>
        </select>
        
        <s:textfield label="Nombre del diagnostico" id="txtareavalue" name="diagnostics.name"></s:textfield>
        <s:textfield label="Nivel " id="txtidvalue" name="treatments.level"></s:textfield>
        <s:textfield label="fecha" id="txtdocvalue" name="appointment.date"></s:textfield>
        <s:submit value="Buscar"></s:submit>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col">nombreDiagnostico</th>
                    <th scope="col">fecha</th>
                    <th scope="col">nivel</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="list">
                <tr>
                    <th scope="row"><s:property value="name"></s:property></th>
                <td><s:property value="level"></s:property></td>
                <td><s:property value="date"></s:property></td>

                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:form>
</body>
</html>
