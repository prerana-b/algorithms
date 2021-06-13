import java.util.*;

public class sorting {
    Scanner sc = new Scanner(System.in);
    int arr[];
    int n;

    int input() {
        System.out.println("SORTING");
        System.out.println("Enter the size of the array: ");
        n = sc.nextInt();
        arr = new int[5];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printarr(arr);
        System.out.println(
                "Choose sorting method: \n 1. Bubble Sort \n 2. Insertion Sort \n 3. Sequential Sort \n 4. Selection sort \n 5. Merge Sort \n 6. Quick Sort \n 7. Heap Sort");
        int c = sc.nextInt();
        return c;
    }

    void printarr(int arr[]) {
        System.out.println("The array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void bubblesort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    void insertionsort() {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    void selectionsort() {
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void sequentialsort() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    void merge(int a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergesort(int a[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergesort(a, l, m);
            mergesort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return (i + 1);
    }

    void quicksort(int a[], int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quicksort(a, low, pi - 1);
            quicksort(a, pi + 1, high);
        }
    }

    void heapify(int a[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, n, largest);
        }
    }

    void heapsort() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        sorting ob = new sorting();
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            int count = ob.input();
            switch (count) {
                case 1:
                    ob.bubblesort();
                    break;
                case 2:
                    ob.insertionsort();
                    break;
                case 3:
                    ob.sequentialsort();
                    break;
                case 4:
                    ob.selectionsort();
                    break;
                case 5:
                    int l = 0;
                    int r = ob.n - 1;
                    ob.mergesort(ob.arr, l, r);
                    break;
                case 6:
                    int low = 0;
                    int high = ob.n - 1;
                    ob.quicksort(ob.arr, low, high);
                    break;
                case 7:
                    ob.heapsort();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            ob.printarr(ob.arr);
            System.out.println("Press 1 to exit anything else to continue: ");
            c = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } while (c != 1);
    }
}
