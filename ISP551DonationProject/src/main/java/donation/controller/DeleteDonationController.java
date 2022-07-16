package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import donation.dao.*;

@WebServlet("/DeleteDonationController")
public class DeleteDonationController extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private DonationDAO dao;
	
	public DeleteDonationController() {
		super();
		dao = new DonationDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int donationNo = Integer.parseInt(request.getParameter("donationno"));
		dao.deleteDonation(donationNo);
		request.setAttribute("donations", DonationDAO.getAllDonations());
		RequestDispatcher view = request.getRequestDispatcher("listDonation.jsp");
		view.forward(request, response);
	}
}