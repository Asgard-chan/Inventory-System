package inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import inventory.connection.ConnectionManager;
import inventory.model.Product;


public class ProductDAO {
	static Connection currentcon = null;
	static ResultSet rs =null;
	
	static PreparedStatement ps= null;
	static PreparedStatement ps2= null;
	static Statement stmt=null;
	static String productid,productname,producttype,productprice,productquantity,productreorderlevel,productexpirydate;
	
	public Product getProduct(Product product) {
		productid = product.getProductId();
		
		String searchQuery="select * from product where productid='" + productid + "'";
		
		try {
			currentcon=ConnectionManager.getConnection(); //cari connection db ko
			stmt =currentcon.createStatement();
			rs =stmt.executeQuery(searchQuery);
			boolean more =rs.next();
			
			System.out.println(searchQuery);
			
			if(more) {
				product.setValid(true);
			}
			else if(!more) {
				product.setValid(false);
			}
			
			
		}
		catch(Exception ex){
			System.out.println("Log IN failed:An Execption has occured! "+ex);
		}
		finally {
			if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentcon != null) {
                try {
                    currentcon.close();
                } catch (Exception e) {
                }

                currentcon = null;
            }
		}
	
	return product;
	}
    public void add(Product product) {
    	
    	productid=product.getProductId();
    	productname=product.getProductName();
    	producttype=product.getProductType();
    	productprice=product.getProductPrice();
    	
    	productquantity=product.getProductsQuantity();
    	productreorderlevel=product.getReorderLevel();
    	productexpirydate=product.getExpiryDate();
    	try {
    		currentcon=ConnectionManager.getConnection();//db connection ko
    		ps=currentcon.prepareStatement("INSERT All\r\n"
    				+ "INTO Product (Productid,producttype,productname, productprice, productquantity, reorderlevel)\r\n"
    				+ "VALUES (seq_productid.nextval,?,?,?,?,?)\r\n"
    				+ "INTO expiryproduct (expproductid,productid,expirydate)\r\n"
    				+ "VALUES (seq_expiryproductid.nextval,seq_productid.currval,?)\r\n"
    				+ "Select * \r\n"
    				+ "from dual");
    		
    	
    		ps.setString(1, producttype);
    		ps.setString(2, productname);
    		ps.setString(3, productprice);
    		
    		ps.setString(4, productquantity);
    		ps.setString(5, productreorderlevel);
    		ps.setString(6, productexpirydate);
    		ps.executeUpdate();
    		
    		System.out.println("ProductId is" + productid);
    		System.out.println("ProductName is" + productname);
    		System.out.println("ProductType is" + producttype);
    		System.out.println("ProductPrice is" + productprice);
    	
    		System.out.println("ProductQuantity is" + productquantity);
    		System.out.println("ReorderLevel is" + productreorderlevel);
    		System.out.println("ExpiryDate is" + productexpirydate);
    		
    		
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentcon != null) {
    			try {
    				currentcon.close();
    			} catch (Exception e) {
    			}
    			currentcon = null;
    		}
    	}
    }
    
    public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();
		  
		  try {
		  	currentcon = ConnectionManager.getConnection();
		  	stmt = currentcon.createStatement();
		  
		  	  String q = "select productid, producttype, productname, productprice, productquantity, reorderlevel, expirydate \r\n"
		  	  		+ "from product \r\n"
		  	  		+ "join expiryproduct using (productid)";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		    	  Product product = new Product();
		          
		          
		    	  product.setProductId(rs.getString("productid"));
		    	  product.setProductName(rs.getString("productname"));
		    	  product.setProductType(rs.getString("producttype"));
		    	  product.setProductPrice(rs.getString("productprice"));
		    	  product.setProductsQuantity(rs.getString("productquantity"));
		    	  product.setReorderLevel(rs.getString("reorderlevel"));
		    	  product.setExpiryDate(rs.getString("expirydate"));
		    	  products.add(product);
		      }
		      
		      
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return products;
	}
    
    public void deleteProduct(String id) {
		String searchQuery = "delete from product where productid =" + "'" + id + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentcon = ConnectionManager.getConnection();
	        stmt = currentcon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
    
    public Product getProductById(String id) {
		Product product = new Product();
	    try {
	    	currentcon = ConnectionManager.getConnection();
	        ps=currentcon.prepareStatement("Select productid, productname, producttype,  productprice, productquantity, reorderlevel, expirydate\r\n"
	        		+ "from product\r\n"
	        		+ "join expiryproduct using (productid)\r\n"
	        		+ "where productid = ?");
	     
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	       
	       
	        

	        if (rs.next()) {
	        	product.setProductId(rs.getString("productid"));
	        	product.setProductName(rs.getString("productname"));
	        	product.setProductType(rs.getString("producttype"));
	        	product.setProductPrice(rs.getString("productprice"));
	        
	        	product.setProductsQuantity(rs.getString("productquantity"));
	        	product.setReorderLevel(rs.getString("reorderlevel"));
	        	product.setExpiryDate(rs.getString("expirydate"));
	        	
	        }
	        
	 
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    
	    
	    return product;
	}
	
public void updateProduct(Product product) {
		
		productid= product.getProductId();
		productname= product.getProductName();
		producttype = product.getProductType();
		productprice = product.getProductPrice();
		productquantity = product.getProductsQuantity();
		productreorderlevel = product.getReorderLevel();
		

	    String searchQuery = "UPDATE product \r\n"
	    					+ "SET producttype='" + producttype  + "' , productname='" + productname  + "' , productprice='" + productprice  + "' , productquantity='" + productquantity  + "', reorderlevel='" + productreorderlevel  + "' \r\n"
	    					+ "WHERE productid= '" + productid  + "'";
		
		try {
	
	        currentcon = ConnectionManager.getConnection();
	        stmt = currentcon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) { 
	        e.printStackTrace();
	    }
		
	}


}
