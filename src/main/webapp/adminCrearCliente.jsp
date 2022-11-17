<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Escrbir nombre">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">Edad</label>
            <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="Escribir edad">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput3" class="form-label">Tipo Cliente</label>
            <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="Natural(N) o Juridica(J)">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput4" class="form-label">Tipo Documento</label>
            <input type="email" class="form-control" id="exampleFormControlInput4" placeholder="RUC o DNI">
        </div>
        <div class="mb-3">
            <select class="form-select" aria-label="Default select example">
                <option selected>Numero de Documento</option>
                <option value="1">123456</option>
                <option value="2">654123</option>
                <option value="3">652341</option>
            </select>
        </div>

    </div>
</center>
<br>
<br>
<a class="btn btn-primary" href="<%=request.getContextPath()%>/COMPLETAR" role="button"
   style="margin-left: 0rem; background-color:#D12C22 ; border: none;"> Crear </a>

<div class="btn-group" role="group" aria-label="Basic example">
    <button type="button" class="btn btn-primary">< Atrás</button>
    <button type="button" class="btn btn-primary">Guardar</button>
    <button type="button" class="btn btn-primary">Cerrar sesion</button>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</body>

</html>