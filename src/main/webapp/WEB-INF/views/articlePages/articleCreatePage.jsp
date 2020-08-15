<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/commonPages/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 생성</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
<script type="text/javascript">
$(document).ready(function() {
	  $('#content').summernote({
	    	placeholder: '내용',
	    	height: 300,
	        minHeight: null,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
});

function check_form(){
	var inputForm_content = $("#content").val().replace(/\s|/gi,'');
	
	if(inputForm_content==""){
		alert("내용을 입력해주세요.");
		$("#content").val("");
		$("#content").focus();
		return false;
	}
	
	var requestArticleCreateDto = {
			title : $("#title").val(),
			content : $("#content").val(),
		}
	
	$.ajax({
		url:"/article",
		type:"post",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(requestArticleCreateDto),
		success:function(data){
			location.href = "/article/"+data;
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			if(code =='C004'){
				console.log(code +" : "+jsonValue.message);
				alert(jsonValue.message);
				history.back();
			}
		}
	});
}
</script>

<body>
<div class="container" style="margin-top: 50px">
	<div class="form">
		<h2>게시글 작성</h2>
			<table class="table table-bordered">
				<tr>
					<td><input id="title" name="title" type="text" class="form-control" placeholder="제목" maxlength="50"></td>
				</tr>
				<tr>
					<td><textarea id="content" name="content"></textarea>
				</tr>
			</table>
		<div style="float: right">
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="취소" onclick="location.href='/articles'">
				<input type="button" class="btn btn-primary" value="작성" onclick="check_form();">
			</div>
		</div>
	</div>
</div>
</body>
</html>