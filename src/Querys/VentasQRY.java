
package Querys;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import setgetters.Ventas;

public class VentasQRY {
    private String mensaje = "";
    private String filasBusc[] = new String[4];
     public String agregarVenta(Connection conn, Ventas vent)
    {
        PreparedStatement pst = null;
        String sql = "INSERT INTO VENTAS (NOMBRE,CANTIDAD,PRECIO)"+ "VALUES(?,?,?)";
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, vent.getNombre());
            pst.setInt(2, vent.getCantidad());
            pst.setDouble(3, vent.getPrecio());
            pst.execute();
            pst.close();
            mensaje = "Agregado con exito";
        } 
        catch (SQLException e) 
        {
            mensaje = "Error no se pudo guardar:\n"+e.getMessage();
        }
        return mensaje;
    }
     public void listarVentas(Connection conn, JTable table)
    {
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","CANTIDAD","PRECIO"};
        model = new DefaultTableModel(null,columnas);
        String [] filas = new String[4];
        
        String sql = "SELECT IDVENTAS,NOMBRE,CANTIDAD,PRECIO FROM VENTAS ORDER BY CANTIDAD";
        Statement st = null;
        ResultSet resu = null;
        try 
        {
            st = conn.createStatement();
            resu = st.executeQuery(sql);
            
            while (resu.next()) {
                for(int i=0; i<4;i++)
                {
                    filas[i]=resu.getString(i+1);
                }
                model.addRow(filas);               
            }
            table.setModel(model);
        } 
        catch (SQLException e) 
        {
            JOptionPane.showConfirmDialog(null,"No se puede listar la tabla:\n"+e.getMessage());
        }           
    }
     public String cancelarVentas(Connection conn)
    {
        PreparedStatement pst = null;
        String sql = "DELETE FROM VENTAS";
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            mensaje = "Venta cancelado con exito!";
        } 
        catch (SQLException e) 
        {
            mensaje = "Error no se pudo cancelar:\n"+e.getMessage();
        }
        return mensaje;
    }     
           
    
}
