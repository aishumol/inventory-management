/**
 * class which does all the Order operations, purchase , respective persons order,cancel/delete the order.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;


import service.OrderInterface;
import utility.ConnectionManager;

public class OrderDAO implements OrderInterface{
	static int status;
	static String sql;
	static ConnectionManager cm = new ConnectionManager();
	static List<Order> list1 = new ArrayList<Order>();
	
// inserting order in the table
	@Override
	public void purchase(Order order) throws Exception {
		
		
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			String sql = "INSERT INTO orderuserss(id,NAME,PNAME,ADRESS,PRICE,QUANTITY)VALUES(ORD_SEQ.NEXTVAL ,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, order.getCustname());
			st.setString(2, order.getPname());
			st.setString(3, order.getAdress());
			st.setString(4, order.getPrice());
			st.setString(5, order.getQuantity());
			int status = st.executeUpdate();
			if(status > 0) {
				System.out.println("Order purchased successfully");
			}else {
				System.out.println("Failure");
			}
			con.close();
			
		
	}
	//view respective order by typing name.
	public List<Order> MyOrders(String name) 
	{
		List<Order> list1 = new ArrayList<Order>();
		try 
		{
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			
			String sql = "Select * from orderuserss where name =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
	
			if(rs.next()==false)
			{
				System.out.println("Sorry!! YOUR CART IS EMPTY...!");
			}
			else
			{
				do{
					Order o = new Order();
					
					String orderId = rs.getString(1);
					String username = rs.getString(2);
					
					String pName = rs.getString(3);
					String adress = rs.getString(4);
					String pPrice = rs.getString(5);
					String PQuantity = rs.getString(6);
					
					o.setId(orderId);
					o.setCustname(username);
					o.setPname(pName);
					o.setAdress(adress);
					o.setPrice(pPrice);
					o.setQuantity(PQuantity);
					
					list1.add(o);
					
					}while(rs.next()); 
			}
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list1;
	}

	
	//cancel order using the order id.
	
	@Override
	public void deleteOrder(String Id)  {
	
		try {
			System.out.println(Id);
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			String sql = "DELETE FROM orderuserss WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,Id);
			int stat = st.executeUpdate();
			if(stat > 0) {
				System.out.println("*************************ORDER CANCELLED SUCCESSFULLY ****************************************");
				con.close();
			}else {
				System.out.println("*************************INVALID ORDER ID***************************************************** ");
				con.close();
			}
		}catch (Exception e) 
		{
			e.getMessage();
		}
		
		
		
		
	}

	

}
