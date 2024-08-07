package Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConeccionBd.Coneccion;

import Modelo.usuario;

public class DaoUsuario {
	Coneccion conn;

	public DaoUsuario () {
		conn = new Coneccion ();
		
	}
	
	public boolean insertarUsuario (usuario Usuario, usuario idusuario) {
		PreparedStatement ps=null;
		try {
			ps=conn.conectar().prepareStatement("INSERT INTO usuario VALUES (null,?,?)");
			ps.setString(1, idusuario.getUsuario());
			ps.setString(2, idusuario.getClave());
			ps.executeUpdate();
			conn.desconectar();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		}
	
}
