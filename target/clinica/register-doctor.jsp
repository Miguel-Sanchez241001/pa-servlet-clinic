<%@ page import="pe.edu.autonoma.clinica.entity.Especialidad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.clinica.entity.Turno" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 22/08/2020
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String username;
    List<Especialidad> especialidads = new ArrayList<>();
    List<Turno> turnos = new ArrayList<>();
%>

<% username = (String) request.getSession().getAttribute("username");
    especialidads =(List<Especialidad>)request.getAttribute("especialidades");
    turnos=(List<Turno>)request.getAttribute("turnos");
%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="css/styles.css">
    <title>Registro</title>
</head>
<body>

<nav class="navbar my-0 navbar-expand-lg navbar-light bg-light">
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
            </li>
            <li class="nav-item"><a class="nav-link" href="signout">Sing Out <%=username%></a></li>
        </ul>
    </div>
</nav>


<div class="container my-0" id="advanced-search-form">
    <h2>Doctor</h2>
    <form action="savedoctor" method="post">
        <div class="form-group">
            <label for="nombreApellido">Nombre Apellido</label>
            <input type="text" name="nombreApellido" class="form-control" placeholder="Nombre Apellido" id="nombreApellido">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" placeholder="Email" id="email">
        </div>
        <div class="form-group">
            <label for="telefono">Telefono</label>
            <input type="text" name="telefono" class="form-control" placeholder="Telefono" id="telefono">
        </div>
        <div class="form-group">
            <label for="colegiatura">Colegiatura</label>
            <input type="number" name="colegiatura" class="form-control" placeholder="Colegiatura" id="colegiatura">
        </div>
        <div class="form-group">
            <label for="especialidadId">Especialidad: </label>
            <select  class="form-control" name="especialidadId"id="especialidadId">
                <%
                    for (Especialidad especialidad : especialidads) {
                %>
                <option value="<%=especialidad.getId()%>"> <%=especialidad.getNombre()%> </option>
                <%
                    }
                %>
            </select>

        </div>

        <div class="form-group">
            <label for="turnoId">Turno: </label>
            <select  class="form-control"name="turnoId"id="turnoId">
                <%
                    for (Turno turno : turnos) {
                %>
                <option value="<%=turno.getId()%>"> <%=turno.getTanda()%> </option>
                <%
                    }
                %>
            </select>

        </div>

        <div class="clearfix"></div>
        <button type="submit" class="btn btn-info btn-lg btn-responsive" >Registrar</button>
    </form>
</div>
</body>
</body>
</html>
