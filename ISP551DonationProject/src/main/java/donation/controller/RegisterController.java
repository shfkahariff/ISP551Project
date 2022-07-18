package donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.UserDAO;
import donation.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO udao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        udao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		//retrieve input and set
		user.setUsername(request.getParameter("username"));		
		user.setUserFullName(request.getParameter("userfullname"));
		user.setUserContactNo(request.getParameter("usercontactno"));
		user.setUserEmail(request.getParameter("useremail"));
		user.setUserPassword(request.getParameter("userpassword"));

		user = UserDAO.getUser(user);
		//check if user exists
		if(!user.isValid()){
        	try {
        		//if user not exist, add/register the user
				udao.add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//redirect to login page
        	response.sendRedirect("beneficiarylogin.html");
        }         
	}	
}
