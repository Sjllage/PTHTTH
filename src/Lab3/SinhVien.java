package SinhVien;

public class SinhVien extends Nguoi {
    private String maSinhVien;
    private String nganhHoc;
    private double diemTrungBinh;

    // Constructor
    public SinhVien(String hoTen, int namSinh, String diaChi,
                    String maSinhVien, String nganhHoc,
                    double diemTrungBinh) {

        // Gọi constructor của lớp cha
        super(hoTen, namSinh, diaChi);

        this.maSinhVien = maSinhVien;
        this.nganhHoc = nganhHoc;
        this.diemTrungBinh = diemTrungBinh;
    }

    // Getter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    // Setter
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    // Xếp loại sinh viên
    public String xepLoai() {
        if (diemTrungBinh >= 8.5) {
            return "Giỏi";
        } else if (diemTrungBinh >= 7.0) {
            return "Khá";
        } else if (diemTrungBinh >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    // Ghi đè phương thức của lớp cha
    @Override
    public void hienThiThongTin() {
        System.out.println("===== THÔNG TIN SINH VIÊN =====");

        // Gọi phương thức của lớp cha
        super.hienThiThongTin();

        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Ngành học: " + nganhHoc);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
        System.out.println("Xếp loại: " + xepLoai());

        System.out.println("===============================");
    }
}

