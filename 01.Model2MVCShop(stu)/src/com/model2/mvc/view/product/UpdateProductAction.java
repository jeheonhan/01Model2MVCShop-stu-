package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class UpdateProductAction extends Action {
	//updateProduct.jsp(menu=manage)에서 넘어옴

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
	
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		String manuDate = request.getParameter("manuDate");
		manuDate = manuDate.replaceAll("-", "");
		
		ProductVO productVO=new ProductVO();
		
		productVO.setProdNo(prodNo);
		productVO.setFileName(request.getParameter("fileName"));
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(manuDate);
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);		
		
		productVO = service.getProduct(prodNo);
		System.out.println("수정된 정보 : "+productVO);
		request.setAttribute("pvo", productVO);	
		System.out.println(request.getAttribute("pvo"));
		
		
		return "redirect:/getProduct.do?prodNo="+prodNo+"&menu="+request.getParameter("menu");
	}
}