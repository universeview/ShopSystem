package servlet.error;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public  class ErrorServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		
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
			 out.println("<h1>"+req.getAttribute("message")+"</h1>    "); 
			 out.println("<br>");
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
		 
	}

	
}
