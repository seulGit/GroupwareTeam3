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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:if test="${empty data}">
    <tr>
        <td>해당 데이터가 없습니다.</td>
    </tr>
</c:if>
<c:forEach var="row" items="${data}">
    <tr class="search_list_contents">
        <td><input type="checkbox" class="check_btn"></td>

        <c:if test="${row.emp_active eq 1}">
            <td>활성</td>
        </c:if>
        <c:if test="${row.emp_active eq 0}">
            <td>비활성</td>
        </c:if>

        <td>${row.emp_num}</td>
        <td>${row.auth_code}</td>
        <td>${row.emp_name}</td>
        <td>${row.dept_name}</td>


        <td><input type="checkbox" class="check_btn_2 authority_EDMS" name="authority_EDMS"
            <c:out value="${row.authority_EDMS == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_worktime" name="authority_worktime"
            <c:out value="${row.authority_worktime == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_booking" name="authority_booking"
            <c:out value="${row.authority_booking == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_board" name="authority_board"
            <c:out value="${row.authority_board == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_personnelCard" name="authority_personnelCard"
            <c:out value="${row.authority_personnelCard == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_loginHistory" name="authority_loginHistory"
            <c:out value="${row.authority_loginHistory == 1 ? 'checked' : ''}"/>></td>
        <td><input type="checkbox" class="check_btn_2 authority_authority" name="authority_authority"
            <c:out value="${row.authority_authority == 1 ? 'checked' : ''}"/>></td>


    </tr>
</c:forEach>

