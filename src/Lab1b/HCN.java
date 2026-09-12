package Lab1b;

public class HCN {
    private double dai;
    private double rong;

    public HCN() {
        this.dai = 0;
        this.rong = 0;
    }

    public HCN(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double getDai() { return dai; }
    public void setDai(double dai) { this.dai = dai; }
    public double getRong() { return rong; }
    public void setRong(double rong) { this.rong = rong; }

    public double tinhChuVi() { return 2 * (dai + rong); }
    public double tinhDienTich() { return dai * rong; }

    public void xuatThongTin() {
        System.out.println("=== Hinh Chu Nhat ===");
        System.out.println("Dai: " + dai);
        System.out.println("Rong: " + rong);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }
}