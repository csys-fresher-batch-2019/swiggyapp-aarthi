package swiggyhotel.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.UserDetails;

public class UsersDAOImpl implements UsersDAO{

	public List<UserDetails> displayUserDetails() throws Exception {
		List<UserDetails> l=new ArrayList<UserDetails>();
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql="select * from users";
		ResultSet ro=stmt.executeQuery(sql);
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
		
		return(l);
	}

	public HashMap<String, Integer> getNameAndtotalAmts(int orderId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		String sqlQuery="select user_name,total_amt from users u,orders o where u.user_id=o.user_id and order_id=?";
		PreparedStatement pst=con.prepareStatement(sqlQuery);
		pst.setInt(1,orderId);
		ResultSet rs=pst.executeQuery();
		
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		if(rs.next()) {
			String username = rs.getString("user_name");
			int totalAmount = rs.getInt("total_amt");
			map.put(username, totalAmount);
		}
		return map;
	}

	public List<String> getNames(String city) throws Exception {
		List<String> l1=new ArrayList<String>();
		Connection con=ConnectionUtil.getConnection();
		String sql="select user_name from users where city=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,city);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			//UserDetails ob1=new UserDetails();
		    String userName=rs.getString("user_name");
		    l1.add(userName);
		}
		
		return(l1);
		
	}

	public String login(String name,Long phoneno) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		String sql="select user_name,phone_no from users where user_name=? and phone_no=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,name);
		pst.setLong(2,phoneno);
		//boolean a=true;
		ResultSet rs=pst.executeQuery();
		//boolean a=true;
		String message=" ";
		if(rs.next())
		{
			message="Welcome "+name;
		}
		else
		{
			message="Login Failure";
		}
		/*String message=" ";
		if(a)	
		{
			message="Welcome "+name;
		}
		else
		{
			message="Login Failure";
		}*/
		return message;
		
	}

	public void insertUserInfo(UserDetails ob) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		String sql="insert into users(user_id,user_name,phone_no,address,city) values(user_id_seq.nextval,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		//pst.setInt(1,ob.userId);
		pst.setString(1,ob.userName);
		pst.setLong(2,ob.phoneNo);
		pst.setString(3,ob.address);
		pst.setString(4,ob.city);
		int row=pst.executeUpdate();
		System.out.println(row+"row inserted");
		
		
	}

	
	


}
	


