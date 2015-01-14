package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.Category;
import service.inter.GwapService;





public class CategoryServiceImpl implements GwapService
{
	public List getGwapList() {
		List CategoryList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from category");
			
			while(rs.next()){
				Category category = new Category();
				
				category.setCategoryid(rs.getString("categoryid"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				
				
				CategoryList.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying categpry ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying categpry ",e);
			}
		}

		return CategoryList;
	}

}
