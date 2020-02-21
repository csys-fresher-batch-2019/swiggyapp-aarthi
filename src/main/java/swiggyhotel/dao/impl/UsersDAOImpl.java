package swiggyhotel.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.UserDetails;

public class UsersDAOImpl implements UsersDAO{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	public List<UserDetails> displayUserDetails() throws DbException {
		List<UserDetails> l=new ArrayList<UserDetails>();
		String sql="select * from users";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
		
		try(ResultSet ro=pst.executeQuery()){
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro.next())
		{   
			//FoodDetails ob=new FoodDetails();
			UserDetails ob=new UserDetails();
			ob.userId=ro.getInt("user_id");
			ob.userName=ro.getString("user_name");
			ob.phoneNo=ro.getLong("phone_No");
			ob.address=ro.getString("address");
		    ob.city=ro.getString("city");
			l.add(ob);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(l);
	}

	public HashMap<String, Integer> getNameAndtotalAmts(int orderId) throws DbException {
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		String sqlQuery="select user_name,total_amt from users u,orders o where u.user_id=o.user_id and order_id=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)){
			pst.setInt(1,orderId);
		try(ResultSet rs=pst.executeQuery()){
	    
		
		if(rs.next()) {
			String username = rs.getString("user_name");
			int totalAmount = rs.getInt("total_amt");
			map.put(username, totalAmount);
		}
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	/*public List<String> getNames(String city) throws DbException {
		List<String> l1=new ArrayList<String>();
		String sql="select user_name from users where city=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1,city);
		try(ResultSet rs=pst.executeQuery()){
		
		while(rs.next())
		{
			//UserDetails ob1=new UserDetails();
		    String userName=rs.getString("user_name");
		    l1.add(userName);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(l1);
		
	}*/

	public String login(String name,Long phoneno) throws DbException {
		String message=" ";
		String sql="select user_name,phone_no from users where user_name=? and phone_no=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1,name);
			pst.setLong(2,phoneno);
			try(ResultSet rs=pst.executeQuery()){
			
		
		//boolean a=true;
		
		
		if(rs.next())
		{
			message="Welcome "+name;
		}
		else
		{
			message="Login Failure";
		}
		//return message;
	    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
		
	}

	public void insertUserInfo(UserDetails ob) throws DbException {
		
		String sql="insert into users(user_id,user_name,phone_no,address,city) values(user_id_seq.nextval,?,?,?,?)";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
		//pst.setInt(1,ob.userId);
		pst.setString(1,ob.userName);
		pst.setLong(2,ob.phoneNo);
		pst.setString(3,ob.address);
		pst.setString(4,ob.city);
		int row=pst.executeUpdate();
		logger.info(row+"row inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


	@Override
	public int getUserId(String name, Long phoneno) throws  DbException {
		String sql="select user_id from users where user_name=? and phone_no=?";
		int userId=0;
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1,name);
			pst.setLong(2,phoneno);
			try(ResultSet rs=pst.executeQuery()){
		      if(rs.next())
		      {
		    	  userId=rs.getInt("user_id");
		      }
			}
			}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public String adminLogin(String userName, String passWord) throws DbException {
		String msg=" ";
		if(userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin"))	
		{
			msg="Welcome";
		}
		else
		{
			msg="Login Failure";
		}
		
		return msg;
		
	}

	@Override
	public int getOrderId(int userId) throws DbException {
		
		String sql1="select order_id from orders where user_id=?";
		int orderId=0;
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
			pst.setInt(1,userId);
			try(ResultSet rs=pst.executeQuery()){
		      if(rs.next())
		      {
		    	  orderId=rs.getInt("order_id");
		      }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderId;
	}
	}
	

	
	



	


