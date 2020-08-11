<%-- 
    Document   : CreateAppointment
    Created on : 03-ago-2020, 19:24:15
    Author     : jabre
--%>

<%@page import="dao.EmailNotification"%>
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
        <title>Asignar cita de paciente</title>
       
    </head>
    <body>
        <h1>Asignar cita al paciente</h1>
        <s:form action="createAppointment">


            <select id="ddselect" onchange="ddlselect();">
                <option value="0">Seleccione cedula del paciente</option>
                <%
                    Conexion conexion = new Conexion();
                    Connection cin = conexion.getConnection();
                    PreparedStatement ps;
                    try {

                        ResultSet rs = null;
                        String login = "SELECT * FROM citas ";
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
                <option value="0">Seleccione codigo de la cita</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT * FROM citas ";
                        ps = cin.prepareStatement(login);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            out.print("<option>" + rs.getString("codigoCita") + "</option>");
                        }
                        ps.close();

                    } catch (SQLException ex) {

                    }


                %>
            </select>
            <select id="docselect" onchange="docselect();">
                <option value="0">Seleccione doctor que atendera</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT * FROM funcionario where tipo='Doctor' ";
                        ps = cin.prepareStatement(login);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            out.print("<option>" + rs.getString("cedula") + "</option>");
                        }
                        ps.close();

                    } catch (SQLException ex) {

                    }


                %>
            </select>
            <select id="daselect" onchange="dalselect();">
                <option value="0">Seleccione especialidad requerida</option>
                <%                    try {

                        ResultSet rs = null;
                        String login = "SELECT * FROM area ";
                        ps = cin.prepareStatement(login);
                        rs = ps.executeQuery();

                        while (rs.next()) {
                            out.print("<option>" + rs.getString("nombre") + "</option>");
                        }
                        ps.close();

                    } catch (SQLException ex) {

                    }


                %>
            </select>
            <s:textfield label="Cedula del paciente" id="txtvalue" name="appointment.idPacient.id"></s:textfield>
            <s:textfield label="Especialidad requerida" id="txtareavalue" name="appointment.areas"></s:textfield>
            <s:textfield label="Codigo de la cita" id="txtidvalue" name="appointment.idAppointment"></s:textfield>
            <s:textfield label="Doctor que lo atiende" id="txtdocvalue" name="appointment.idDoctor"></s:textfield>
            <s:textfield label="Fecha de la cita:"  name="appointment.date"></s:textfield>
            <s:textfield label="Hora de la cita:" name="appointment.hour"></s:textfield>
            <s:textfield label="Observaciones" name="appointment.observation"></s:textfield>

            <s:submit value="Asignar"></s:submit>

        </s:form>
         <s:form action="email">
             <s:submit value="Enviar correo electrónico"></s:submit>
         </s:form>
    </body>
</html>
