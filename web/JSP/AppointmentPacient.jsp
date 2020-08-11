<%-- 
    Document   : PacientAppointments
    Created on : 02/08/2020, 09:52:58 PM
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
        <s:form action="getDiagnosticsPFilter">


            <select id="ddlselect" onchange="ddlselect();">
                <option value="0">Seleccione el estado de su cita</option>
                <%
                    Conexion conexion = new Conexion();
                    Connection cin = conexion.getConnection();
                    PreparedStatement ps;
                    try {

                        ResultSet rs = null;
                        String login = "SELECT B.cedulaPaciente, A.nombre, B.estado, B.area, B.fecha FROM paciente A, citas B WHERE A.cedula=1 and A.cedula=B.cedulaPaciente ";
                        ps = cin.prepareStatement(login);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            out.print("<option>" + rs.getString("estado") + "</option>");
                        }
                        ps.close();

                    } catch (SQLException ex) {

                    }


                %>
            </select>
            <select id="dalselect" onchange="dalselect();">
                <option value="0">Seleccione la especialiación de la cita del cliente</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT B.cedulaPaciente, A.nombre, B.estado, B.area, B.fecha FROM paciente A, citas B WHERE A.cedula=1 and A.cedula=B.cedulaPaciente ";
                        ps = cin.prepareStatement(login);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            out.print("<option>" + rs.getString("area") + "</option>");
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
                        String login = "SELECT B.cedulaPaciente, A.nombre, B.estado, B.area, B.fecha FROM paciente A, citas B WHERE A.cedula=1 and A.cedula=B.cedulaPaciente ";
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

            <s:textfield label="Estado " id="txtddlvalue" name="appointment.condition"></s:textfield>
            <s:textfield label="Especizalización " id="txtdalvalue" name="appointment.area"></s:textfield>
            <s:textfield label="Fecha " id="txtidvalue" name="appointment.date"></s:textfield>
            <s:submit value="Buscar"></s:submit>

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Estado</th>
                            <th scope="col">Especialización</th>
                            <th scope="col">Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list">
                        <tr>
                            <th scope="row"><s:property value="condition"></s:property></th>
                            <td><s:property value="area"></s:property></td>
                            <td><s:property value="date"></s:property></td>
                            </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:form>
    </body>
</html>
