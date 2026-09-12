package Lab1b;

public class HTG {
    private double day;
    private double cao;

    public HTG() { this.day = 0; this.cao = 0; }
    public HTG(double day, double cao) { this.day = day; this.cao = cao; }

    public double getDay() { return day; }
    public void setDay(double day) { this.day = day; }
    public double getCao() { return cao; }
    public void setCao(double cao) { this.cao = cao; }

    public double tinhChuVi() {
        double canhBen = Math.sqrt((day / 2) * (day / 2) + cao * cao);
        return day + 2 * canhBen;
    }
    public double tinhDienTich() { return (day * cao) / 2; }

    public void xuatThongTin() {
        System.out.println("=== Hinh Tam Giac ===");
        System.out.println("Day: " + day);
        System.out.println("Cao: " + cao);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }
}
