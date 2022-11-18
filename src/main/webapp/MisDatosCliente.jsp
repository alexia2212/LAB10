<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.lab10.Beans.Clientes" %>
<jsp:useBean id="listaCliente" scope="request" type="java.util.ArrayList<com.example.lab10.Beans.Clientes>"/>
<%
    String searchText = (String) request.getAttribute("searchText");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

    <title>Iniciar Sesión</title>
    <style>
        body {
            background: url("https://s3.amazonaws.com/files.pucp.edu.pe/puntoedu/wp-content/uploads/2021/01/23012836/atardecer-1-campus-1200x800-1-1024x683.jpg");
            background-position: center center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            height: 100vh;
            bgcolor: "#800000";
        }
        @font-face {
            font-family: Decor;
            src: url(KrinkesDecorPERSONAL.ttf);
        }
        @font-face {
            font-family: Decor;
            src: url(KrinkesRegularPERSONAL.ttf);
            font-style: italic;
        }
        p {
            font-family: Decor;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>


</head>

<body class="p-3 m-0 border-0 bd-example">
<br>
<br>
<br>
<center>
    <div class="card mb-3" style="max-width: 58rem; background-color:#00000090">
        <h1>LISTAR CONTRATOS</h1>
        <br>
        /search
        <form method="post" action="<%=request.getContextPath()%>/ServletCliente?action=buscar">
            <div class="col-auto">
                <label for="floatingInput" class="col-form-label">Buscar:</label>
            </div>
            <div class="col-auto">
                <input type="text" name="searchText" class="form-control" id="floatingInput"
                       placeholder="Buscar" value="<%=searchText!=null?searchText:""%>">
            </div>
        </form>

        <br>
        <div class="d-grid gap-2">
            <ul class="list-group">
                <li class="list-group-item">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Tipo Cliente</th>
                            <th scope="col">Numero Documento</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% int i = 1;
                            for (Clientes clientes : listaCliente) {%>
                        <tr>
                            <th scope="row"><%=i%></th>
                            <td><%=clientes.getNombreCliente()%></td>
                            <td><%=clientes.getEdad()%></td>
                            <td><%=clientes.getTipoCliente()%></td>
                            <td><%=clientes.getNumeroDocumento()%></td>
                        </tr>
                        <%
                                i++;
                            }
                        %>
                        </tbody>
                    </table>
                </li>
            </ul>
        </div>
    </div>

    </div>
</center>
<br>

<a class="btn btn-primary" href="<%=request.getContextPath()%>/completar" role="button"
   style="margin-left: 0rem; background-color:#D12C22 ; border: none;"> ◄ Atrás </a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</body>

</html>