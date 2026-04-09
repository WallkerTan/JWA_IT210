<%--
  Created by IntelliJ IDEA.
  User: luyen
  Date: 4/7/2026
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Report</title>
</head>
<body>

<h2>Student Report</h2>

<%-- Hiển thị danh sách sinh viên --%>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Score</th>
        <th>Status</th>
    </tr>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>
                <c:out value="${student.name}" />
            </td>
            <td>
                <c:out value="${student.score}" />
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.score >= 5}">
                        Pass
                    </c:when>
                    <c:otherwise>
                        Fail
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
