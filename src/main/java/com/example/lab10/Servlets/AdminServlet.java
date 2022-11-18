package com.example.lab10.Servlets;

import com.example.lab10.Beans.Contratos;
import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;
import com.example.lab10.Daos.BaseDao;
import com.example.lab10.Daos.ClienteDao;
import com.example.lab10.Daos.AdminDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AdminServlet", value = {"/AdminServlet",""})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {


    }
}
