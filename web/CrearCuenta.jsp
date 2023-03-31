<%-- 
    Document   : Crear Cuenta
    Created on : 6 mar 2023, 22:04:06
    Author     : UrielC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cuenta</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/CrearCuenta.css"/>
    </head>
    <body>
        <header class="me_header">
            <div class="header">
                <div class="header_container">
                    <p class="header_logo">MindEase</p>
                    <a class="header_back" href="index.jsp"><i class='bx bx-arrow-back bx-sm'></i></a>
                </div>
            </div>
        </header>
        
        <main class="me_main">
            <div class="form_container">
                <form action="/Loginx/Register" method="post" class="form">
                    <header>Crear Cuenta</header>
                    <p class="form_text">Nombre:</p>
                    <input type="text" name="nombre" placeholder="Ingrese su nombre" class="form_input">
                    <p class="form_text">Correo:</p>
                    <input type="email" name="email" placeholder="Ingrese su correo" class="form_input">
                    <p class="form_text">Contraseña:</p>
                    <input type="password" name="pass" minlength="8" maxlength="20" placeholder="Ingrese una contraseña" class="form_input">
                    <div class="form_buttons">
                        <input type="submit" value="Enviar" class="form_button">
                        <input type="reset" value="Restablecer" class="reset form_button">
                    </form>
                    <input type="hidden" id="estado" value="<%=request.getAttribute("estado")%>">
                </form>
            </div>
        </main>
        <script type="text/javascript">
            let estado = document.getElementById("estado").value;
            if (estado == "exito") {
                alert("Ha creado una nueva cuenta con exito");
            }else if(estado == "sin_exito"){
                alert("No se ha pododo crear una cuenta")
            }
        </script>
    </body>
</html>


