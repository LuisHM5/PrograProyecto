
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
    private String rescatarVentas[][] = new String[100][100];
     public String agregarVenta(Connection conn, Ventas vent)
    {
        PreparedStatement pst = null;
        String sql = "INSERT INTO VENTAS (NOMBRE,CANTIDAD,PRECIO,IDPRODUCTO)"+ "VALUES(?,?,?,?)";
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, vent.getNombre());
            pst.setInt(2, vent.getCantidad());
            pst.setDouble(3, vent.getPrecio());
            pst.setInt(4, vent.getIdprodc());
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
     
    public String [][] rescatarVentas(Connection conn)
    {
        String sql2 ="SELECT COUNT(*) FROM VENTAS";
        String sql = "SELECT * FROM VENTAS ORDER BY PRECIO";
        int cantidad=-1;
        PreparedStatement pst = null;
        ResultSet resu = null;
        try {
            pst = conn.prepareStatement(sql2);
            resu = pst.executeQuery(); 
            if(resu.next())
            {
                cantidad=resu.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"No se pudo wey\n"+e.getMessage());
        }
        try 
        {
            pst = null;
            resu = null;
            pst = conn.prepareStatement(sql);
            resu = pst.executeQuery(); 
            if(resu.next())
            {

                for(int j=0;j<cantidad+1;j++)
                {
                    for(int i=0; i<5;i++)
                    {
                        rescatarVentas[i][j]=resu.getString(i+1);
                    }
                }                                                                
            }                             
        } 
        catch (SQLException e) 
        {
            JOptionPane.showConfirmDialog(null,"No se puede listar la tabla:\n"+e.getMessage());
        }
        return rescatarVentas;
    }     
           
    
}
