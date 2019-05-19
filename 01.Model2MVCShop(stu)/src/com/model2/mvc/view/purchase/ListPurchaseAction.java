package com.model2.mvc.view.purchase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;


public class ListPurchaseAction extends Action {
	
	public String execute(HttpServletRequest request,
							HttpServletResponse response) throws Exception{
		
		System.out.println("listPurchase 시작....");
		
		SearchVO searchVO=new SearchVO();
		
		int page=1;
		if(request.getParameter("page") != null)
			page=Integer.parseInt(request.getParameter("page"));
		System.out.println("페이지 = "+page);
		
		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		searchVO.setSearchKeyword(request.getParameter("searchKeyword"));
		
		String pageUnit=getServletContext().getInitParameter("pageSize");
		System.out.println("페이지 유닛 = "+pageUnit);
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		
		PurchaseService service = new PurchaseServiceImpl();
		HashMap<String,Object> map = service.getPurchaseList(searchVO, request.getParameter("userId"));
		
		System.out.println("Hash맵 = "+map);
		
		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);		
		
		
		return "forward:/purchase/listPurchase.jsp";
		}

}
