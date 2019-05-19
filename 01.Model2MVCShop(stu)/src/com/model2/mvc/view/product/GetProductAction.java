package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class GetProductAction extends Action {
	
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception{
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProduct(prodNo);
		System.out.println(vo);
		
		String history = null;		 
		Cookie[] cookies = request.getCookies();
		if (cookies!=null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("history")) {
					history = cookie.getValue();
				}
			}
		}
		
			history += ","+request.getParameter("prodNo") ;
			
			Cookie cookie = new Cookie("history", history);
			
			response.addCookie(cookie);
		
				
//		Cookie[] cookies = request.getCookies();
//		String history = null;
//		
//		if(cookies != null) {
//			
//		}
//		response.addCookie(history);
//		
//		Cookie cookie = new Cookie("prodNo", request.getParameter("prodNo"));
//		
		request.setAttribute("pvo", vo);
		
		if(request.getParameter("menu").equals("manage")) {			
			return "forward:/product/updateProduct.jsp";			
		}else {
			return "forward:/product/getProduct.jsp";			
		}
		
	}

}
