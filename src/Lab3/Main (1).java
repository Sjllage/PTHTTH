package lab2;

public class Main {
    public static void main(String[] args) {

        // Tạo 2 sản phẩm
        SanPham sp1 = new SanPham(
                "SP001",
                "Laptop Dell",
                15000000,
                10
        );

        SanPham sp2 = new SanPham(
                "SP002",
                "Chuột Logitech",
                500000,
                20
        );

        // Hiển thị thông tin ban đầu
        System.out.println("=== THÔNG TIN BAN ĐẦU ===");
        sp1.hienThiThongTin();
        sp2.hienThiThongTin();

        // Nhập thêm hàng cho sản phẩm 1
        System.out.println("\n=== NHẬP THÊM HÀNG CHO SP1 ===");
        sp1.hienThiThongTin();

        sp1.nhapHang(5);

        System.out.println("Sau khi nhập hàng:");
        sp1.hienThiThongTin();

        // Thử bán hàng thành công
        System.out.println("\n=== BÁN HÀNG THÀNH CÔNG ===");
        sp1.hienThiThongTin();

        boolean ketQua = sp1.banHang(3);

        System.out.println("Kết quả bán hàng: " + ketQua);
        sp1.hienThiThongTin();

        // Thử bán số lượng lớn hơn tồn kho
        System.out.println("\n=== BÁN VƯỢT QUÁ TỒN KHO ===");
        sp1.hienThiThongTin();

        ketQua = sp1.banHang(100);

        System.out.println("Kết quả bán hàng: " + ketQua);
        System.out.println("Sau khi thử bán vượt tồn kho:");
        sp1.hienThiThongTin();
    }
}

