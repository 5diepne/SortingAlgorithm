/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting;

/**
 *
 * @author DiepTCNN
 */
class SortingEmp {

    public static void insertionSort(Employees[] arr, boolean asc) { // asc là ascending
        for (int i = 1; i < arr.length; i++) {
            Employees key = arr[i];
            int j = i - 1;
            if (asc) {
                while (j >= 0 && arr[j].getID().compareTo(key.getID()) > 0) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            } else {
                while (j >= 0 && arr[j].getID().compareTo(key.getID()) < 0) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(Employees[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if ((asc && arr[j].getID().compareTo(arr[idx].getID()) < 0)
                        || (!asc && arr[j].getID().compareTo(arr[idx].getID()) > 0)) {
                    idx = j;
                }
            }
            Employees temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(Employees[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if ((asc && arr[j].getID().compareTo(arr[j + 1].getID()) > 0)
                        || (!asc && arr[j].getID().compareTo(arr[j + 1].getID()) < 0)) {
                    Employees temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
//===========================mergeSort====================================

    public static void mergeSort(Employees[] arr, boolean asc) {
        merge(arr, 0, arr.length - 1, asc);
    }

    private static void merge(Employees[] arr, int l, int r, boolean ascending) {
        if (l < r) {
            int mid = (l + r) / 2;
            merge(arr, l, mid, ascending);
            merge(arr, mid + 1, r, ascending);
            merge(arr, l, mid, r, ascending);
        }
    }

    private static void merge(Employees[] arr, int l, int mid, int r, boolean ascending) {
        //xác định kích thước 2 mảng con cần trộn
        int size1 = mid - l + 1; //kích thước mảng con trái
        int size2 = r - mid; //kích thước mảng con phải
        //tạo mảng con để lưu các phần tử để merge
        Employees[] leftArr = new Employees[size1];
        Employees[] rightArr = new Employees[size2];
        //cho dữ liệu vào mảng con trái
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[l + i];
        }
        //cho dữ liệu vào mảng con phải
        for (int j = 0; j < size2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < size1 && j < size2) {
            int comparison = ascending ? leftArr[i].getID().compareTo(rightArr[j].getID())
                    : rightArr[j].getID().compareTo(leftArr[i].getID());

            if (comparison <= 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }
//========================heapSort=======================================

    public static void heapSort(Employees[] arr, boolean asc) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i, asc);
        }

        for (int i = n - 1; i > 0; i--) {
            Employees temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heap(arr, i, 0, asc);
        }
    }

    private static void heap(Employees[] arr, int n, int root, boolean asc) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (asc) {
            if (left < n && arr[left].getID().compareTo(arr[largest].getID()) > 0) {
                largest = left;
            }

            if (right < n && arr[right].getID().compareTo(arr[largest].getID()) > 0) {
                largest = right;
            }
        } else {
            if (left < n && arr[left].getID().compareTo(arr[largest].getID()) < 0) {
                largest = left;
            }

            if (right < n && arr[right].getID().compareTo(arr[largest].getID()) < 0) {
                largest = right;
            }
        }

        if (largest != root) {
            Employees swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            heap(arr, n, largest, asc);
        }
    }
//========================quickSort=======================================
    public static void quickSort(Employees[] arr, boolean asc) {
        quickSort(arr, 0, arr.length - 1, asc);
    }

    private static void quickSort(Employees[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pivot = partition(arr, low, high, ascending);

            quickSort(arr, low, pivot - 1, ascending);
            quickSort(arr, pivot + 1, high, ascending);
        }
    }

    private static int partition(Employees[] arr, int low, int high, boolean ascending) {
        String pivot = arr[high].getID();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if ((ascending && arr[j].getID().compareTo(pivot) <= 0)
                    || (!ascending && arr[j].getID().compareTo(pivot) >= 0)) {
                i++;

                Employees temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Employees temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

//  =============== display ================
    public void display(Employees[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1]);
    }

}

public class Sorting {

    public static void main(String[] args) {
        Employees[] employees = {
            new Employees("A05", "Tran Quang", 7),
            new Employees("A03", "Nguyen An", 7),
            new Employees("A01", "Truong Phung", 5),
            new Employees("A04", "Pham Thi Lam", 2),
            new Employees("A02", "Do Trung Ton", 5)
        };
        SortingEmp s = new SortingEmp();

        // Sắp xếp tăng dần bằng thuật toán Insertion Sort
        System.out.println("Insertion Sort(ascending) :");
        s.insertionSort(employees, true);
        for (Employees e : employees) {
            System.out.println(e);
        }

        // Sắp xếp giảm dần bằng thuật toán Selection Sort
        System.out.println("Selection Sort(descending):");
        s.selectionSort(employees, false);

        // Sắp xếp giảm dần bằng thuật toán Bubble Sort
        System.out.println("Bubble Sort(ascending):");
        s.bubbleSort(employees, false);
        s.display(employees);

        // Sắp xếp tăng dần bằng thuật toán MergeSort
        System.out.println("Merge Sort(ascending):");
        s.mergeSort(employees, true);

        // Sắp xếp tăng dần bằng thuật toán HeapSort
        System.out.println("Heap Sort(ascending):");
        s.heapSort(employees, true);
        s.display(employees);
        
        // Sắp xếp tăng dần bằng thuật toán QuickSort
        System.out.println("Quick Sort(ascending):");
        s.quickSort(employees, true);
        s.display(employees);
    }

}
