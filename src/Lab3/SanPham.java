package lab2;

public class SanPham {
    // Các thuộc tính được đóng gói bằng private
    private String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuong;

    // Constructor đầy đủ tham số
    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Getter
    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Tính thành tiền
    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    // Nhập hàng
    public void nhapHang(int soLuongNhap) {
        if (soLuongNhap > 0) {
            soLuong += soLuongNhap;
            System.out.println("Nhập hàng thành công: +" + soLuongNhap);
        } else {
            System.out.println("Số lượng nhập phải lớn hơn 0!");
        }
    }

    // Bán hàng
    public boolean banHang(int soLuongBan) {
        // Kiểm tra số lượng bán
        if (soLuongBan <= 0) {
            System.out.println("Số lượng bán phải lớn hơn 0!");
            return false;
        }

        // Kiểm tra tồn kho
        if (soLuongBan > soLuong) {
            System.out.println("Không đủ hàng trong kho!");
            return false;
        }

        // Bán thành công
        soLuong -= soLuongBan;
        System.out.println("Bán hàng thành công: -" + soLuongBan);
        return true;
    }

    // Hiển thị thông tin sản phẩm
    public void hienThiThongTin() {
        System.out.println("----- THÔNG TIN SẢN PHẨM -----");
        System.out.println("Mã sản phẩm: " + maSanPham);
        System.out.println("Tên sản phẩm: " + tenSanPham);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng tồn kho: " + soLuong);
        System.out.println("Thành tiền: " + tinhThanhTien());
        System.out.println("------------------------------");
    }
}
