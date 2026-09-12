package Lab1b;

public class DemoHinh {
    public static void main(String[] args) {
        System.out.println("===== Khoi tao khong tham so =====");
        HCN hcn1 = new HCN();
        HVuong hv1 = new HVuong();
        HTG htg1 = new HTG();
        hcn1.xuatThongTin();
        System.out.println();
        hv1.xuatThongTin();
        System.out.println();
        htg1.xuatThongTin();

        System.out.println("\n===== Khoi tao day du tham so =====");
        HCN hcn2 = new HCN(5, 3);
        HVuong hv2 = new HVuong(4);
        HTG htg2 = new HTG(6, 4);
        hcn2.xuatThongTin();
        System.out.println();
        hv2.xuatThongTin();
        System.out.println();
        htg2.xuatThongTin();

        System.out.println("\n===== Su dung set =====");
        hcn1.setDai(8); hcn1.setRong(5);
        hv1.setCanh(6);
        htg1.setDay(10); htg1.setCao(7);
        hcn1.xuatThongTin();
        System.out.println();
        hv1.xuatThongTin();
        System.out.println();
        htg1.xuatThongTin();

        System.out.println("\n===== Su dung get =====");
        System.out.println("HCN2 dai = " + hcn2.getDai() + ", rong = " + hcn2.getRong());
        System.out.println("HVuong2 canh = " + hv2.getCanh());
        System.out.println("HTG2 day = " + htg2.getDay() + ", cao = " + htg2.getCao());
    }
}