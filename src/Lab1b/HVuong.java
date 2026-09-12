package Lab1b;

public class HVuong {
    private double canh;

    public HVuong() { this.canh = 0; }
    public HVuong(double canh) { this.canh = canh; }

    public double getCanh() { return canh; }
    public void setCanh(double canh) { this.canh = canh; }

    public double tinhChuVi() { return 4 * canh; }
    public double tinhDienTich() { return canh * canh; }

    public void xuatThongTin() {
        System.out.println("=== Hinh Vuong ===");
        System.out.println("Canh: " + canh);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }
}