package com.example.lab10.Daos;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Contratos;
import com.example.lab10.DTOS.ExpLossDTO;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDao extends BaseDao {
    //listar los contratos de un cliente
    public ArrayList<Contratos> listarContratos() {
        ArrayList<Contratos> listaContratos = new ArrayList<>();

        //cambiar query
        String sql = "select * from jm_cotr_bis ";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
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
    public ArrayList<Contratos> obtenerListaCantidadContrato() {
        ArrayList<Contratos> listaCantidadContrato = new ArrayList<>();

        String sql2 = "SELECT * FROM jm_cotr_bis";
        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql2)
        ) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCantidadContrato;
    }

    //Mostrar Max ExpectedLoss
    //esta conectado con contrato
   public ArrayList<ExpLossDTO> mostrarExpectedLoss(int cliente_nro_id)
    {
        ArrayList<ExpLossDTO> mostrarListaEXLOSS = new ArrayList<>();
        String sql = "SELECT pd_value FROM jm_values";
        //tasa de recuperación recovery_rate
        //Corregir ??
        try(
        Connection connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            preparedStatement.setInt(1, cliente_nro_id);
            while (resultSet.next()){
                ExpLossDTO expLossDTO = new ExpLossDTO();

                expLossDTO.setId_contrato(resultSet.getInt(1));
                expLossDTO.setCliente_nro_id(resultSet.getString(2));
                expLossDTO.setExpLoss(resultSet.getFloat(3));
                mostrarListaEXLOSS.add(expLossDTO);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
            return mostrarListaEXLOSS;
    }

    //Buscar Cliente
    public Clientes busquedaNombre(int nro_documento){
        String sql = "select * from jm_client_bii where g4093_age like ?";
        Clientes clientes = null;

        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setInt(1,nro_documento);

            try(ResultSet rs= pstmt.executeQuery();){
                while (rs.next()){
                    clientes = new Clientes();
                    Contratos contratos = new Contratos();
                    contratos.setIdCliente(rs.getInt("idCliente"));
                    clientes.setNombreCliente(rs.getString("nombre"));
                    clientes.setEdad(rs.getString("edad"));
                    clientes.setTipoCliente(rs.getString("tipoCliente"));
                    clientes.setNumeroDocumento(rs.getString("numeroDocumento"));


                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }


}
