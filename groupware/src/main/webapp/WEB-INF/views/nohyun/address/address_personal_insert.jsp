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
               
		
	<script src="<c:url value='resources/js/address/address_personal.js'/>"></script>
	<!-- <script src="../resources/js/scripts.js"></script> -->
</body>
</html>