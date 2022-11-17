package com.example.lab10.Daos;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Contratos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao extends BaseDao{

    //Listar clientes que no estén en la tabla de credentials
    public ArrayList<Clientes> listarClientes() {
        ArrayList<Clientes> listaClientes = new ArrayList<>();

        //cambiar query
        String sql = "select * from jm_cliente_bii ";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while(rs.next()){
                Clientes clientes = new Clientes();

                clientes.setNombreCliente(rs.getString(1));
                clientes.setEdad(rs.getString(2));
                clientes.setTipoCliente(rs.getString(3));
                clientes.setNumeroDocumento(rs.getString(4));

                listaClientes.add(clientes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }




}
