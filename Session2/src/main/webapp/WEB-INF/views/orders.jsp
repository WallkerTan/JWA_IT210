<%--
  Created by IntelliJ IDEA.
  User: luyen
  Date: 4/7/2026
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Orders</title>
</head>
<body>

<h2>
  Xin chào, ${sessionScope.loggedUser}!
  Vai trò: ${sessionScope.role}
</h2>

<a href="logout">Đăng xuất</a>

<table border="1">
  <tr>
    <th>Mã</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>

  <c:forEach var="o" items="${orders}">
    <tr>
      <td>${o.id}</td>
      <td>${o.name}</td>
      <td>
        <fmt:formatNumber value="${o.price}" type="currency" currencySymbol="₫"/>
      </td>
      <td>
        <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy"/>
      </td>
    </tr>
  </c:forEach>
</table>

<h3>
  Tổng lượt xem: ${applicationScope.totalViewCount}
</h3>

</body>
</html>
