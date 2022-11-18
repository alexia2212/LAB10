package com.example.lab10.Daos;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;

import java.sql.*;
import java.util.ArrayList;

public class AdminDao extends BaseDao{

    //Obtener datos del Cliente
    public Clientes buscarCliente(String usuarioId){

        Clientes clientes = null;
        String sql = "select * from jm_client_bii where g4093_nro_id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, usuarioId);

            try (ResultSet rs = pstmt.executeQuery();) {
                while(rs.next()){
                    clientes = new Clientes();
                    clientes.setNumeroDocumento(rs.getString(1));
                    clientes.setNombreCliente(rs.getString(2));
                    clientes.setEdad(rs.getString(3));
                    clientes.setTipoCliente(rs.getString(4));

                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return clientes;
    }

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

    //el admin deberá crear la cuenta a sus clientes por lo tanto habrá un
    //formulario donde se Introduzca el número de documento del cliente y su contraseña . Esta información
    //la deben guardar en la tabla de credential . La contraseña debe ser hasheada en la base de datos.
    public void createCredentialCliente(Clientes clientes, Credentials credentials, String password){

        String sql="insert into credentials (nro_documento,password) values (?,sha2(?,256))";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, credentials.getNumeroDocumento());
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


}
