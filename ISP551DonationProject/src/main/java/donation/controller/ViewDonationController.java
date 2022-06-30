package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDAO;

@WebServlet("/ViewDonationController")
public class ViewDonationController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DonationDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDonationController() {
        super();
        dao = new DonationDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int donationNo = Integer.parseInt(request.getParameter("donationNo"));
		request.setAttribute("d", DonationDAO.getDonationById(donationNo));
		RequestDispatcher view = request.getRequestDispatcher("viewDonation.jsp");
		view.forward(request, response);
	}

}