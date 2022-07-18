package donation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.BeneficiaryDAO;
import donation.dao.UserDAO;
import donation.model.Beneficiary;


/**
 * Servlet implementation class BeneficiaryController
 */
@WebServlet("/BeneficiaryController")
public class BeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BeneficiaryDAO bdao;  
	private static UserDAO udao;
	private String beneficiaryic;
	private String forward;
	private static String LIST = "staff/listBeneficiary.jsp";
	private static String VIEW = "staff/viewBeneficiary.jsp";	
	private static String UPDATE = "beneficiary/updateBeneficiary.jsp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeneficiaryController() {
        super();
        bdao = new BeneficiaryDAO();
        udao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		
		if(action.equalsIgnoreCase("listBeneficiary")) {
			forward = LIST;
	        request.setAttribute("users", UserDAO.getUserBeneficiary());        
		}		
		if(action.equalsIgnoreCase("viewBeneficiary")) {    
			forward = VIEW;
			beneficiaryic = request.getParameter("beneficiaryic");
			request.setAttribute("ben", BeneficiaryDAO.getBeneficiaryById(beneficiaryic));
		}		
		if(action.equalsIgnoreCase("updateBeneficiary")) { 
			forward = UPDATE;
			beneficiaryic = request.getParameter("beneficiaryic");
	        request.setAttribute("ben", BeneficiaryDAO.getBeneficiaryById(beneficiaryic));	        
		}
		if(action.equalsIgnoreCase("deleteBeneficiary")) {
			forward = LIST;
	        String userid = request.getParameter("userid");
		    udao.deleteUser(userid);		    
		    request.setAttribute("users", UserDAO.getUserBeneficiary());        
		}

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Beneficiary ben = new Beneficiary();
		ben.setAddress(request.getParameter("address"));
		ben.setCategory(request.getParameter("category"));
		ben.setOccupation(request.getParameter("occupation"));
		ben.setMonthlyIncome(Double.parseDouble(request.getParameter("monthlyincome")));
		ben.setBankAccNo(request.getParameter("bankaccno"));
		ben.setBankType(request.getParameter("banktype"));
		ben.setNoOfDependents(Integer.parseInt(request.getParameter("noofdependents")));				
		ben.setDonationForm(request.getParameter("donationform"));
		ben.setStatus(request.getParameter("status"));
		
		String beneficiaryic = request.getParameter("beneficiaryic");
		ben.setBeneficiaryIC(beneficiaryic);
		bdao.updateBeneficiary(ben);
			   
	    request.setAttribute("users", UserDAO.getUserBeneficiary());
	    RequestDispatcher view = request.getRequestDispatcher("staff/listBeneficiary.jsp");
        view.forward(request, response);	}

}
