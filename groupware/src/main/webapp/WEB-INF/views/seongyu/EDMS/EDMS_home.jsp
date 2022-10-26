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
    <link rel="stylesheet" href="<c:url value="/resources/css/EDMS/EDMS_home.css"/>">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<%@ include file="/WEB-INF/views/intro.jsp" %>

<div id="layoutSidenav_content">
    <div class="content_box">
        전자결재홈 <a href="<c:url value="/EDMS/new"/>"><input type="button" value="새 결재 진행" id="EDMS_home_new_docu_btn"></a>
    </div>

    <!-- 결재 대기중 문서 테이블 -->
    <div class="EDMS_docu_list">
        <p>결재 대기중 문서</p>
        <div id="EDMS_docu_font">승인할 문서가 <strong>${wait_list_length}</strong>건 있습니다.</div>
        <div class="EDMS_docu_table_list">
            <table class="EDMS_docu_table">
                <tr class="EDMS_table_bg">
                    <td>문서번호</td>
                    <td>기안일</td>
                    <td>결재양식</td>
                    <td>기안자</td>
                    <td style="width:40%">제목</td>
                    <td>긴급</td>
                    <td>첨부</td>
                </tr>
                <c:forEach var="wait" items="${EDMS_wait}">
                    <tr class="EDMS_table_hover" onclick="location.href = '/EDMS/docu?EDMS_docu_num=${wait.EDMS_docu_num}&EDMS_docu_category=${wait.EDMS_docu_category}'">
                        <td>${wait.EDMS_docu_num}</td>
                        <td>${fn:substring(wait.EDMS_docu_date, 0, 10)}</td>
                        <td>${wait.EDMS_docu_category}</td>
                        <td>${wait.emp_name}</td>
                        <td>${wait.approval_request_docu_title}</td>
                        <td>
                            <i class="<c:out value="${wait.EDMS_docu_urgent == 1 ? 'xi-error' : ''}"/>"></i>
                        </td>
                        <td>
                            <i class="<c:out value="${wait.file_no != null ? 'xi-paper' : ''}"/>"></i>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- 기안 진행 문서 테이블 -->
    <div class="EDMS_docu_list">
        <p>기안 진행 문서</p>
        <div class="EDMS_docu_table_list">
            <table class="EDMS_docu_table">
                <tr class="EDMS_table_bg">
                    <td>문서번호</td>
                    <td>기안일</td>
                    <td>결재양식</td>
                    <td>기안자</td>
                    <td style="width:40%">제목</td>
                    <td>긴급</td>
                    <td>첨부</td>
                </tr>
                <c:forEach var="ing" items="${EDMS_ing}">
                    <tr class="EDMS_table_hover"  onclick="location.href = '/EDMS/docu?EDMS_docu_num=${ing.EDMS_docu_num}&EDMS_docu_category=${ing.EDMS_docu_category}'">
                        <td>${ing.EDMS_docu_num}</td>
                        <td>${fn:substring(ing.EDMS_docu_date, 0, 10)}</td>
                        <td>${ing.EDMS_docu_category}</td>
                        <td>${ing.emp_name}</td>
                        <td>${ing.approval_request_docu_title}</td>
                        <td>
                            <i class="
                                    <c:out value="${ing.EDMS_docu_urgent == 1 ? 'xi-error' : ''}"/>
                                "></i>
                        </td>
                        <td>
                            <i class="
                                    <c:out value="${ing.file_no != null ? 'xi-paper' : ''}"/>
                                "></i>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- 완료문서 테이블 -->
    <div class="EDMS_docu_list">
        <p>완료 문서</p>
        <div class="EDMS_docu_table_list">
            <table class="EDMS_docu_table">
                <tr class="EDMS_table_bg">
                    <td>문서번호</td>
                    <td>기안일</td>
                    <td>결재양식</td>
                    <td>기안자</td>
                    <td>결재상태</td>
                    <td style="width:40%">제목</td>
                    <td>긴급</td>
                    <td>첨부</td>
                </tr>
                <c:forEach var="end" items="${EDMS_end}">
                    <tr class="EDMS_table_hover" onclick="location.href = '/EDMS/docu?EDMS_docu_num=${end.EDMS_docu_num}&EDMS_docu_category=${end.EDMS_docu_category}'">
                        <td>${end.EDMS_docu_num}</td>
                        <td>${fn:substring(end.EDMS_docu_date, 0, 10)}</td>
                        <td>${end.EDMS_docu_category}</td>
                        <td>${end.emp_name}</td>
                        <td>승인</td>
                        <td>${end.approval_request_docu_title}</td>
                        <td>
                            <i class="<c:out value="${end.EDMS_docu_urgent == 1 ? 'xi-error' : ''}"/>"></i>
                        </td>
                        <td>
                            <i class="<c:out value="${end.file_no != null ? 'xi-paper' : ''}"/>"></i>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>

</html>