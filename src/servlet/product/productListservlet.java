package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Product;
import pojo.Users;
import service.impl.ProductServiceImpl;
import service.impl.UsersServiceImpl;
import service.inter.GwapService;

public class productListservlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
	    resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
	
		 List productList =(List)req.getAttribute("productList");
		 
		 out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.print("<html>");
			out.print("	<head>");
			out.print("		<title>达内电子商务门户</title>");
			out.print("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			out.print("		<meta name=\"description\" content=\"达内电子商务门户\">");
			out.print("		<link href=\"css/tarena.css\" rel=stylesheet>");
			out.print("	</head>");
			out.print("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
			out.print("<!-- Header Start -->");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
			out.print("			<tr>");
			out.print("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
			out.print("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
			out.print("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.print("			<tr>");
			out.print("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
			out.print("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.print("						<tr>");
			out.print("							<td width=\"5%\"></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"user2.do\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"shop2.do\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"order2.do\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("						</tr>");
			out.print("					</table>");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
			out.print("			<tr>");
			out.print("				<td width=\"65%\"><br>");
			out.print("					>> 欢迎访问 <b>达内电子商务门户</b>");
			out.print("				</td>");
			out.print("				<td width=\"35%\" align=\"right\">");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("<!-- Header End -->");
			out.print("<!-- Body Start -->");
			out.print("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
			out.print("			<tr>");
			out.print("				<td height=\"25\" valign=\"middle\">");
			out.print("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
			out.print("					<a href=index.jsp>达内电子商务门户</a> →<img border=\"0\" src=\"images/dog.gif\" width=\"19\" height=\"18\">欢迎<font color=\"red\">admin</font>光临！");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<br>");
			out.print("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
			out.print("			<tr>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>序号</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"60%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>产品名称</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>价格</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"24%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>操作</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("			</tr>");
			
			
			 for(Iterator<Product> it = productList.iterator();it.hasNext();)
			 {
	             Product product = it.next();
			out.print("			<tr>");
			out.print("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.print(product.getProductid());
			out.print("				</td>");
			out.print("				");
			out.print("    <td class=tablebody1 valign=\"middle\" width=\"60%\"> &nbsp;&nbsp;<a href=\"product1.do?id="+product.getProductid()+"\">"+product.getName()+"</a> ");
			out.print("    </td>");
			out.print("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.print(product.getBasePrice());
			out.print("				</td>");
			out.print("				");
			out.print("    <td class=tablebody1 valign=\"middle\" align=\"center\" width=\"24%\"> <a href=\"shop2.do?id="+product.getProductid()+"\"><img border=\"0\" src=\"images/car_new.gif\" width=\"97\" height=\"18\"></a> ");
			out.print("    </td>");
			out.print("			</tr>   ");
			 }
			
			

			out.print("		</table>");
			out.print("<!-- Body End -->");
			out.print("<!-- Footer Start -->");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
			out.print("			<tr>");
			out.print("				<td height=\"17\" background=\"images/bot_bg.gif\">");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.print("			<tr>");
			out.print("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
			out.print("					<p align=\"center\">");
			out.print("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
			out.print("					</p>");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("<!-- Footer End -->");
			out.print("	</body>");
			out.print("	</html>");
			
			out.close();
	
		 

		
		

		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
	    resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		 List productList =(List)req.getAttribute("productList");
		 
		 out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.print("<html>");
			out.print("	<head>");
			out.print("		<title>达内电子商务门户</title>");
			out.print("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			out.print("		<meta name=\"description\" content=\"达内电子商务门户\">");
			out.print("		<link href=\"css/tarena.css\" rel=stylesheet>");
			out.print("	</head>");
			out.print("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
			out.print("<!-- Header Start -->");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
			out.print("			<tr>");
			out.print("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
			out.print("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
			out.print("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.print("			<tr>");
			out.print("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
			out.print("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.print("						<tr>");
			out.print("							<td width=\"5%\"></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"user2.do\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"shop2.do\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"order2.do\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("							");
			out.print("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
			out.print("						</tr>");
			out.print("					</table>");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
			out.print("			<tr>");
			out.print("				<td width=\"65%\"><br>");
			out.print("					>> 欢迎访问 <b>达内电子商务门户</b>");
			out.print("				</td>");
			out.print("				<td width=\"35%\" align=\"right\">");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("<!-- Header End -->");
			out.print("<!-- Body Start -->");
			out.print("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
			out.print("			<tr>");
			out.print("				<td height=\"25\" valign=\"middle\">");
			out.print("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
			out.print("					<a href=index.jsp>达内电子商务门户</a> →<img border=\"0\" src=\"images/dog.gif\" width=\"19\" height=\"18\">欢迎<font color=\"red\">admin</font>光临！");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<br>");
			out.print("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
			out.print("			<tr>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>序号</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"60%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>产品名称</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>价格</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"24%\">");
			out.print("					<font color=\"#ffffff\">");
			out.print("						<b>操作</b>");
			out.print("					</font>");
			out.print("				</td>");
			out.print("			</tr>");
			
			
			 for(Iterator<Product> it = productList.iterator();it.hasNext();)
			 {
	             Product product = it.next();
			out.print("			<tr>");
			out.print("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.print(product.getProductid());
			out.print("				</td>");
			out.print("				");
			out.print("    <td class=tablebody1 valign=\"middle\" width=\"60%\"> &nbsp;&nbsp;<a href=\"product1.do?id="+product.getProductid()+"\">"+product.getName()+"</a> ");
			out.print("    </td>");
			out.print("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.print(product.getBasePrice());
			out.print("				</td>");
			out.print("				");
			out.print("    <td class=tablebody1 valign=\"middle\" align=\"center\" width=\"24%\"> <a href=\"shop2.do?id="+product.getProductid()+"\"><img border=\"0\" src=\"images/car_new.gif\" width=\"97\" height=\"18\"></a> ");
			out.print("    </td>");
			out.print("			</tr>   ");
			 }
			
			

			out.print("		</table>");
			out.print("<!-- Body End -->");
			out.print("<!-- Footer Start -->");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
			out.print("			<tr>");
			out.print("				<td height=\"17\" background=\"images/bot_bg.gif\">");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.print("			<tr>");
			out.print("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
			out.print("					<p align=\"center\">");
			out.print("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
			out.print("					</p>");
			out.print("				</td>");
			out.print("			</tr>");
			out.print("		</table>");
			out.print("<!-- Footer End -->");
			out.print("	</body>");
			out.print("	</html>");
			
			out.close();
	
	}
	

	
	

}
