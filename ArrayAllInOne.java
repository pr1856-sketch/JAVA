import java.util.Scanner;

public class ArrayAllInOne {

    // Method to input 1D array
    public static void inputArray(int[] arr, Scanner scanner) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = scanner.nextInt();
        }
    }

    // Method to display 1D array
    public static void displayArray(int[] arr) {
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to find sum
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Method to find max
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Method to reverse array
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Method to modify array
    public static void modifyArray(int[] arr, int index, int value) {
        if (index < 0 || index >= arr.length) {
            System.err.println("Invalid index!");
            System.exit(1);
        }
        arr[index] = value;
    }

    // Method to input 2D array
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method to display 2D array
    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to find largest in matrix
    public static int findMaxMatrix(int[][] matrix) {
        int max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.err.println("Size must be positive!");
            System.exit(1);
        }

        int[] arr = new int[size];

        // 1D Array operations
        inputArray(arr, scanner);
        displayArray(arr);

        System.out.println("Sum = " + findSum(arr));
        System.out.println("Max = " + findMax(arr));

        reverseArray(arr);
        System.out.println("Reversed Array:");
        displayArray(arr);

        // Modify array
        System.out.print("Enter index to modify: ");
        int index = scanner.nextInt();

        System.out.print("Enter new value: ");
        int value = scanner.nextInt();

        modifyArray(arr, index, value);
        System.out.println("Updated Array:");
        displayArray(arr);

        // 2D Array (Matrix)
        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter columns: ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.err.println("Invalid matrix size!");
            System.exit(1);
        }

        int[][] matrix = new int[rows][cols];

        inputMatrix(matrix, scanner);
        displayMatrix(matrix);

        System.out.println("Largest in Matrix = " + findMaxMatrix(matrix));

        scanner.close();
    }
}