package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.Users;
import service.inter.GwapService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class UsersServiceImpl implements GwapService
{
	public List getGwapList() {
		List UsersList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from users");
			
			while(rs.next()){
				Users users = new Users();				
				users.setUserid(rs.getString("userid"));
				users.setPassword(rs.getString("password"));											
				UsersList.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying users ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying users ",e);
			}
		}

		return UsersList;
	}
}
