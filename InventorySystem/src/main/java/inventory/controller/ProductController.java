package inventory.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import inventory.dao.ProductDAO;
import inventory.model.Product;
/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_PRODUCT="manageProduct.jsp";
	private static String VIEW_PRODUCT="viewProduct.jsp";
	private static String UPDATE_PRODUCT = "updateProduct.jsp";
	private ProductDAO daoProduct;
	
	String forward ="";

   
        
   public ProductController() {
        super();
        daoProduct= new ProductDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listProduct")) {
			
			forward = LIST_PRODUCT;
            request.setAttribute("products", daoProduct.getAllProduct());
					
		} else if (action.equalsIgnoreCase("deleteProduct")) {
    	
			String productid= request.getParameter("productid");
    	
			daoProduct.deleteProduct(productid);
    	
			forward = LIST_PRODUCT;
			request.setAttribute("products", daoProduct.getAllProduct()); 
   
		} else if (action.equalsIgnoreCase("updateProduct")) {	
        	
        	String productid= request.getParameter("productid");
        	
        	Product product = new Product();
        	product = daoProduct.getProductById(productid);
        	        	
        	forward = UPDATE_PRODUCT;
            request.setAttribute("product", product); 
	
        } else if (action.equalsIgnoreCase("viewProduct")) {
        	
        	String productid= request.getParameter("productid");
        	
        	Product product = new Product();
        	product = daoProduct.getProductById(productid);  
        	
        
        	
        	forward = VIEW_PRODUCT;       		
            request.setAttribute("product", product);        	
      
        }
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("productid");
		String productName = request.getParameter("productname");
		String productType = request.getParameter("producttype");
		String productPrice = request.getParameter("productprice");
		
		String productQuantity = request.getParameter("productquantity");
		String reorderLevel = request.getParameter("reorderlevel");
		String expiryDate = request.getParameter("expirydate");
		System.out.println("sebelumjalan");
		Product product =new Product(productId,productName,productType,productPrice,productQuantity,reorderLevel,expiryDate);
		System.out.println("sebelumjalan1");
		product=daoProduct.getProduct(product);
		System.out.println("jalan1");
		
		if(product.isValid()){	
			System.out.println("subject already exist");
        	daoProduct.updateProduct(product);
        	System.out.println("jalan2");
        	    	
        	
        	RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT);
        	
			request.setAttribute("products", daoProduct.getAllProduct());
			view.forward(request, response);
			
        }
		
		else{
			System.out.println("inserting product");
        	daoProduct.add(product);       	
        	response.sendRedirect("Dashboard.jsp");
        	System.out.println("jalan3");
        	
            
        }
       
		
	
	}

}
