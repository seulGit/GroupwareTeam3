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
    <link rel="stylesheet" href="../../resources/css/styles.css" />
    <link rel="stylesheet" href="../../resources/css/worktime/worktime_new.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	<script src = "resources/api/ckeditor4_standard/ckeditor.js"></script>
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	

</head>
  
<body class="sb-nav-fixed stop_scroll">
<!-- 상단/왼쪽 메뉴 include -->
<%@ include file="/WEB-INF/views/intro.jsp" %>

        <div id="layoutSidenav_content">
            <div class="content_box">
                휴가계신청
            </div>
			 <form action="/vacation_insert" method="post">
			<!-- 휴가계 선택  -->
            <div class="worktime_new_container">
                <div class="basic_setting">
                   <p>기본설정</p>
                   <div class="worktime_table_box_fir">
                   <div class="basic_setting_docu_type">
                      <table>
                        <tr>
                            <td class="table_bg">휴가계종류</td>
                            <td><select name="vacation_docu_category" id="type_select">
                                <option value="annual">연차</option>
                                <option value="halfway">반차</option>
                                <option value="sick_leave">병가</option>
                                <option value="early_departure">조퇴</option>
                                <option value="outing">외출</option>
                            </select>
                            </td>
                        </tr>
                      </table>
                   </div>
    
    			<!-- 결재라인 선택  -->
                   <div>
                       <table>
                        <tr>
                            <td class="table_bg">기안작성자</td>
                            <td>${WorktimeNameMap.emp_name}
                           		<input type="hidden" value="${WorktimeNameMap.emp_num}" name="emp_num"> 
                           </td>
                        </tr>
                       </table>
                   </div>
                </div>
                </div>
    
                <div class="basic_setting">
                    	결재선 지정
                    <input type="button" value="조직도검색" class="worktime_dept_modal_btn" id="btn_bg">
                    <div class="table_box_sec">
                        <table id="approval_info">
                            <tr>
                                <td class="table_bg table_size">구분</td>
                                <td class="table_bg">중간결재자
                                	<input type="hidden" name="vacation_approval_emp_1" id="vacation_approval_emp_1">
                                </td>
                                <td class="table_bg">최종결재자
                                	<input type="hidden" name="vacation_approval_emp_2" id="vacation_approval_emp_2">
                                </td>
                            </tr>
                            <tr>
                                <td class="table_bg table_size">이름</td>
                                <td class="table_approval_info middle_name"></td>
                                <td class="table_approval_info final_name"></td>
                            </tr>
                            <tr>
                                <td class="table_bg table_size">직위</td>
                                <td class="table_approval_info middle_approval"></td>
                                <td class="table_approval_info final_approval"></td>
                            </tr>
                            <tr>
                                <td class="table_bg table_size">부서</td>
                                <td class="table_approval_info middle_dept"></td>
                                <td class="table_approval_info fianl_dept"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                
                <!-- 상세입력  -->
                  <div class="worktime_docu_input_box">
                    <p>상세입력</p>
                    <div class="worktime_docu_input_icon">
                        <i class="xi-file-download" title="EXCEL파일 다운로드"></i>
                        <i class="xi-print" title="프린트"></i>
                    </div>
    
    				<!-- 휴가계 내용 작성  -->
                    <div class="table_box_thr">
             
                     <table class="input_table">
                        <tr class="input_table_size">
                            <td>연차신청서</td>
                            <td colspan="6"></td>
                        </tr>
                        <tr>
                            <td>기안부서</td>
                            <td class="table_size">${WorktimeNameMap.dept_name}</td>
                            <td>기안일</td>
                            <td class="table_size worktime_new_date"></td>
                            <td class="docu_num_width">부서번호</td>
                            <td class="table_size">${WorktimeNameMap.dept_code}</td>
                        </tr>

                  		<tr>
                     		<td>휴가 기간</td>
                            <td colspan="2" class="date_width">
                            	<div class="vacation_date">
                            	<input type="date" class="vacation_days1" name="vacation_start"> ~ <input type="date" class="vacation_days2" name="vacation_last"></div>
                            </td>
                    		<td>사유</td>
                            <td colspan="2"><input type="text" id="worktime_docu_reason" name="vacation_reason"></td>
                  		</tr>   
                        <tr>
                           <td>제목</td>
                           <td colspan="6"><input type="text" id="worktime_docu_title" name="vacation_title"></td>
                        </tr>

                        <tr>
                        	<td>첨부 파일</td>
                        	<td colspan="6"><input type="file" id="file_text_align"></td>
                        </tr>
                    </table>
                    
                </div>
                <div class="worktime_new_api">
                    <textarea id="ckeditor" name="vacation_contents"></textarea>
                    <script type="text/javascript">
              			 CKEDITOR.replace('ckeditor', {
               				});
            </script>
                </div>
                   
                   <!-- 최종결재자 의견  -->
                </div>
                <div class="worktime_result_write">
                    <div>결재자 의견</div>
                    <input type="text" id="worktime_result">
                </div>
               	 <div class="worktime_btn">
                    <input type="submit" value="상신" class="worktime_input_btn worktime_approval">
                    <input type="button" value="취소" class="worktime_input_btn worktime_cancel">
                 </div>
                </div>
       		 </form>
         </div>
       
         
         
			 <!-- 모달 창  -->
        <div id="worktime_modal_back"></div>
        <div id="worktime_modal">
            
            	<div id="worktime_modal_search">
	                <select name="type_option" id="dept_type_select">
	                    <option value="all">전체</option>
	                    <option value="emp_name">사원이름</option>
	                    <option value="dept_name">부서명</option>
	                </select>
	                <input type="text" placeholder="검색 키워드를 입력하세요" id="dept_search_input" name="keyword" value="${keyword}">
	                <input type="button" id="dept_search_btn" value="검색">
            	</div>
            
            <div id="worktime_modal_flex">
                <div id="worktime_modal_dept_name">
                        <ul>
                            <li class="worktime_dept_btn">전략기획팀</li>
                            <li class="worktime_dept_btn">경영지원팀</li>
                            <li class="worktime_dept_btn">마켓팅팀</li>
                            <li class="worktime_dept_btn">인사팀</li>
                            <li class="worktime_dept_btn">영업팀</li>
                            <li class="worktime_dept_btn">IT팀</li>
                            <li class="worktime_dept_btn">CEO</li>
                        </ul>
                </div>
                <div id="worktime_modal_dept_people_info">
                	<!-- 팀에 소속된 사원 정보 출력  -->
                </div>
                <div id="worktime_modal_button">
                    <button class="approval_btn middle_btn">중간결재자</button>
                    <button class="approval_btn final_btn">최종결재자</button>
                </div>
                <div id="worktime_modal_approval">
                    <div class="modal_approval">
                        <p>중간결재자</p>
                        <div class="approval_box middle_box"><span></span>
                        									 <span></span>
                        									 <span></span>
                        </div>
                    </div>
                    <div class="modal_approval">
                        <p>최종결재자</p>
                        <div class="approval_box final_box"><span></span>
                        									<span></span>
                        									<span></span>
                        </div>
                    </div>
                </div>
                <div id="worktime_modal_xicon">
                    <i class="xi-close-circle"></i>
                </div>
            </div>
            <input type="submit" class="modal_submit_btn" value="선택완료">
        </div>
    
    	

 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        <script src="../../resources/js/worktime/worktime_new.js"></script>
 		<script src="<c:url value='resources/js/officemap.js'/>"></script>

</body>



</html>