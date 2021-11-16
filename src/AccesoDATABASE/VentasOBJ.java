
package AccesoDATABASE;
import Querys.VentasQRY;
import app.Conexion;
import java.sql.Connection;
import javax.swing.JTable;
import setgetters.Ventas;

public class VentasOBJ {
    private String mensaje = "";
    private VentasQRY pov = new VentasQRY();    
    private String filas []= new String[6];
     public String agregarVenta(Conexion conect, Ventas vent)
    {
        Connection conn = conect.getConnection();
        try
        {
            mensaje=pov.agregarVenta(conn, vent);
        } 
        catch (Exception e) 
        {
            mensaje= mensaje +" "+e.getMessage();
        }
        finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje= mensaje +" "+e.getMessage();
            }
        }
        return mensaje;
    }
     public String cancelarVentas(Conexion conect)
    {
        Connection conn = conect.getConnection();
        try
        {
            mensaje=pov.cancelarVentas(conn);
        } 
        catch (Exception e) 
        {
            mensaje= mensaje +" "+e.getMessage();
        }
        finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje= mensaje +" "+e.getMessage();
            }
        }
        return mensaje;
    }
     public void listarVentas(Conexion conect, JTable table)
    {
        Connection conn = conect.getConnection();
        pov.listarVentas(conn, table);       
        try 
        {
            conn.close();
        } 
        catch (Exception e) 
        {
           // mensaje= mensaje +" "+e.getMessage();
        }
        finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                //mensaje= mensaje +" "+e.getMessage();
            }
        }               
    } 
}
