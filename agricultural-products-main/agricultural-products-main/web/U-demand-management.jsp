<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.MessageBoardData" %>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>
<jsp:useBean id="dataBeanlongin" class="javabean.longinJavabean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<style>
*{
	margin:0px;padding:0px;/*默认是指网页上所有的元素的margin和padding值为0*/
}
body{
	/*background-image: url('img/body.jpg');*/
	background-image: url('img/farm.jpg');
	background-size:100%;

	overflow:auto;/*如果内容被修剪，则浏览器会显示滚动条以便查看其余的内容。*//*这个属性最好只个body或者相对小级子元素，像home里一样，若是auto，下拉框在超出div时可能无法实现*/
}
.main{
	overflow:visible;/*	默认值。内容不会被修剪，会呈现在元素框之外。*/
/*	width:1549.71px;/*如果这里还是应用的body默认的网页打开的实时宽度，相当于width不定，会因为父元素的width不定，使在页面变小时，后续子元素变形*/
	/*min-width:1500px;*/
	width:100%;
}

/*table*/
.show{
	margin-top:100px;
	margin-left:5%;
	width:90%;
	background-color:#f9f9f9;
}
.show table{
	width:100%;
	/*margin-left:15%;*/
	border-style:groove;
}
.show table tr{

}
.show table tr th{
	height:50px;
	border-style:groove;	
}
.show table tr td{
	height:210px;
	border-style:groove;	
}
.show table tr td p{
	margin-left:15px;
	margin-top:15px;/*margin:上右下左*/
	/*line-height:70%;*//*段内文字间距*/
}

.th1{/*产品图片*/
	width:170px;
	height:50px;
	border-style:groove;
}
.th2{/*产品介绍*/
	width:300px;
	height:50px;
	border-style:groove;
}
.th3{/*产品附加*/
/*宽度未限制*/
	height:50px;
	border-style:groove;
}
.th4{/*功能*/
	width:100px;
	height:50px;
	border-style:groove;
}

.td-img{
	border-style:groove;
}
.td-img img{
	margin-left:5%;
	width:150px;
	height:150px;
}
.td-show{
	border-style:groove;
}
.td-show-number{
	color:red;
}
.td-showadd{
	border-style:groove;
}
.td-button{

}
</style>
<meta charset="UTF-8">
<title>产品</title>
</head>
<body>
<div class="main">
	<div class="Nva">
		<jsp:include page="Nva.jsp"/>
	</div>
	<div class="show">
	<!--  <img src="product/P1.png"/>-->
		<table>
		<tr>
			<th class="th1">编号</th>
			<th class="th2">摘要</th>
			<th class="th3">详细</th>
		</tr>
		<%
			CachedRowSetImpl rowSet=dataBeanlongin.getRowSetUDemand();
		
			//rowSet.beforeFirst();//将光标定位到结果集中第一行之前。
			while(rowSet.next()){//next();滚动参考resultset的方法
				out.print("<tr>");
				out.print("<td class='td-img'>");
				out.print("<p>求购编号:"+rowSet.getString(1)+"</p>");
				//out.print("<img src='"+"product/"+rowSet.getString(2)+"'>");
				out.print("</td>");
				//out.print("<td>"+rowSet.getString(2)+"</td>");
				out.print("<td class='td-show'>");
				out.print("<p>发布时间:"+rowSet.getString(2)+"</p>");
				out.print("<p>发布者:"+rowSet.getString(3)+"</p>");
				out.print("<p>发布摘要:"+rowSet.getString(4)+"</p>");
				out.print("</td>");
				out.print("<td class='td-showadd'>");		
				out.print("<p>发布要求:"+rowSet.getString(5)+"</p>");;
				//out.print("<td class='td-show-message'>");
				out.print("</td>");
				out.print("</tr>");
				
			}
			rowSet.close();
		%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		</table>

		</div>
</div>
</body>
</html>