package company.Fundamentals;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        int n = 5;
        int max = 0;
        int row =0;
        int col =0;
        int new_row=0;
        int new_col=0;

        int[][]matrix = new int[n][n];

        System.out.println("Начальная матрица: ");
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random()*100);
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for (int i =0;i<n;i++){
            for (int j=0;j<n;j++){
                if (max < matrix[i][j]){
                    max = matrix[i][j];
                    row=i;
                    col = j;
                }
            }
        }

        System.out.println("Полученная матрица: ");
        for (int i =0;i<n;i++){
            if (i != row){
                for (int j=0;j<n;j++){
                    if (j!=col){
                        System.out.printf("%3d", matrix[i][j]);
                        new_col++;
                    }
                }
                new_col =0;
                new_row++;
                System.out.println();
            }
        }
        System.out.println();
    }
}

