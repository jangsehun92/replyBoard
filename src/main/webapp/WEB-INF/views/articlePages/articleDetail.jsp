<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/commonPages/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	replyList("${responseArticleDto.id}");
});

function articleDeleteConfirm(id){
	if(confirm("글을 삭제하시겠습니까?")){
		articleDelete(id);
	}else{
		return;
	}
}

// 게시글 삭제
function articleDelete(id){
	
	$.ajax({
		url:"/article/"+id,
		type:"delete",
		contentType : "application/json; charset=UTF-8",
		success:function(data){
			location.href="/";
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			console.log("errorCode : " + code);
			alert(jsonValue.message);
		}
	});
	
}

// 댓글 리스트 불러오기
function replyList(id){
	$.ajax({
		url:"/replys/${responseArticleDto.id}",
		type:"GET",
		contentType : "application/json; charset=UTF-8",
		dataType: "JSON",
		success:function(data){
			$("#replyList").empty();
			$("#replyContent").val("");
			var html = "";
			if(data.length == 0){
				$("#replyList").append(
					"<li class='list-group-item'>"+
						"<div>"+
							"<div>"+
								"<div>"+
									"<div id='replyForm'>"+
										"<span>댓글이 없습니다.</span>"+
									"</div>"+
								"</div>"+
							"</div>"+
						"</div>"+
					"</li>"
				);
			}
			$.each(data, function(index, value) {
				html += "<li class='list-group-item'>"+
							 "<div style='position: relative; height: 100%'>"+
							  	"<div>"+
									"<div>";
								if(value.depth != 0){
									html +=	"<span style='margin-left:8px'>ㄴ익명</span><span class='text-muted'> | <small>"+uxin_timestamp(value.regdate)+" 작성</small></span>";
									if(value.enabled != 0){
										html +=	"<div id='dropdownForm-"+value.id+"' style='float: right;'>"+
														"<a onClick='replyUpdateForm("+value.id+")'>수정</a> ᛫ "+
														"<a onClick='deleteConfirm("+value.id+")'>삭제</a>";
									}
									html +=	"</div>"+
												"<div id='replyForm-"+value.id+"' style='white-space : pre-wrap;height: 100%'>"+
													"<p id='reply-"+value.id+"' style='margin-left:20px'>"+value.content+"</p>"+
												"</div>"+
											"</div>";	
								}else{
									html +=	"<span>익명</span><span class='text-muted'> | <small>"+uxin_timestamp(value.regdate)+" 작성</small></span>";
									if(value.enabled != 0){
										html +=	"<div id='dropdownForm-"+value.id+"' style='float: right;'>"+
														"<a onClick='replyToReplyForm("+value.id+")'>답글</a> ᛫ "+
														"<a onClick='replyUpdateForm("+value.id+")'>수정</a> ᛫ "+
														"<a onClick='deleteConfirm("+value.id+")'>삭제</a>";
									}
									html +=	"</div>"+
												"<div id='replyForm-"+value.id+"' style='white-space : pre-wrap;height: 100%'>"+
													"<p id='reply-"+value.id+"'>"+value.content+"</p>"+
												"</div>"+
											"</div>";
								}
									
								html += 
									/* "</div>"+
											"<div id='replyForm-"+value.id+"' style='white-space : pre-wrap;height: 100%'>"+
												"<p id='reply-"+value.id+"'>"+value.content+"</p>"+
											"</div>"+
									"</div>"+ */
									"<div id='updateForm-"+value.id+"' style='display: none;'>"+
										"<form method='post' action='/reply/"+value.id+"' onsubmit='return replyUpdate("+value.id+");'>"+
											"<input type='hidden' name='_method' value='PUT'>"+
											"<textarea id='replyContent-"+value.id+"' name='content' class='form-control z-depth-1' rows='3' maxlength='1000' placeholder='댓글을 입력해주세요.'>"+value.content+"</textarea>"+
											"<input type='submit' style='width:50%' class='btn btn-success' value='수정'>"+
											"<input type='button' style='width:50%' class='btn btn-primary' value='취소' onclick='replyForm("+value.id+")'>"+
											"</form>"+
									"</div>"+
										"<div id='replyToReplyForm-"+value.id+"' style='display: none;'>"+
										"<form method='post' action='/reply' onsubmit='return replyToReply("+value.id+","+value.replyGroup+");'>"+
											"<textarea id='replyToReply-"+value.id+"' name='content' class='form-control z-depth-1' rows='3' maxlength='1000' placeholder='답글을 입력해주세요.'></textarea>"+
											"<input type='submit' style='width:50%' class='btn btn-success' value='입력'>"+
											"<input type='button' style='width:50%' class='btn btn-primary' value='취소' onclick='replyForm("+value.id+")'>"+
											"</form>"+
										"</div>"+
								"</div>"+
							"</div>"+
						"</li>";
				document.getElementById('replyList').innerHTML = html;
			});
		},
		error:function(request,status,error){
			alert("code:"+request.status+"\n\n"+"message:"+request.responseText+"\n\n"+"error:"+error);
		}
	});
	return false;
}


//댓글 폼 컨트롤
function replyForm(id){
	var dropdownForm = $("#dropdownForm-"+id);
	var replyForm = $("#replyForm-"+id);
	var updateForm = $("#updateForm-"+id);
	var replyToReplyForm = $("#replyToReplyForm-"+id);
	
	replyForm.show();
	dropdownForm.show();
	updateForm.hide();
	replyToReplyForm.hide();
	$("#replyForm-"+id).focus();
}

//대댓글 폼 요청
function replyToReplyForm(id){
	alert(id);
	var dropdownForm = $("#dropdownForm-"+id);
	var replyForm = $("#replyForm-"+id);
	var updateForm = $("#updateForm-"+id);
	var replyToReplyForm = $("#replyToReplyForm-"+id);
	
	$("#replyToReply-"+id).val("");
	replyForm.show();
	dropdownForm.hide();
	updateForm.hide();
	replyToReplyForm.show();
	$("#replyToReply-"+id).focus();
}

// 댓글 업데이트 폼 요청
function replyUpdateForm(id){
	var dropdownForm = $("#dropdownForm-"+id);
	var replyForm = $("#replyForm-"+id);
	var updateForm = $("#updateForm-"+id);
	var replyToReplyForm = $("#replyToReplyForm-"+id);
	
	$("#replyContent-"+id).val($("#reply-"+id).text());
	replyForm.hide();
	dropdownForm.hide();
	replyToReplyForm.hide();
	updateForm.show();
	$("#replyContent-"+id).focus();
}

//댓글 입력
function replyCreate(){
	var content = $("#replyContent").val().replace(/\s|/gi,'');
	
	if(content==""){
		alert("댓글을 입력해주세요.");
		$("#replyContent").val("");
		$("#replyContent").focus();
		return false;
	}
	
	var requestReplyCreateDto = {
			articleId : "${responseArticleDto.id}",
			replyGroup : 0,
			content : $("#replyContent").val()
	}
	
	$.ajax({
		url:"/reply",
		type:"post",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(requestReplyCreateDto), 
		
		success:function(data){
			replyList("${responseArticleDto.id}");
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			console.log("errorCode : " + code);
			alert(jsonValue.message);
		}
	});
	return false;
}

//대댓글 입력 
function replyToReply(id,replyGroup){
	var content = $("#replyToReply-"+id).val().replace(/\s|/gi,'');
	
	if(content==""){
		alert("댓글을 입력해주세요.");
		$("#replyContent").val("");
		$("#replyContent").focus();
		return false;
	}
	
	var requestReplyCreateDto = {
			articleId : "${responseArticleDto.id}",
			replyGroup : replyGroup,
			content : content
	}
	
	$.ajax({
		url:"/reply",
		type:"post",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(requestReplyCreateDto), 
		success:function(data){
			replyList("${responseArticleDto.id}");
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			console.log("errorCode : " + code);
			alert(jsonValue.message);
		}
	});
	return false;
}

// 댓글 업데이트 
function replyUpdate(id){
	
	var requestReplyUpdateDto = {
		id : id,
		articleId : "${responseArticleDto.id}",	
		content : $("#replyContent-"+id).val()
	}
	
	$.ajax({
		url:"/reply/"+id,
		type:"patch",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(requestReplyUpdateDto), 
		success:function(data){
			replyList("${responseArticleDto.id}");
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			console.log("errorCode : " + code);
			alert(jsonValue.message);
		}
	});
	return false;
}

function deleteConfirm(id){
	if(confirm("댓글을 삭제하시겠습니까?")){
		replyDelete(id);
	}else{
		return;
	}
}

// 댓글 삭제 
function replyDelete(id){
	var requestReplyDeleteDto = {
		id : id
	}
	
	$.ajax({
		url:"/reply/"+id,
		type:"delete",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(requestReplyDeleteDto),
		success:function(data){
			alert("댓글이 삭제되었습니다.");
			replyList("${responseArticleDto.id}");
		},
		error:function(request,status,error){
			jsonValue = jQuery.parseJSON(request.responseText);
			code = jsonValue.code;
			console.log("errorCode : " + code);
			alert(jsonValue.message);
		}
	});
	return false;
}

function uxin_timestamp(time){
	var date = new Date(time);
	var year = date.getFullYear();
	var month = "0" + (date.getMonth()+1);
	var day = "0" + date.getDate();
	var hour = "0" + date.getHours();
	var minute = "0" + date.getMinutes();
	//var second = "0" + date.getSeconds();
	return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2);
}

function listConfirm(id){
	if(confirm("새로고침 하시겠습니까?")){
		replyList(id);
	}else{
		return;
	}
}
</script>
<body>
<div id="container" class="container" style="margin-top: 50px">
	<div class="header">
		<h2>글보기</h2>
		<hr>
			<ul class="list-group">
				<li class="list-group-item">
					<div class="title">
						<h3>${responseArticleDto.title }</h3>
					</div>
					<div class="row" >
						<div class="col-md-4" style="float: left">
							<span>${responseArticleDto.writer } </span> 
							<span style="margin-left: 10px"><small><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${responseArticleDto.regdate }"/> 작성 </small></span>
						</div>
						<div style="float: right">
							<small >댓글<span id = "replyCount" style="margin-right: 10px">${responseArticleDto.replyCount }</span> </small>
						</div>
					</div>
				</li>
				<li class="list-group-item">
					<div>
						<div id="board_content" style="white-space : pre-wrap;height: 100%">${responseArticleDto.content }</div>
					</div>
				</li>
			</ul>
			<div class="row" style="margin-left: 0px; margin-right: 0px">
					<div style="float: left">
						<div class="btn-group">
<!-- 글 수정,삭제 버튼 -->
								<input type="button" class="btn btn-primary" value="수정" onclick="location.href='/article/edit/${responseArticleDto.id}';">
								<input type="button" class="btn btn-primary" value="삭제" onclick="articleDeleteConfirm(${responseArticleDto.id});" >
						</div>
					</div>
			</div>
		<hr >
<!-- 댓글 입력란 -->
			<div class="form-group shadow-textarea">
					<label>댓글</label>
						<div style="position: relative; height: 100%">
							<div>
								<form method="post" action="/reply" onsubmit="return replyCreate();">
									<textarea id="replyContent" name="content" class="form-control z-depth-1" rows="3" maxlength="1000" placeholder="댓글을 입력해주세요."></textarea>
									<input type="submit" class="btn btn-default" style="width:100%;" value="작성">
								</form>
							</div>
						</div>
			</div>
<!-- 새로고침(댓글) -->			
			<hr>
				<input type="button" class="btn btn-default" value="새로고침" onclick="listConfirm(${responseArticleDto.id});">
<!-- 댓글 리스트 -->
			<div>
				<ul class="list-group" id="replyList">
					
				</ul>
			</div>
	</div>
</div>
</body>
</html>