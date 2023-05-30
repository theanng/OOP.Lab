import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int column = scanner.nextInt();
        //Initialize Matrix1
        System.out.println("Enter matrix 1: ");
        int[][] Matrix1 = new int[row][column];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                Matrix1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter matrix 2: ");
        int[][] Matrix2 = new int[row][column];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                Matrix2[i][j] = scanner.nextInt();
            }
        }
        int[][] SumMatrix = new int[row][column];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                SumMatrix[i][j] = Matrix1[i][j]+Matrix2[i][j];
            }
        }
        System.out.println("Sum of two matrices:");
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                System.out.print(SumMatrix[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
}}
