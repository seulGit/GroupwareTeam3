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
        <td>${row.emp_num}</td>
        <td>${row.emp_name}</td>
        <c:set var="today" value="<%=new java.util.Date()%>"/>
        <c:set var="timeZone" value="UTC-9"/>
        <fmt:formatDate value="${today}" type="both" />
        <fmt:timeZone value="${timeZone}">
        <td><fmt:formatDate value="${row.recent_datetime}"
                            pattern="yyyy-MM-dd HH:mm:ss" timeZone="${timeZone}" type="both"/></td>
        </fmt:timeZone>
<%--        <td><fmt:formatDate value="${row.start_date}"--%>
<%--                            pattern="yyyy-MM-dd"/></td>--%>
<%--        <td><fmt:formatDate value="${row.end_date}"--%>
<%--                            pattern="yyyy-MM-dd"/></td>--%>

    </tr>
</c:forEach>

