package com.example.lab10.Daos;

import com.example.lab10.Beans.Contratos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDao extends BaseDao{
    //listar los contratos de un cliente
    public ArrayList<Contratos> listarContratos() {
        ArrayList<Contratos> listaContratos = new ArrayList<>();

        //cambiar query
        String sql = "select * from jm_cotr_bis ";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while(rs.next()){
                Contratos contratos = new Contratos();
                contratos.setNroDeContrato(rs.getString(1));
                contratos.setIdCliente(rs.getInt(2));
                contratos.setDivisa(rs.getString(3));
                contratos.setEstado(rs.getInt(4));
                contratos.setMesesEnEseEstado(rs.getInt(5));

                listaContratos.add(contratos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaContratos;
    }

    //Mostrar cantidad de contratos

    //Mostrar Max ExpectedLoss

    //Buscar Cliente

}
