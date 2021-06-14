import java.util.*;

public class search {
    Scanner sc = new Scanner(System.in);
    int arr[];
    int n;
    int no;

    int input() {
        System.out.println("SEARCH");
        System.out.println("Enter the size of the array: ");
        n = sc.nextInt();
        arr = new int[5];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printarr(arr);
        System.out.println("Choose search method: \n 1. Linear Search \n 2. Binary Search(Array must be sorted)");
        int c = sc.nextInt();
        System.out.println("Enter number to search.");
        no = sc.nextInt();
        return c;
    }

    void printarr(int arr[]) {
        System.out.println("The array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void linearsearch() {
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] == no) {
                System.out.println(no + " found at " + (i + 1));
                break;
            }
        }
        if (i == n) {
            System.out.println(no + " not found.");
        }
    }

    void binarysearch() {
        int l = 0;
        int h = n - 1;
        while (h >= l) {
            int m = (int) ((h + l) / 2);
            if (no == arr[m]) {
                System.out.println(no + " found at " + (m + 1));
                break;
            } else if (no > arr[m]) {
                l = m + 1;
            } else if (no < arr[m]) {
                h = m - 1;
            }
        }
        if (h <= l) {
            System.out.println(no + " not found");
        }
    }

    public static void main(String[] args) {
        search ob = new search();
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            int count = ob.input();
            switch (count) {
                case 1:
                    ob.linearsearch();
                    break;
                case 2:
                    ob.binarysearch();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            System.out.println("Press 1 to exit anything else to continue: ");
            c = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } while (c != 1);
    }

}
