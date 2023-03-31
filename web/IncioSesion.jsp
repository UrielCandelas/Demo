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
        <title>Iniciar Sesion
        </title>
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
                <form action="/Loginx/Login" method="post" class="form">
                    <header>Iniciar Sesión</header>
                    <p class="form_text">Correo</p>
                    <input type="email" name="email" placeholder="Ingrese su correo" class="form_input"/>
                    <p class="form_text">Contraseña:</p>
                    <input
                        type="password"
                        name="pass"
                        minlength="8"
                        maxlength="20"
                        placeholder="Ingrese su contraseña"
                        class="form_input"
                        />
                    <div class="form_buttons">
                        <input type="submit" value="Enviar" class="form_button">
                        <input type="reset" value="Restablecer" class="reset form_button">
                    </form>
                    <input type="hidden" id="estado2"
                    value="<%=request.getAttribute("estado2")%>">
                </form>
            </div>
        </main>
        <script type="text/javascript">
            let estado2 = document.getElementById("estado2").value;
            if (estado2 == "fallido") {
              alert("Usuario o contraseña incorrectos");
            }
          </script>
    </body>
</html>


