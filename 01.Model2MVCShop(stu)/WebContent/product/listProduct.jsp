<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

<%@ page import="java.util.*" %>
<%@ page import="com.model2.mvc.service.product.vo.*" %>
<%@ page import="com.model2.mvc.common.*" %>


<%
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	SearchVO searchVO=(SearchVO)request.getAttribute("searchVO");	
	
	int total=0;
	ArrayList<ProductVO> list=null;
	if(map != null){
		total=((Integer)map.get("count")).intValue();
		list=(ArrayList<ProductVO>)map.get("list");
	}
	
	int currentPage=searchVO.getPage();
	
	int totalPage=0;
	if(total > 0) {
		totalPage= total / searchVO.getPageUnit() ;
		if(total%searchVO.getPageUnit() >0)
			totalPage += 1;
	}
%>
    <html>
<head>
<title>��ǰ �����ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">

function fncGetProductList(){
	document.detailForm.submit();
}

</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=<%= request.getParameter("menu") %>" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
						<%if((request.getParameter("menu")).equals("manage")){%>
							�ǸŻ�ǰ ����
						<%} else {%>
							�ǸŻ�ǰ ��ȸ
						<%}%>
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>			
		<td align="right">					
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0"  <%if((searchVO.getSearchCondition() != null && searchVO.getSearchCondition() != "")	&& searchVO.getSearchCondition().equals("0")) {%>
											selected	<%}%>>��ǰ��ȣ</option>
				<option value="1"  <%if((searchVO.getSearchCondition() != null && searchVO.getSearchCondition() != "")	&& searchVO.getSearchCondition().equals("1")) {%>
											selected	<%}%>>��ǰ��</option>
				<option value="2"  <%if((searchVO.getSearchCondition() != null && searchVO.getSearchCondition() != "")	&& searchVO.getSearchCondition().equals("2")) {%>
											selected	<%}%>>��ǰ����</option>							
			</select>
		
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px"
					<%if(searchVO.getSearchKeyword() != null && searchVO.getSearchKeyword()!= "" ){%>
							value="<%=searchVO.getSearchKeyword()%>"	<%}%>
					class="ct_input_g" style="width:200px; height:20px" 
					onkeypress="if(event.keyCode==13) {javascript:fncGetProductList('1');}" >
		</td>
		
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList('1');">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >��ü <%= total%> �Ǽ�, ���� <%=currentPage %> ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�������</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">��������</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�������</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	
	<%	
		int no=list.size();
		for(int i=0; i<list.size(); i++) {
			ProductVO vo = (ProductVO)list.get(i);	
	%>		
	<tr class="ct_list_pop">
		<td align="center"><%=no--%></td>
		<td></td>				
		<td align="center">
			<a href="/getProduct.do?prodNo=<%=vo.getProdNo() %>&menu=<%=request.getParameter("menu")%>"><%= vo.getProdName()%></a>
		</td>		
		<td></td>
		<td align="center"><%= vo.getPrice() %></td>
		<td></td>
		<td align="center"><%= vo.getRegDate() %></td>
		<td></td>
		<td align="center"><%= vo.getManuDate() %></td>
		<td></td>
		<td align="center">
		<%if(vo.getProTranCode().equals("000")){%>
					�Ǹ���
		<%}else if(vo.getProTranCode().equals("111")){%>
					���ſϷ�
		<%}else{%>
					������					
		<%}%>
		<%if(request.getParameter("menu").equals("manage") & vo.getProTranCode().equals("111")) { %>
		--><a href="/updateTranCode.do?prodNo=<%=vo.getProdNo()%>&page=<%=currentPage%>&menu=<%=request.getParameter("menu")%>">����ϱ�</a>
		<%}%>			
		</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	<%} %>	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
		<%if(searchVO.getSearchCondition() == null && searchVO.getSearchKeyword() == null){%>
			<%for(int i=1;i<=totalPage;i++){%>							
				<a href="/listProduct.do?page=<%=i%>&menu=<%=request.getParameter("menu")%>"><%=i%></a>
			<%}%>
		<%}else{%>
			<%for(int i=1;i<=totalPage;i++){%>							
				<a href="/listProduct.do?page=<%=i%>&menu=<%=request.getParameter("menu")%>&searchCondition=<%=request.getParameter("searchCondition")%>&searchKeyword=<%=request.getParameter("searchKeyword")%>"><%=i%></a>
			<%}%>
		<%}%>
				
    	</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>
    