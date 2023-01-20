package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.pojo.User;

/**
 * Servlet implementation class registerservlet
 */
@WebServlet(description = "to register student", urlPatterns = { "/registerme" })
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {		
		System.out.println("init --" + getClass());
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.write("<h2>Fill registration details</h2>");
			pw.write("<form action='validatestudent' method='post'>");
			pw.write("<input type='number' name='rollno' id='roll1'>rollno");
			pw.write("<input type='number' name='phone' id='phnno'>phone");
			pw.write("<input type='number' name='age' id='age1'>Age");
			pw.write("<input type='text' name='city' id='cty1'>city");
			pw.write("<input type='text' name='psswrd' id='psswrd1'>password");
			pw.write("<input type='submit' name='sbmnt' value='submit'>");	
	}
		catch (Exception ex) {
			ex.printStackTrace();
		}

}
}
