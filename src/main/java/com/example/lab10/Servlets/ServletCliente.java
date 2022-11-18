package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Daos.ClienteDao;
import com.example.lab10.DTOS.ExpLossDTO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCliente", value = {"/ServletCliente",""})
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "Lista" : request.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("numeroContrato");
        opciones.add("divisa");
        opciones.add("estado");
        opciones.add("mesesEstado");
        ArrayList<String> options = new ArrayList<>();
        options.add("nroDeContrato");
        options.add("idCliente");
        options.add("divisa");
        options.add("estado");
        options.add("mesesEnEseEstado");
        ClienteDao clienteDao = new ClienteDao();

        switch (action){
            case "Lista":
                request.setAttribute("opciones", opciones);
                request.setAttribute("listaContratos", clienteDao.listarContratos());
                view = request.getRequestDispatcher("cliente.jsp");
                view.forward(request,response);
            break;
            case "MostrarContratos":
                request.setAttribute("options", options);
                request.setAttribute("listaCantidadContrato",clienteDao.obtenerListaCantidadContrato());
                view = request.getRequestDispatcher("ListarContratosCliente.jsp");
                view.forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("name");
        ClienteDao clienteDao = new ClienteDao();

        switch (action){
            case "buscar":
                String buscar = request.getParameter("numeroDocumento");
                int id_user = Integer.parseInt(buscar);
                Clientes clientes = clienteDao.busquedaNombre(id_user);
                request.setAttribute("listaClientes",clientes);
                view = request.getRequestDispatcher("MisDatosCliente.jsp");
                view.forward(request, response);
                break;
            case "mostrarExpLoss":
                int mostrarEL = Integer.parseInt(request.getParameter("mostrarExpLoss"));
                String option = request.getParameter("tipo");
                request.setAttribute("opciones", opciones);
                ArrayList<ExpLossDTO> mostrarExpL = new ArrayList<>();
                if(option.equals("nombre")){
                    mostrarExpL = clienteDao.mostrarExpectedLoss(mostrarEL);
                }
                request.setAttribute("mostrarListaEXLOSS", mostrarExpL);
                view = request.getRequestDispatcher("MostrarPuntMax.jsp");
                view.forward(request,response);
                break;
        }

    }
}
