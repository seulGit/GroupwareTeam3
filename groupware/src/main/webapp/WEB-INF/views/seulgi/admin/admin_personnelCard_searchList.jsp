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
        <td>해당 사원이 없습니다.</td>
    </tr>
</c:if>
<c:forEach var="row" items="${data}">
    <tr class="search_list_contents">
        <td>${row.emp_name}</td>
        <td>${row.emp_gender}</td>
        <td>${row.dept_name}</td>
        <td>${row.emp_num}</td>
        <td><fmt:formatDate value="${row.join_date}"
                            pattern="yyyy-MM-dd"/></td>
        <td>${row.emp_phonenum}</td>
        <td>${row.emp_email}</td>
        <input type="hidden" value="${row.emp_address}">
        <input type="hidden" value="${row.emp_address2}">
        <input type="hidden" value="${row.auth_code}">
        <input type="hidden" value="${row.emp_pw}">
        <input type="hidden" value="${row.emp_desk_num}">
        <input type="hidden" value="${row.emp_birth}">
        <input type="hidden"
               value="<fmt:formatDate value="${row.leave_date}"
                                pattern="yyyy-MM-dd"/>"
        >
        <input type="hidden" value="${row.emp_active}">
        <input type="hidden" value="${row.position_grade}">
        <input type="hidden" value="${row.dept_code}">
        <input type="hidden" value="${row.emp_pw}">


    </tr>
</c:forEach>

