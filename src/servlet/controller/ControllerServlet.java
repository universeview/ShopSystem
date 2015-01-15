package servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.ContactInfoServiceImpl;
import service.impl.OrdersServiceImpt;
import service.impl.ProductServiceImpl;
import service.impl.UsersServiceImpl;
import service.inter.GwapService;

public class ControllerServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		 path = path.substring(0,path.indexOf("."));
		
		 if("/user2".equals(path)){
			try{
				GwapService userService = new UsersServiceImpl();
							
				List usersList = userService.getGwapList();
	
				req.setAttribute("usersList", usersList);
				
				 getServletContext().getRequestDispatcher("/user2").forward(req, resp);
			} catch (Exception e){
				 req.setAttribute("message", e.getMessage());	
				 getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}
		}
		 else if("/user3".equals(path)){
			 try{
				 					 
				 GwapService contactService = new ContactInfoServiceImpl();
					
					List contactInfoList = contactService.getGwapList();
					
					req.setAttribute("contactInfoList", contactInfoList);
					
					 getServletContext().getRequestDispatcher("/user3").forward(req, resp);
				} catch (Exception e){
					req.setAttribute("message", e.getMessage());
					
					 getServletContext().getRequestDispatcher("/error").forward(req, resp);
				}
		 }
		 else if("/user4".equals(path)){
			 try{
					 getServletContext().getRequestDispatcher("/user4").forward(req, resp);
				} catch (Exception e){
					req.setAttribute("message", e.getMessage());
					
					 getServletContext().getRequestDispatcher("/error").forward(req, resp);
				}
		 }
		 
		 else if("/user1".equals(path)){
			 try{
				 	
					
					 getServletContext().getRequestDispatcher("/user1").forward(req, resp);
				} catch (Exception e){
					req.setAttribute("message", e.getMessage());
					
					 getServletContext().getRequestDispatcher("/error").forward(req, resp);
				}
		 }
		 else if("/product2".equals(path)){ 
				try{ 
					GwapService productService = new ProductServiceImpl(); 
					 
		 				List productList = productService.getGwapList(); 
		 				
		 				req.setAttribute("productList", productList); 
		 				 
		 			getServletContext().getRequestDispatcher("/product2").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}			 
		 	} 
			else if("/order2".equals(path)){ 
				try{ 
					GwapService orderService = new OrdersServiceImpt(); 
					 
		 				List orderList = orderService.getGwapList(); 
		 				 
		 				req.setAttribute("orderList", orderList); 
		 				 
		 			getServletContext().getRequestDispatcher("/order2").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}			 
		 	} 
		 	else if("/order1".equals(path)){ 
				try{ 
					GwapService orderserver = new OrdersServiceImpt();
					
					List orderDetailList = orderserver.getGwapList();
		 				 
		 				req.setAttribute("orderdetailserver", orderDetailList); 
		 				
		 			getServletContext().getRequestDispatcher("/order1").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}
			}else if("/product1".equals(path)){ 
				try{ 
					
					String productid=req.getParameter("id");
					
					GwapService productService = new ProductServiceImpl();
					
					List productList = productService.getGwapList();
					  
					req.setAttribute("productList", productList);
		 			
					getServletContext().getRequestDispatcher("/product1").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}			 
		 }
		 else if("/shop2".equals(path)){ 
				try{ 
										
					getServletContext().getRequestDispatcher("/shop2").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}			 
		 } else if("/shop1".equals(path)){ 
				try{ 
										
					getServletContext().getRequestDispatcher("/shop1").forward(req, resp); 
		 			 
				} catch (Exception e){ 
		 			req.setAttribute("message", e.getMessage()); 
		 			 
					getServletContext().getRequestDispatcher("/error").forward(req, resp); 
		 		}			 
		 } 		
		 else {
			  resp.sendError(resp.SC_NOT_FOUND);
		 }
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
