<%@ page import="pe.edu.autonoma.clinica.entity.Paciente" %>
<%@ page import="pe.edu.autonoma.clinica.entity.Doctor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="pe.edu.autonoma.clinica.entity.Cita" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 22/08/2020
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Doctor> doctores = new ArrayList<>();
%>
<%
    doctores = (List<Doctor>) request.getAttribute("doctores");
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
    <title>Registro Cita</title>
</head>
<body>
<nav class="navbar my-0 navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Clinica Felipe </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="showcitas">Citas</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="signout">Sing Out </a></li>
        </ul>
    </div>
</nav>

<div class="container my-0" id="advanced-search-form">
    <h2>Citas</h2>
    <form action="savecita" method="post">

        <div class="form-group">
        <label for="dni">DNI: </label>
        <input type="hidden" name="id" id="id"
               value="<%=(String) request.getSession().getAttribute("username")%>"></br>
        <input type="text" name="dni" id="dni"
               class="form-control"value="<%=(String) request.getSession().getAttribute("username")%>" disabled>
        </div>

        <div class="form-group">
            <label for="asunto">Asunto</label>
            <input type="text" name="asunto" class="form-control" placeholder="Asunto" id="asunto">
        </div>
        <div class="form-group">
            <label for="doctorId">Doctor: </label>
            <select class="form-control"name="doctorId"id="doctorId">
                <%
                    for (Doctor cliente : doctores) {
                %>
                <option value="<%=cliente.getId()%>"> <%=cliente.getNombreApellido()%> </option>
                <%
                    }
                %>
            </select>

        </div>
        <div class="form-group">
        </div><div class="form-group">
         </div>

        <div class="form-group">
            <label for="fecha">Fecha</label>
            <input type="text" name="fecha" class="form-control" placeholder="Fecha" id="fecha">
        </div>

        <div class="clearfix"></div>
        <button type="submit" class="btn btn-info btn-lg btn-responsive" >Registrar</button>
    </form>
</div>
</body>
</html>
