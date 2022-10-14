<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/EDMS/EDMS_docu.css'/>">
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">

    <%@ include file="/WEB-INF/views/intro.jsp" %>
        <div id="layoutSidenav_content">
            <div class="content_box">

            </div>
            <div class="EDMS_new_container">
                <div class="docu_input_box">
                    <div class="docu_input_icon">
                        <i class="xi-file-download" title="EXCEL파일 다운로드"></i>
                        <i class="xi-print" title="프린트"></i>
                    </div>

                    <div class="table_box_thr">
                        <table class="input_table">
                            <tr class="input_table_size">
                                <td colspan="4">증명서신청</td>
                                <td colspan="2">
                                    <div class="Approval_container">
                                        <div class="approval_1_container">
                                            <div>
                                                중간결재자
                                            </div>
                                            <div class="approval_1_check">

                                            </div>
                                            <div class="approval_1_name">
                                                ${docu.EDMS_approval_emp_1_position_grade} ${docu.EDMS_approval_emp_1_name}
                                            </div>
                                            <div class="approval_1_check_date">

                                            </div>
                                        </div>
                                        <div class="approval_2_container">
                                            <div>
                                                최종결재자
                                            </div>
                                            <div class="approval_2_check">

                                            </div>
                                            <div class="approval_2_name">
                                                ${docu.EDMS_approval_emp_2_position_grade} ${docu.EDMS_approval_emp_2_name}
                                            </div>
                                            <div class="approval_2_check_date">

                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>기안부서</td>
                                <td>${docu.dept_name}</td>
                                <td>기안일</td>
                                <td class="drafting_date">${docu.EDMS_docu_date}</td>
                                <td>기안자</td>
                                <td>${docu.position_grade} ${docu.emp_name}</td>
                            </tr>
                            <tr>
                                <td>증명서종류</td>
                                <td>
                                    ${docu.EDMS_docu_category}
                                </td>
                                <td>용도</td>
                                <td>
                                    ${docu.certificate_purpose}
                                </td>
                                <td>제출처</td>
                                <td>
                                    ${docu.certificate_submit_to}
                                </td>
                            </tr>
                            <tr>
                                <td>제목</td>
                                <td colspan="4">
                                    ${docu.certificate_docu_title}
                                </td>
                                <td class="EDMS_new_impor_position">
                                    <div>
                                        긴급
                                        <input type="checkbox" name="EDMS_docu_urgent" id="EDMS_new_impor" disabled
                                        <c:if test="${docu.EDMS_docu_urgent == 1}">
                                            checked
                                        </c:if>
                                        >
                                        <label for="EDMS_new_impor" class="EDMS_new_impor_switch">
                                            <span class="EDMS_new_impor_btn"></span>
                                        </label>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="EDMS_new_api">
                        <textarea name="approval_request_docu_contents" id="editor" readonly>
                            ${docu.certificate_docu_contents}
                        </textarea>
                    </div>
                    <%--  파일 첨부  --%>
                    <div class="EDMS_docu_file_container">
                        <div class="file_upload_container">
                            <input type="text" class="upload_name" value="파일이 없습니다." placeholder="파일이 없습니다." disabled>
                            <label for="upload_file">다운로드</label>
                            <input name="file" type="file" id="upload_file">
                        </div>
                    </div>
                    <div class="EDMS_btn">
                        <input type="submit" value="승인" class="EDMS_input_btn EDMS_approval">
                        <input type="button" value="반려" class="EDMS_input_btn EDMS_cancel">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/EDMS/EDMS_docu.js"/>"></script>
    <script src="<c:url value="/resources/api/ckeditor5-35.1.0-cfi81gg98uxz/build/ckeditor.js"/>"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</body>
</html>