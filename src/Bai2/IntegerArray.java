package Bai2;

import java.util.Scanner;

public class IntegerArray {
    private int[] arr;
    private int n;
    private int maxN;

    public IntegerArray(int maxN) {
        this.maxN = maxN;
        this.arr = new int[maxN];
        this.n = 0;
    }

    public void nhapGiaTri(Scanner sc) {
        System.out.print("Nhap so phan tu (toi da " + maxN + "): ");
        n = sc.nextInt();
        if (n > maxN) n = maxN;
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
    }

    public void xuatThongTin() {
        System.out.print("Mang: [");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public void themDau(int y) {
        if (n >= maxN) { System.out.println("Mang da day!"); return; }
        for (int i = n; i > 0; i--) arr[i] = arr[i - 1];
        arr[0] = y;
        n++;
    }

    public void themCuoi(int y) {
        if (n >= maxN) { System.out.println("Mang da day!"); return; }
        arr[n] = y;
        n++;
    }

    public void themGiua(int y, int viTri) {
        if (n >= maxN) { System.out.println("Mang da day!"); return; }
        if (viTri < 0 || viTri > n) { System.out.println("Vi tri khong hop le!"); return; }
        for (int i = n; i > viTri; i--) arr[i] = arr[i - 1];
        arr[viTri] = y;
        n++;
    }

    public void xoaPhanTu(int x) {
        int viTri = timKiemChuaSapXep(x);
        if (viTri == -1) { System.out.println("Khong tim thay phan tu " + x); return; }
        xoaPhanTuTai(viTri);
    }

    public void xoaPhanTuTai(int j) {
        if (j < 0 || j >= n) { System.out.println("Vi tri khong hop le!"); return; }
        for (int i = j; i < n - 1; i++) arr[i] = arr[i + 1];
        n--;
    }

    public void sapXepTangDanRadix() {
        if (n == 0) return;

        boolean isNegative = false;
        for (int i = 0; i < n; i++)
            if (arr[i] < 0) { isNegative = true; break; }

        if (isNegative) {
            int[] positives = new int[n];
            int[] negatives = new int[n];
            int posCount = 0, negCount = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= 0) positives[posCount++] = arr[i];
                else negatives[negCount++] = -arr[i];
            }
            int[] tempPos = new int[posCount];
            System.arraycopy(positives, 0, tempPos, 0, posCount);
            radixSort(tempPos, posCount);
            int[] tempNeg = new int[negCount];
            System.arraycopy(negatives, 0, tempNeg, 0, negCount);
            radixSort(tempNeg, negCount);
            int idx = 0;
            for (int i = negCount - 1; i >= 0; i--) arr[idx++] = -tempNeg[i];
            for (int i = 0; i < posCount; i++) arr[idx++] = tempPos[i];
        } else {
            radixSort(arr, n);
        }
    }

    private void radixSort(int[] a, int len) {
        int max = a[0];
        for (int i = 1; i < len; i++)
            if (a[i] > max) max = a[i];
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(a, len, exp);
    }

    private void countSort(int[] a, int len, int exp) {
        int[] output = new int[len];
        int[] count = new int[10];
        for (int i = 0; i < len; i++) count[(a[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = len - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, a, 0, len);
    }

    public int timKiemChuaSapXep(int b) {
        for (int i = 0; i < n; i++)
            if (arr[i] == b) return i;
        return -1;
    }

    public int timKiemDaSapXep(int b) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == b) return mid;
            else if (arr[mid] < b) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int getN() { return n; }
    public int[] getArr() { return arr; }
}