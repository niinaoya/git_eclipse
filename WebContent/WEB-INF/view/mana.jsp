<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="dto.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	Post result = (Post)request.getAttribute("post");
	%>
	<input style="color: #000000; submit" style="background-color:  #ffffff; border: solid 1px #000000;" type="button" id="btn1" value="Topへ戻る">
    <%
	ArrayList<Post> Postlist = (ArrayList<Post>)request.getAttribute("list");
	for(int i = 0 ; i < Postlist.size() ; i++){
		Post post = Postlist.get(i);
	%>
		<%=post.getContent() %><br>
		投稿者:<%=post.getName() %>　
		投稿時間:<%=post.getTime() %>　
		編集時間:<%=post.getTime2() %>
	<%
	}
	%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
    $('#btn1').click(function(){
    	location.href = "http://localhost:8080/Bulletinboard1/main";
    });

});
</script>
</body>
</html>