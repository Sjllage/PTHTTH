package SinhVien;

public class Main {
    public static void main(String[] args) {

        // =========================
        // TẠO 2 SINH VIÊN
        // =========================

        SinhVien sv1 = new SinhVien(
                "Nguyen Van An",
                2005,
                "TP. Ho Chi Minh",
                "SV001",
                "Cong nghe thong tin",
                8.7
        );

        SinhVien sv2 = new SinhVien(
                "Tran Thi Binh",
                2004,
                "Dong Nai",
                "SV002",
                "Ke toan",
                6.8
        );

        // =========================
        // TẠO 2 GIẢNG VIÊN
        // =========================

        GiangVien gv1 = new GiangVien(
                "Nguyen Van Minh",
                1980,
                "TP. Ho Chi Minh",
                "GV001",
                "Lap trinh Java",
                5000000,
                2.5
        );

        GiangVien gv2 = new GiangVien(
                "Le Thi Hoa",
                1985,
                "Binh Duong",
                "GV002",
                "Co so du lieu",
                6000000,
                2.0
        );

        // =========================
        // HIỂN THỊ SINH VIÊN
        // =========================

        System.out.println("******** SINH VIÊN ********");

        sv1.hienThiThongTin();
        System.out.println();

        sv2.hienThiThongTin();
        System.out.println();

        // =========================
        // HIỂN THỊ GIẢNG VIÊN
        // =========================

        System.out.println("******** GIẢNG VIÊN ********");

        gv1.hienThiThongTin();
        System.out.println();

        gv2.hienThiThongTin();
    }
}

