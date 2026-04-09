<%--
  Created by IntelliJ IDEA.
  User: luyen
  Date: 4/7/2026
  Time: 7:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Employee List</title>
</head>
<body>

<h2>Danh sách nhân viên</h2>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Họ tên</th>
    <th>Phòng ban</th>
    <th>Lương</th>
    <th>Đánh giá</th>
  </tr>

  <c:forEach var="e" items="${employees}">
    <tr>
      <td>${e.id}</td>
      <td>${e.fullName}</td>
      <td>${e.department}</td>
      <td>${e.salary}</td>
      <td>
        <c:choose>
          <c:when test="${e.salary >= 10000}">
            Mức lương cao
          </c:when>
          <c:otherwise>
            Mức lương cơ bản
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
