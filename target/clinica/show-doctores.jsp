<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.clinica.entity.Doctor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 22/08/2020
  Time: 04:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!

    int acum;
    String key;
    List<Doctor> doctores = new ArrayList<>();

%>
<%
    acum=0;
    key= (String) session.getAttribute("key");
    doctores = (List<Doctor>) request.getAttribute("doctores");
%>
<html>
<head>
    <title>Doctores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
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
            <%
                if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + (String) session.getAttribute("username"))){
            %>
            <li class="nav-item">
                <a class="nav-link" href="showpacientes">Pacientes</a>
            </li>


            <%
                }
            %>
            <li class="nav-item">
                <a class="nav-link" href="showdoctores">Doctores</a>

            <li class="nav-item"><a class="nav-link" href="signout">Sing Out</a></li>

            </li>

        </ul>
    </div>
</nav>
<br>
<div class="container p- mb-2 bg-white text-dark">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col"></th>
            <th scope="col">Nombre Apellido</th>
            <th scope="col">Correo</th>
            <th scope="col">Telefono</th>
            <th scope="col">Colegiatura</th>
            <th scope="col">Especialidad</th>
            <th scope="col">Turno</th>
            <%
                if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + (String) session.getAttribute("username"))){
            %>
            <th></th>
            <th></th>
            <%
                }
            %>

        </tr>
        </thead>
        <tbody>
        <%

                for (Doctor doctores: doctores) {


        %>
        <tr>
            <th scope="row"><%=acum=acum+1%></th>
            <td><%=doctores.getNombreApellido()%></td>
            <td><%=doctores.getEmail()%></td>
            <td><%=doctores.getTelefono()%></td>
            <td><%=doctores.getNumeroColegiatura()%></td>
            <td><%=doctores.getEspecialidad().getNombre()%></td>
            <td><%=doctores.getTurno().getTanda()%></td>
            <%
                if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + (String) session.getAttribute("username"))){
            %>
            <td><a class="btn btn-success"href="editdoctor?id=<%=doctores.getId()%>" >Editar</a> </td>
            <td><a class="btn btn-danger" href="deletedoctor?id=<%=doctores.getId()%>" >Eliminar</a></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
    <%
        if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + (String) session.getAttribute("username"))){
    %>
    <button type="button" class="btn btn-success"><a class="badge badge-success"href="newdoctor" class="a-button a-button-new">Nueva Doctor</a></button>
    <%
        }
    %>
</div>
</body>


</body>
</html>
