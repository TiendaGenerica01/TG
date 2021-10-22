package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*conexion DB local y maria DB*/
public class Conexion {
	static String bd="tiendaGenerica01";
	static String login="root";
	static String pass="jrsebastian55";
	static String url="jdbc:mysql://localhost:3306/"+bd;
	
	/* static String bd="tiendaGenerica01";
	 * static String login="Admin";
	 * static String pass="****";
	 * static String url="jdbc:mariadb//tienda.c47knbsonjdi.us-east-2.rds.amazonws.com/"+bd;*/
	
	Connection con=null;
	
	public Conexion () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//mariadb
			//Class.forName("org.mariadb.jdbc.Driver");
			
			con=DriverManager.getConnection(url,login,pass);
			if (con != null) {
				System.out.println("con conexion");
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	//retornar conexion
	public Connection getConnection() {
		return con;
	}
	//desconexion
	public void desnex() {
		con=null;
		
	}
}
