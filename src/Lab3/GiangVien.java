package SinhVien;

public class GiangVien extends Nguoi {
    private String maGiangVien;
    private String chuyenMon;
    private double luongCoBan;
    private double heSoLuong;

    // Constructor
    public GiangVien(String hoTen, int namSinh, String diaChi,
                     String maGiangVien, String chuyenMon,
                     double luongCoBan, double heSoLuong) {

        // Gọi constructor lớp cha
        super(hoTen, namSinh, diaChi);

        this.maGiangVien = maGiangVien;
        this.chuyenMon = chuyenMon;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    // Getter
    public String getMaGiangVien() {
        return maGiangVien;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    // Setter
    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    // Tính lương
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    // Ghi đè phương thức của lớp cha
    @Override
    public void hienThiThongTin() {
        System.out.println("===== THÔNG TIN GIẢNG VIÊN =====");

        // Hiển thị thông tin chung của Nguoi
        super.hienThiThongTin();

        System.out.println("Mã giảng viên: " + maGiangVien);
        System.out.println("Chuyên môn: " + chuyenMon);
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.println("Lương: " + tinhLuong());

        System.out.println("================================");
    }
}

