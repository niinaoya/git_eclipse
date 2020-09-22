<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/mvp.css">
    <title>Bulletinboard</title>
</head>
<body>

    <input style="color: #000000; submit" style="background-color:  #ffffff; border: solid 1px #000000;" type="button" id="btn1" value="管理画面へ">
    <form name="post" action="#">
        <p><label for="name">投稿者</label><br>
        <input type="text" name="name" id="name"></p>
        <p><label for="content">内容</label><br>
        <textarea name="content" id="content"></textarea></p>
		<p><input type="submit" value="投稿" id="postsubmit"></p>
	</form>
    <p id="double-bottom"></p>
    <div id="output_message"></div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
    $('#btn1').click(function(){
    	location.href = "/Bulletinboard1/mana";
    });

    $('#postsubmit').click(function(){
    	var content = document.getElementById("content").value;
    	var name = document.getElementById("name").value;
    	//var name = document.getElementById("name").value;
    	//var name = document.getElementById("name").value;
    	name = "投稿者:" + name;
    	document.getElementById("output_message").innerHTML = content;
        document.getElementById("output_message").innerHTML = name;
    });

    $('#double-bottom').css({
        "border-bottom": "double"
    });
    $('#name').css({
        "width": "280px"
    });
    $('#content').css({
        "width": "400px",
        "height": "180px"
    });
});
</script>
</body>
</html>