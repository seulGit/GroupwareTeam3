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


<c:if test="${empty data}">
    <tr>
        <td>해당 데이터가 없습니다.</td>
    </tr>
</c:if>
<c:forEach var="row" items="${data}">
    <tr class="search_list_contents">
        <td><input type="checkbox" class="check_btn"></td>

        <c:if test="${row.emp_active}==1">
            <td>활성</td>
        </c:if>
        <c:if test="${row.emp_active}==0">
            <td>비활성</td>
        </c:if>

        <td>${row.emp_num}</td>
        <td>${row.auth_code}</td>
        <td>${row.emp_name}</td>
        <td>${row.dept_name}</td>
        <td><input type="checkbox" class="all_check_btn_2"></td>
        <td><input type="checkbox" class="check_btn_2 authority_EDMS"></td>
        <td><input type="checkbox" class="check_btn_2 authority_worktime"></td>
        <td><input type="checkbox" class="check_btn_2 authority_booking"></td>
        <td><input type="checkbox" class="check_btn_2 authority_board"></td>
        <td><input type="checkbox" class="check_btn_2 authority_personnelCard"></td>
        <td><input type="checkbox" class="check_btn_2 authority_loginHistory"></td>
        <td><input type="checkbox" class="check_btn_2 authority_authority"></td>
    </tr>
</c:forEach>

