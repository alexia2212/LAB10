package com.example.lab10.Servlets;

import com.example.lab10.Beans.*;
import com.example.lab10.Daos.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "InicioServlet", urlPatterns = {"","/InicioServlet"})
        public class InicioServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            RequestDispatcher requestDispatcher;
            if(action == null){
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request,response);
            }else{
                switch (action){
                    case "Login":
                        Credentials user = (Credentials) request.getSession().getAttribute("userlogged");
                        if(user != null && user.getNumeroDocumento() !=0){
                            response.sendRedirect(request.getContextPath());
                            System.out.println(":D");
                        }
                        else{
                            requestDispatcher = request.getRequestDispatcher("index.jsp");
                            requestDispatcher.forward(request,response);
                            System.out.println(":o");
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
            String nro_docum = request.getParameter("nro_documento");
            String password = request.getParameter("password");
            Credentials userLog = datosDao.validUserPassword(nro_docum,password);


        }
}
