package BTVN;

public class Bai2 {
//**
// Nguyên nhân lỗi nằm ở scope mặc định của Bean trong Spring
//@Component
//public class PlaySession {
//    private double playTime = 0;
//
//    public void addTime(double time) {
//        this.playTime += time;
//    }
//}

//1. Bean mặc định là Singleton
//Trong Spring IoC Container:
//Nếu không khai báo gì thêm, @Component → scope = Singleton
//Nghĩa là:
//Chỉ có 1 instance duy nhất của PlaySession trong toàn bộ ứng dụng

//2. Hệ quả trong bài toán này
//Vì chỉ có 1 object PlaySession dùng chung, nên:
//Máy 01 gọi:
//addTime(10);
//→ playTime = 10
//Máy 02 cũng dùng chính object đó, gọi:
//addTime(5);
//→ playTime = 15
// Kết quả:
//Tất cả máy trạm đang chia sẻ cùng một biến playTime
//Bộ đếm thời gian bị dùng chung
//Dẫn đến:
//Máy 01 chơi → máy 02 cũng bị trừ tiền
//Sai hoàn toàn logic nghiệp vụ

//3. Bản chất vấn đề (theo IoC & Scope)
//PlaySession là stateful object (có trạng thái playTime)
//Nhưng lại bị quản lý dưới dạng Singleton (shared state)
//Trong khi nghiệp vụ yêu cầu:
// Mỗi user / mỗi máy phải có một session riêng

//4. Kết luận ngắn gọn
//Lỗi xảy ra vì:
//Spring tạo 1 instance duy nhất (Singleton) cho PlaySession
//Tất cả client (máy trạm) dùng chung instance này
//Dẫn đến chia sẻ trạng thái → tính tiền sai
// Nói đúng bản chất:
//Dùng Singleton Bean cho một đối tượng có state riêng theo từng user/session là sai thiết kế.*//
}
