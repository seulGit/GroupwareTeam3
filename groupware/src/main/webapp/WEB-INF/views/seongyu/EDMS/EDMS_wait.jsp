<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="utf-8" %>
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
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/EDMS/EDMS_wait.css"/>">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<%@ include file="/WEB-INF/views/intro.jsp" %>
<div id="layoutSidenav_content">
    <div class="content_box">
        결재대기중
    </div>

    <!-- 결재대기중 리스트 테이블 -->
    <div class="EDMS_wait_docu_list">
        <div id="EDMS_wait_docu_font">결재할 문서가 <strong>5</strong>건 있습니다.</div>
        <div class="EDMS_wait_docu_table_list">
            <table class="EDMS_wait_docu_table">
                <tr class="EDMS_wait_table_bg">
                    <td>문서번호</td>
                    <td>기안일</td>
                    <td>결재양식</td>
                    <td>기안자</td>
                    <td style="width:40%">제목</td>
                    <td>긴급</td>
                    <td>첨부</td>
                </tr>
                <c:forEach var="list" items="${EDMS_list}">
                    <tr class="EDMS_wait_table_hover" onclick="location.href = '/EDMS/docu?EDMS_docu_num=${list.EDMS_docu_num}'">
<%--                        <c:if test="${sessionScope.emp_num != list.EDMS_approval_emp_1 or sessionScope.emp_num != list.EDMS_approval_emp_2}">--%>
<%--                            <script>--%>
<%--                                location.href = "/";--%>
<%--                            </script>--%>
<%--                        </c:if>--%>
                        <td>${list.EDMS_docu_num}</td>
                        <td>${fn:substring(list.EDMS_docu_date, 0, 10)}</td>
                        <td>${list.EDMS_docu_category}</td>
                        <td>${list.emp_name}</td>
                        <td>${list.approval_request_docu_title}</td>
                        <td>
                            <i class="<c:out value="${list.EDMS_docu_urgent == 1 ? 'xi-error' : ''}"/>"></i>
                        </td>
                        <td>
                            <i class="<c:out value="${list.file_no != null ? 'xi-paper' : ''}"/>"></i>
                        </td>
                    </tr>

                </c:forEach>
            </table>

        </div>
        <!-- 페이지 넘버 -->
        <div class="EDMS_wait_list_number">
            <div>
                <div class="EDMS_wait_list_n_menu">

                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>
    let list_length = ${EDMS_length};
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/EDMS/EDMS_wait.js"/>"></script>
</body>

</html>