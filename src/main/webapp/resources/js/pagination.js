$(function(){
	var page = $("#page").val();
	var totalPage = $("#totalPage").val();
	var startPage = $("#startPage").val(); 
	var endPage = $("#endPage").val(); 
	
	if((Number(startPage)) > 1){
		$("#pagination").append("<li class=''><a href='/articles?page=1' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	}else{
		$("#pagination").append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	}
	
	if((Number(page)) > 1){
		$("#pagination").append("<li class=''><a href='/articles?page="+(page-1)+"' aria-label='Previous'><span aria-hidden='true'>&lang;</span></a></li>");
	}else{
		$("#pagination").append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&lang;</span></a></li>");
	}
		
	for(var iCount = (Number(startPage)); iCount <= (Number(endPage)); iCount++) {
		if (iCount == (Number(page))) {
	       $("#pagination").append("<li class='active'><a href='#'>"+iCount+"<span class='sr-only'></span></a></li>");
	    } else {
	    	$("#pagination").append("<li class=''><a href='/articles?page="+iCount+"'>" + iCount + "<span class='sr-only'></span></a></li>");
	    }
	}
		
	if((Number(page)) < (Number(totalPage))){
		$("#pagination").append("<li class=''><a href='/articles?page="+(Number(page)+1)+"' aria-label='Next'><span aria-hidden='true'>&rang;</span></a></li>");
	}else{
		$("#pagination").append("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&rang;</span></a></li>");
	}
	
	if((Number(endPage)) < (Number(totalPage))){
		$("#pagination").append("<li class=''><a href='/articles?page="+totalPage+"' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	}else{
		$("#pagination").append("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	}
})