package inventory.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inventory.connection.ConnectionManager;
import inventory.model.Staff;
import inventory.model.SupplierBean;


public class StaffDAO {
	static Connection currentcon = null;
	static ResultSet rs =null;
	static PreparedStatement ps= null;
	static Statement stmt=null;
	static String id,uname,pwsd,name,tel;
	
	public static Staff getStaff(Staff staff) {
		id=staff.getStaffID();
		String searchQuery="select * from Staff where staffid='" + id + "'";
		
		try {
			currentcon=ConnectionManager.getConnection(); //nanti cari connection db 
			stmt =currentcon.createStatement();
			rs =stmt.executeQuery(searchQuery);
			boolean more1 =rs.next();
			
			System.out.println(searchQuery);
			if(more1) {
			staff.setValid(true);
			}
			else if(more1) {
				staff.setValid(true);
			}
		}
		catch(Exception ex){
			System.out.println("Log IN failed:An Execption has occured! "+ex);
			System.out.println("hye");
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
	
	return staff;
	}
    public void add(Staff staff) {
    	
    	id=staff.getStaffID();
    	uname=staff.getStaffUsername();
    	pwsd=staff.getStaffPassword();
    	name=staff.getStaffName();
    	tel=staff.getStaffTelnum();
    	
    	try {
    		currentcon=ConnectionManager.getConnection();//nanti cari db connection 
    		ps=currentcon.prepareStatement("insert into staff (StaffId,StaffUsername,Staffpassword,Staffname,Stafftelnum)values(?,?,?,?,?)");
    		ps.setString(1, id);
    		ps.setString(2, uname);
    		ps.setString(3, pwsd);
    		ps.setString(4, name);
    		ps.setString(5, tel);
    		ps.executeUpdate();
    		
    		System.out.println("StaffId is" + id);
    		System.out.println("StaffUsername is" + uname);
    		System.out.println("StaffPassword is" + pwsd);
    		System.out.println("StaffName is" + name);
    		System.out.println("StaffTelnum is" + tel);
    		
    		
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
    public static Staff getStaffById(String id) {
		Staff staff = new Staff();
	    try {
	    	currentcon = ConnectionManager.getConnection();
	        ps=currentcon.prepareStatement("select * from staff where staffid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	staff.setStaffID(rs.getString("staffid"));
	        	staff.setStaffUsername(rs.getString("staffUsername"));
	        	staff.setStaffPassword(rs.getString("staffpassword"));
	        	staff.setStaffName(rs.getString("staffemail"));
	        	staff.setStaffTelnum(rs.getString("stafftelnum"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    return staff;
	}
    public List<Staff> getAllStaff() {
		List<Staff> staffs = new ArrayList<Staff>();
		  
		  try {
		  	currentcon = ConnectionManager.getConnection();
		  	stmt = currentcon.createStatement();
		  
		  	  String q = "select * from staff";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Staff staff1 = new Staff();		          
		          
		          staff1.setStaffID(rs.getString("staffid"));
		          staff1.setStaffUsername(rs.getString("staffusername"));
		          staff1.setStaffPassword(rs.getString("staffpassword"));
		          staff1.setStaffName(rs.getString("staffaddress"));
		          staff1.setStaffTelnum(rs.getString("stafftelnum"));
		          staffs.add(staff1);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return staffs;
	}
    public void deleteStaff(String id) {
    	String searchquery ="delete from staff where staffid="+"'"+ id +"'";
    	
    	System.out.println(searchquery);
    	try {
    		currentcon=ConnectionManager.getConnection();
    		stmt=currentcon.createStatement();
    		stmt.executeUpdate(searchquery);
    	} catch(SQLException e){
    		e.printStackTrace();
    		
    	}
    	
    }
    
    public void updateStaff(Staff staff) {
		
    	id=staff.getStaffID();
    	uname=staff.getStaffUsername();
    	pwsd=staff.getStaffPassword();
    	name=staff.getStaffName();
    	tel=staff.getStaffTelnum();
		
	    String searchQuery = "UPDATE staff SET staffusername='" + uname  + "' , staffpassword='" + pwsd +  "' , staffname='" + name + "' , stafftelnum='" + tel + "' WHERE staffid= '" + id + "'";
		
		try {
	
			currentcon = ConnectionManager.getConnection();
	        stmt = currentcon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    }
	public static Staff getStaffByUsername(String staffUsername) {
		Staff staff1 =new Staff();
		try {
			currentcon=ConnectionManager.getConnection();
			ps=currentcon.prepareStatement("select * from staff where staffusername=?");
			
			ps.setString(1, staffUsername);
			if(rs.next()) {
				staff1.setStaffID(rs.getString("staffid"));
				staff1.setStaffUsername(rs.getString("stafusername"));
	        	staff1.setStaffPassword(rs.getString("staffpassword"));
	        	staff1.setStaffName(rs.getString("staffemail"));
	        	staff1.setStaffTelnum(rs.getString("stafftelnum"));
	        }
			
		}
		catch (SQLException e){
			e.printStackTrace();
			
		}
		return staff1;
	}
	 public static Staff login(Staff staff) {
		  
		 
			// preparing some objects for connection
			 System.out.println("JIJIJI");
			 Statement stmt = null;
			 String username = staff.getStaffUsername();
			 String password = staff.getStaffPassword();
			 String searchQuery = "select * from Staff where staffusername='" + username + "'  AND staffpassword='" + password + "'";
			 
			 
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
			 				staff.setValid(false);
			 }
			 	
			 	
			 // if user exists set the isValid variable to true
			 	else if (more) {
			 		String userName = rs.getString("Staffusername");
			 		String staffid = rs.getString("Staffid"); System.out.println("Welcome " + userName);
			 		staff.setStaffUsername(userName);
			 		staff.setStaffID(staffid);
			 		staff.setValid(true); }
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
			 return staff;
			 }
  

}
