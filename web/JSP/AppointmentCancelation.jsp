<%-- 
    Document   : DoctorsDateCancel
    Created on : 03-ago-2020, 18:54:28
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
            function ddlselect(){
                var d=document.getElementById("ddselect");
                var displaytext=d.options[d.selectedIndex].text;
                document.getElementById("txtvalue").value=displaytext;
                
            }
        </script>
        <title>Cancelar cita Paciente</title>
    </head>
    <body>
        <h1>Seleccione la cita a cancelar</h1>
        <s:form action="appointmentCancelation">


            <select id="ddselect" onchange="ddlselect();">
                <option value="0">Seleccione centro a eliminar</option>
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
                            out.print("<option>" + rs.getInt("cedulaPaciente") + "</option>");
                        }
                        ps.close();

                    } catch (SQLException ex) {

                    }


                %>
            </select>
            <s:textfield id="txtvalue" name="appointment.idAppointment"></s:textfield>
            <s:submit value="Eliminar"></s:submit>
        </s:form>
    </body>
</html>
