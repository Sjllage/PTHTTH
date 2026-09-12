package Bai6;

public class B extends A {
    protected int x;

    public B() { super(); this.x = 0; }
    public B(int xA, int xB) { super(xA); this.x = xB; }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    public int getAx() { return super.getX(); }

    public void displayB() { System.out.println("B.x = " + x); }
}