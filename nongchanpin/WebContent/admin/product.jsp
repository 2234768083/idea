<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.dao.CommonDAO"%>
<%@page import="com.util.Info"%>
<%@page import="com.util.PageManager"%>
<%@page import="com.model.Product"%>
<%@page import="com.model.Protype"%>
<%@page import="com.model.Kcrecord"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>农产品电商服务平台后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<LINK href="/nongchanpin/admin/css/test.css" rel=stylesheet>
	<script language = "JavaScript" src = "/nongchanpin/admin/js/test.js"></script>
  </head>
  <%        
  CommonDAO dao = (CommonDAO)Info.getDao(request,"CommonDAO");
  String hql = " from Product where  delstatus=0 ";
  String url ="/nongchanpin/admin/product.jsp?1=1"; 
  String key = request.getParameter("key")==null?"":request.getParameter("key");
  String f = request.getParameter("f");
  if(f==null)
  {
  key = Info.getUTFStr(key);
  }
  if(!key.equals(""))
  {
  hql+=" and (proname like'%"+key+"%'  )";
  url+="&key="+key;
  }
  hql+="  order by id desc"; %>
  <body onLoad="MM_preloadImages('/nongchanpin/admin/images/index_on.gif','/nongchanpin/admin/images/reg_on.gif','/nongchanpin/admin/images/order_on.gif','/nongchanpin/admin/images/top/topxmas/jp_on.gif','/nongchanpin/admin/images/top/topxmas/download_on.gif','/nongchanpin/admin/images/top/topxmas/bbs_on.gif','/nongchanpin/admin/images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
        <jsp:include page="top.jsp"></jsp:include>
        
        <form action="/nongchanpin/admin/product.jsp?f=f" name="f1" method="post">
        <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="/nongchanpin/admin/images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>电子商务门户</a> →商品管理
					<img border="0" src="/nongchanpin/admin/images/dog.gif" width="19" height="18">
					欢迎<font color="red"></font>光临！
                </td>
                </tr>
		</table>
              <br>
        <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle align=right>
                 商品名称：<input type="text" id="key" name="key" value="<%=key %>"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="搜索"/>
                 &nbsp;&nbsp;<input type="button" value="新增" onclick="add()">
                </td>
                </tr>
		</table>
		
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>商品编号</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>图片</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>商品名称</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>所属类别</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>特价</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>库存</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>品牌</b></font></td>
			<td valign=middle align=center height=25 background="/nongchanpin/admin/images/bg2.gif" ><font color="#ffffff"><b>操作</b></font></td>
		</tr>
        <%
        PageManager pageManager = PageManager.getPage("/nongchanpin/admin/product.jsp?1=1",10, request);
	    pageManager.doList(hql);
	    PageManager bean= (PageManager)request.getAttribute("page");
	    ArrayList<Product> list=( ArrayList<Product>)bean.getCollection(); 
	   
	   	int i=0;
	    for(Product product :list)
	    {
	    	i++;
        %>
		<tr>
			<td class=tablebody2 valign=middle align=center width=""><%=i %></td>
			<td class=tablebody1 valign=middle align=center width=""><%=product.getProno() %></td>
			<td class=tablebody1 valign=middle align=center width=""><img src="/nongchanpin/upfile/<%=product.getImg() %>" width="60" height="60"></td>
			<td class=tablebody1 valign=middle align=center width=""><%=product.getProname() %></td>
			<td class=tablebody1 valign=middle align=center width="">
			<%Protype protype = (Protype)dao.findById(product.getProtype(),"Protype"); %>
			<%=protype.getTypename() %>
			</td>
			<td class=tablebody1 valign=middle align=center width=""><%=product.getPrice() %>元</td>
			<td class=tablebody1 valign=middle align=center width="">
			<%if(product.getField7().equals("yes")){ %>
				<%=product.getField8() %> 元 <a href="productQxTj.action?id=<%=product.getId() %>">取消特价</a>
			<%}else{ %>
			<a href="javascript:settj(<%=product.getId() %>)">设置特价</a>
			<%} %>
			</td>
			<td class=tablebody1 valign=middle align=center width="">
			<%
			ArrayList<Kcrecord> inlist = (ArrayList<Kcrecord>)dao.findByHql("  from Kcrecord where productid='"+product.getId()+"' and type='in' ");
			ArrayList<Kcrecord> outlist = (ArrayList<Kcrecord>)dao.findByHql("  from Kcrecord where productid='"+product.getId()+"' and type='out' ");
			int kc;
			if(inlist.size()!=0){
			int innum = 0;
			int outnum = 0;
			for(Kcrecord in:inlist){
				innum+=Integer.parseInt(in.getNum());
			}
			for(Kcrecord kout:outlist){
				outnum+=Integer.parseInt(kout.getNum());
			}
			kc = innum-outnum;
			}else{
				kc = 0;
			}
			%>
			<%=kc %>
			<a href="javascript:rk(<%=product.getId() %>)"> 入库</a></td>
			<td class=tablebody1 valign=middle align=center width=""><%=product.getField1() %></td>
			<td class=tablebody1 valign=middle align=center width=""><a href="javascript:edit(<%=product.getId() %>)">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="productDel.action?id=<%=product.getId() %>">删除</a></td>
		</tr>
        <%} %>     
		</table>
		<br>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
			<tr>
			<td height=25 valign=middle align=middle>${page.info }</td>
	        </tr>
		</table>
		</form>
        <jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
<SCRIPT language=javascript src="/nongchanpin/commfiles/js/popup.js"></SCRIPT>
<script type="text/javascript">
	function add()
	{
		pop("/nongchanpin/admin/productadd.jsp","新增商品",800,450);
	}
	function edit(id)
	{
		pop("/nongchanpin/admin/productedit.jsp?id="+id,"编辑商品",800,450);
	}
	function settj(id){
		pop("/nongchanpin/admin/productsettj.jsp?id="+id,"设置特价",300,100);
	}
	function rk(id){
		pop("/nongchanpin/admin/productrk.jsp?id="+id,"入库",300,100);
	}
</script>