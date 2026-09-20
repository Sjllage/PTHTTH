package SinhVien;

public class Nguoi {
    private String hoTen;
    private int namSinh;
    private String diaChi;

    // Constructor đầy đủ tham số
    public Nguoi(String hoTen, int namSinh, String diaChi) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    // Getter
    public String getHoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Setter
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Tính tuổi
    public int tinhTuoi() {
        return 2026 - namSinh;
    }

    // Hiển thị thông tin chung
    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Tuổi: " + tinhTuoi());
    }
}

