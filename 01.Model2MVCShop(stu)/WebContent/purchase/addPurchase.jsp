<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.model2.mvc.service.purchase.vo.PurchaseVO" %>

<%
	PurchaseVO purchaseVO=(PurchaseVO)request.getAttribute("purchaseVO");
%>




<html><head><title>구매 완료</title></head>

<body>
	다음과 같이 구매가 되었습니다.

	<table border=1>
		<tr>
			<td>물품번호</td>
			<td><%=purchaseVO.getPurchaseProd().getProdNo()%></td>
		</tr>
		<tr>
			<td>구매자아이디</td>
			<td><%=purchaseVO.getBuyer().getUserId()%></td>
		</tr>
		<tr>
			<td>구매방법</td>
			<td><%if(purchaseVO.getPaymentOption().equals("100")) {%>
				현금구매
				<%}else{%>
				신용구매
				<%}%>
			</td>
		</tr>
		<tr>
			<td>구매자이름</td>
			<td><%=purchaseVO.getReceiverName()%></td>
		</tr>
		<tr>
			<td>구매자연락처</td>
			<td><%=purchaseVO.getReceiverPhone()%></td>
		</tr>
		<tr>
			<td>구매자주소</td>
			<td><%=purchaseVO.getDivyAddr()%></td>
		</tr>
			<tr>
			<td>구매요청사항</td>
			<td><%=purchaseVO.getDivyRequest()%></td>
		</tr>
		<tr>
			<td>배송희망일자</td>
			<td><%=purchaseVO.getDivyDate()%></td>
		</tr>
	</table>
</body>

</html>