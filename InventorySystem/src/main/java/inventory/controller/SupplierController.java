package inventory.controller;

import java.io.IOException;


import inventory.dao.SupplierDAO;
import inventory.model.SupplierBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupplierController
 */
@javax.servlet.annotation.WebServlet("/SupplierController")
public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPDATE_SUPPLIER = "updateSupplier.jsp";
	private static String VIEW_SUPPLIER = "viewSupplier.jsp";
	private static String LIST_SUPPLIER="manageSupplier.jsp";
	private SupplierDAO daoSupplier;
	
	
String forward="";
    /**
     * Default constructor. 
     */
    public SupplierController() {
        super();
       daoSupplier=new SupplierDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");


		if (action.equalsIgnoreCase("listsupp")) {
			
			forward = LIST_SUPPLIER;
			request.setAttribute("suppliers", daoSupplier.getAllSupplier());
		}
		else if (action.equalsIgnoreCase("deleteSupplier")) {
			
			String id= request.getParameter("SupplierID");
		
			daoSupplier.deleteSupplier(id);
		
			forward = LIST_SUPPLIER;
				request.setAttribute("supplier", daoSupplier.getAllSupplier());


		} else if (action.equalsIgnoreCase("updateSupplier")) {	
	    	
			String id= request.getParameter("SupplierID");
	    	
	    	SupplierBean supplierBean = new SupplierBean();
	    	supplierBean = daoSupplier.getSupplierById(id);
	    	        	
	    	forward = UPDATE_SUPPLIER;
	        request.setAttribute("supplier", supplierBean); 

	    } else if (action.equalsIgnoreCase("viewSupp")) {
	    	
	    	String id= request.getParameter("SupplierID");
	    	
	    	SupplierBean supplierBean = new SupplierBean();
	    	supplierBean = daoSupplier.getSupplierById(id);        	
	   
	    	forward = VIEW_SUPPLIER;       		
	        request.setAttribute("supplier", supplierBean);        	
	    }
		
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SupplierID = request.getParameter("SupplierID");
		String SupplierUserName = request.getParameter("SupplierUserName");
		String SupplierPassword = request.getParameter("SupplierPassword");
		String SupplierEmail = request.getParameter("SupplierEmail");
		String SupplierAddress= request.getParameter("SupplierAddress");
		String SupplierTelNum=request.getParameter("SupplierTelnum");
		SupplierBean supplierBean =new SupplierBean(SupplierID,SupplierUserName,SupplierPassword,SupplierEmail,SupplierAddress,SupplierTelNum);
		 supplierBean =daoSupplier.getSupplier(supplierBean);
		 System.out.println("adding" + SupplierID);
		 if(!supplierBean.isValid()) {
			 System.out.println("adding");
			 daoSupplier.add(supplierBean);
			 System.out.println("Done");
			 response.sendRedirect("manageSupplier.jsp");
		 }
		 else {
			 System.out.println(" already exist");
			 response.sendRedirect("creatSupplier.jsp");
		 }		
		
	}

}
