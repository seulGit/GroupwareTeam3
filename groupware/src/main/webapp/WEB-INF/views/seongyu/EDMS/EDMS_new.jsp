<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/EDMS/EDMS_new.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
    <!-- <link rel="stylesheet" href="../../../../resources/css/EDMS/EDMS_new.css"> -->
    <!-- <link rel="stylesheet" href="../../../../resources/css/styles.css"> -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<%@ include file="/WEB-INF/views/intro.jsp" %>
<div id="layoutSidenav_content" class="EDMS_main_section">
    <div class="content_box">
        새결재진행
    </div>

    <!-- 기본 설정 -->
    <form name="EDMS_docu" type="POST">
    <div class="EDMS_new_container">
        <div class="basic_setting">
            <p>기본설정</p>
            <div class="table_box_fir">
                <div class="basic_settint_docu_type">
                    <table>
                        <tr>
                            <td class="table_bg">문서종류</td>
                            <td>
                                <select id="type_select" name="EDMS_docu_category">
                                    <option value="choice">구분선택</option>
                                    <option value="general">일반품의서</option>
                                    <option value="money">비용품의서</option>
                                    <option value="certificate">증명서신청</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>

                <div>
                    <table>
                        <tr>
                            <td class="table_bg">기안작성자</td>
                            <td>
                                <c:out value="${sessionScope.emp_name}">${sessionScope.emp_name}</c:out>
                                <input type="hidden" value="${sessionScope.emp_num}" class="create_user_emp_num" name="emp_num">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- 조직도 검색 -->
        <div class="basic_setting">
            결재선 지정
            <div class="table_box_sec">
                <table id="approval_info">
                    <tr>
                        <td class="table_bg table_size">구분</td>
                        <td class="table_bg">중간결재자
                            <input type="hidden" name="EDMS_approval_emp_1" id="EDMS_approval_emp_1"></td>
                        <td class="table_bg">최종결재자
                            <input type="hidden" name="EDMS_approval_emp_2" id="EDMS_approval_emp_2"></td>
                    </tr>
                    <tr>
                        <td class="table_bg table_size">이름</td>
                        <td id="first_approver_name"></td>
                        <td id="second_approver_name"></td>
                    </tr>
                    <tr>
                        <td class="table_bg table_size">부서</td>
                        <td id="first_approver_dept">
                            <input type="button" value="중간결재자 선택" id="btn_bg_first">
                        </td>
                        <td id="second_approver_dept">
                            <input type="button" value="최종결재자 선택" id="btn_bg_second">
                        </td>
                    </tr>
                    <tr>
                        <td class="table_bg table_size">직급</td>
                        <td id="first_approver_position"></td>
                        <td id="second_approver_position"></td>
                    </tr>
                </table>
            </div>
            <div class="approval_reset">
                <input type="button" value="결재선 초기화" id="approver_reset_btn">
            </div>
        </div>

        <div class="EDMS_docu"></div>

    </div>
    <div class="approver_modal">
        <div class="approver_container">
            <div class="approver_box">
                <div>
                    <table>
                        <tr>
                            <td>부서</td>
                            <td>직급</td>
                            <td>이름</td>
                            <td>사원번호</td>
                        </tr>
                    </table>
                </div>
                <div class="approver_emp_list">
                    <table class="approver_emp_list_table">
                        <c:forEach var="info" items="${emp_info}">
                            <tr>
                                <td>${info.dept_name}</td>
                                <td>${info.position_grade}</td>
                                <td>${info.emp_name}</td>
                                <td class="emp_num">${info.emp_num}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous">
</script>
<!-- <script src="../../../../resources/js/EDMS/EDMS_new.js"></script> -->
<%--<script src="../js/scripts.js"></script>--%>
<script src="<c:url value="/resources/js/EDMS/EDMS_new.js"/>"></script>
<script src="<c:url value="/resources/api/ckeditor5-35.1.0-cfi81gg98uxz/build/ckeditor.js"/>"></script>
</body>
</html>