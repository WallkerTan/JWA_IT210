package BTVN;
public class Bai1 {
//Đoạn code sai (gây tight coupling)
//public RechargeService() {
//    // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
//    this.gateway = new InternalPaymentGateway();
//}
//Phân tích lỗi theo nguyên lý IoC / DI

//1. Vi phạm Inversion of Control (IoC)
// Theo IoC, việc tạo và quản lý dependency (ở đây là PaymentGateway) phải do IoC Container (ví dụ: Spring) đảm nhiệm.
//Nhưng trong code này, RechargeService tự kiểm soát việc khởi tạo dependency, tức là:
// new InternalPaymentGateway()
//→ Điều này đi ngược lại nguyên lý IoC (control không bị “đảo ngược”).

// 2. Gây tight coupling (liên kết chặt)
//RechargeService bị phụ thuộc cứng vào InternalPaymentGateway.
//Nếu muốn thêm:
//MomoPaymentGateway
//ZaloPayPaymentGateway
//→ Bắt buộc phải sửa code class này.
// Vi phạm nguyên lý Open/Closed Principle (OCP):
//Đáng lẽ phải “mở để mở rộng, đóng để sửa đổi”
//Nhưng hiện tại: muốn mở rộng → phải sửa code

//3. Mất tính linh hoạt và khả năng mở rộng
//Không thể:
//Inject gateway khác khi runtime
//Cấu hình từ bên ngoài (config file, Spring Bean)
//Mỗi lần đổi cổng thanh toán → phải rebuild lại hệ thống

//4. Khó test (unit test kém hiệu quả)
//Không thể mock PaymentGateway
//→ Không test độc lập được RechargeService

//Kết luận:
//Đoạn code sai vì:
//Hard-code dependency (new InternalPaymentGateway())
//Làm cho class không tuân theo IoC
//Gây tight coupling, khó mở rộng, khó bảo trì, khó test
}