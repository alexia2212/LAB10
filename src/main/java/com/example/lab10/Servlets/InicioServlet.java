package com.example.lab10.Servlets;

import com.example.lab10.Beans.*;
import com.example.lab10.Daos.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InicioServlet", urlPatterns = {"/","/InicioServlet"})
        public class InicioServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            RequestDispatcher requestDispatcher;
            if(action == null){

                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
            }else{
                switch (action){
                    case "Login":
                        Credentials user = (Credentials) request.getSession().getAttribute("userlogged");
                        if(user != null && !user.getNumeroDocumento().equals("0")){
                            response.sendRedirect(request.getContextPath());
                        }
                        else{
                            System.out.println("get2");
                            requestDispatcher = request.getRequestDispatcher("index.jsp");
                            requestDispatcher.forward(request,response);
                        }
                        break;
                    case "logout":
                        HttpSession session = request.getSession();
                        session.invalidate();
                        response.sendRedirect( request.getContextPath() + "/InicioServlet");
                        break;
                }
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            DatosDao datosDao = new DatosDao();
            AdminDao adminDao = new AdminDao();
            String nro_docum = request.getParameter("nro_documento");
            String password = request.getParameter("password");
            Credentials userLog = datosDao.validUserPassword(nro_docum,password);
            if (userLog !=null){
                HttpSession session = request.getSession();
                session.setAttribute("userlogged",userLog);
                if(userLog.getTipoUsuario()==1){
                    response.sendRedirect(request.getContextPath() + "/AdminServlet?action=admin");
                } else if (userLog.getTipoUsuario()==2) {
                    response.sendRedirect(request.getContextPath() + "/ServletCliente?action=cliente");
                }
                else{
                    response.sendRedirect("index");
                }
            }

            else {
                response.sendRedirect(request.getContextPath()+"InicioServlet?action=LogIn&error");
            }

        }
}
