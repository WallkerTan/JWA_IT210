<%--
  Created by IntelliJ IDEA.
  User: luyen
  Date: 4/7/2026
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="https://jakarta.ee/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="https://jakarta.ee/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="https://jakarta.ee/jsp/jstl/functions" %>

<html>
<head>
  <title>Search Events</title>
</head>
<body>

<h2>
  Kết quả tìm kiếm cho:
  <c:out value="${keyword}" />
</h2>

<p>
  Tìm thấy ${fn:length(events)} sự kiện
</p>

<!-- Nếu không có dữ liệu -->
<c:if test="${empty events}">
  <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- Nếu có dữ liệu -->
<c:if test="${not empty events}">
  <table border="1">
    <tr>
      <th>STT</th>
      <th>Tên sự kiện</th>
      <th>Ngày</th>
      <th>Giá</th>
      <th>Vé còn</th>
      <th>Thao tác</th>
    </tr>

    <c:forEach var="event" items="${events}" varStatus="loop">
      <tr>
        <!-- STT -->
        <td>${loop.count}</td>

        <!-- Tên (chống XSS) -->
        <td>
          <c:out value="${event.name}" />
        </td>

        <!-- Ngày -->
        <td>${event.date}</td>

        <!-- Giá -->
        <td>
          <c:choose>
            <c:when test="${event.price == 0}">
              <span style="color:green;">MIỄN PHÍ</span>
            </c:when>
            <c:otherwise>
              <fmt:formatNumber value="${event.price}" type="number"/>
            </c:otherwise>
          </c:choose>
        </td>

        <!-- Vé còn -->
        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span style="color:red;">HẾT VÉ</span>
            </c:when>
            <c:when test="${event.remainingTickets < 10}">
                            <span style="color:orange;">
                                Sắp hết (còn ${event.remainingTickets} vé)
                            </span>
            </c:when>
            <c:otherwise>
                            <span style="color:green;">
                                ${event.remainingTickets}
                            </span>
            </c:otherwise>
          </c:choose>
        </td>

        <!-- Action -->
        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span style="color:gray;">Không khả dụng</span>
            </c:when>
            <c:otherwise>
              <a href="<c:url value='/events/${event.id}/book'/>">
                Đặt vé
              </a>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<hr/>

<!-- Footer -->
<c:if test="${not empty events}">
  <p>
    Sự kiện đầu tiên:
      ${fn:toUpperCase(events[0].name)}
  </p>
</c:if>

<p>
  Độ dài từ khóa: ${fn:length(keyword)} ký tự
</p>

</body>
</html>
