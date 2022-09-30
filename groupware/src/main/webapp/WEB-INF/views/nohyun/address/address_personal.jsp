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
<link rel="stylesheet" href="<c:url value='/resources/css/address/address_personal.css'/>" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
<script src="<c:url value='/resources/js/jquery-3.6.0.min.js'/>"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>JaeHee Group</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/intro.jsp"%>
	
	<div id="layoutSidenav_content">
            <div class="address_personal_total_container">
                <!-- 개인주소록 카테고리 항목 -->
                <div class="address_personal_category_container">
                    <div class="address_personal_category_list">
      				  
      				  <c:forEach var="row" items="${categoryData}">
      				  	
                        <form class="address_personal_category_data"><a href="">${row.searchCategory}</a></form>
                      </c:forEach>
                      
                        <div class="address_personal_input_box">
                        <input type="text" placeholder="연락처 그룹 이름" class="address_personal_category_input"><i class="xi-check"></i></div>
                        <div class="address_personal_category_add">
                        	<i class="xi-plus"></i>연락처 주소록 추가
                        </div>
                    	
                    	
                    
                    </div>
                </div>
                <!-- 개인주소록 세션 -->
                <div class="address_personal_section">
                    <!-- 개인주소록 타이틀 -->
                    <div class="address_personal_title_box">
                        <span class="address_personal_title">개인 주소록</span>
                        <span class="address_personal_next">in 공용 주소록(총<span>5</span>건)</span>
                    </div>
                    <!-- EXCEL 내보내기  -->
                    <div class="address_personal_excel_sendout">
                        <a href="">EXCEL로 내보내기</a>
                    </div>
                    <!-- 주소록 추가 -->
                    <div class="address_personal_input_container">
                        <div class="address_personal_input_add">
                            <input type="text" placeholder="이름(표시명)" class="address_name"><input type="text" placeholder="이메일" class="address_email"><input type="text" placeholder="휴대폰" class="address_phone"><span><i class="xi-plus-square-o"></i></span>
                        </div>
                    </div>

                    <!-- 자음별 검색 -->
                    <div class="address_personal_search_consonant">
                        <a href="">전체</a>
                        <a href="">ㄱ</a>
                        <a href="">ㄴ</a>
                        <a href="">ㄷ</a>
                        <a href="">ㄹ</a>
                        <a href="">ㅁ</a>
                        <a href="">ㅂ</a>
                        <a href="">ㅅ</a>
                        <a href="">ㅇ</a>
                        <a href="">ㅈ</a>
                        <a href="">ㅊ</a>
                        <a href="">ㅋ</a>
                        <a href="">ㅌ</a>
                        <a href="">ㅍ</a>
                        <a href="">ㅎ</a>
                        <a href="">a-z</a>
                    </div>
                    <!-- 필드설정 -->
                    <div class="address_personal_field_set">
                        <div></div>
                        <span> <i class="xi-cog"></i>필드설정
                            <select name="" id="">
                                <option value="">20</option>
                                <option value="">40</option>
                                <option value="">60</option>
        
                            </select>
                        </span>
                    </div>
                    <!-- 테이블 -->
                    <table class="address_personal_table">
                        <tr class="address_personal_table_title">
                            <td>이름(표시명)</td>
                            <td>직위</td>
                            <td>휴대폰</td>
                            <td>이메일</td>
                            <td>부서</td>
                            <td>회사전화</td>
                            <td>주소</td>
                        </tr>
                        </table>
                        <table class="address_personal_list">
                        <c:forEach var="row" items="${data}">
                        <tr>
                            <td><i class="xi-user-o"></i><a href="../address/address_all_info.html">${row.emp_name}</a></td>
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
                    <div class="address_personal_page_num_box">
                        <div>
                            <div class="address_personal_page_num">
                                <span class="address_personal_disabled">&lt;&nbsp;  이전</span>
                                <span class="address_personal_current">1</span>
                                <a href="#?page=2">2</a>
                                <a href="#?page=3">3</a>
                                <a href="#?page=4">4</a>
                                <a href="#?page=5">5</a>
                                <a href="#?page=6">6</a>
                                <a href="#?page=7">7</a>
                                <a href="#?page=7">8</a>
                                <a href="#?page=7">9</a>
                                <a href="#?page=7">10</a>
                                <span class="address_personal_disabled">다음  &nbsp;&gt;</span>                                
                            </div>                            
                        </div>
                    </div>
    
                </div>
            </div>
      </div>
     
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
		
	<script src="<c:url value='resources/js/address/address_personal.js'/>"></script>
	<!-- <script src="../resources/js/scripts.js"></script> -->
</body>
</html>