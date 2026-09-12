package Bai6;

public class Demo {
    public static void main(String[] args) {
        C objC = new C(10, 20, 30);
        System.out.println("Truoc khi thay doi:");
        objC.displayC();

        objC.setAX(99);

        System.out.println("\nSau khi setAX(99):");
        objC.displayC();
    }
}