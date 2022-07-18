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
    	int donationno = Integer.parseInt(request.getParameter("donationno"));
    	request.setAttribute("d", DonationDAO.getDonationById(donationno));
    	RequestDispatcher view = request.getRequestDispatcher("updateDonation.jsp");
    	view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	Donation d = new Donation();
    	d.setDonationno(Integer.parseInt(request.getParameter("donationno")));
    	d.setDonationtype(request.getParameter("donationtype"));
    	d.setDonationdate(request.getParameter("donationdate"));
    	d.setDonationtotal(Double.parseDouble(request.getParameter("donationtotal")));
    	
    	dao.updateDonation(d);
    	
    	request.setAttribute("donations", DonationDAO.getAllDonations());
    	RequestDispatcher view = request.getRequestDispatcher("listDonation.jsp");
    	view.forward(request, response);
    }
    	
}
