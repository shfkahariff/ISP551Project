package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.userDAO;

/**
 * Servlet implementation class listUserController
 */
@WebServlet("/listAdminController")
public class listAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public listAdminController() {
        super();
        new userDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admins", userDAO.getAllAdmin());
		RequestDispatcher view = request.getRequestDispatcher("listAdmin.jsp");
		view.forward(request, response);
	}

	
}
