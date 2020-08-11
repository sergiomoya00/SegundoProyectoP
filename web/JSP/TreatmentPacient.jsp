<%-- 
    Document   : PacientTreatments
    Created on : 07/08/2020, 09:27:20 PM
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
        <s:form action="getDiagnosticsFilter">

            <select id="ddlselect" onchange="ddlselect();">
                <option value="0">Seleccione el tipo de tratamiento</option>
                <%
                    Conexion conexion = new Conexion();
                    Connection cin = conexion.getConnection();
                    PreparedStatement ps;
                    try {

                        ResultSet rs = null;
                        String login = "SELECT A.cedulaPaciente, A.nombreTratamiento, B.tipo, D.fecha FROM tratamientoPaciente A inner join paciente C on A.cedulaPaciente=C.cedula inner join catalogoTratamientos B on A.nombreTratamiento=B.tratamiento inner join citas D on D.cedulaPaciente=A.cedulaPaciente WHERE A.cedulaPaciente=1";
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
            <select id="dalselect" onchange="dalselect();">
                <option value="0">Seleccione nombre del tratamiento</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT A.cedulaPaciente, A.nombreTratamiento, B.tipo, D.fecha FROM tratamientoPaciente A inner join paciente C on A.cedulaPaciente=C.cedula inner join catalogoTratamientos B on A.nombreTratamiento=B.tratamiento inner join citas D on D.cedulaPaciente=A.cedulaPaciente WHERE A.cedulaPaciente=1";
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
            <select id="idselect" onchange="idselect();">
                <option value="0">Seleccione la fecha de la cita</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT A.cedulaPaciente, A.nombreTratamiento, B.tipo, D.fecha FROM tratamientoPaciente A inner join paciente C on A.cedulaPaciente=C.cedula inner join catalogoTratamientos B on A.nombreTratamiento=B.tratamiento inner join citas D on D.cedulaPaciente=A.cedulaPaciente WHERE A.cedulaPaciente=1";
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