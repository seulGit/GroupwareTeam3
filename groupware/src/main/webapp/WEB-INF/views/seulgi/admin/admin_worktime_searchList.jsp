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
        <td><input type="checkbox" class="check_btn"></td>
        <td>${row.emp_num}</td>
        <td>${row.emp_name}</td>
        <td>${row.dept_name}</td>
        <c:if test="${row.join_date} != null or ${row.join_date} != ''">
            <td><fmt:formatDate value="${row.join_date}"
                                pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${row.leave_date}"
                                pattern="yyyy-MM-dd"/></td>
            <td>${row.used_count}</td>
            <td>${row.available_count}</td>
        </c:if>
        <c:if test="${row.join_date} == null or ${row.join_date} == ''">
            <td>${row.workdate}</td>
            <td>${row.worktime_hours}</td>
            <td>${row.worktime_go}</td>
            <td>${row.worktime_out}</td>
        </c:if>
    </tr>
</c:forEach>

