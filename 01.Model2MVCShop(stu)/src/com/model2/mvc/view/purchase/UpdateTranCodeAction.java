package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class UpdateTranCodeAction extends Action {
	
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception{
		
		
		if(request.getParameter("prodNo") != null && request.getParameter("prodNo") != "" ) {
			
			PurchaseService service = new PurchaseServiceImpl();			
			
			PurchaseVO purchaseVO = service.getPurchase2(Integer.parseInt(request.getParameter("prodNo")));
			
			purchaseVO.setTranCode("222");
			
			service.updateTranCode(purchaseVO);	
			
			return "redirect:/listProduct.do?page="+request.getParameter("page")+"&menu="+request.getParameter("menu");
			
		}else {
			
			System.out.println("tranNo : "+Integer.parseInt(request.getParameter("tranNo")));
			
			PurchaseService service = new PurchaseServiceImpl();
			
			PurchaseVO purchaseVO = service.getPurchase(Integer.parseInt(request.getParameter("tranNo")));
			
			purchaseVO.setTranCode("333");			
			
			service.updateTranCode(purchaseVO);	
			
			System.out.println("¼öÁ¤µÈ purchaseVO : "+purchaseVO);

				
			return "redirect:/listPurchase.do?page="+request.getParameter("page")+"&userId="+request.getParameter("userId");
		}		
		
		
	}
		

}
