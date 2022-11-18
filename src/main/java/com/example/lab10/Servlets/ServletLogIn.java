package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Daos.AdminDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogIn", value = "/ServletLogIn")
public class ServletLogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action")==null ? "index": request.getParameter("action");
        RequestDispatcher requestDispatcher;

        AdminDao adminDao = new AdminDao();
        HttpSession session = request.getSession();

        switch (action){

            case "index":
                Clientes clientes = (Clientes) session.getAttribute("usuarioLogged");

                if(clientes != null && Integer.parseInt(clientes.getNumeroDocumento()) != 0){
                    response.sendRedirect(request.getContextPath() + "/AdminServlet");
                } else {
                    requestDispatcher= request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request,response);
                }
                break;

            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath()+"/index.jsp");
                break;

            case "registro":
                request.setAttribute("listaEspecialidades", u.listarEspecialidad());
                requestDispatcher= request.getRequestDispatcher("registro.jsp");
                requestDispatcher.forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action= request.getParameter("action");
        AdminDao adminDao = new AdminDao();
        Clientes clientes = new Clientes();
        switch (action){

            case "login":

                String emailInput = request.getParameter("nro_documento");
                String passwordInput = request.getParameter("password");
                RequestDispatcher view;

                BUsuario bUsuario = userDao.validarUsuarioPassword(emailInput,passwordInput);
                if (bUsuario != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("userLogueado",bUsuario);
                    session.setMaxInactiveInterval(60*10);

                    String codigo = userDao.obtenerCodigoPorCorreo(emailInput);
                    request.setAttribute("codigopucp", codigo);

                    BUsuario teleco = userDao.obtenerUsuario(codigo);


                    if(teleco.getIdespecialidad()!=1){
                        response.sendRedirect(request.getContextPath() + "/loginServlet?erroresp");
                        break;
                    }


                    request.setAttribute("teleco",teleco);
                    request.setAttribute("listaViaje", empresaDaos.listadoViaje(codigo));
                    view = request.getRequestDispatcher("header_principal/Header_Principal.jsp");
                    view.forward(request, response);

                } else {
                    response.sendRedirect(request.getContextPath() + "/loginServlet?error");
                }
                break;
            case "crearUser":
                BUsuario buser = new BUsuario();
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                int edad = Integer.parseInt(request.getParameter("edad"));
                String codigo = request.getParameter("codigo");
                String correo = request.getParameter("correo");
                int especialidad = Integer.parseInt(request.getParameter("especialidad"));
                String contra = request.getParameter("contra");
                buser.setNombre(nombre);
                buser.setApellido(apellido);
                buser.setEdad(edad);
                buser.setCodigoPucp(codigo);
                buser.setCorreoPucp(correo);
                buser.setIdespecialidad(especialidad);
                buser.setPassword(contra);
                u.crearUsuario(buser);

                response.sendRedirect(request.getContextPath() + "/loginServlet?registro");

                break;
        }
    }
}
