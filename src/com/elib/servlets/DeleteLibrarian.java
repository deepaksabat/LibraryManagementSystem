package com.elib.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.dao.LibrarianDao;

/**
 * Servlet implementation class DeleteLibrarian
 */
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		LibrarianDao.delete(id);
		response.sendRedirect("ViewLibrarian");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
