package Bai6;

public class C extends B {
    private int x;

    public C() { super(); this.x = 0; }
    public C(int xA, int xB, int xC) { super(xA, xB); this.x = xC; }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    // Truy cap va dat x cua A ma khong doi B.x hay C.x
    public void setAX(int value) { super.setX(value); }

    public int getAx() { return ((A) this).x; }

    public void displayC() {
        System.out.println("A.x = " + ((A) this).x);
        System.out.println("B.x = " + super.getX());
        System.out.println("C.x = " + x);
    }
}