<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21/08/2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
String username, message;

%>
<%
    username = (String) request.getAttribute("username");
    message = (String) request.getAttribute("message");
%>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Login</title>
</head>


<body background="img/clinic-slider02.jpg">
<div class="sign-up">
    <h1 class="sign-up-title">Login</h1>
    <hr class="form-linea">
    <%
        if( message != null ) {
    %>
    <p class=="sign-up-input"><%=message%></p>
    <%
        }
    %>
    <form action="signin" method="post">
        <label for="username">Usuario:</label>
        <input class="sign-up-input"  type="text" name="username" id="username" value="<%=(username!=null ? username : "")%>"placeholder="Ingresar Usuario" autofocus>
        <label for="password">Contraseña:</label>
        <input class="sign-up-input"  type="password" name="password" id="password" placeholder="********">
        <input class="sign-up-button" type="submit" name="ingresar"value="Ingresar">
    </form>
    <br>
    <form action="register.jsp" method="post">
        <input class="sign-up-button" type="submit" name="registrar"value="registrar">
    </form>
</div>
</body>

</html>
