package service.impl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import pojo.ContactInfo;
import service.inter.GwapService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ContactInfoServiceImpl implements GwapService 
{
	public List getGwapList() {
		List ContactinfoList = new ArrayList();
		
		java.sql.Connection conn = null;
		
		java.sql.Statement stmt = null;
		
		java.sql.ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from contactinfo left join users on (contactinfo.userid = users.userid)");
			
			while(rs.next()){
				ContactInfo contactinfo = new ContactInfo();				
				contactinfo.setContactid(rs.getString("contactid"));
				contactinfo.setUserid(rs.getString("contactinfo.userid"));		
				contactinfo.setStreet1(rs.getString("street1"));	
				contactinfo.setStreet2(rs.getString("street2"));	
				contactinfo.setCity(rs.getString("city"));	
				contactinfo.setProvince(rs.getString("province"));	
				contactinfo.setCountry(rs.getString("country"));	
				contactinfo.setZip(rs.getString("zip"));	
				contactinfo.setEmail(rs.getString("email"));	
				contactinfo.setHomephone(rs.getString("homephone"));	
				contactinfo.setCellphone(rs.getString("cellphone"));	
				contactinfo.setOfficephone(rs.getString("officephone"));	
				contactinfo.setPassword(rs.getString("password"));
				ContactinfoList.add(contactinfo);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying contactinfo ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying contactinfo ",e);
			}
		}

		return ContactinfoList;
	}

}
