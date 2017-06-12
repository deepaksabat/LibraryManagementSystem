package com.elib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.elib.beans.LibrarianBean;

public class LibrarianDao {
	
	public static int save(LibrarianBean bean)
	{
		int status = 0;
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("insert into e_librarian(name,email,password,mobile) values(?,?,?,?)");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4, bean.getMobiel());
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public static int update(LibrarianBean bean)
	{
		int status = 0;
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps1 = con.prepareStatement("update e_librarian set name=?,email=?,password=?,mobile=? where id=?");
			ps1.setString(1,bean.getName());
			ps1.setString(2,bean.getEmail());
			ps1.setString(3,bean.getPassword());
			ps1.setLong(4,bean.getMobiel());
			ps1.setInt(5,bean.getId());
			status = ps1.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static List<LibrarianBean> view()
	{
		List<LibrarianBean> list = new ArrayList<LibrarianBean>();
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps2 = con.prepareStatement("select * from e_librarian");
			ResultSet rs = ps2.executeQuery();
			while(rs.next())
			{
				LibrarianBean bean = new LibrarianBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobiel(rs.getLong("mobiel"));
				list.add(bean);
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static LibrarianBean viewById(int id){
		LibrarianBean bean=new LibrarianBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_librarian where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobiel(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id)
	{
		int status = 0;
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("delete from e_librarian where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static boolean authenticate(String email,String password)
	{
		boolean status = false;
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from e_librarian where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				status = true;
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
