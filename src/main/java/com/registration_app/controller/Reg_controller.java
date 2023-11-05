package com.registration_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registration_app.model.DAOService;
import com.registration_app.model.DAOServiceImpl;


@WebServlet("/newreg")
public class Reg_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Reg_controller() {
        super();
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create_reg.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if (session.getAttribute("email")!=null) {
			
			String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB(); 
		
		service.createRegistration(name,email,city,mobile);
		
		request.setAttribute("msg", "record is saved!!");
		
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create_reg.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	} catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
