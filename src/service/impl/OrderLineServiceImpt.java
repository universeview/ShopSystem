package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.OrderLine;
import service.inter.GwapService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class OrderLineServiceImpt implements GwapService
{
	public List getGwapList() 
	{
		List OrderlineList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from orderline");
			
			while(rs.next()){
				OrderLine orderline = new OrderLine();
				
				orderline.setLineid(rs.getString("lineid"));
				orderline.setOrderid(rs.getString("orderid"));
				orderline.setProductid(rs.getString("productid"));
				orderline.setAmount(rs.getString("amount"));
			
									
				OrderlineList.add(orderline);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying orderline ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying orderline ",e);
			}
		}

		return OrderlineList;
	}
}
