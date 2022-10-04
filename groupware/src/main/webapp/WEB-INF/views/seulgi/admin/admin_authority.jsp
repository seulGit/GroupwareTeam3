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
    <link href="/resources/css/admin/admin_authority.css" rel="stylesheet"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<%@ include file="/WEB-INF/views/intro.jsp" %>


<div id="layoutSidenav_content">
    <div class="content_box">
        <i class="fa-solid fa-id-card"></i>관리자권한관리
    </div>


    <!-- 기본정보_본문 -->
    <div class="admin_login_authority">
        <div class="search">
            <span class="office_map_btn"><a href="">조직도 조회</a></span>
            <span>권한ID</span>
            <input type="text" id="search_num">
            <span>사용자명</span>
            <input type="text" id="search_name">
            <span>사용부서명</span>
            <select name="dept_code" value="" id="search_department">
                <option value="">전체</option>
                <option value="CEO">CEO</option>
                <option value="전략기획">전략기획</option>
                <option value="경영지원">경영지원</option>
                <option value="인사">인사</option>
                <option value="영업">영업</option>
                <option value="마켓팅">마켓팅</option>
                <option value="IT">IT</option>
            </select>
            <i class="xi-search"></i>
        </div>
        <div class="authority_list">
            <table>
                <thead>
                <td><input type="checkbox" class="all_check_btn"></td>
                <td>활성화여부</td>
                <td>권한ID</td>
                <td>권한명</td>
                <td>사용자명</td>
                <td>사용부서명</td>
                <td>전체</td>
                <td>전자결재관리</td>
                <td>근태관리</td>
                <td>예약관리</td>
                <td>게시글관리</td>
                <td>인사기록카드</td>
                <td>접속내역확인</td>
                <td>권한관리</td>
                </thead>
                <table class="result_table">

                </table>
            </table>
        </div>
        <div class="details_btn">
            <button class="btn_save">저장</button>
            <button class="btn_delete">삭제</button>
        </div>
    </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <%--<script src="../resources/js/admin/admin_personnelCard.js"></script>--%>
    <script src="<c:url value="/resources/js/admin/admin_authority.js"/>"></script>

    </body>
</html>
