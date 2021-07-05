import java.util.*;

public class dutchnationalflag {

    Scanner sc = new Scanner(System.in);
    int arr[];
    int n;

    void input() {
        System.out.println("Enter the size of the array: ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void printarr() {
        System.out.println("The array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void dnf() {
        int lo = 0;
        int mid = 0;
        int hi = n - 1;
        for (int i = 0; i < n; i++) {
            if (mid <= hi) {
                if (arr[i] == 0) {
                    int t = arr[i];
                    arr[i] = arr[lo];
                    arr[lo] = t;
                    lo++;
                    mid++;
                } else if (arr[i] == 1) {
                    mid++;
                } else if (arr[i] == 2) {
                    int t = arr[i];
                    arr[i] = arr[hi];
                    arr[hi] = t;
                    hi--;
                    i--;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String args[]) {
        dutchnationalflag ob = new dutchnationalflag();
        ob.input();
        ob.printarr();
        ob.dnf();
        ob.printarr();
    }
}