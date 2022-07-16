package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDAO;
import donation.model.*;

@WebServlet("/UpdateDonationController")
public class UpdateDonationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonationDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDonationController() {
        super();
        dao = new DonationDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int donationNo = Integer.parseInt(request.getParameter("donationNo"));
    	request.setAttribute("d", DonationDAO.getDonationById(donationNo));
    	RequestDispatcher view = request.getRequestDispatcher("updateDonation.jsp");
    	view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	Donation d = new Donation();
    	d.setDonationNo(Integer.parseInt(request.getParameter("donationNo")));
    	d.setDonationType(request.getParameter("donationType"));
    	d.setDonationDate(request.getParameter("donationDate"));
    	d.setDonationTotal(Double.parseDouble(request.getParameter("donationTotal")));
    	
    	dao.updateDonation(d);
    	
    	request.setAttribute("donations", DonationDAO.getAllDonations());
    	RequestDispatcher view = request.getRequestDispatcher("listDonation.jsp");
    	view.forward(request, response);
    }
    	
}
