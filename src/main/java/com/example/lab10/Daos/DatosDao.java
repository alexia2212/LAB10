package com.example.lab10.Daos;
import com.example.lab10.Beans.*;
import java.sql.*;
import java.util.ArrayList;

public class DatosDao extends BaseDao{
    public ArrayList<Clientes> obtenerlistarContratos() {
        ArrayList<Clientes> listaContratos = new ArrayList<>();
        String sql = "select * from jm_client_bii";
        try(Connection connection=this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)
        ){
            while (resultSet.next()) {
                Clientes clientes = new Clientes();
                clientes.setNumeroDocumento(resultSet.getString(1));
                clientes.setNombreCliente(resultSet.getString(2));
                listaContratos.add(clientes);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return listaContratos;
    }
    public Credentials buscarPorId(int userID) {
        Credentials user = null;
        String sql = "select * from credential WHERE nro_documento = ?";
        try(Connection connection=this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setInt(1, userID);
            try(ResultSet resultSet = pstmt.executeQuery()){
                user =new Credentials();
                user.setTipoUsuario(resultSet.getInt(1));
                user.setNumeroDocumento(resultSet.getString(2));

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return user;
    }
    public Credentials validUserPassword(String nro_documento, String password) {
        Credentials user = new Credentials();
        String sql = "SELECT nro_documento, tipoUsuario FROM credentials where nro_documento = ? and password= sha2(?,256)";
        try(Connection connection = this.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
        ){
            pstm.setString(1,nro_documento);
            pstm.setString(2,password);
            try(ResultSet rs = pstm.executeQuery();) {
                if(rs.next()){
                    String userID = rs.getString(1);
                    int tipoUser = rs.getInt(2);
                    user.setNumeroDocumento(userID);
                    user.setTipoUsuario(tipoUser);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
