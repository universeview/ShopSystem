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
		
	
		 List productList = null;
		 
		 try{
			 GwapService productservice = new ProductServiceImpl(); 
		 	  productList = productservice.getGwapList();
		 
			toProductList(out, productList);
		     
			} catch (Exception e){
				toError(resp,e.getMessage());
			}
		
		

		
	}

	private void toProductList(PrintWriter out, List productList) {
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
		out.print("          <td width=\"10%\"><a href=\"product2\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.print("							");
		out.print("          <td width=\"10%\"><a href=\"user2\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.print("							");
		out.print("          <td width=\"10%\"><a href=\"shop2\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.print("							");
		out.print("          <td width=\"10%\"><a href=\"order2\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.print("							");
		out.print("          <td width=\"10%\"><a href=\"product2\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
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
		out.print("    <td class=tablebody1 valign=\"middle\" width=\"60%\"> &nbsp;&nbsp;<a href=\"product1?id="+product.getProductid()+"\">"+product.getName()+"</a> ");
		out.print("    </td>");
		out.print("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
		out.print(product.getBasePrice());
		out.print("				</td>");
		out.print("				");
		out.print("    <td class=tablebody1 valign=\"middle\" align=\"center\" width=\"24%\"> <a href=\"shop2?id="+product.getProductid()+"\"><img border=\"0\" src=\"images/car_new.gif\" width=\"97\" height=\"18\"></a> ");
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
		
	
		 List productList = null;
		 
		 try{
			 GwapService productservice = new ProductServiceImpl(); 
		 	  productList = productservice.getGwapList();
		 
			toProductList(out, productList);
		     
			} catch (Exception e){
				toError(resp,e.getMessage());
			}
	
	}
	
	private void toError(HttpServletResponse resp, String message) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>    "); 
		
		 out.println("<head>    "); 
		 out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />    "); 
		 out.println("<title>网站正在建设中，请稍候再试</title>    "); 
		 out.println("<style>    "); 
		 out.println("body{font-family:Helvetica,Arial,sans-serif;margin:0;background-color:#CCC;background:-webkit-linear-gradient(#CCC,#AAA);background-attachment:fixed;}#cell{padding:40px;}#box{background-color:white;color:black;font-size:10pt;line-height:18px;margin:auto;max-width:800px;border-radius:5px;-webkit-box-shadow:2px 5px 12px#555;padding:20px;}    "); 
		 out.println("ul{margin:0;padding-bottom:0;}    "); 
		 out.println("li{padding-top:2px;}    "); 
		 out.println("h1{font-size:18pt;line-height:30px;margin:0;}    "); 
		 out.println(".right{color:#00FF00;text-align: right;}    "); 
		 out.println("a{color:#B5B5B5;}    "); 
		 out.println("</style>    "); 
		 out.println("</head>    "); 
		 out.println("<body id=\"t\">    "); 
		 out.println("<div id=\"cell\">    "); 
		 out.println("<div id=\"box\">    "); 
		 out.println("<body bgcolor=#rrggbb>"); 
		 out.println("<font bgcolor=#00FF00></font>");
		 out.println("<font face=\"隶书\"></font>");
		 out.println("<h1>有点小错误啊，请稍候再试好不好哇.....</h1>    "); 
		 out.println("<p>    "); 
		 out.println("<ul>    "); 
		 out.println("<h3>");
		 out.println("<li>粗枝大叶没有设置默认页</li>    "); 
		 out.println("<br>");
		 out.println("<li>贵人多忘事没有上传程序</li>    "); 
		 out.println("<br>");
		 out.println("<li>不干了网站荒废已经长草</li>    "); 
		 out.println("<br>");
		 out.println("<li>怒火攻心把网站咔嚓掉了</li>    "); 
		 out.println("<br>");
		 out.println("<li>有个二货把域名CNAME到这里</li>    "); 
		 out.println("<br>");
		 out.println("<br>");
		 out.println("<li>要不去百度玩玩???</li>    "); 
		 out.println("</h3>");
		 out.println("</ul>    "); 
		 out.println("</p>    "); 
		 out.println("<body link=#rrggbb> ");
		 out.println("<p class=\"right\">&copy; 2015 @<a href=\"http://www.baidu.com\">百度一下  你就知道:</a></p>    "); 
		 out.println("</div>    "); 
		 out.println("</div>    "); 
		 out.println("</body>    "); 
		 out.println("</html>    ");
		out.close();
	}

	
	

}
