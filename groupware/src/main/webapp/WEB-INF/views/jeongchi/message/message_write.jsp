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
<!-- 220902 smart editor -->
// ====== 조직도에서 팀이름 클릭 했을때 ====== //
window.onload = function(){

    // ====== 보내기 버튼 클릭 이벤트 ====== // 
    $("#writeSubmit").click(function(){
		// ====== 유효성 검사 ====== //
	    // 받는사람
	    let receiver = $("#message_receiver").val().trim();
	    if(receiver == "") {
	    	alert("받는사람을 선택해주세요!");
	    	return false;
	    }
	    
	    // 제목
	    let subject = $("#message_title").val().trim();
	    if(subject == "") {
	    	alert("제목을 입력해주세요!");
	    	return false;
	    }	    
	    
	    // 작성자
	    let writer = $("#message_sender").val().trim();
	    if(writer == "") {
	    	alert("작성자를 입력해주세요!");
	    	return false;
	    }	    
	    
	    // 작성내용(SmartEditor 유효성 검사)
	    	
	
		if(document.getElementById("message_contents").value == null){
			alert("내용을 입력해주세요!");
			return false;
		};
	    oEditors.getById["message_contents"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		$("#form1").submit();
		return;
	    
	    // 중요! 체크박스가 선택되어있는지 아닌지 확인하자
//	    let note_important = 0;
	    
	//  if($("input[name=important]").prop("checked")) {
	 //   	// 중요 체크박스가 체크되어 있으면 
	 //   	note_importantVal = 1;
	  //  }
    	
    });
	
	// 팀명 클릭 시 ajax 
	
	$(".dept_ajax").each(function (){
	$(this).click(function () {
		
		// 검색어 비우기
		$("input#messageAddressSearch").val().trim();
		
		var dept_code = $(this).val();
		
		$.ajax({ 
			type: "GET",  						// DB를 가져옴
			url:"/message/writeAddress",  		// 해당주소에서
			data: {"dept_code" : dept_code},  	// {"dept_code" : dept_code} << 과 같은 형식의 데이터를
			dataType:"json",  					// 데이터 받는 형식
            success: function(data) {  			// 데이터 가져온거 성공했으면 
            									// data = 위에서 가져올 데이터
            	// console.log(fk_dept_no); .dept_ajax의  value값
	            writeAddressTable(data);
	            writeAddressChkBox();
			},
	        error: function(request, status, error){
	        	alert("실패했어");
			       // alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
			}
		});
	});
	});
	// ====== 팀명 클릭 시 ajax 끝 ====== // 
	
	// ====== 주소록 모달창 내에서 사원 검색하는 버튼 클릭(사원명 또는 부서 검색) ====== // 
	$("#searchBtn").click(function(){
        let keyword = $("input[name='keyword']").val();
        let search_option = $("#search_option").val();
        let params={"search_option":search_option, "keyword":keyword}
        console.log(search_option);
    	console.log(keyword);
    	console.log(params);
        $.ajax({
        	type: "POST",
            url : "/message/writeAddressSearch",	
            data : params,						// {"dept_code" : dept_code} << 과 같은 형식의 데이터를
			dataType : "json",
            success : function(data){

            	writeAddressTable(data);		// 주소 테이블  */
	            writeAddressChkBox();			// 체크박스 전체 선택 / 해제 기능  */
            },
	        error: function(request, status, error){
			    alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	        	console.log(data);
			}
        });

	});	
	// ====== 주소록 모달창 내에서 사원 검색하는 버튼 클릭(사원명 또는 부서 검색) ====== // 
	/* 	220920 김정치 주소 테이블 시작  */
	function writeAddressTable(data) {
        var output =
            "<table><thead><tr><th style=\"width: 40px;\"><input type=\"checkbox\" name=\"checkAll\" id=\"checkAll\">"+
            "</th><th style=\"width: 35%;\">부서</th><th style=\"width: 15%;\">직책</th><th style=\"width: 20%;\">이름</th><th style=\"width: 30%;\">사원코드</th></thead><tbody>";
          if(data.length > 0) {
              $.each(data, function(index, item){
              output +=
              "<tr class=\"receive_emp\"><td> " +
              "<input type=\"checkbox\" name=\"chkbox\" class=\"chkbox\">" +
              "</td><td>"+
              item.dept_name +
              "</td><td>" +
              item.position_grade +
              "</td><td>" +
              item.emp_name +
              "</td><td>" +
              item.emp_num +
              "</td></tr>";
          });
          output += "</tbody></table>";
          $("#modal_personal_info").html(output);
          $("table").addClass("dept_right");
          }
	}
	
    /* 	220920 김정치   체크박스 전체 선택 / 해제 기능  */
    function writeAddressChkBox() {
    	const chkBox = document.querySelectorAll(".chkbox"); // 체크박스 생성
    	const checkAll = document.querySelector("#checkAll"); // 전체 체크박스 생성
    	//체크박스 전체 선택 / 해제
    	var arrNum = [];
    	
    	checkAll.addEventListener('click', function(){    		
    		console.log(chkBox);
    	    if(checkAll.checked==true){
        	    for(let i=0; i<chkBox.length; i++){
            	chkBox[i].checked = true;
            	}
    	    } else if (checkAll.checked==false){
        	    for(let i=0; i<chkBox.length; i++){
            	chkBox[i].checked = false;
        	    console.log("체크 제거");
        	    arrNum = [];
        		}
        	}
    		// 쪽지 주소록에서 확인 버튼 누를 시 받는 사람으로 관련 내용 in
        	$("#write_address_selectCheck").click(function () {
    	    	let messageReceiver = document.querySelector("#message_receiver");
    	    	let arrNumJoin;
        	    for(let i=0; i<chkBox.length; i++){
        	    	if(chkBox[i].checked==true){
            	    let innerEmpnum = chkBox[i].parentNode.parentNode.childNodes[4].innerHTML;
                	console.log(innerEmpnum);
                	arrNum.push(innerEmpnum);
                	arrNumJoin = arrNum.join(", ");
        	    	}
            	}
    	    	messageReceiver.value = arrNumJoin;
        	    $(".message_modal").css("display", "none");		// 확인 버튼 클릭 시 모달 삭제
        	});
    	});
    	//체크박스 하나 해제 시 전체선택 체크박스 해제
    	for(let i=0; i<chkBox.length; i++){
    		chkBox[i].addEventListener('click', function(){   
    	    	const checked = document.querySelectorAll(".chkbox:checked");
        		if(chkBox.length == checked.length){
        			checkAll.checked = true;
        		} else {
        			checkAll.checked = false;
        		}
      		});
    	}; // 체크박스 전체 선택 / 해제 기능 끝    


    	// 2
	}
};

</script>

<%@ include file="/WEB-INF/views/intro.jsp"%>
<div id="layoutSidenav_content">
	<div class="content_box">쪽지쓰기</div>
	<div id="message_write_container">
		<form id="form1" name="form1" action="/send" method="POST">
			<div class="top_btn">
				<button class="write_div_btn" id="writeSubmit" value="보내기">보내기</button>
				<div class="write_div_btn">임시저장</div>
				<div class="write_div_btn" id="writeReset">다시쓰기</div>
			</div>
			<div class="message_write_insert_info">
				<table>
					<tr>
						<td class="message_td1">받는사람</td>
						<td class="message_td2"><input type="text" name="message_receiver" id="message_receiver" value=""></td>
						<td class="message_td3"><div class="write_div_btn message_btn-open-popup">주소록</div></td>
					</tr>
					<tr>
						<td class="message_td1">제목 <span><input type="checkbox" name="important" id="important">중요!</span></td>
						<td class="message_td2"><input type="text" name="message_title" id="message_title" value=""></td>
					</tr>
					<tr>
						<td class="message_td1">작성자</td>
						<td class="message_td2"><input type="text" name="message_sender" id="message_sender" value=""></td>
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
		</form>
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