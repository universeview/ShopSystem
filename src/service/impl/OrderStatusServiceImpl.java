package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.OrderStatus;
import service.inter.GwapService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class OrderStatusServiceImpl implements GwapService
{
	public List getGwapList() {
		List OrderstatusList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from orderstatus");
			
			while(rs.next()){
				OrderStatus orderstatus = new OrderStatus();
				
				orderstatus.setStatusid(rs.getString("statusid"));
				orderstatus.setName(rs.getString("name"));
				orderstatus.setDescription(rs.getString("description"));
				
				
				OrderstatusList.add(orderstatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying orderstatus ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying orderstatus ",e);
			}
		}

		return OrderstatusList;
	}

}
