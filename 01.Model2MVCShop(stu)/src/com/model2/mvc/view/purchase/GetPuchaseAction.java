package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class GetPuchaseAction extends Action {
	
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception{
		
		PurchaseVO purchaseVO = new PurchaseVO();
		PurchaseService service = new PurchaseServiceImpl();
		System.out.println("tranNo확인 : "+Integer.parseInt(request.getParameter("tranNo")));
		purchaseVO = service.getPurchase(Integer.parseInt(request.getParameter("tranNo")));
		
		System.out.println("getPurchase 결과 : "+purchaseVO);
		System.out.println("prodNo : "+purchaseVO.getPurchaseProd().getProdNo());
		System.out.println("buyerId : "+purchaseVO.getBuyer().getUserId());
		
		 request.setAttribute("purchaseVO", purchaseVO);
		 request.setAttribute("prodNo", purchaseVO.getPurchaseProd().getProdNo());
		 request.setAttribute("buyerId", purchaseVO.getBuyer().getUserId());
		
				
		return "forward:/purchase/getPurchase.jsp";
	}
		

}
