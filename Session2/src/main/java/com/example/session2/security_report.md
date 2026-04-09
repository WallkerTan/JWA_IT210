# security_report.md

## 1. XSS là gì? Vì sao `<c:out>` an toàn hơn `${}`?

**XSS (Cross-Site Scripting)** là lỗ hổng bảo mật cho phép chèn mã JavaScript độc hại vào trang web, khiến trình duyệt người dùng thực thi đoạn mã đó.

Ví dụ input:

```html
<script>alert(1)</script>
```

* Nếu dùng `${keyword}`:

```html
<script>alert(1)</script>
```

→ Trình duyệt sẽ thực thi → gây XSS

* Nếu dùng `<c:out value="${keyword}" />`:

```html
&lt;script&gt;alert(1)&lt;/script&gt;
```

→ Chỉ hiển thị text → không chạy script

**Kết luận:**
`<c:out>` an toàn hơn vì mặc định escape XML/HTML (`escapeXml="true"`), giúp ngăn chặn XSS.

---

## 2. Sự khác nhau giữa `<c:if>` và `<c:choose>`

* `<c:if>`: dùng cho điều kiện đơn lẻ, không có else
* `<c:choose>`: giống if–else if–else, xử lý nhiều nhánh logic

**Áp dụng trong bài:**

* Phần **Giá vé** (0 hoặc >0) → dùng `<c:choose>`
* Phần **Vé còn lại** (0, <10, ≥10) → dùng `<c:choose>`

**Lý do:** có nhiều trường hợp cần xử lý, `<c:if>` không đủ linh hoạt.

---

## 3. Vai trò của `<c:url>`

Nếu hardcode:

```html
href="/events/1/book"
```

Khi deploy app với context path `/ticketing`:

```
http://localhost:8080/events/1/book  (sai)
```

Dùng `<c:url>`:

```jsp
<c:url value="/events/${event.id}/book"/>
```

→ Tự động sinh:

```
/ticketing/events/1/book  (đúng)
```

**Kết luận:**
`<c:url>` giúp tạo URL đúng với context path, đảm bảo ứng dụng chạy đúng trên mọi môi trường.
