package inventory.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.dao.StaffDAO;
import inventory.model.Staff;
import inventory.model.SupplierBean;
/**
 * Servlet implementation class StaffController
 */
@javax.servlet.annotation.WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREATE_STAFF="createStaff.jsp";
	private static String VIEW_STAFF="viewStaff.jsp";
	private static String lIST_STAFF="manageStaff.jsp";
	private static String UPDATE_STAFF="updateStaff.jsp";
	private StaffDAO daoStaff;
	
	String forward="";

    /**
     * Default constructor. 
     */
    public StaffController() {
        super();
        daoStaff= new StaffDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");


		if (action.equalsIgnoreCase("liststaff")) {
			
			forward = lIST_STAFF;
			request.setAttribute("staffs", daoStaff.getAllStaff());
		}
		else if (action.equalsIgnoreCase("deleteStaff")) {
			
			String id= request.getParameter("StaffID");
		
			daoStaff.deleteStaff(id);
		
			forward = lIST_STAFF;
				request.setAttribute("staff", daoStaff.getAllStaff());


		} else if (action.equalsIgnoreCase("updateStaff")) {	
	    	
			String id= request.getParameter("StaffID");
	    	
	    	Staff staff = new Staff();
	    	staff = daoStaff.getStaffById(id);
	    	        	
	    	forward = UPDATE_STAFF;
	        request.setAttribute("staff", staff); 

	    } else if (action.equalsIgnoreCase("viewStaff")) {
	    	
	    	String id= request.getParameter("StaffID");
	    	
	    	Staff staff = new Staff();
	    	staff = daoStaff.getStaffById(id);        	
	   
	    	forward = VIEW_STAFF;       		
	        request.setAttribute("staff", staff);        	
	    }
		
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffid=request.getParameter("StaffID");
		String staffusername=request.getParameter("StaffUserName");
		String password=request.getParameter("StaffPassword");
		String name=request.getParameter("StaffName");
		String telnum=request.getParameter("StaffTelnum");
		Staff staff=new Staff(staffid,staffusername,password,name,telnum);
		staff=daoStaff.getStaff(staff);
		if(!staff.isValid()) {
			 System.out.println("adding");
			 daoStaff.add(staff);
			 System.out.println("Done");
		 }
		
		response.sendRedirect("createStaff.jsp");
	}

}
