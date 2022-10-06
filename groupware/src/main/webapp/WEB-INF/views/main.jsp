<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" /> -->
    <link href="../resources/css/styles.css?ver=1" rel="stylesheet" />
    <link href="../resources/css/main.css?ver=1" rel="stylesheet" />
    <script src="../resources/js/jquery-3.6.0.min.js?ver=1"></script>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<script>

// 게시판
// 전체 게시판
window.onload = function(){
	
	var board_category_num = 0;
	
	let btnCon = document.querySelectorAll(".btnCon");
	
	for(let i=0; i<btnCon.length;i++){
		btnCon[i].addEventListener('click', function(){
			$(".btnCon").css('backgroundColor','#ffffff');
			this.style.backgroundColor = "#dadada";
		});
	}
	
	$.ajax({
		type: "GET",  						// DB를 가져옴
		url:"/mainView",
		data: {"board_category_num" : board_category_num},
		dataType:"json",
		success:function(data){
			
			mainBoardViewAjax(data);
		},
		error:function(request, status, error){
			alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
		}
		});
	
	
	$(".btnCon").each(function (){
	$(this).click(function () {
	
	
	var board_category_num = $(this).val();
	
	$.ajax({
		type: "GET",  						// DB를 가져옴
		url:"/mainAllBoardView",
		data: {"board_category_num" : board_category_num},
		dataType:"json",
		success:function(data){
			
			mainBoardViewAjax(data);
		},
		error:function(request, status, error){
			alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
		}
		});
	});
	});
	
	function mainBoardViewAjax(data) {
		
        var output =
            "<table><thead><tr><th style=\"width: 35%;\">제목</th><th style=\"width: 15%;\">작성자</th>"+
            "<th style=\"width: 20%;\">작성일</th></thead><tbody>";
        if(data.length > 0) {
            $.each(data, function(index, item){
            output +=
            "<tr class=\"receive_emp\"><td><a href=\"board_detail?board_num=" + 
            item.board_num + 
            "\">" +
            item.board_title +
            "</a></td><td>" +
            item.emp_name +
            "</td><td>" +
            item.board_write_date +
            "</td></tr>";
        	});
        output += "</tbody></table>";
        $("#mainBoardView").html(output);
        $("table").addClass("dept_down");
        }
	}
}

</script>


<%@ include file="/WEB-INF/views/intro.jsp" %>
        <div id="layoutSidenav_content">
            <div id="home_content_container">
                <div class="home_content homebox1">
                    <div class="home_personal_info">
                        <div class="home_personal_text">
                            <p class="home_personal_company">(주)JaeHee</p>
                            <p class="home_personal_company">${sessionScope.dept_name}</p>
                            <h1 class="home_personal_name">${sessionScope.emp_name} ${sessionScope.posion_grade}</h1>
                        </div>

                    </div>
                    <div class="home_personal_insert_info">
                        <a href="/message/write" class="home_meg_write">쪽지쓰기</a>
                        <a href="/address_personal" class="home_contact">연락처 추가</a>
                        <a href="/todo" class="home_calendar">ToDo+ 등록</a>
                        <a href="/board_write" class="home_board_write">게시글 작성</a>
                    </div>
                    <div class="home_worktime">
                        <h1 class="home_content_title">근태관리</h1>
                        <p class="home_worktime_time">2022년 09월 26일(월)</p>
                    </div>
                </div>
                <div class="home_content homebox2">
                    <div>
                        <h1 class="home_content_title">전사게시판 최근글</h1>
                        <div class="tabmenu">
                			<div>
                            <ul class="tabmenu_list">               
                                <li id="tab1" class="btnCon" value="">전체 </li>
								<li id="tab2" class="btnCon" value="500">전체공지</li>
                                <li id="tab3" class="btnCon" value="600">일반게시판	</li>
                                <li id="tab4" class="btnCon" value="700">자료게시판</li>
                            </ul>
                        	</div>
              		  	<div id="mainBoardView">			
<!-- 				<table class="dept_down">
						<thead>
							<tr>
							<th style="width: 35%;">제목</th>
							<th style="width: 15%;">작성자</th>
							<th style="width: 20%;">작성일</th>
							</tr>
						</thead>				
						<tbody id="messageAddressSearch">
   		                 <tr>
  		                  <td>전략기획</td>
   		                 <td>부장</td>
   		                 <td>2208011</td>
   		                 </tr>
						</tbody>
						</table>  -->                
						</div>
                        </div>
                    </div>
                </div>
                <div class="home_content homebox3">
                    <div class="home_todo">
                        <h1 class="home_content_title">ToDO+ 카드목록</h1>
                        <div class="home_todo_content">2022년 09월 26일(월)</div>
                        <div class="home_todo_content">2022년 09월 26일(월)</div>
                    </div>
                    <div class="home_recent_login">
                        <h1 class="home_content_title">최근 로그인 정보</h1>
                        <div class="home_todo_content">2022년 09월 26일(월)</div>
                        <div class="home_todo_content">2022년 09월 26일(월)</div>
                	</div>
				</div>
        	</div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="<c:url value='resources/js/officemap.js'/>"></script>
</body>

</html>