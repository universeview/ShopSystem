package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.Orders;
import service.inter.GwapService;

public class Order_UserServiceImpl implements GwapService
{
	public List getGwapList(String name) 
	{
		List OrdersList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from orders left join payway on (orders.paywayid = payway.paywayid) left join orderstatus on (orders.statusid = orderstatus.statusid)  ");
			
			while(rs.next()){
				Orders orders = new Orders();
				
				orders.setOrderid(rs.getString("orderid"));
				orders.setName(rs.getString("orders.name"));
				orders.setCost(rs.getString("cost"));
				orders.setUserid(rs.getString("userid"));
				orders.setStatusid(rs.getString("statusid"));
				orders.setPaywayid(rs.getString("paywayid"));
				orders.setPayway(rs.getString("paystyle"));
				orders.setStatus(rs.getString("orderstatus.name"));
				
				
							
				OrdersList.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying orders ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying orders ",e);
			}
		}

		return OrdersList;
	}

	@Override
	public List getGwapList() {
		// TODO Auto-generated method stub
		return null;
	}

}
