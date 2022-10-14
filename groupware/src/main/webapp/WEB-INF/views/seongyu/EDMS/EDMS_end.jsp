<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value="/resources/css/EDMS/EDMS_end.css"/>">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<%@ include file="/WEB-INF/views/intro.jsp" %>
        <div id="layoutSidenav_content">
            <div class="content_box">
                완료문서
            </div>

            <!-- 완료문서 리스트 테이블 -->
            <div class="EDMS_end_docu_list">
                <div class="EDMS_end_docu_table_list">
                <table class="EDMS_end_docu_table">
                    <tr class="EDMS_end_table_bg">
                        <td>문서번호</td>
                        <td>기안일</td>
                        <td>결재양식</td>
                        <td>기안자</td>
                        <td style="width:40%">제목</td>
                        <td>첨부</td>
                        <td>결재상태</td>
                    </tr>
                    <tr class="EDMS_end_table_hover">
                        <td>20203086</td>
                        <td>2021-12-10</td>
                        <td>품의서</td>
                        <td>김형준</td>
                        <td>교통비 신청 2</td>
                        <td><i class="xi-paper"></i></td>
                        <td>승인</td>
                    </tr>
                    <tr class="EDMS_end_table_hover">
                        <td>20203075</td>
                        <td>2021-12-05</td>
                        <td>품의서</td>
                        <td>김형준</td>
                        <td>교통비 신청 </td>
                        <td></td>
                        <td>반려</td>
                    </tr>
                </table>
                </div>

                <!-- 페이지 넘버 -->
                <div class="EDMS_end_list_number">
                    <div>
                        <div class="EDMS_end_list_n_menu">

                        </div>                            
                    </div>
                </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/EDMS/EDMS_end.js"/>"></script>
</body>

</html>