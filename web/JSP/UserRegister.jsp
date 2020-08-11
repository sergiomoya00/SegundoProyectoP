<%-- 
    Document   : UserRegister
    Created on : 27-jul-2020, 22:47:36
    Author     : jabre
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.center"%>
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
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRAR USUARIOS</h1>
        <s:form action="userRegister">
            <s:textfield id="txtvalue" label="Usuario:" name="login.email"></s:textfield>
                <select id="ddselect" onchange="ddlselect();">
                    <option value="0">Seleccione diagnostico asociado</option>
                <%
                    Conexion conexion = new Conexion();
                    Connection cin = conexion.getConnection();
                    PreparedStatement ps;
                    try {

                        ResultSet rs = null;
                        String login = "SELECT * FROM usuario";
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
            <s:password label="Ingresar la contraseña" name="login.password"></s:password>
            <s:textfield label="Ingresar el tipo de usuario" name="login.type"></s:textfield>
            <s:submit value="Ingresar"></s:submit>
        </s:form>
        <s:form action="PacientR">
            <s:password label="Ingresar la contraseña" name="login.password"></s:password>
            <s:textfield label="Ingresar el tipo de usuario" name="login.type"></s:textfield>
            <s:submit value="Registrarse"></s:submit>
        </s:form>
    </body>
</html>
