package Bai3;

import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] dsSV = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin sinh vien thu " + (i + 1) + " ---");
            dsSV[i] = new Student();
            dsSV[i].inputInfo();
        }

        System.out.println("\n===== DANH SACH SINH VIEN =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nSinh vien " + (i + 1) + ":");
            dsSV[i].printInfo();
        }

        int idxMax = 0, idxMin = 0;
        for (int i = 1; i < n; i++) {
            if (dsSV[i].getDiemTB() > dsSV[idxMax].getDiemTB()) idxMax = i;
            if (dsSV[i].getDiemTB() < dsSV[idxMin].getDiemTB()) idxMin = i;
        }

        System.out.println("\n===== SINH VIEN CO DIEM TB CAO NHAT =====");
        dsSV[idxMax].printInfo();

        System.out.println("\n===== SINH VIEN CO DIEM TB THAP NHAT =====");
        dsSV[idxMin].printInfo();

        System.out.println("\n===== SINH VIEN DUOC HOC BONG =====");
        boolean coHocBong = false;
        for (int i = 0; i < n; i++) {
            if (dsSV[i].hocBong()) {
                dsSV[i].printInfo();
                System.out.println("---");
                coHocBong = true;
            }
        }
        if (!coHocBong) System.out.println("Khong co sinh vien nao duoc hoc bong.");

        sc.close();
    }
}
