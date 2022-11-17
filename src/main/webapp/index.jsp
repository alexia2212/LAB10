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
        <p></p>
        <p></p>
        <h2 style="font-family: 'KrinkesDecorPERSONAL'; color:#E2FAFF" class="card-title"><b>INICIO DE
            SESIÓN</b></h2>
        <center>
            <img src="https://saludpublica.uchile.cl/dam/jcr:1e8f3e0a-5c5e-4087-b942-987580a7bb82/linea-celeste-final.png"
                 alt="linea" class="card-img" width="90%" height="10%">
        </center>
        <p></p>
        <p></p>
        <h5 style="font-family: 'Times New Roman', Times, serif; color:#C6D6F5" class="card-text"><b> Ingrese sus DATOS </b></h5>
        <p></p>
        <form method="post" class="form-signin" action="<%=request.getContextPath()%>/InicioServlet">
            <div class="d-grid gap-2 col-8 mx-auto form-floating mb-3">
                <input type="numbers" class="form-control" id="nro_documento" placeholder="Nro Documento" name="nro_documento">
                <label for="nro_documento">Usuario</label>
            </div>
            <div class="d-grid gap-2 col-8 mx-auto form-floating">
                <input type="password" class="form-control" id="password" placeholder="password"
                       name="password">
                <label for="password">Contraseña</label>
            </div>
            <p></p>
            <p></p>
            <% if (request.getParameter("error") != null) {%>
            <div class="text-danger mb-2">Hubo un Error en su Usuario o Contraseña , Vuelva a Ingresar</div>
            <% } %>
            <div class="d-grid gap-2 col-3 mx-auto">
                <button type="submit" class="btn btn-primary">
                    Ingresar
                </button>
            </div>
        </form>
        <br>
    </div>
    </div>
</center>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</body>

</html>