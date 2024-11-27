package Controlador;
import Modelo.Cliente;
import Modelo.Pedido;
import bd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;

/**
 *
 * @author bastian
 */
public class Registro {
    
    public boolean agregar(Cliente cliente)
    {
        try {
            Date date;
            
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
                
            date = cliente.getFecha();
            
            String query = "INSERT INTO cliente(nombre,rut,fecha) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
           
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRut());
            stmt.setDate(3, new java.sql.Date(date.getTime()));

            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar Cliente " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar Cliente " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar(Cliente cliente)
    {
        try {
            Date date;
            
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
            
            date = cliente.getFecha();
            
            String query = "INSERT INTO cliente(nombre,rut,fecha) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
           
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRut());
            stmt.setDate(3, new java.sql.Date(date.getTime()));

            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar Cliente " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método actualizar Cliente " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean eliminar(int idCliente)
    {
        try {
            
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
            
           
            String query = "DELETE FROM cliente WHERE idCliente=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            stmt.setInt(1, idCliente);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al eliminar Cliente " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método eliminar Cliente " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Cliente> buscarTodos()
    {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        try {
                   
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "SELECT * FROM Cliente ORDER BY nombre" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setRut(rs.getString("rut"));
                cliente.setFecha(rs.getDate("fecha"));
                
                lista.add(cliente);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar los clientes " + e.getMessage());
        }
       return lista;
    }

    public Cliente buscarPorId(int idCliente) {
        Cliente cliente = new Cliente();
        try {

            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();

            //SQL
            String query = "SELECT * FROM cliente WHERE idCliente = ?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setRut(rs.getString("rut"));
                cliente.setFecha(rs.getDate("fecha"));

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en SQL al listar libros " + e.getMessage());
        }
       return cliente;
    }
    
    
    public boolean agregar(Pedido pedido)
    {
        try {
            
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
                

            
            String query = "INSERT INTO pedido(nombre,marca,cantidad) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
           
            stmt.setString(1, pedido.getNombre());
            stmt.setString(2, pedido.getMarca());
            stmt.setInt(3, pedido.getCantidad());


            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar Pedido " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar Pedido " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarPedido(int idPedido)
    {
        try {
            
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
            
           
            String query = "DELETE FROM pedido WHERE idPedido=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            stmt.setInt(1, idPedido);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al eliminar Pedido " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método eliminar Pedido " + e.getMessage());
            return false;
        }
    }
    
     public ArrayList<Pedido> buscarPedido()
    {
        ArrayList<Pedido> lista = new ArrayList<>();
        
        try {
                   
            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "SELECT * FROM Pedido ORDER BY nombre" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setNombre(rs.getString("nombre"));
                pedido.setMarca(rs.getString("marca"));
                pedido.setCantidad(rs.getInt("Cantidad"));
                
                lista.add(pedido);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar los pedido " + e.getMessage());
        }
       return lista;
    }

    public Pedido buscarPorIdpedido(int idPedido) {
        Pedido pedido = new Pedido();
        try {

            ConexionBD con = new ConexionBD();
            Connection cnx = con.obtenerConexion();

            //SQL
            String query = "SELECT * FROM Pedido WHERE idPedido = ?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idPedido);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setNombre(rs.getString("nombre"));
                pedido.setMarca(rs.getString("marca"));
                pedido.setCantidad(rs.getInt("cantidad"));

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en SQL al listar pedido2 " + e.getMessage());
        }
       return pedido;
    }
    
}
