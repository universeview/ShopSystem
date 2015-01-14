package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Orders;
import pojo.Users;
import service.impl.OrdersServiceImpt;
import service.impl.UsersServiceImpl;
import service.inter.GwapService;

public class OrderListservlet  extends HttpServlet{
	


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
		
		 List<Orders> ordersList = null;
		 
		 try{
			 
			 GwapService orderservice = new OrdersServiceImpt();			 
		 	 ordersList = orderservice.getGwapList();		 	 		 	 
			 toOrderList(out, ordersList);
		   
		     
			} catch (Exception e){
				toError(resp,e.getMessage());
			}
			

	}

	private void toOrderList(PrintWriter out, List<Orders> ordersList) {
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
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
		out.println("          <td width=\"10%\"><a href=\"product2\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"user2\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"shop2\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"order2\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"product2\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
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
		out.println("<!-- Body Start -->");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=index.jsp>达内电子商务门户</a> →<img border=\"0\" src=\"images/dog.gif\" width=\"19\" height=\"18\"> 订单列表");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>序号</b></font></td>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>订单编号</b></font></td>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>订单金额</b></font></td>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>订单状态</b></font></td>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>付款方式</b></font></td>");
		out.println("				<td valign=middle align=center height=25 background=\"images/bg2.gif\"><font color=\"#ffffff\"><b>操作</b></font></td>");
		out.println("			</tr>");
		
		 for(Iterator<Orders> it = ordersList.iterator();it.hasNext();)
		 {
			 int i =0 ;
			 i++;
			 Orders order = it.next();  
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=middle align=center>"+i+"</td>");
		out.println("				<td class=tablebody1 valign=middle>&nbsp;&nbsp;<a href=\"order1?id="+order.getOrderid()+"\">"+order.getOrderid()+"</a></td>");
		out.println("				<td class=tablebody2 valign=middle align=left>&nbsp;&nbsp;￥"+order.getCost()+"</td>");
		out.println("				<td class=tablebody1 valign=middle align=center>"+order.getStatus()+"</td>");
		out.println("				<td class=tablebody2 valign=middle align=center>"+order.getPayway()+" </td>");
		out.println("				<td class=tablebody1 valign=middle align=center>");
		out.println("					<input type=\"button\" value=\"删除\" onclick=\"javascript:window.location='order2?id="+order.getOrderid()+"';\">&nbsp;");
		out.println("					<input type=\"button\" value=\"明细\" onclick=\"javascript:window.location='order1?id="+order.getOrderid()+"';\">");
		out.println("				</td>");
		out.println("			</tr>");
		 }

		out.println("		</table>");
		out.println("		<br>");
		out.println("<!-- Body End -->");
		out.println("<!-- Footer Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("			<tr>");
		out.println("				<td height=\"17\" background=\"images/bot_bg.gif\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("			<tr>");
		out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("					<p align=\"center\">");
		out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
		out.println("					</p>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Footer End -->");
		out.println("	</body>");
		out.println("</html>");
        out.close();
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
