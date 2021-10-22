package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.DTO.Cliente;

//metodos listar  registrar actualizar y borrar
public class CliDAO {
	//consultar
			public ArrayList <Cliente> licli(){
				ArrayList<Cliente>mycli=new ArrayList<Cliente>();
				Conexion nex=new Conexion();
				
				try {
					PreparedStatement consulta=nex.getConnection().prepareStatement("SELECT * FROM clientes");
					ResultSet res=consulta.executeQuery();
					while(res.next()) {
						Long idcli=(long) Integer.parseInt(res.getString("cedula_cliente"));
						String dircli=res.getString("direccion_cliente");
						String mailcli=res.getString("email_cliente");
						String nomcli=res.getString("nombre_cliente");
						String telcli=res.getString("telefono_cliente");
						
						Cliente cli=new Cliente(idcli,dircli,mailcli,nomcli,telcli);
						mycli.add(cli);
					}
					res.close();
					consulta.close();
					nex.desnex();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "no se pudo consultar"+e);
				}
				return mycli;
			}
			//registrar
			public Cliente regcli(Cliente cli) {
				Conexion nex=new Conexion();
				
				try {
					Statement tuto=nex.getConnection().createStatement();
					tuto.executeUpdate("INSERT INTO clientes VALUES (' "+cli.getIdcli()+"','"+cli.getDircli()+"','"+cli.getMailcli()+"','"+cli.getNomcli()+"','"+cli.getTelcli()+ "')" );
					tuto.close();
					nex.desnex();
				}catch(SQLException e){
					cli=null;
					System.out.println(e.getMessage());
				}
				return cli;
			}
			//buscar
			public Cliente buscli(Cliente cli) {
				Conexion nex=new Conexion();
		        try {
		        	Statement tuto=nex.getConnection().createStatement();
		            
		            ResultSet res = tuto.executeQuery("select * from clientes where cedula_cliente = '"+cli.getIdcli()+"'");

		            if (res != null){
		                while (res.next()){
		                    System.out.println("Cedula Cliente:"+res.getString("cedula_cliente")+"\n"+"Direccion Cliente:"+res.getString("direccion_cliente")+"\n"+"Correo Cliente:"+res.getString("email_cliente")+"\n"+"Nombre Cliente:"+res.getString("nombre_cliente")+"\n"+"Telefono Cliente:"+res.getString("telefono_cliente")+"\n");
		                }
		            }
		        }catch (Exception e){
		        	cli=null;
					System.out.println(e.getMessage());
		        }
		        return cli;
		    }
			//borrar
			public Cliente delcli(Cliente cli) {
				Conexion nex=new Conexion();
				  try {
					  Statement tuto=nex.getConnection().createStatement();
			          String ry = "delete from clientes where cedula_cliente = '"+cli.getIdcli()+"'";
			          tuto.executeUpdate(ry);
			        }catch (Exception e){
			        	cli=null;
						System.out.println(e.getMessage());
			        }
				  return cli;
			}
			//actualizar
			public Cliente actcli(Cliente cli) {
				Conexion nex=new Conexion();
				 try {
					 Statement tuto=nex.getConnection().createStatement();
			         String ry = "update clientes set direccion_cliente = '"+cli.getDircli()+"', email_cliente = '"+cli.getMailcli()+"', nombre_cliente = '"+cli.getNomcli()+"', telefono_cliente = '"+cli.getTelcli()+"' where cedula_cliente = '"+cli.getIdcli()+"' ";
			         tuto.executeUpdate(ry);
			        }catch (Exception e){
			        	cli=null;
						System.out.println(e.getMessage());
			        }
				 return cli;
			    }
}
