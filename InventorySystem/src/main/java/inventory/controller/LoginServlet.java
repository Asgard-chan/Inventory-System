package inventory.controller;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.model.UserBean;
import user.dao.UserDAO;
import inventory.dao.StaffDAO;
import inventory.dao.SupplierDAO;
import inventory.model.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDAO daostaff;
    private SupplierDAO daosupplier;
    String forward="";
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, java.io.IOException {
try {
	Staff staff =new Staff(null,null,null,null,null);
	SupplierBean supplierBean=new SupplierBean(null,null,null,null,null,null);
staff.setStaffUsername(request.getParameter("staffusername"));
staff.setStaffPassword(request.getParameter("staffpassword"));
supplierBean.setSupplierUsername(request.getParameter("supplierusername"));
supplierBean.setSupplierPassword(request.getParameter("supplierpassword"));
staff=StaffDAO.login(staff);
supplierBean=SupplierDAO.login(supplierBean);
if(staff.isValid()) {
	HttpSession session = request.getSession(true);
	System.out.println("yes");
	session.setAttribute("sessionUsername", staff.getStaffUsername());
	session.setAttribute("sessionRole", staff.getRole());
	System.out.println(staff.getRole());
	System.out.println("sessionUsername");
	//response.sendRedricect("dashboard.jsp) // logged-in page
	if(staff.getRole().equals("staff")) {
		request.setAttribute("user", staff.getStaffUsername());
		RequestDispatcher view = request.getRequestDispatcher("Dashboard.jsp");
		view.forward(request, response);
	}
	else {
		response.sendRedirect("login.jsp");	
	}
}
if(supplierBean.isValid()) {
	HttpSession session = request.getSession(true);
	session.setAttribute("sessionUsername", supplierBean.getSupplierUsername());
	session.setAttribute("sessionRole", supplierBean.getRole());
	System.out.println(supplierBean.getRole());
	if(supplierBean.getRole().equals("supplier")) {
		request.setAttribute("user", supplierBean.getSupplierID());
		RequestDispatcher view = request.getRequestDispatcher("supplierdashboard.jsp");
		view.forward(request, response);
	}
	else {
		response.sendRedirect("login.jsp");
	}
}
}
catch (Throwable theException) {
System.out.println(theException);
}
}

}
