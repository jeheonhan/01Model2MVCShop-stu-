package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddPurchaseViewAction extends Action {
	
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception{
		
		
		
		ProductService service = new ProductServiceImpl();
		ProductVO pvo = service.getProduct(Integer.parseInt(request.getParameter("prodNo")));
		
		System.out.println(pvo);
		request.setAttribute("pvo", pvo);
		
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
		

}
