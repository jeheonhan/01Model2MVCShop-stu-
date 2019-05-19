package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class UpdatePurchaseAction extends Action {
	
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception{
		
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setTranNo(Integer.parseInt(request.getParameter("tranNo")));
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(request.getParameter("receiverDate"));
		
		PurchaseService service = new PurchaseServiceImpl();
		service.updatePurcahse(purchaseVO);
		
//		System.out.println("getPurchase °á°ú : "+purchaseVO);
//		System.out.println("prodNo : "+purchaseVO.getPurchaseProd().getProdNo());
//		System.out.println("buyerId : "+purchaseVO.getBuyer().getUserId());
//		
//		 request.setAttribute("purchaseVO", purchaseVO);
//		 request.setAttribute("prodNo", purchaseVO.getPurchaseProd().getProdNo());
//		 request.setAttribute("buyerId", purchaseVO.getBuyer().getUserId());
		
				
		return "redirect:/getPurchase.do?tranNo="+purchaseVO.getTranNo();
	}
		

}
