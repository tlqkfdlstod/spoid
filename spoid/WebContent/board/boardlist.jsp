<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">


<title>Insert title here</title>
<style type="text/css">
	p,h2{margin : 0;}
	th,td{height: 30px;}
	#blist_body{
		margin-top: 110px;
	}
	#blist_wrapper{
		width : 80%;
		margin: 110px auto;

	}
	.blist_header{
		height : 50px;
		border-bottom: 3px solid #0e4754;
	}
	.blist_header > div{ display: inline-block;}

	.blist_title *{
		line-height: 50px;
	}
	.blist_title *,.bl_bottom *{ display: inline-block;}
	.bl_category{margin-top: 10px;}
	.bl_category > ul > li{
		display: inline-block;
	}
	.bl_category > ul > li >a{
		border-radius : 5px;
		display : inline-block;
		height: 30px;
		vertical-align : middle;
		padding : 5px;
		border : none;
		cursor: pointer;
		color:black;
	}
	.bl_category > ul > li >button:hover{background-color: #30a1c0;}
	.c_active{
		background-color: #30a1c0;
		color:white;
	}

	.bl_tab{
		width : 100%;
		border-collapse: collapse;
		
	}

	.bl_tab > thead th{
		
		background-color: rgb(249, 249, 247);
	}
	.bl_tab > tbody{
		text-align: left;
	}
	.bl_tab  th,.bl_tab td{
    	border-bottom: 1px solid #cccccc;
    	padding : 10px;
    	height: 30px;
    	overflow: hiddent;

  	}
  	.bl_tab td:not(.bl_title_td){
  		text-align: center;
  	}
  	.comments_num{
  		color : red;
  	}
	.clr_both{clear:both;}
	.bl_search_area{
		margin-top : 10px;
		float : right;
		display: inline-block;
		height: 30px;
	}
	.bl_s_a_wrap{
		position: relative;
	}
	.bl_search_sel{

		height : 30px;
		line-height:30px;
		border :3px solid #0e4754;
		box-sizing: border-box;
		vertical-align: middle;
	}
	#bl_search{
		border : 3px solid #0e4754;
		width : 300px;
		height: 30px;
		line-height: 30px;
		box-sizing: border-box;
		vertical-align: middle;
	}
	#bl_search_btn{
		background-color : #0e4754;
		height: 30px;
		line-height: 30px;
		color:white;
		border: none;
		width : 50px;
		position:absolute;
		vertical-align: middle;
		top : 0px;
		right : 0px;
		display: inline-block;
		text-align: center;
		
	}
	.order_area{
		text-align: right;
	}
	#order_sel{
		margin : 10px;
		width : 80px;
		height: 30px;
		line-height: 30px;
		
	}
	#write_btn{
		display: inline-block;
		float : left;
		color : white;
		background-color : #0e4754;
		width : 80px;
		height: 30px;
		text-align: center;
		line-height: 30px;
		margin-top: 10px;
		
	}
	.pagination_area{text-align: center;}
	.pagination {
 		display:inline-block;
   	 	margin: auto;
 
	}
	.pagination a {
	    color: black;
	    float: left;
	    padding: 8px 16px;
	    text-decoration: none;
	    transition: background-color .3s;
	    border-radius:10px;
	}
	
	.pagination a.active {
	    background-color:  #0e4754;
	    color: white;
	}
	.pagination a:hover:not(.active) {background-color: #ddd;}
	.bl_title{color:black;}

	
	.bl_title_td{text-align: left;}
	.new_time{
		border-radius:5px;
		color:white;
		background-color: orange;
		padding : 2px;
	}
	.search_result{
		text-align: center;
		color:red;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		$(".cat_btn[data-cat=${category}]").addClass("c_active");
		$("#order_sel").val("${code}");
		if("${flag}==null"){
			$(".bl_search_sel").val("1");

		}else{
			$(".bl_search_sel").val("${flag}");
		}
		
		$("#bl_search").val("${keyword}");
		
	});
	$(document).on("click","#bl_search_btn", function () {
		var flag = $(".bl_search_sel").val();
		var keyword = $("#bl_search").val();
		var category = $(".c_active").attr("data-cat");
		location.href="boardList.spoid?flag="+flag+"&keyword="+keyword+"&category="+category;
		
	});

	$(document).on("change","#order_sel",function(){
		var flag = $(".bl_search_sel").val();
		var keyword = $("#bl_search").val();
		
		var key = $(this).val();
		var category = $(".c_active").attr("data-cat");
		location.href = "boardList.spoid?flag="+flag+"&keyword="+keyword+"&key="+key+"&category="+category;
	});
	$(document).on("click",".cat_btn",function(){
		var key = $("#order_sel").val()
		var flag = $(".bl_search_sel").val();
		var keyword = $("#bl_search").val();
		var category = $(this).attr("data-cat");
		$(".c_active").removeClass("c_active");
		$(this).addClass("c_active");
		location.href = "boardList.spoid?flag="+flag+"&keyword="+keyword+"&key="+key+"&category="+category;
	});
</script>
</head>
<body id="blist_body">
	<div id="blist_wrapper">
		<form class="blist_frm">
		<div class="blist_header">
			<div class="blist_title">
				<h2>자유게시판</h2>
				<p>|자유게시판 입니다.</p>
			</div>
		</div>
		<div class="bl_category">
				<ul>
					<li><a href = "#" class="cat_btn" data-cat = "0">전체</a></li>
					<li><a href = "#" class="cat_btn" data-cat = "review">리뷰</a></li>
					<li><a href = "#" class="cat_btn" data-cat ="free">잡담</a></li>
				</ul>
				<div class="clr_both"></div>
		</div>
		<div class="order_area">
				<select id="order_sel">
					<option id="orderNew" value="new" selected="selected">최신순</option>
					<option id="orderReply" value="reply">댓글순</option>
					<option id="orderGood" value="good">좋아요순</option>
					<option id="orderCnt" value="cnt">조회순</option>		
				</select>
	   </div>
				
		<div class="bl_contents">
			<table class="bl_tab">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">카테고리</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">날짜</th>
						<th scope="col">조회</th>
						<th scope="col">좋아요</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${boardList}" var="bDto">
				 	<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today2"/>
					<fmt:formatDate value="${bDto.regdate}" pattern="yyyy-MM-dd" var="regdate2"/>
					<tr>
						<td width ="100" class="bl_num_td">${bDto.bno}</td>
						<td width = "150" class="bl_cate_td">${bDto.category}</td>
						<td width = "600" class="bl_title_td">
							<a href="boardviewcnt.spoid?bno=${bDto.bno}" class="bl_title">${bDto.title}</a>
							<c:if test="${today2==regdate2}">
								<span class="new_time">New</span>
								
							</c:if>
							<c:choose>
								<c:when test="${bDto.filesize>0}"><i class="far fa-image"></i></c:when>
							</c:choose><a href="#" class="comments_num">${bDto.replycnt}</a>
						</td>
						<td width = "150" class="bl_writer_td">${bDto.writer}</td>
						<td width = "150" class="bl_date_td">

							<c:choose>
								<c:when test="${today2==regdate2}">
									<fmt:formatDate pattern="HH:mm:ss" value="${bDto.regdate}"/>
								</c:when>
								<c:otherwise>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${bDto.regdate}"/>
								</c:otherwise>
							</c:choose>

						</td>
						<td class="bl_view_td">${bDto.viewcnt}</td>
						<td class="bl_like_td">${bDto.goodcnt}</td>
					</tr>					
				</c:forEach>
				</tbody>
			
			</table>
		
		</div>
		<div class="bl_bottom">
			<div class="bl_write_area">
				<c:if test="${not empty sessionScope.loginUser.id}">
					<a href="boardInsert.spoid" id="write_btn"><i class="fas fa-pen"></i> 글쓰기</a>	
				</c:if>
					
			</div>

		
			<div class="bl_search_area">
				<div class="bl_s_a_wrap">
					<select class="bl_search_sel" name="bl_search_sel">
						<option value = "1" selected="selected">제목+내용</option>
						<option value = "2">제목</option>
						<option value = "3">내용</option>
						<option value = "4">글쓴이</option>
					</select>
					<input type="text" id="bl_search" name="bl_search">
					<a href="#"id="bl_search_btn">검색</a>
				</div>
			</div>
			<div class="clr_both"></div>
		</div>
		<c:if test="${not empty flag && not empty keyword}">
				<div class="search_result">
					${keyword}에 대한 검색 결과가 총 ${pageMaker.totalCount}개 나왔습니다.	
				</div>
		</c:if>
		<div class="pagination_area">
			<div class="pagination">
				<c:if test="${pageMaker.prev}">
					<a href="boardList.spoid?page=${pageMaker.startPage-1}">&laquo;</a>
					<a href="boardList.spoid?page=1">1</a>
					<a href="#">...</a>
					
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					<a href="boardList.spoid?page=${idx}&flag=${flag}&keyword=${keyword}&key=${code}&category=${category}" <c:out value="${pageMaker.criDto.page==idx?'class=active':''}"/>>${idx}</a>
			  	</c:forEach>
			  	<c:if test="${pageMaker.next}">
			  		<a href="#">...</a>
			  		<a href="boardList.spoid?page=${pageMaker.finalPage}">${pageMaker.finalPage}</a>
			  		<a href="boardList.spoid?page=${pageMaker.endPage+1}">&raquo;</a>
			  		
			  	</c:if>

			  <div class="clr_both"></div>
			</div>
		</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../include/footer.jsp" %>