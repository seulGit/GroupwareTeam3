<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String ctxPath = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>JaeHee Group</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"	rel="stylesheet" />
<link href="../resources/css/styles.css?ver=1" rel="stylesheet" />
<link href="../resources/css/message/message_write.css?ver=1" rel="stylesheet" />
<script src="../resources/js/jquery-3.6.0.min.js?ver=1"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf-8"
	src="../resources/api/smarteditor/libs/smarteditor/js/service/HuskyEZCreator.js"></script>

</head> 

<script>


</script>

<%@ include file="/WEB-INF/views/intro.jsp"%>
<div id="layoutSidenav_content">
	<div class="content_box">쪽지보기</div>
	<div id="message_write_container">
		<div class="top_btn">
			<div class="write_div_btn" id="writeSubmit" value="보내기"><a>답장 보내기</a></button>				
			<div class="write_div_btn">임시저장</div>
			<div class="write_div_btn" id="writeReset">다시쓰기</div>
		</div>
		<div class="message_write_insert_info">
			<table>
				<tr>
					<td class="message_td1">받는사람</td>
					<td class="message_td2"><input type="text" name="message_receiver2" id="message_receiver2" value=""></td>
					<td class="message_td3"><div class="write_div_btn message_btn-open-popup">주소록</div></td>
				</tr>
				<tr>
					<td class="message_td1">제목 <span><input type="checkbox" name="important" id="important">중요!</span></td>
					<td class="message_td2"><input type="text" name="message_title" id="message_title" value=""></td>
				</tr>
				<tr>
					<td class="message_td1">작성자</td>					
					<td class="message_td2"><input type="text" name="message_sender" id="message_sender" value="${sessionScope.emp_name}"></td>
				</tr>
				<tr>
					<td class="message_td1">첨부파일</td>
					<td class="message_td2"><input type="file" name="message_file_route" id="message_file_route" value=""></td>
				</tr>
			</table>
		</div>
		<div class="message_write_textarea">
			<textarea name="message_contents" id="message_contents" rows="1" cols="1" style="width: 100%;"></textarea>
		</div>
		<div class="bottom_btn">
			<button>예약발송</button>
		</div>
	</div>
</div>
</div>
<!-- 주소록 모달 시작 -->
<div class="message_modal">
	<div class="message_modal_body">
		<button class="modal_close">
			<i class="fa-solid fa-circle-xmark"></i>
		</button>
		<h1>쪽지쓰기 주소록</h1>
		<div id="searchBox">
			<form name="addSearchForm" action="/message/writeAddressSearch" method="POST">
				<select name="search_option" id="search_option">
					<option value="all"  <c:out value="${addSearchData.search_option == 'all' ? 'selected' : ''}"/>>전체</option>
					<option value="emp_name"  <c:out value="${addSearchData.search_option == 'emp_name' ? 'selected' : ''}"/>>사원명</option>
					<option value="emp_num"  <c:out value="${addSearchData.search_option == 'emp_num' ? 'selected' : ''}"/>>사원번호</option>
					
				</select> 
				<input type="text" name="keyword" id="messageAddressSearch"  value=""> 
				<input type="button" id="searchBtn" value="검색">
			</form>
		</div>
		<div class="modal_container">
			<div class="dept">
				<ul>
					<li><button class="dept_ajax" value="001">전략기획팀</button></li>
					<li><button class="dept_ajax" value="002">경영지원팀</button></li>
					<li><button class="dept_ajax" value="003">인사팀</button></li>
					<li><button class="dept_ajax" value="004">영업팀</button></li>
					<li><button class="dept_ajax" value="005">마켓팅팀</button></li>
					<li><button class="dept_ajax" value="006">IT팀</button></li>
				</ul>
			</div>
			<div id="modal_personal_info">
			


				<!-- 
				<table class="dept_right">
				<thead>
					<tr>
					<th style="width: 40px;"><input type="checkbox" name="checkAll" id="checkAll"></th>
					<th style="width: 35%;">부서</th>
					<th style="width: 15%;">직책</th>
					<th style="width: 20%;">이름</th>
					<th style="width: 30%;">사원코드</th>
					</tr>
				</thead>				
					<tbody id="messageAddressSearch">
                                <tr>
                                    <td id="dept1">전략기획</td>
                                    <td id="posion1">부장</td>
                                    <td id="name1">노현</td>
                                    <td id="code1">2208011</td>
                                </tr>
                                <tr>
                                    <td>전략기획</td>
                                    <td>부장</td>
                                    <td>노현</td>
                                    <td>2208011</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr> -->
			</div>
		</div>
		<div>
			<button type="reset" id="write_address_cancelCheck"
				class="write_div_btn">취소</button>
			<button type="submit" id="write_address_selectCheck"
				class="write_div_btn">확인</button>
		</div>
	</div>
</div>
<!-- 모달 끝 -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<!--     <script src="../resources/js/message_jquery.js"></script> -->
<script src="../resources/js/message/message_write.js?ver=1"></script>

<script>
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "message_contents",
			sSkinURI : "../resources/api/smarteditor/libs/smarteditor/SmartEditor2Skin.html",
			htParams : {
				bUseVerticalResizer : false, // 리사이즈 제거
			}, //boolean
				fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["message_contents"].exec("PASTE_CONTENTS_FIELD", []);
			},
				fCreator : "createSEditor2"
			});
		
			// ====== 다시쓰기 버튼 이벤트 ====== // 
			$("#writeReset").click(function() {
				oEditors.getById["message_contents"].exec("SET_IR", [""]); //내용초기화
			});
</script>

</body>

</html>