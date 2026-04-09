package BTVN;

public class Bai4 {
//        | Tiêu chí                     | Constructor Injection                          | Field Injection                                    |
//        | ---------------------------- | ---------------------------------------------- | -------------------------------------------------- |
//        | Nguyên lý thiết kế           | Tuân thủ IoC, rõ ràng dependency               | Vi phạm encapsulation (inject trực tiếp vào field) |
//        | Tính bắt buộc dependency     | ✔ Bắt buộc (object luôn đủ dependency khi tạo) | x Có thể null nếu inject lỗi                       |
//        | Test (Unit Test)             | ✔ Dễ mock, test độc lập                        | x Khó test (phải dùng Spring context)              |
//        | Tính bất biến (immutability) | ✔ Có thể dùng `final`                          | x Không dùng được `final`                          |
//        | Độ rõ ràng code              | ✔ Rõ dependency qua constructor                | x Dependency bị “ẩn”                               |
//        | Khả năng lỗi runtime         | ✔ Ít lỗi hơn (fail-fast)                       | x Dễ lỗi NullPointerException                      |
//        | Khả năng bảo trì             | ✔ Tốt                                          | x Kém                                              |

//Phân tích thêm theo “bẫy dữ liệu” (SMS bị đứt mạng)
//Khi SmsSender gặp lỗi:
//Cần dễ dàng:
//Mock để test
//Thay bằng fallback (Email hoặc retry)
//Constructor Injection hỗ trợ tốt vì:
//Có thể inject nhiều implementation
//Dễ kết hợp pattern (Strategy / Fallback)

// Kết luận lựa chọn
// Chọn: Constructor Injection

//Lý do:
//Đảm bảo object luôn ở trạng thái hợp lệ (không null dependency)
//Dễ test và mock khi SMS bị lỗi
//Hỗ trợ mở rộng (thêm Zalo, Push Notification…)
//Tuân thủ clean code & best practice của Spring
}
