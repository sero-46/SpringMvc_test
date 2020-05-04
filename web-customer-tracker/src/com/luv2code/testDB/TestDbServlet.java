package com.luv2code.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="sero";
		String pass="sero";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
	   
		try
		{
			PrintWriter out=response.getWriter();
			out.println("Connecting to DB URL : " + jdbcUrl);
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("SUCCESSFULLY CONNECTED!!!!!!!");
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}

}
