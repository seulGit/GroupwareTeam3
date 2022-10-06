<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="../resources/css/styles.css?ver=1" rel="stylesheet" />
    <link href="../resources/css/message/message_send.css?ver=1" rel="stylesheet" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="../resources/js/jquery-3.6.0.min.js?ver=1"></script>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<script>
function list(page) {
	location.href = "message_receive?curPage=" + page;
}
window.onload = function(){
/* 	220920 김정치   체크박스 전체 선택 / 해제 기능  */
	sendWriteAddressChkBox();

	function sendWriteAddressChkBox() {
		let chkBox2 = document.querySelectorAll(".chkbox2"); // 체크박스 생성
		let checkAll2 = document.querySelector("#checkAll2"); // 전체 체크박스 생성    	
		//체크박스 전체 선택 / 해제    	
		checkAll2.addEventListener('click', function(){
		    if(checkAll2.checked==true){
    		    for(let i=0; i<chkBox2.length; i++){
        		chkBox2[i].checked = true;
        		}
		    } else if (checkAll2.checked==false){
    		    for(let i=0; i<chkBox2.length; i++){
        		chkBox2[i].checked = false;
    	    	console.log("체크 제거");
	    		}
    		}
		});
		//체크박스 하나 해제 시 전체선택 체크박스 해제
		for(let i=0; i<chkBox2.length; i++){
			chkBox2[i].addEventListener('click', function(){   
		    	const checked = document.querySelectorAll(".chkbox2:checked");
    			if(chkBox2.length == checked.length){
    				checkAll2.checked = true;
    			} else {
	    			checkAll2.checked = false;
    			}
  			});
		}; // 체크박스 전체 선택 / 해제 기능 끝    
	
		// 쪽지 주소록에서 확인 버튼 누를 시 받는 사람으로 관련 내용 in
	/*	$("#write_address_selectCheck").click(function () {
		    for(let i=0; i<chkBox.length; i++){
	    		if(chkBox[i].checked==true){
	    			let sendEmpNum = chkBox[i].parentNode.parentNode.childNodes[4].innerHTML;   // empNum 값 가져오기
	    			let sendEmpName = chkBox[i].parentNode.parentNode.childNodes[3].innerHTML;  // empName 값 가져오기
		    		SendEmpInfoObject[sendEmpNum] = sendEmpName;								// empNum : empName 객체화 시켜서 SendEmpInfoObject에 담기
    	    		console.log(SendEmpInfoObject);
        			arrNum = Object.keys(SendEmpInfoObject);
        			arrSet = Object.values(SendEmpInfoObject);// 객체의 키값만 가져오기
        			console.log(arrNum);
		    	}
    		}    	    
			console.log(SendEmpInfoObject);
	    	arrNumJoin = arrNum.join(", ");					// 조인으로 문자화 하기
	    	messageReceiver.value = arrNumJoin;
		    $(".message_modal").css("display", "none");		// 확인 버튼 클릭 시 모달 삭제
		}); */
	}

}


</script>
<%@ include file="/WEB-INF/views/intro.jsp" %>
<div id="layoutSidenav_content">
	<div class="content_box">받은 쪽지</div>
	<div id="message_send_container">
		<div class="message_send_table_position">
			<button>
				<i class="xi-trash"></i>삭제
			</button>
			<table class="message_send_table">
			<thead>
				<tr class="table_bg">
					<td><input type="checkbox" id="checkAll2"></td>
					<td><i class="xi-star"></i></td>
					<td><i class="xi-attachment"></i></td>
					<td>보낸사원id</td>
					<td>사원명</td>
					<td>제목</td>
					<td>날짜</td>
					<td>수신확인</td>
					<td>비고</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${messageMap.receiveMessageList}">
				<tr class="message_send_table_hover">
					<td><input type="checkbox" class="chkbox2"></td>
					<td><i class="xi-star"></i></td>
					<td><i class="xi-attachment"></i></td>
					<td>${row.message_sender2}</td>
					<td>${row.message_sender}</td>
					<td>${row.message_title}</td>
					<td>${row.message_datetime}</td>
					<td>${row.message_read}</td>
					<td>${row.message_type}</td>
				</tr>
				</c:forEach>
				<tr class="message_send_list_number">
            	<td colspan="9" align="center" class="message_send_list_n_menu">
               	<c:if test="${messageMap.page_info.curBlock > 1 }">
                	<a href="javascript:list('1')">[처음]</a>
                </c:if>
                <c:if test="${messageMap.page_info.curBlock > 1 }">
                    <a href="javascript:list('${messageMap.page_info.prevPage }')"><span class="message_send_disabled">< 이전</span></a>
                </c:if>
                <c:forEach var="num" begin="${messageMap.page_info.blockBegin}" end="${messageMap.page_info.blockEnd}">
                   <c:choose>
                      <c:when test="${num==messageMap.page_info.curPage}">
                         <span style="color:red">${num}</span>
                      </c:when>
                      <c:otherwise>
                         <a href="javascript:list('${num}')">${num}</a>
                      </c:otherwise>
                   </c:choose>
                </c:forEach>
                <c:if test="${messageMap.page_info.curBlock <= messageMap.page_info.totBlock}">
                   <a class="message_send_disabled" href="javascript:list('${messageMap.page_info.nextPage }')">[다음]</a>
                </c:if>
                <c:if test="${messageMap.page_info.curPage <= messageMap.page_info.totPage}">
                   <a href="javascript:list('${messageMap.page_info.totPage }')">[끝]</a>
                </c:if>
                </td>
            	</tr>
			</tbody>
			</table>
<!-- 			<div class="message_send_list_number">
				<div>
					<div class="message_send_list_n_menu">
						<span class="message_send_disabled">< 이전</span> <span
							class="message_send_current">1</span> <a href="#?page=2">2</a> <a
							href="#?page=3">3</a> <a href="#?page=4">4</a> <a href="#?page=5">5</a>
						<a href="#?page=6">6</a> <a href="#?page=7">7</a> <a
							href="#?page=7">8</a> <a href="#?page=7">9</a> <a href="#?page=7">10</a>
						<span class="message_send_disabled">다음 ></span>
					</div>
				</div>
			</div>   -->
			<!-- 검색 폼 영역 -->
			<div class="message_send_search">
				<select id='message_send_search_select'>
					<option value='A'>제목+내용</option>
					<option value='T'>제목</option>
					<option value='C'>내용</option>
				</select> <input type="text">
				<button>검색</button>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>