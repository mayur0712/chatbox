package com.cebs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cebs.beans.User;


public class DAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public DAO() {
		// TODO Auto-generated constructor stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test21","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean registerUser(User user)
	{
		try
		{
			String sql = "insert into user (fname,lname,email,phone,uname,password) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getUname());
			pstmt.setString(6, user.getPassword());
			return pstmt.executeUpdate()>0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public User validateUser(String uname,String password)
	{
		try
		{
			String sql = "select * from user where uname = ? or email = ? or phone = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, uname);
			pstmt.setString(3, uname);
			pstmt.setString(4, password);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getInt("active"));
				return user;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
