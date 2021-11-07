package app;
//jdbc
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conn = null;
    private static String login;
    private static String pass;
    private static String host;
    private static String Puerto;
    private static String sid;
    private static String url;
    public Conexion()
    {        
    }         
    public Conexion(String log, String pss, String h, String pt, String s)
    {

        if(!log.equals("") && !pss.equals("") && !h.equals("") && !pt.equals("") 
           && !s.equals(""))
        {
            login =log;
            pass = pss;
            host = h;
            Puerto = pt;
            sid = s;
            url ="jdbc:oracle:thin:@"+host+":"+Puerto+":"+sid;  
        }     
    }
       
    public static Connection getConnection(){            
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,login,pass);
            conn.setAutoCommit(false);
            if(conn == null)
            {
                JOptionPane.showMessageDialog(null,"Conexión Fallida");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Conexcion Erronea:\n"+e.getMessage());
        }
        return conn;        
    }
    public void desconexion()
    {
        try {
            conn.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al desconectar:\n"+e.getMessage());
        }
    }
  
}
