package com.registration_app.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration_app.model.DAOService;
import com.registration_app.model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		service.DeleteReg(email);
		
		ResultSet result  = service.readreg();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/search_result.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
