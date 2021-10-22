package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.DTO.Proveedor;

//metodos listar  registrar actualizar y borrar
public class ProDAO {
	//consultar
	public ArrayList <Proveedor> lipro(){
		ArrayList<Proveedor>mypro=new ArrayList<Proveedor>();
		Conexion nex=new Conexion();
		
		try {
			PreparedStatement consulta=nex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res=consulta.executeQuery();
			while(res.next()) {
				Long idpro=(long) Integer.parseInt(res.getString("nitproveedor"));
				String ciupro=res.getString("ciudad_proveedor");
				String dirpro=res.getString("direccion_proveedor");
				String nompro=res.getString("nombre_proveedor");
				String telpro=res.getString("telefono_proveedor");
				
				Proveedor pro=new Proveedor(idpro,ciupro,dirpro,nompro,telpro);
				mypro.add(pro);
			}
			res.close();
			consulta.close();
			nex.desnex();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar"+e);
		}
		return mypro;
	}
	//registrar
	public Proveedor regpro(Proveedor pro) {
		Conexion nex=new Conexion();
		
		try {
			Statement tuto=nex.getConnection().createStatement();
			tuto.executeUpdate("INSERT INTO proveedores VALUES (' "+pro.getIdpro()+"','"+pro.getCiupro()+"','"+pro.getDirpro()+"','"+pro.getNompro()+"','"+pro.getTelpro()+ "')" );
			tuto.close();
			nex.desnex();
		}catch(SQLException e){
			pro=null;
			System.out.println(e.getMessage());
		}
		return pro;
	}
	//buscar
	public Proveedor buspro(Proveedor pro) {
		Conexion nex=new Conexion();
        try {
        	Statement tuto=nex.getConnection().createStatement();
            
            ResultSet res = tuto.executeQuery("select * from proveedores where nitproveedor = '"+pro.getIdpro()+"'");

            if (res != null){
                while (res.next()){
                    System.out.println("NIT Proveedor:"+res.getString("nitproveedor")+"\n"+"Ciudad Proveedor:"+res.getString("ciudad_proveedor")+"\n"+"Direccion Proveedor:"+res.getString("direccion_proveedor")+"\n"+"Nombre Proveedor:"+res.getString("nombre_proveedor")+"\n"+"Telefono Proveedor:"+res.getString("telefono_proveedor")+"\n");
                }
            }
        }catch (Exception e){
        	pro=null;
			System.out.println(e.getMessage());
        }
        return pro;
    }
	//borrar
	public Proveedor delpro(Proveedor pro) {
		Conexion nex=new Conexion();
		  try {
			  Statement tuto=nex.getConnection().createStatement();
	          String ry = "delete from proveedores where nitproveedor = '"+pro.getIdpro()+"'";
	          tuto.executeUpdate(ry);
	        }catch (Exception e){
	        	pro=null;
				System.out.println(e.getMessage());
	        }
		  return pro;
	}
	//actualizar
	public Proveedor actpro(Proveedor pro) {
		Conexion nex=new Conexion();
		 try {
			 Statement tuto=nex.getConnection().createStatement();
	         String ry = "update proveedores set ciudad_proveedor = '"+pro.getCiupro()+"', direccion_proveedor = '"+pro.getDirpro()+"', nombre_proveedor = '"+pro.getNompro()+"', telefono_proveedor = '"+pro.getTelpro()+"' where nitproveedor = '"+pro.getIdpro()+"' ";
	         tuto.executeUpdate(ry);
	        }catch (Exception e){
	        	pro=null;
				System.out.println(e.getMessage());
	        }
		 return pro;
	    }
}
