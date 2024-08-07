package ConeccionBd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccion {
		Connection conn= null;
		
		public Connection conectar() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ejemplo","root","prime");
				System.out.println("Coneccion ok");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn; 
			
		}
		
		public static void main(String [] args) {
			Coneccion conn= new Coneccion ();
			conn.conectar();
		}

		public void desconectar() {
			// TODO Auto-generated method stub
			
		}

}
