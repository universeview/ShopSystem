package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.PayWay;
import service.inter.GwapService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class PayWayServiceImpt implements GwapService
{
	public List getGwapList() {
		List PaywayList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from payway");
			
			while(rs.next()){
				PayWay payway = new PayWay();
				
				payway.setPaywayid(rs.getString("paywayid"));
				payway.setPaystyle(rs.getString("paystyle"));
				
							
				PaywayList.add(payway);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying payway ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying payway ",e);
			}
		}

		return PaywayList;
	}
}
