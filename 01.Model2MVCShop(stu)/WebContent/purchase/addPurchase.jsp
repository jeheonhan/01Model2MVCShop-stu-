<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.model2.mvc.service.purchase.vo.PurchaseVO" %>

<%
	PurchaseVO purchaseVO=(PurchaseVO)request.getAttribute("purchaseVO");
%>




<html><head><title>���� �Ϸ�</title></head>

<body>
	������ ���� ���Ű� �Ǿ����ϴ�.

	<table border=1>
		<tr>
			<td>��ǰ��ȣ</td>
			<td><%=purchaseVO.getPurchaseProd().getProdNo()%></td>
		</tr>
		<tr>
			<td>�����ھ��̵�</td>
			<td><%=purchaseVO.getBuyer().getUserId()%></td>
		</tr>
		<tr>
			<td>���Ź��</td>
			<td><%if(purchaseVO.getPaymentOption().equals("100")) {%>
				���ݱ���
				<%}else{%>
				�ſ뱸��
				<%}%>
			</td>
		</tr>
		<tr>
			<td>�������̸�</td>
			<td><%=purchaseVO.getReceiverName()%></td>
		</tr>
		<tr>
			<td>�����ڿ���ó</td>
			<td><%=purchaseVO.getReceiverPhone()%></td>
		</tr>
		<tr>
			<td>�������ּ�</td>
			<td><%=purchaseVO.getDivyAddr()%></td>
		</tr>
			<tr>
			<td>���ſ�û����</td>
			<td><%=purchaseVO.getDivyRequest()%></td>
		</tr>
		<tr>
			<td>����������</td>
			<td><%=purchaseVO.getDivyDate()%></td>
		</tr>
	</table>
</body>

</html>