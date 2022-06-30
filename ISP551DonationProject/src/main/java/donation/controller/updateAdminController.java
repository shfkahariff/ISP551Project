package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.userDAO;
import user.model.Admin;

/**
 * Servlet implementation class updateAdminController
 */
@WebServlet("/updateAdminController")
public class updateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAdminController() {
        super();
        dao = new userDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("a", userDAO.getAdminsById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateAdmin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin a = new Admin();
		a.setId(Integer.parseInt(request.getParameter("id")));
		a.setUsername(request.getParameter("username"));
		a.setFullname(request.getParameter("fullname"));
		a.setContactno(request.getParameter("contactno"));
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		a.setRole(request.getParameter("role"));
		
		dao.updateAdmin(a);
		
		request.setAttribute("admins", userDAO.getAllAdmin());
		RequestDispatcher view = request.getRequestDispatcher("listAdmin.jsp");
		view.forward(request, response);
	}

}
