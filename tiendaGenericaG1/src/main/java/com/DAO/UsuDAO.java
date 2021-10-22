package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.DTO.Usuario;

//metodos listar  registrar actualizar y borrar
public class UsuDAO {
	//consultar
		public ArrayList <Usuario> liusu(){
			ArrayList<Usuario>myusu=new ArrayList<Usuario>();
			Conexion nex=new Conexion();
			
			try {
				PreparedStatement consulta=nex.getConnection().prepareStatement("SELECT * FROM usuarios");
				ResultSet res=consulta.executeQuery();
				while(res.next()) {
					Long idusu=(long) Integer.parseInt(res.getString("cedula_usuario"));
					String mailusu=res.getString("email_usuario");
					String nomusu=res.getString("nombre_usuario");
					String pass=res.getString("password");
					String ario=res.getString("usuario");
					
					Usuario usu=new Usuario(idusu,mailusu,nomusu,pass,ario);
					myusu.add(usu);
				}
				res.close();
				consulta.close();
				nex.desnex();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "no se pudo consultar"+e);
			}
			return myusu;
		}
		//registrar
		public Usuario regusu(Usuario usu) {
			Conexion nex=new Conexion();
			
			try {
				Statement tuto=nex.getConnection().createStatement();
				tuto.executeUpdate("INSERT INTO usuarios VALUES (' "+usu.getIdusu()+"','"+usu.getMailusu()+"','"+usu.getNomusu()+"','"+usu.getPass()+"','"+usu.getArio()+ "')" );
				tuto.close();
				nex.desnex();
			}catch(SQLException e){
				usu=null;
				System.out.println(e.getMessage());
			}
			return usu;
		}
		//buscar
		public Usuario bususu(Usuario usu) {
			Conexion nex=new Conexion();
	        try {
	        	Statement tuto=nex.getConnection().createStatement();
	            
	            ResultSet res = tuto.executeQuery("select * from usuarios where cedula_usuario = '"+usu.getIdusu()+"'");

	            if (res != null){
	                while (res.next()){
	                    System.out.println("Cedula Usuario:"+res.getString("cedula_usuario")+"\n"+"Email Usuario:"+res.getString("email_usuario")+"\n"+"Nombre Usuario:"+res.getString("nombre_usuario")+"\n"+"Contraseña Usuario:"+res.getString("password")+"\n"+"Usuario:"+res.getString("usuario")+"\n");
	                }
	            }
	        }catch (Exception e){
	        	usu=null;
				System.out.println(e.getMessage());
	        }
	        return usu;
	    }
		//borrar
		public Usuario delusu(Usuario usu) {
			Conexion nex=new Conexion();
			  try {
				  Statement tuto=nex.getConnection().createStatement();
		          String ry = "delete from usuarios where cedula_usuario = '"+usu.getIdusu()+"'";
		          tuto.executeUpdate(ry);
		        }catch (Exception e){
		        	usu=null;
					System.out.println(e.getMessage());
		        }
			  return usu;
		}
		//actualizar
		public Usuario actusu(Usuario usu) {
			Conexion nex=new Conexion();
			 try {
				 Statement tuto=nex.getConnection().createStatement();
		         String ry = "update usuarios set email_usuario = '"+usu.getMailusu()+"', nombre_usuario = '"+usu.getNomusu()+"' where cedula_usuario = '"+usu.getIdusu()+"' ";
		         tuto.executeUpdate(ry);
		        }catch (Exception e){
		        	usu=null;
					System.out.println(e.getMessage());
		        }
			 return usu;
		    }
		public void regusu(int i, String string, String string2, String string3, String string4) {
			// TODO Auto-generated method stub
			
		}
}
