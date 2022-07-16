package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.model.*;
import donation.dao.DonationDAO;

@WebServlet("/CreateDonationController")
public class CreateDonationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonationDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDonationController() {
        super();
        dao = new DonationDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated constructor stub
    	
    	Donation d = new Donation();
    	d.setDonationtype(request.getParameter("donationtype"));
    	d.setDonationdate(request.getParameter("donationdate"));
    	d.setDonationtotal(Double.parseDouble(request.getParameter("donationtotal")));
    	
    	dao.createDonation(d);
    	
    	request.setAttribute("donations", DonationDAO.getAllDonations());
    	RequestDispatcher view = request.getRequestDispatcher("listDonation.jsp");
    	view.forward(request, response);
    }
}
