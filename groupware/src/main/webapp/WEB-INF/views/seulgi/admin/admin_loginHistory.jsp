<%--
  Created by IntelliJ IDEA.
  User: oseulki
  Date: 2022/09/26
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>JaeHee Group</title>
    <%--    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>--%>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <link href="/resources/css/admin/admin_loginHistory.css" rel="stylesheet"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<%@ include file="/WEB-INF/views/intro.jsp" %>


<div id="layoutSidenav_content">
    <div class="content_box">
        <i class="fa-solid fa-id-card"></i>접속내역확인
    </div>


    <!-- 기본정보_본문 -->
    <div class="admin_login_history">
        <div class="search">
            <span>사원번호</span>
            <input type="text" value="" id="search_num">
            <span>사원명</span>
            <input type="text" value="" id="search_name">
            <span>기간</span>
            <input type="date" value="" id="search_startdate">
            <span>~</span>
            <input type="date" value="" id="search_enddate">
            <i class="xi-search"></i>
        </div>
        <div class="history_list">
            <div class="excel_print">
                <a href="excelDown.do">엑셀파일 출력</a>
            </div>
            <table>
                <thead>
                <td><input type="checkbox" class="all_check_btn"></td>
                <td>사원번호</td>
                <td>사원명</td>
                <td>접속일시</td>
                </thead>
            </table>
            <table class="result_table">

            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<%--<script src="../resources/js/admin/admin_personnelCard.js"></script>--%>
<script src="<c:url value="/resources/js/admin/admin_loginHistory.js"/>"></script>
<script src="<c:url value='/resources/js/officemap.js'/>"></script>
</body>
</html>
