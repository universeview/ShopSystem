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
import service.impl.ProductServiceImpl;
import service.inter.GwapService;

public class productDetailservlet extends HttpServlet{
	

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
		
		//此处获取
				String name=req.getParameter("id");
				 List productList = (List)req.getAttribute("productList");
				 
				 out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
					out.println("<html>");
					out.println("	<head>");
					out.println("		<title>达内电子商务门户</title>");
					out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
					out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
					out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");
					out.println("	</head>");
					out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
					out.println("<!-- Header Start -->");
					out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
					out.println("			<tr>");
					out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
					out.println("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
					out.println("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
					out.println("			<tr>");
					out.println("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
					out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
					out.println("						<tr>");
					out.println("							<td width=\"5%\"></td>");
					out.println("							");
					out.println("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
					out.println("							");
					out.println("          <td width=\"10%\"><a href=\"user2.do\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
					out.println("							");
					out.println("          <td width=\"10%\"><a href=\"shop2.do\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
					out.println("							");
					out.println("          <td width=\"10%\"><a href=\"order2.do\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
					out.println("");
					out.println("							");
					out.println("          <td width=\"10%\"><a href=\"product2.do\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
					out.println("						</tr>");
					out.println("					</table>");
					out.println("				</td>");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
					out.println("			<tr>");
					out.println("				<td width=\"65%\"><br>");
					out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
					out.println("				</td>");
					out.println("				<td width=\"35%\" align=\"right\">");
					out.println("				</td>");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("<!-- Header End -->");
					out.println("");
					out.println("");
					out.println("<!-- Body Start -->");
					out.println("");
					out.println("	<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
					out.println("");
					out.println("			<tr>");
					out.println("				<td height=\"25\" valign=\"middle\">");
					out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
					out.println("					<a href=index.jsp>达内电子商务门户</a> → 产品明细");
					out.println("				</td>");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("");
					out.println("		<br>");
					out.println("			");
					out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");

					for(Iterator<Product> it = productList.iterator();it.hasNext();)
					 {
			            Product product = it.next();
			            if(product.getProductid().equals(name))
			            {
			        		out.println("			<tr>");
			        		out.println("				<td  colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"100%\">");
			        		out.println("					<font color=\"#ffffff\">");
			        		out.println("						<b>"+product.getName()+"</b>");
			        		out.println("					</font>");
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[ 作 &nbsp者 ]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getAuthor());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[ 价 &nbsp格 ]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getBasePrice());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[出 版 社]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getPublish());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[ 书 &nbsp号 ]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getCategoryid());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[ 页 &nbsp码 ]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getPages());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\" align=\"center\">");
			        		out.println("				[所属类别]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println("				"+product.getCategoryid()+"<br>");
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"top\" width=\"25%\" align=\"center\">");
			        		out.println("				[ 简 &nbsp介 ]");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println(product.getDescription());
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			<tr>");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"25%\">");
			        		out.println("				");
			        		out.println("				</td>");
			        		out.println("				");
			        		out.println("				<td class=tablebody1 valign=\"middle\" width=\"75%\">");
			        		out.println("				&nbsp");
			        		out.println("				<img src=\"images/zcover2.gif\">");
			        		out.println("				</td>");
			        		out.println("			</tr>");
			        		out.println("			");
			        		out.println("			<tr>");
			            	
			            }
					
					 }

					out.println("			<td colspan=\"2\" class=tablebody2 valign=\"top\" align=\"center\" width=\"100%\" height=\"32\"> ");
					out.println("				<a href=\"shop2.do?id="+"\"><img border=\"0\" src=\"images/buycar.gif\" ></a> ");
					out.println("    		</td>");
					out.println("    		</tr>");
					out.println("			");
					out.println("		</table>");
					out.println("		<br>");
					out.println("		<br>");
					out.println("");
					out.println("<!-- Body End -->");
					out.println("");
					out.println("");
					out.println("");
					out.println("<!-- Footer Start -->");
					out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
					out.println("			<tr>");
					out.println("				<td height=\"17\" background=\"images/bot_bg.gif\">");
					out.println("				</td>");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("");
					out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
					out.println("			<tr>");
					out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
					out.println("					<p align=\"center\">");
					out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
					out.println("					</p>");
					out.println("				</td>");
					out.println("");
					out.println("			</tr>");
					out.println("		</table>");
					out.println("<!-- Footer End -->");
					out.println("	</body>");
					out.println("</html>");
					
					out.close();

	
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
	
	

}
