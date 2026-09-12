package Bai2;

import java.util.Scanner;

public class DemoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap kich toi da cua mang: ");
        int maxN = sc.nextInt();
        IntegerArray iarr = new IntegerArray(maxN);

        System.out.println("\n--- Nhap gia tri cho mang ---");
        iarr.nhapGiaTri(sc);
        System.out.print("Mang vua nhap: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Them phan tu vao dau ---");
        System.out.print("Nhap gia tri can them: ");
        iarr.themDau(sc.nextInt());
        System.out.print("Mang sau khi them: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Them phan tu vao cuoi ---");
        System.out.print("Nhap gia tri can them: ");
        iarr.themCuoi(sc.nextInt());
        System.out.print("Mang sau khi them: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Them phan tu vao giua ---");
        System.out.print("Nhap gia tri can them: ");
        int y3 = sc.nextInt();
        System.out.print("Nhap vi tri: ");
        iarr.themGiua(y3, sc.nextInt());
        System.out.print("Mang sau khi them: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Xoa phan tu theo gia tri ---");
        System.out.print("Nhap gia tri can xoa: ");
        iarr.xoaPhanTu(sc.nextInt());
        System.out.print("Mang sau khi xoa: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Xoa phan tu theo vi tri ---");
        System.out.print("Nhap vi tri can xoa: ");
        iarr.xoaPhanTuTai(sc.nextInt());
        System.out.print("Mang sau khi xoa: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Sap xep tang dan (Radix Sort) ---");
        iarr.sapXepTangDanRadix();
        System.out.print("Mang sau sap xep: ");
        iarr.xuatThongTin();

        System.out.println("\n--- Tim kiem trong mang da sap xep ---");
        System.out.print("Nhap gia tri can tim: ");
        int vt1 = iarr.timKiemDaSapXep(sc.nextInt());
        System.out.println(vt1 != -1 ? "Tim thay tai vi tri: " + vt1 : "Khong tim thay!");

        System.out.println("\n--- Tim kiem trong mang chua sap xep ---");
        System.out.print("Nhap gia tri can tim: ");
        int vt2 = iarr.timKiemChuaSapXep(sc.nextInt());
        System.out.println(vt2 != -1 ? "Tim thay tai vi tri: " + vt2 : "Khong tim thay!");

        sc.close();
    }
}