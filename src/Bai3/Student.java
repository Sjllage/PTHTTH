package Bai3;

import java.util.Scanner;

public class Student extends Person {
    private double diemTB;
    private String email;

    public Student() { super(); this.diemTB = 0.0; this.email = ""; }

    public Student(String ten, String gioiTinh, String ngaySinh, String diaChi,
                   double diemTB, String email) {
        super(ten, gioiTinh, ngaySinh, diaChi);
        this.diemTB = diemTB;
        this.email = email;
    }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        super.inputInfo();

        while (true) {
            System.out.print("Nhap diem trung binh (0.0 - 10.0): ");
            this.diemTB = sc.nextDouble();
            sc.nextLine();
            if (this.diemTB >= 0.0 && this.diemTB <= 10.0) break;
            System.out.println("Diem trung binh phai tu 0.0 den 10.0!");
        }

        while (true) {
            System.out.print("Nhap email: ");
            this.email = sc.nextLine();
            if (this.email.contains("@") && !this.email.contains(" ")) break;
            System.out.println("Email phai chua ky tu '@' va khong co khoang trang!");
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Diem trung binh: " + diemTB);
        System.out.println("Email: " + email);
    }

    public boolean hocBong() { return diemTB > 8.0; }
}