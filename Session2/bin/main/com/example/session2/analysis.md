1. Vì sao lỗi đăng nhập phải dùng Request Scope?
   ✅ Lý do:
   Thông báo lỗi (vd: “Sai mật khẩu”) chỉ cần tồn tại trong 1 request duy nhất
   Sau khi reload hoặc chuyển trang → phải biến mất
   ❌ Nếu dùng Session:
   Message sẽ bị lưu xuyên suốt phiên
   Người dùng refresh → vẫn thấy lỗi cũ
   Có thể gây hiểu nhầm (đã login đúng nhưng vẫn thấy lỗi)

👉 Kết luận:

Error message = Request Scope (ngắn hạn, stateless)

2. Vì sao totalViewCount phải dùng Application Scope?
   ✅ Lý do:
   Đây là biến toàn hệ thống
   Tất cả user đều nhìn chung 1 giá trị duy nhất
   ❌ Nếu dùng Session:
   Mỗi user có 1 session riêng
   → mỗi người thấy 1 counter khác nhau
   Ví dụ:
   User	Session Counter
   A	3
   B	1

→ Sai yêu cầu nghiệp vụ

👉 Kết luận:

Global counter = Application Scope

3. Race Condition là gì?
   📌 Định nghĩa:

Race Condition xảy ra khi:

nhiều thread truy cập & cập nhật cùng 1 biến dùng chung mà không đồng b