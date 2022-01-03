package inventory.dao;

import java.util.List;





import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import inventory.connection.ConnectionManager;
import inventory.model.SupplierBean;

public class SupplierDAO {
	
	static Connection currentcon = null;
	static ResultSet rs =null;
	static PreparedStatement ps= null;
	static Statement stmt=null;
	static String id,name,pwsd,email,ads,tel;
	
	public SupplierBean getSupplier(SupplierBean supplierBean) {
		id=supplierBean.getSupplierID();
		
		String searchQuery="select * from Supplier where SUPPLIERID =" + id + "";
		
		try {
			currentcon=ConnectionManager.getConnection(); //cari connection db ko
			stmt =currentcon.createStatement();
			rs =stmt.executeQuery(searchQuery);
			boolean more =rs.next();
			
			System.out.println(searchQuery);
			
			if(more) {
				supplierBean.setValid(true);
			}
			else if(!more) {
				supplierBean.setValid(true);
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
	
	return supplierBean;
	}
    public void add(SupplierBean supplierBean) {
    	
    	id=supplierBean.getSupplierID();
    	name=supplierBean.getSupplierUsername();
    	pwsd=supplierBean.getSupplierPassword();
    	email=supplierBean.getSupplierEmail();
    	ads=supplierBean.getSupplierAddress();
    	tel=supplierBean.getSupplierTelnum();
    	
    	try {
    		currentcon=ConnectionManager.getConnection();//db connection ko
    		ps=currentcon.prepareStatement("insert into supplier (supplierid,supplierUsername,supplierpassword,supplieremail,supplieraddress,suppliertelnum)values(?,?,?,?,?,?)");
    		ps.setString(1, id);
    		ps.setString(2, name);
    		ps.setString(3, pwsd);
    		ps.setString(4, email);
    		ps.setString(5, ads);
    		ps.setString(6, tel);
    		ps.executeUpdate();
    		
    		System.out.println("Id is" + id);
    		System.out.println("Username is" + name);
    		System.out.println("Password is" + pwsd);
    		System.out.println("Email is" + email);
    		System.out.println("Address is" + ads);
    		System.out.println("tel num is" + tel);
    		
    		
    	}
    	catch(Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
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

	
    public List<SupplierBean> getAllSupplier() {
		List<SupplierBean> supplierBeans = new ArrayList<SupplierBean>();
		  
		  try {
		  	currentcon = ConnectionManager.getConnection();
		  	stmt = currentcon.createStatement();
		  
		  	  String q = "select * from supplier";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          SupplierBean supplier1 = new SupplierBean();		          
		          
		          supplier1.setSupplierID(rs.getString("supplierid"));
		          supplier1.setSupplierUsername(rs.getString("supplierusername"));
		          supplier1.setSupplierPassword(rs.getString("supplierpassword"));
		          supplier1.setSupplierEmail(rs.getString("supplieremail"));
		          supplier1.setSupplierAddress(rs.getString("supplieraddress"));
		          supplier1.setSupplierTelnum(rs.getString("suppliertelnum"));
		          supplierBeans.add(supplier1);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return supplierBeans;
	}
    public void deleteSupplier(String id) {
    	String searchquery ="delete from supplier where supplierid="+"'"+ id +"'";
    	
    	System.out.println(searchquery);
    	try {
    		currentcon=ConnectionManager.getConnection();
    		stmt=currentcon.createStatement();
    		stmt.executeUpdate(searchquery);
    	} catch(SQLException e){
    		e.printStackTrace();
    		
    	}
    	
    }
    
    public void updateSupplier(SupplierBean supplierBean) {
		
    	id=supplierBean.getSupplierID();
    	name=supplierBean.getSupplierUsername();
    	pwsd=supplierBean.getSupplierPassword();
    	email=supplierBean.getSupplierEmail();
    	ads=supplierBean.getSupplierAddress();
    	tel=supplierBean.getSupplierTelnum();
		
	    String searchQuery = "UPDATE supplier SET supplierusername='" + name  + "' , supplierpassword='" + pwsd + "' , supplieremail='" + email + "' , supplieradress='" + ads + "' , suppliertelnum='" + tel + "' WHERE supplierid= '" + id + "'";
		
		try {
	
			currentcon = ConnectionManager.getConnection();
	        stmt = currentcon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    }
    
	public SupplierBean getSupplierById(String id) {
		SupplierBean supplier1 =new SupplierBean();
		try {
			
			
			currentcon=ConnectionManager.getConnection();
			System.out.println("1111");
			ps=currentcon.prepareStatement("select * from supplier where supplierid=?");
			System.out.println("2222");
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        System.out.println("3333");
	        

			while(rs.next()) {
				
		        System.out.println(rs.getString("supplierID"));
		        System.out.println(rs.getString("supplierusername"));
		        System.out.println(rs.getString("supplierpassword"));
		        System.out.println(rs.getString("supplieremail"));
		        System.out.println(rs.getString("supplieraddress"));
		        System.out.println(rs.getString("suppliertelnum"));
				
				supplier1.setSupplierID(rs.getString("supplierID"));
				supplier1.setSupplierUsername(rs.getString("supplierusername"));
				supplier1.setSupplierPassword(rs.getString("supplierpassword"));
				supplier1.setSupplierEmail(rs.getString("supplieremail"));
				supplier1.setSupplierAddress(rs.getString("supplieraddress"));
				supplier1.setSupplierTelnum(rs.getString("suppliertelnum"));
	        }
			
		}
		catch (SQLException e){
			e.printStackTrace();
			
		}
		return supplier1;
	}
	public static SupplierBean login(SupplierBean supplierBean) {
		  
		 
		// preparing some objects for connection
		 System.out.println("JIJIJI");
		 Statement stmt = null;
		 String username = supplierBean.getSupplierUsername();
		 String password = supplierBean.getSupplierPassword();
		 System.out.println("hey "+ username);
		 String searchQuery = "select * from Supplier where supplierusername='" + username + "'  AND supplierpassword='" + password + "'";
		 
		 
		 // "System.out.println" prints in the console; Normally used to trace the  process
		 System.out.println("Your user name is " + username);
		 System.out.println("Your password is " + password);
		 System.out.println("Query: " + searchQuery);
		 
		 
		 	try {
		 		// connect to DB
		 			currentcon = ConnectionManager.getConnection();
		 			stmt = currentcon.createStatement();
		 			rs = stmt.executeQuery(searchQuery);
		 			boolean more = rs.next();
		 
		 // if user does not exist set the isValid variable to false
		 	if (!more) {
		 			System.out.println("Sorry, you are not a registered user! Please sign up first");
		 				supplierBean.setValid(false);
		 }
		 	
		 	
		 // if user exists set the isValid variable to true
		 	else if (more) {
		 		String userName = rs.getString("Supplierusername");
		 		String staffid = rs.getString("Supplierid");
		 		System.out.println("Welcome " + userName);
		 		supplierBean.setSupplierUsername(userName);
		 		supplierBean.setSupplierID(staffid);
		 		supplierBean.setValid(true); }
		 }
		 
		 
		 	catch (Exception ex) {
			 	System.out.println("Log In failed: An Exception has occurred! " + ex);
		 }
		 
		 	
		 // some exception handling
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
		 return supplierBean;
		 }

}
