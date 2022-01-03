package user.dao;

import java.sql.*;

import inventory.connection.ConnectionManager;
import user.model.UserBean;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String firstname,lastname,username,password;


	public static UserBean getUser(UserBean user) {
		username = user.getUsername();

	    String searchQuery = "select * from myuser where username='" + username + "'";

	    try {
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        rs = stmt.executeQuery(searchQuery);
	        boolean more = rs.next();
	        
	        System.out.println(searchQuery);

	        // if subject exists set the isValid variable to true
	        if (more) {          
	            user.setValid(true);
	       	}
	       
	        else if (!more) {
	        	
	        	user.setValid(false);
	        }
	       
	    }

	    catch (Exception ex) {
	        System.out.println("Log In failed: An Exception has occurred! " + ex);
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

	        if (currentCon != null) {
	            try {
	                currentCon.close();
	            } catch (Exception e) {
	            }

	            currentCon = null;
	        }
	    }

	    return user;
	}
	 
	 
	 public void add(UserBean user) {
			
		    firstname = user.getFirstName();
		    lastname = user.getLastName();
		    username = user.getUsername();
		    password = user.getPassword();
		   
			try {
				currentCon = ConnectionManager.getConnection();
				ps=currentCon.prepareStatement("insert into myuser (firstname, lastname, username,password)values(?,?,?,?)");
				ps.setString(1,firstname);
				ps.setString(2,lastname);
				ps.setString(3,username);
				ps.setString(4,password);
				ps.executeUpdate();
			
				System.out.println("Your firstname is " + firstname);
				System.out.println("Your lastname is " + lastname);
				System.out.println("Your username is " + username);
				System.out.println("Your password is " + password);
		        
			}

			catch (Exception ex) {
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
				
				if (currentCon != null) {
					try {
						currentCon.close();
					} catch (Exception e) {
					}
					currentCon = null;
				}
			}
			
			
	}

	 
	 
	 public static UserBean login(UserBean bean) {
	  
	 
	// preparing some objects for connection
	 System.out.println("JIJIJI");
	 Statement stmt = null;
	 String username = bean.getUsername();
	 String password = bean.getPassword();
	 String searchQuery = "select * from MYUSER where username='" + username + "'  AND password='" + password + "'";
	 
	 
	 // "System.out.println" prints in the console; Normally used to trace the  process
	 System.out.println("Your user name is " + username);
	 System.out.println("Your password is " + password);
	 System.out.println("Query: " + searchQuery);
	 
	 
	 	try {
	 		// connect to DB
	 			currentCon = ConnectionManager.getConnection();
	 			stmt = currentCon.createStatement();
	 			rs = stmt.executeQuery(searchQuery);
	 			boolean more = rs.next();
	 
	 // if user does not exist set the isValid variable to false
	 	if (!more) {
	 			System.out.println("Sorry, you are not a registered user! Please sign up first");
	 				bean.setValid(false);
	 }
	 	
	 	
	 // if user exists set the isValid variable to true
	 	else if (more) {
	 		String firstName = rs.getString("FirstName");
	 		String lastName = rs.getString("LastName"); System.out.println("Welcome " + firstName);
	 		bean.setFirstName(firstName);
	 		bean.setLastName(lastName);
	 		bean.setValid(true); }
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
	 		if (currentCon != null) {
	 			try {
	 				currentCon.close();
	 			} catch (Exception e) {
	 			}
	 			currentCon = null;
	 		}
	 	}
	 return bean;
	 }



}
