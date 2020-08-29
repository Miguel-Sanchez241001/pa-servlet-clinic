<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.clinica.entity.Paciente" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21/08/2020
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String username;

%>
<%
    username = (String) request.getSession().getAttribute("username");
%>
<%!
    List<Paciente> pacientes = new ArrayList<>();
%>
<%
    pacientes = (List<Paciente>) request.getAttribute("pacientes");
%>
<html>
<head>
    <title>Pacientes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body background="img/clinic-slider02.jpg">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Clinica Felipe </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="showcitas">Citas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="showpacientes">Pacientes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="showdoctores">Doctores</a>
            <li class="nav-item"><a class="nav-link" href="signout">Sing Out <%=username%></a></li>
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="container p- mb-2 bg-white text-dark">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">DNI</th>
            <th scope="col">Nombre Apellido</th>
            <th scope="col">Email</th>
            <th scope="col">Telefono</th>
            <th scope="col">Edad</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Paciente pacientes: pacientes) {
        %>
        <tr>
            <th scope="row"><%=pacientes.getDni()%></th>
            <td><%=pacientes.getNombreApellido()%></td>
            <td><%=pacientes.getEmail()%></td>
            <td><%=pacientes.getTelefono()%></td>
            <td><a class="btn btn-success"href="editpaciente?id=<%=pacientes.getDni()%>" >Editar</a></td>
            <td><a class="btn btn-danger"href="deletepaciente?id=<%=pacientes.getDni()%>" >Eliminar</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <button type="button" class="btn btn-success"><a class="badge badge-success"href="register.jsp" class="a-button a-button-new">Nuevo</a></button>
</div>
</body>
</html>
