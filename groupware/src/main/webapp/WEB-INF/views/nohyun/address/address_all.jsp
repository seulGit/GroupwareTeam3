<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/address/address_all.css'/>" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
<script src="<c:url value='/resources/js/jquery-3.6.0.min.js'/>"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>JaeHee Group</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/intro.jsp"%>

	<div id="layoutSidenav_content">
		<div class="address_all_title_box">
			<span class="address_all_title">전사 주소록</span> <span
				class="address_all_next">in 공용 주소록(총<span>25</span>건)
			</span>
		</div>

		<div class="address_all_search">
			<div></div> <!-- input css로 공간 벌리려고 만들어둔 div -->
			<span><input type="text" placeholder="검색" class="keyword_search"><i
				class="xi-search"></i></span>
		</div>

		<div class="address_all_excel_sendout">
			<a href="<c:url value='/address_all/excelDown' />">EXCEL로 내보내기</a>
		</div>

		<div class="address_all_search_consonant">
			<a>전체</a> <a>ㄱ</a> <a>ㄴ</a> <a>ㄷ</a> <a>ㄹ</a> <a>ㅁ</a> <a>ㅂ</a>
			<a>ㅅ</a> <a>ㅇ</a> <a>ㅈ</a> <a>ㅊ</a> <a>ㅋ</a> <a>ㅌ</a> <a>ㅍ</a>
			<a>ㅎ</a> <a>a-z</a>
		</div>
		
		<div class="address_all_field_set">
			<div></div>
			<span> <i class="xi-cog"></i>필드설정 <select name="" id="">
					<option value="">20</option>
					<option value="">40</option>
					<option value="">60</option>

			</select>
			</span>
		</div>

		<table class="address_all_table">
			<tr class="address_all_table_title">
				<td>이름(표시명)</td>
				<td>직위</td>
				<td>휴대폰</td>
				<td>이메일</td>
				<td>부서</td>
				<td>회사전화</td>
				<td>주소</td>
			</tr>
			</table>
			
		<table class="address_all_list">
			<c:forEach var="row" items="${data}">
					<tr class="address_all_list_foreach">
						<td><i class="xi-user-o"></i>
						<a href="/address_all_info?emp_num=${row.emp_num}">${row.emp_name}</a></td>
						<td>${row.position_grade}</td>
						<td>${row.emp_phonenum}</td>
						<td>${row.emp_email}</td>
						<td>${row.dept_name}</td>
						<td>${row.emp_desk_num}</td>
						<td>${row.emp_address}</td>

					</tr>
			</c:forEach>
		</table>
		
		<!-- 하단 페이지 넘버  -->
		<div class="address_all_page_num_box">
			<div>
				<div class="address_all_page_num">
					<span class="address_all_disabled">&lt;&nbsp; 이전</span> <span
						class="address_all_current">1</span> <a href="#?page=2">2</a> <a
						href="#?page=3">3</a> <a href="#?page=4">4</a> <a href="#?page=5">5</a>
					<a href="#?page=6">6</a> <a href="#?page=7">7</a> <a
						href="#?page=7">8</a> <a href="#?page=7">9</a> <a href="#?page=7">10</a>
					<span class="address_all_disabled">다음 &nbsp;&gt;</span>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
		
	<script src="<c:url value='resources/js/address/address_all.js'/>"></script>
	<script src="<c:url value='resources/js/officemap.js'/>"></script>
</body>
</html>