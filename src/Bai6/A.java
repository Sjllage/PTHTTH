package Bai6;

public class A {
    protected int x;

    public A() { this.x = 0; }
    public A(int x) { this.x = x; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public void displayA() { System.out.println("A.x = " + x); }
}
