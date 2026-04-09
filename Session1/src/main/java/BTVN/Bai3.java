package BTVN;

public class Bai3 {
//Input:
//username, foodName, quantity
//Output:
//Thành công: "Đặt món thành công"
//Thất bại:
//        "Món ăn đã hết"
//        "Số dư không đủ"
//        "Tài khoản không hợp lệ"

//Luồng xử lý logic
//Kiểm tra user tồn tại
//Kiểm tra tồn kho
//Nếu không đủ → trả "Món ăn đã hết"
//Tính tiền
//Kiểm tra số dư
//Nếu không đủ → trả "Số dư không đủ"
//Trừ tiền tài khoản
//Trừ số lượng trong kho
//Trả "Đặt món thành công"

//Kiến trúc (DI – Loose Coupling)
//OrderFoodService phụ thuộc:
//InventoryRepository
//UserAccountRepository
//Tiêm dependency qua constructor (không dùng new)
//→ Đảm bảo Loose Coupling + dễ mở rộng
}
